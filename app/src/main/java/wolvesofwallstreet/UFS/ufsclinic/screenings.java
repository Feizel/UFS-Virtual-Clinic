package wolvesofwallstreet.UFS.ufsclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class screenings extends AppCompatActivity {
    String Names[] = {
            "Health Screenings",
            "Ear, Nose, and Throat Conditions",
    };
    String Desc[] = {
            "Regular health checks to monitor key indicators such as blood pressure, weight, body mass index, blood glucose, and cholesterol.",
            "Expert care for issues affecting the ear, nose, and throat, such as ear infections, sinus problems, or sore throats.",
            "Services related to eye health, covering issues like red eyes, minor infections, or other non-severe eye conditions.",
            "Consultations and treatments for various skin concerns, from rashes and minor irritations to skin infections.",
            "Confidential testing, diagnosis, and treatment for sexually transmitted infections, ensuring privacy and comprehensive care."
    };
    int Images1[] = {R.drawable.swab_test, R.drawable.blood_drops, R.drawable.ambulance};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screenings);

        //Back Button
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Home = new Intent(screenings.this, Dashboard.class);
                startActivity(Home);
                finish();
            }
        });

        ListView lv = findViewById(R.id.listview);
        screenings.CustomerAdapter ca = new screenings.CustomerAdapter();
        lv.setAdapter(ca);

        //Sexual Health Button
        Button sexualHealth = findViewById(R.id.btnSexualHealth);
        sexualHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToWomensHealth = new Intent(screenings.this, women_health.class);
                startActivity(goToWomensHealth);
                finish();
            }
        });

        //Chronic Meds Button
        Button chronicMeds = findViewById(R.id.btnChronicMeds);
        chronicMeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMeds = new Intent(screenings.this, chronic_medication.class);
                startActivity(goToMeds);
                finish();
            }
        });

    }
    class CustomerAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlistviewlayout, parent, false);
            TextView tv = convertView.findViewById(R.id.tv);
            TextView tv2 = convertView.findViewById(R.id.tv2);
            ImageView Iv = convertView.findViewById(R.id.iv1);
            ImageView Iv2 = convertView.findViewById(R.id.iv2);
            ImageView Iv3 = convertView.findViewById(R.id.iv3);

            tv.setText(Names[position]);

            int arrayPosition = position % Images1.length; // Calculate the array position to cycle through images

            if (arrayPosition < Images1.length) {
                Iv.setImageResource(Images1[arrayPosition]);
            } else {
                // Handle the case where the images array doesn't have enough elements
            }

            if ((arrayPosition + 1) < Images1.length) {
                Iv2.setImageResource(Images1[arrayPosition + 1]);
            } else {
                // Handle the case where the images array doesn't have enough elements
            }

            if ((arrayPosition + 2) < Images1.length) {
                Iv3.setImageResource(Images1[arrayPosition + 2]);
            } else {
                // Handle the case where the images array doesn't have enough elements
            }

            tv2.setText(Desc[position]);

            return convertView;
        }

    }
}