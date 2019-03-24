package com.example.studentportal2;

public class Website {

    private String mPortalName;
    private String mPortalUrl;

    public Website(String mPortalName, String mPortalUrl) {

        this.mPortalName = mPortalName;
        this.mPortalUrl = mPortalUrl;
    }

    public String getmPortalName() {
        return mPortalName;
    }

    public String getmPortalUrl() {
        return mPortalUrl;
    }

    public void setmPortalName(String mPortalName) {
        this.mPortalName = mPortalName;
    }

    public void setmPortalUrl(String mPortalUrl) {
        this.mPortalUrl = mPortalUrl;
    }
}
