package com.community.model;


import java.util.UUID;

/**
 * This class shows a sample of using annotation validators.
 */
public class EmailModel {

    private String emailAddress;
    private String secureHash;

    public EmailModel() {
        setSecureHash(UUID.randomUUID().toString());
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    public String getSecureHash() {
        return secureHash;
    }

    /**
     * A unique value used to secure the unsubscribe function.
     *
     * @param secureHash
     */
    public void setSecureHash(String secureHash) {
        this.secureHash = secureHash;
    }
}