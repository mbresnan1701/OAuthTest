package com.reddogsoftware.mbresnan.oauthtest;

import com.reddogsoftware.mbresnan.oauthtest.Model.OAuthToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OAuthServerIntf {
    /**
     * The call to request a token
     */
    @FormUrlEncoded
    @POST("oauth2/v4/token")
    Call<OAuthToken> requestTokenForm(
            @Field("code")String code,
            @Field("client_id")String client_id,
            @Field("redirect_uri")String redirect_uri,
            @Field("grant_type")String grant_type);
}
