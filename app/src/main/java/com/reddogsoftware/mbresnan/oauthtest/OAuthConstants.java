package com.reddogsoftware.mbresnan.oauthtest;

public class OAuthConstants {
    public static final String CLIENT_ID = "434645588824-i46dvs5keto6tq4nd4v23o02h81qs3of.apps.googleusercontent.com";
    /**
     * The redirect uri you have define in your google console for your project
     */
    public static final String REDIRECT_URI = "com.reddogsoftware.mbresnan.oauthtest:/oauth2redirect";
    /**
     * The redirect root uri you have define in your google console for your project
     * It is also the scheme your Main Activity will react
     */
    public static final String REDIRECT_URI_ROOT = "com.reddogsoftware.mbresnan.oauthtest";
    /**
     * You are asking to use a code when autorizing
     */
    public static final String CODE = "code";
    /**
     * The scope: what do we want to use
     * Here we want to be able to do anything on the user's GDrive
     */
    public static final String API_SCOPE = "https://www.googleapis.com/auth/drive";

    public static final String ERROR_CODE = "ERROR";

}
