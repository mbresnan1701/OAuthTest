package com.reddogsoftware.mbresnan.oauthtest.Model;

public class OAuthToken {
    @JSON(name = "access_token")
    private String accessToken;
    @Json(name = "token_type")
    private String tokenType;
    @Json(name = "expires_in")
    private long expiresIn;
    private long expiredAfterMilli = 0;
    @Json(name = "refresh_token")
    private String refreshToken;
}
