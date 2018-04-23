package com.example.toby.myapplication;

import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.login.LoginBehavior;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button customTabButton = findViewById(R.id.custom_tab);
        LoginButton fbButton = findViewById(R.id.login_button);

        fbButton.setLoginBehavior(LoginBehavior.WEB_ONLY);

        final MainActivity self = this;
        customTabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(self, Uri.parse(
                        "https://www.facebook.com/v2.12/dialog/oauth?" +
                        "app_id=246049848827026" +
                        "&response_type=code" +
                        "&redirect_uri=https://www.roam7.com/" +
                        "&state=banana"));
            }
        });
    }
}
