package wolvesofwallstreet.UFS.ufsclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class Onboarding extends AppCompatActivity {
    private ImageSwitcher imgSwitcher;
    private Button btnSkipTour, btnNext;
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

    private void updateImageAndText() {
        imgSwitcher.setImageResource(onboardingImages[currentIndex]);

        TextView lblAppointments = findViewById(R.id.lblAppointments);
        lblAppointments.setText(getString(onboardingLabels[currentIndex]));

        TextView txtAppointments = findViewById(R.id.txtAppointments);
        txtAppointments.setText(getString(onboardingTexts[currentIndex]));

        // If it's the last image, navigate to the login screen
        if (currentIndex == onboardingImages.length - 1) {
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    navigateToLogin();
                }
            });
            btnNext.setText("Go to Login");
        }
    }

    private void navigateToMain() {
        Intent intent = new Intent(Onboarding.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToLogin() {
        Intent intent = new Intent(Onboarding.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
