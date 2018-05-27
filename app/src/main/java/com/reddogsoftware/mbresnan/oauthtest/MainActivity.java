package com.reddogsoftware.mbresnan.oauthtest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import okhttp3.HttpUrl;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private OAuthConstants oAuthConstants = new OAuthConstants();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(onClick);

        Uri data = getIntent().getData();
        if (data != null && !TextUtils.isEmpty(data.getScheme())) {
            if (oAuthConstants.REDIRECT_URI_ROOT.equals(data.getScheme())) {
                String code = data.getQueryParameter(oAuthConstants.CODE);
                String error = data.getQueryParameter(oAuthConstants.ERROR_CODE);
                Log.d("HELLO", "onCreate: handle result of authorization with code :" + code);
                if (!TextUtils.isEmpty(code)) {
//                    getTokenFromUrl();
                }
                if(!TextUtils.isEmpty(error)) {
                    //a problem occurs, the user reject our granting request or something like that
                    Toast.makeText(this, "REJECTED!!!", Toast.LENGTH_LONG).show();
                    Log.e("HELLO", "onCreate: handle result of authorization with error :" + error);
                    //then die
                    finish();
                }
            }
        }

    }

    private View.OnClickListener onClick = v -> {
//        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);

//        startActivity(loginIntent);
        HttpUrl authorizeUrl = HttpUrl.parse("https://accounts.google.com/o/oauth2/v2/auth") //
                .newBuilder() //
                .addQueryParameter("client_id", oAuthConstants.CLIENT_ID)
                .addQueryParameter("scope", oAuthConstants.API_SCOPE)
                .addQueryParameter("redirect_uri", oAuthConstants.REDIRECT_URI)
                .addQueryParameter("response_type", oAuthConstants.CODE)
                .build();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(String.valueOf(authorizeUrl.url())));
        startActivity(i);
    };

}
