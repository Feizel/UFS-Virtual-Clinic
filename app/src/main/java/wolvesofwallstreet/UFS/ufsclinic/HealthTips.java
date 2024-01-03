package wolvesofwallstreet.UFS.ufsclinic;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HealthTips extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);

        // Example: Add tips to the Quick Tips section
        LinearLayout quickTipsContainer = findViewById(R.id.quickTipsContainer);
        addTip(quickTipsContainer, "Tip 1");
        addTip(quickTipsContainer, "Tip 2");
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
