package wolvesofwallstreet.UFS.ufsclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class Onboarding extends AppCompatActivity {
    private ImageSwitcher imgSwitcher;
    private Button btnSkipTour, btnNext;
    private int[] onboardingImages = {
            R.drawable.onb1,
            R.drawable.onb2,
            R.drawable.onb3
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

        btnSkipTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Onboarding.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1) % onboardingImages.length;
                imgSwitcher.setImageResource(onboardingImages[currentIndex]);
            }
        });
    }
}