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

public class chronic_medication extends AppCompatActivity {
    String Names[] = {
            "Chronic Medication",
            "Ear, Nose, and Throat Conditions",
    };
    String Desc[] = {
            "Diagnosis and treatment for respiratory issues, including common colds, flu, or other breathing-related problems.",
            "Expert care for issues affecting the ear, nose, and throat, such as ear infections, sinus problems, or sore throats.",
            "Services related to eye health, covering issues like red eyes, minor infections, or other non-severe eye conditions.",
            "Consultations and treatments for various skin concerns, from rashes and minor irritations to skin infections.",
            "Confidential testing, diagnosis, and treatment for sexually transmitted infections, ensuring privacy and comprehensive care."
    };

    int Images1[] = {R.drawable.pills, R.drawable.hand_virus, R.drawable.tablet};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronic_medication);

        //Back Button
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Home = new Intent(chronic_medication.this, Dashboard.class);
                startActivity(Home);
                finish();
            }
        });

        ListView lv = findViewById(R.id.listview);
        chronic_medication.CustomerAdapter ca = new chronic_medication.CustomerAdapter();
        lv.setAdapter(ca);

        //Screenings Button
        Button screenings = findViewById(R.id.btnScreenings);
        screenings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToScreenings = new Intent(chronic_medication.this, screenings.class);
                startActivity(goToScreenings);
                finish();
            }
        });

        //Minor ailments Button
        Button minor_ailments = findViewById(R.id.btnMinorAilments);
        minor_ailments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMeds = new Intent(chronic_medication.this, minor_ailments.class);
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
            convertView = getLayoutInflater().inflate(R.layout.customlistviewlayout, null);
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