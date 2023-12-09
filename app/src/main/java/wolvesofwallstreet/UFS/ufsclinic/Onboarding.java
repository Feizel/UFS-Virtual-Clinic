package wolvesofwallstreet.UFS.ufsclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class Onboarding extends AppCompatActivity {
    private ImageSwitcher imgSwitcher;
    private ImageView dot1, dot2, dot3;
    private Button btnSkipTour, btnNext;

    Animation animIn, animOut;
    private static final int[] onboardingImages = {
            R.drawable.onb1,
            R.drawable.onb2,
            R.drawable.onb3
    };
    private static final int[] onboardingLabels = {
            R.string.appoint_label,
            R.string.appoint_label2,
            R.string.appoint_label3
    };
    private static final int[] onboardingTexts = {
            R.string.appointments_onB1,
            R.string.appointments_onB2,
            R.string.appointments_onB3
    };
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        imgSwitcher = findViewById(R.id.imgSwitcherONB);
        btnSkipTour = findViewById(R.id.btnSkipTour);
        btnNext = findViewById(R.id.btnNext);

        dot1 = findViewById(R.id.dot1);
        dot2 = findViewById(R.id.dot2);
        dot3 = findViewById(R.id.dot3);

        updateDots();

        // Set animations for ImageSwitcher
        animIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        animOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);

        imgSwitcher.setInAnimation(animIn);
        imgSwitcher.setOutAnimation(animOut);

        imgSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imgView = new ImageView(Onboarding.this);
                imgView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imgView;
            }
        });

        updateImageAndText();

        btnSkipTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMain();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1) % onboardingImages.length;
                updateImageAndText();
            }
        });
    }

    private void updateDots() {
        switch (currentIndex) {
            case 0:
                dot1.setImageResource(R.drawable.dot_active);
                dot2.setImageResource(R.drawable.dot_inactive);
                dot3.setImageResource(R.drawable.dot_inactive);
                break;
            case 1:
                dot1.setImageResource(R.drawable.dot_inactive);
                dot2.setImageResource(R.drawable.dot_active);
                dot3.setImageResource(R.drawable.dot_inactive);
                break;
            case 2:
                dot1.setImageResource(R.drawable.dot_inactive);
                dot2.setImageResource(R.drawable.dot_inactive);
                dot3.setImageResource(R.drawable.dot_active);
                break;
            default:
        }
    }
    private void updateImageAndText() {
        // Create fade-in and fade-out animations
        animIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        animOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);

        // Set animations for ImageSwitcher
        imgSwitcher.setInAnimation(animIn);
        imgSwitcher.setOutAnimation(animOut);

        imgSwitcher.setImageResource(onboardingImages[currentIndex]);

        TextView lblAppointments = findViewById(R.id.lblAppointments);
        lblAppointments.setText(getString(onboardingLabels[currentIndex]));

        TextView txtAppointments = findViewById(R.id.txtAppointments);
        txtAppointments.setText(getString(onboardingTexts[currentIndex]));

        // Start animations
        imgSwitcher.startAnimation(animIn);
        lblAppointments.startAnimation(animIn);
        txtAppointments.startAnimation(animOut);

        updateDots();

        // If it's the last image, navigate to the login screen
        if (currentIndex == onboardingImages.length - 1) {
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    navigateToLogin();
                }
            });
            btnNext.setText("Proceed");
        }
    }

    private void navigateToMain() {
        Intent intent = new Intent(Onboarding.this, Dashboard.class);
        startActivity(intent);
        finish();
        Toast.makeText(this, "Going To Dashboard", Toast.LENGTH_SHORT).show();
    }

    private void navigateToLogin() {
        Intent intent = new Intent(Onboarding.this, Dashboard.class);
        startActivity(intent);
        finish();
    }
}
