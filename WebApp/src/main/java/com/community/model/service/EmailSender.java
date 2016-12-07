package com.community.model.service;

import com.community.Exceptions.EmailSendException;
import com.community.model.EmailModel;
import com.community.utils.ConfigManager;
import com.jcraft.jsch.*;

/**
 * This class is responsible for sending emails.
 */
//@Service
public class EmailSender implements IEmailSender {

    private String emailHost = "";
    private String emailUser = "";

    public EmailSender() {
        emailHost = ConfigManager.getInstance().getSetting(ConfigManager.SMTP_HOST_KEY);
        emailUser = ConfigManager.getInstance().getSetting(ConfigManager.SMTP_USER_KEY);
    }

    /**
     * This method is a STUB. Waiting for SMTP to populate.
     *
     * @param email
     * @param fromAddress
     */
    public void sendEmail(EmailModel email, String fromAddress) throws EmailSendException {

        Channel channel = null;
        Session session = null;

        try {
            JSch jsch = new JSch();
            if(email.getEmailContent().isEmpty())
                throw new Exception("Email address cannot be empty!");

            session = jsch.getSession(emailUser, emailHost, 22);

            UserInfo ui = new MyUserInfo();
            session.setUserInfo(ui);
            session.connect();

            String command = "echo \"" + email.getEmailContent() +"\" | mail -a \"Content-type: text/html\" -s \""+ email.getSubject()+"\" " + email.getSendTo().getEmailAddress();
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            channel.connect();

        } catch (Exception e) {
            throw new EmailSendException("Error sending email");
        } finally {

            if(channel != null)
                channel.disconnect();

            if(session != null)
                session.disconnect();
        }
    }

    private static class MyUserInfo implements UserInfo{
        public String getPassword(){ return passwd; }
        public boolean promptYesNo(String str){
            str = "Yes";
            return true;
        }

        String passwd = ConfigManager.getInstance().getSetting(ConfigManager.SMTP_USER_PASSWORD_KEY);

        public String getPassphrase(){ return null; }
        public boolean promptPassphrase(String message){ return true; }
        public boolean promptPassword(String message){
            return true;
        }
        public void showMessage(String message){

        }
    }

}


