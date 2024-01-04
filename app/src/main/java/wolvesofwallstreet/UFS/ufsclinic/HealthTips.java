package wolvesofwallstreet.UFS.ufsclinic;

import android.content.Intent;
import android.os.Bundle;
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

        //Back Button
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Home = new Intent(HealthTips.this, Dashboard.class);
                startActivity(Home);
                finish();
            }
        });

        // Example: Add tips to the Quick Tips section
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

        // Similar approach for other sections
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
