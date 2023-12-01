package wolvesofwallstreet.UFS.ufsclinic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Dashboard extends AppCompatActivity {
    private ImageView iconSearch, iconMic;
    private EditText editTxtSearch;
    private FloatingActionButton addFab;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        iconSearch = findViewById(R.id.iconSearch);
        iconMic = findViewById(R.id.iconMic);
        editTxtSearch = findViewById(R.id.editTxtSearch);
        addFab = findViewById(R.id.add_fab);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Event Listeners & Logic
        // Add click listener to the FAB
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent goToSetAppointmentsFrag = new Intent(Dashboard.this, Appointments.class);
//                startActivity(goToSetAppointmentsFrag);
            }
        });

        // Add click listener to the search icon
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

        // Add click listener to the mic icon
        iconMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVoiceRecognition();
            }
        });

        // Add your additional logic and event listeners here
    }

    private void performSearch() {
        // Get the search query from your EditText
        String searchQuery = editTxtSearch.getText().toString();

        // Perform the search using the searchQuery
        // Implement search logic here
        Toast.makeText(this, "Search: " + searchQuery, Toast.LENGTH_SHORT).show();
    }

    private void startVoiceRecognition() {
        // Implement voice recognition logic here
        Toast.makeText(this, "Voice recognition not implemented", Toast.LENGTH_SHORT).show();
    }
}
