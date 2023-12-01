package wolvesofwallstreet.UFS.ufsclinic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends Activity {
    private static final int TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        ImageView imgLogo = findViewById(R.id.imgLogo);
        Animation logInAnimation = AnimationUtils.loadAnimation(this, R.anim.logo_in);
        imgLogo.setAnimation(logInAnimation);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Splash.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, TIME);
    }
}
