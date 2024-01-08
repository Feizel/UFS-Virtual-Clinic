package wolvesofwallstreet.UFS.ufsclinic;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HealthTips extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);

//        // For Quick Tips Section
//        LinearLayout quickTipsSection = findViewById(R.id.quickTipsSection);
//        View quickTipsView = LayoutInflater.from(this).inflate(R.layout.section_quick_tips, quickTipsSection, false);
//        quickTipsSection.addView(quickTipsView);
//
//        // For Health & Wellness Section
//        LinearLayout healthWellnessSection = findViewById(R.id.healthWellnessSection);
//        View healthWellnessView = LayoutInflater.from(this).inflate(R.layout.section_health_and_wellness, healthWellnessSection, false);
//        healthWellnessSection.addView(healthWellnessView);
//
//        // For Stress Management Section
//        LinearLayout stressManagementSection = findViewById(R.id.stressManagementSection);
//        View stressManagementView = LayoutInflater.from(this).inflate(R.layout.section_stress_management, stressManagementSection, false);
//        stressManagementSection.addView(stressManagementView);
//
//        // For Healthy Eating Section
//        LinearLayout healthyEatingSection = findViewById(R.id.healthyEatingSection);
//        View healthyEatingView = LayoutInflater.from(this).inflate(R.layout.section_healthy_eating, healthyEatingSection, false);
//        healthyEatingSection.addView(healthyEatingView);
//
//        // For Sleep Hygiene Section
//        LinearLayout sleepHygieneSection = findViewById(R.id.sleepHygieneSection);
//        View sleepHygieneSecView = LayoutInflater.from(this).inflate(R.layout.section_sleep_hygiene, sleepHygieneSection, false);
//        sleepHygieneSection.addView(sleepHygieneSecView);
//
//        // For Exercise & Fitness Section
//        LinearLayout exerciseFitnessSection = findViewById(R.id.exerciseFitnessSection);
//        View exerciseFitnessView = LayoutInflater.from(this).inflate(R.layout.section_exercise_and_fitness, exerciseFitnessSection, false);
//        exerciseFitnessSection.addView(exerciseFitnessView);
//
//        // For Campus Safety Section
//        LinearLayout campusSafetySection = findViewById(R.id.campusSafetySection);
//        View campusSafetyView = LayoutInflater.from(this).inflate(R.layout.section_campus_safety, campusSafetySection, false);
//        campusSafetySection.addView(campusSafetyView);
//
//        // For Sexual Health Education Section
//        LinearLayout sexualHealthSection = findViewById(R.id.sexualHealthSection);
//        View sexualHealthView = LayoutInflater.from(this).inflate(R.layout.section_sexual_health_education, sexualHealthSection, false);
//        sexualHealthSection.addView(sexualHealthView);
//
//        // For Mental Health Support Section
//        LinearLayout mentalHealthSection = findViewById(R.id.mentalHealthSection);
//        View mentalHealthView = LayoutInflater.from(this).inflate(R.layout.section_mental_health_support, mentalHealthSection, false);
//        mentalHealthSection.addView(mentalHealthView);

        // Back Button
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Home = new Intent(HealthTips.this, Dashboard.class);
                startActivity(Home);
                finish();
            }
        });

        // Add tips to the Quick Tips section
        LinearLayout quickTipsContainer = findViewById(R.id.quickTipsContainer);
        addTip(quickTipsContainer, "Take the stairs for a mini workout.");
        addTip(quickTipsContainer, "Get sunlight for a mood lift.");
        addTip(quickTipsContainer, "Deep breathing for stress relief.");
        addTip(quickTipsContainer, "Keep healthy snacks in your bag.");
        addTip(quickTipsContainer, "Use a study timer for focus.");
        addTip(quickTipsContainer, "Stay hydrated with water breaks.");
        addTip(quickTipsContainer, "Prioritize tasks with to-do lists.");
        addTip(quickTipsContainer, "Stand or stretch every hour.");
        addTip(quickTipsContainer, "Connect with friends daily.");
        addTip(quickTipsContainer, "Quality sleep is non-negotiable.");
        // Add more tips as needed
    }

    private void addTip(LinearLayout container, String tip) {
        TextView textView = new TextView(this);
        textView.setText(tip);
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        container.addView(textView);
    }
}
