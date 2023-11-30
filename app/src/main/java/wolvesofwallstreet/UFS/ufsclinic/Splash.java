package wolvesofwallstreet.UFS.ufsclinic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class Splash extends Activity
{
    private ImageView imgLogo;
    private Animation log_in;
    private static final int TIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        imgLogo =  findViewById(R.id.imgLogo);

        log_in = AnimationUtils.loadAnimation(this, R.anim.logo_in);

        imgLogo.setAnimation(log_in);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(Splash.this, Onboarding.class);
                startActivity(intent);
                finish();
            }
        }, TIME);
    }
}
