package cryptenet.thanatos.smart_tour_guide.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cryptenet.thanatos.smart_tour_guide.R;
import cryptenet.thanatos.util.AppInfo;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
    }

    private void init() {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            SplashActivity.this.finish();
        }, AppInfo.SPLASH_TIME_OUT);
    }
}
