package com.community.data;

import com.community.Exceptions.EmailNotFoundException;
import com.community.model.EmailAddressModel;
import com.community.utils.ConfigManager;
import com.github.fakemongo.junit.FongoRule;
import com.mongodb.client.MongoDatabase;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mjohns on 11/5/16.
 * Extends EmailRepository to supply a fongo instance for tests.
 */
public class EmailRepositoryTest extends EmailRepository {

    final private static org.slf4j.Logger LOG = LoggerFactory.getLogger(BaseRepositoryTest.class);

    final private static String emailAddr = "foo@bar.com";

    @Rule
    public FongoRule fongoRule = new FongoRule();//allows swapping to localhost if needed.

    @Override
    public MongoDatabase getMongoDatabase() {
        //Override to use fongo database
        return fongoRule.getFongo().getDatabase(ConfigManager.getInstance().getSetting(ConfigManager.DB_NAME_KEY));
    }

    public EmailAddressModel saveEmailInternal(String addr) throws UnknownHostException {
        EmailAddressModel emailAddressModel = new EmailAddressModel();
        emailAddressModel.setEmailAddress(addr);
        this.saveEmail(emailAddressModel);
        return emailAddressModel;
    }

    @Test
    public void saveEmailTest() {
        try {
            saveEmailInternal(emailAddr);
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

    @Test
    public void saveNullEmailAddressModelTest() {
        try {
            EmailAddressModel emailAddressModel = null;
            this.saveEmail(emailAddressModel);
            fail("EmailAddressModel cannot be null");
        } catch (Exception e) {
            return;
        }
    }

    @Test
    public void saveNullEmailAddressTest() {
        try {
            EmailAddressModel emailAddressModel = new EmailAddressModel();
            this.saveEmail(emailAddressModel);
            fail("EmailAddress cannot be null");
        } catch (Exception e) {
            return;
        }
    }

    @Test
    public void getEmailTest() {
        try {
            //1. pre-condition -- call #saveEmailInternal()
            this.saveEmailInternal(emailAddr);

            //2. run this test
            EmailAddressModel foundEmail = this.getEmail(emailAddr);
            assertNotNull("Expected foundEmail to not equal null.",foundEmail);
            assertEquals(String.format("Expected email found and matching provided address '%s'.",emailAddr),emailAddr,foundEmail.getEmailAddress());
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

    @Test
    public void getNoEmailTest() {
        try {
            EmailAddressModel foundEmail = this.getEmail(emailAddr);
            assertNull("Expected foundEmail to equal null.",foundEmail);
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

      @Test
    public void getAllEmails1Test() {
        try{
            //1. pre-condition -- call #saveEmailInternal()
            this.saveEmailInternal(emailAddr);

            //2. run this test
            List<EmailAddressModel> emails = this.getAllEmails();
            assertEquals("Expected 1 email available.",1,emails.size());
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

    @Test
    public void getAllEmailsMultipleTest() {
        try{
            //1. pre-condition -- call #saveEmailInternal()
            this.saveEmailInternal(emailAddr);
            this.saveEmailInternal("emailtest2@test.com");
            this.saveEmailInternal("emailtest3@test.com");

            //2. run this test
            List<EmailAddressModel> emails = this.getAllEmails();
            assertEquals("Expected 3 emails available.",3,emails.size());
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

    @Test
    public void getAllEmailsNoneTest() {
        try{
            List<EmailAddressModel> emails = this.getAllEmails();
            assert(emails.size()==0);
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

    @Test
    public void deleteEmailTest() {
        try {
            //1. pre-condition -- call #saveEmailInternal()
            this.saveEmailInternal(emailAddr);

            //2. run this test
            String secureHash = this.getEmail(emailAddr).getSecureHash();
            this.deleteEmail(secureHash);
            assertNull(this.getEmail(emailAddr));
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

    @Test
    public void deleteNonExistentEmailTest() {
        try {
            //1. pre-condition -- call #saveEmailInternal()
            this.saveEmailInternal(emailAddr);

            //2. run this test
            this.deleteEmail("12345");
            fail("This secureHash value shouldn't exist");
        } catch (EmailNotFoundException ex) {
            return;
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

}
