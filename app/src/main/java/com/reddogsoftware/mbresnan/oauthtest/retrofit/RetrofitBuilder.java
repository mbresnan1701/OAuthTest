package com.reddogsoftware.mbresnan.oauthtest.retrofit;

import android.content.Context;

import com.reddogsoftware.mbresnan.oauthtest.OAuthServerIntf;

import retrofit2.Retrofit;

public class RetrofitBuilder {
    /**
     * Root URL
     * (always ends with a /)
     */
    public static final String BASE_URL = "https://www.googleapis.com/";
/***********************************************************
 * Getting OAuthServerIntf instance using Retrofit creation
 **********************************************************/
    /**
     * A basic client to make unauthenticated calls
     * @param ctx
     * @return OAuthServerIntf instance
     */
    public static OAuthServerIntf getSimpleClient(Context ctx) {
        //Using Default HttpClient
        Retrofit retrofit = new Retrofit.Builder()
                .client(getSimpleOkHttpClient(ctx))
                .addConverterFactory(new StringConverterFactory())
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        OAuthServerIntf webServer = retrofit.create(OAuthServerIntf.class);
        return webServer;
    }
}
