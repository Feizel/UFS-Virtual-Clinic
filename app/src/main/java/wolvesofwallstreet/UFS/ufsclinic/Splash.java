package wolvesofwallstreet.UFS.ufsclinic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.airbnb.lottie.LottieAnimationView;

public class Splash extends Activity {
    private static final int TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        LottieAnimationView lottieUFSLogo = findViewById(R.id.lottieUFSLogo);
        ProgressBar progressBar = findViewById(R.id.idPBLoading);

        lottieUFSLogo.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // Animation has ended, navigate to the main activity
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Optional: add a loading progress callback
        lottieUFSLogo.addAnimatorUpdateListener(animation -> {
            // Do something based on the animation progress (e.g., show/hide progress bar)
            float progress = animation.getAnimatedFraction();
            if (progress == 1.0f) {
                // Animation is complete, hide the progress bar
                progressBar.setVisibility(View.GONE);
            } else {
                // Animation is still in progress, show the progress bar
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        // Optional: Start the Lottie animation
        lottieUFSLogo.playAnimation();
    }

//        ImageView imgLogo = findViewById(R.id.imgLogo);
//
//        Animation logInAnimation = AnimationUtils.loadAnimation(this, R.anim.logo_in);
//        imgLogo.setAnimation(logInAnimation);
//
//        new Handler().postDelayed(() -> {
//            Intent intent = new Intent(Splash.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }, TIME);
}
