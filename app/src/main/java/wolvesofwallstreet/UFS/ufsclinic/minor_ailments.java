package wolvesofwallstreet.UFS.ufsclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class minor_ailments extends AppCompatActivity {
    String Names[] = {
            "Respiratory Conditions",
            "Ear, Nose, and Throat Conditions",
            "Eye Conditions",
            "Skin Conditions",
            "Sexually Transmitted Infections"
    };
    String Desc[] = {
            "Diagnosis and treatment for respiratory issues, including common colds, flu, or other breathing-related problems.",
            "Expert care for issues affecting the ear, nose, and throat, such as ear infections, sinus problems, or sore throats.",
            "Services related to eye health, covering issues like red eyes, minor infections, or other non-severe eye conditions.",
            "Consultations and treatments for various skin concerns, from rashes and minor irritations to skin infections.",
            "Confidential testing, diagnosis, and treatment for sexually transmitted infections, ensuring privacy and comprehensive care."
    };

    int Images1[] = {R.drawable.lungs, R.drawable.oxygen, R.drawable.pills};
    int Images2[] = {R.drawable.swab_test, R.drawable.surgeon, R.drawable.tooth};
    int Images3[] = {R.drawable.blood_drops, R.drawable.transfusion, R.drawable.mens_health};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minor_ailments);

        ListView lv = findViewById(R.id.listview);
        CustomerAdapter ca = new CustomerAdapter();
        lv.setAdapter(ca);

        Button ChronicMeds = findViewById(R.id.btnChronicMeds);
        ChronicMeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ChronicMeds = new Intent(minor_ailments.this, chronic_medication.class);
                startActivity(ChronicMeds);
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
            Iv.setImageResource(Images1[position]);
            Iv2.setImageResource(Images2[position]);
            Iv3.setImageResource(Images3[position]);
            tv2.setText(Desc[position]);

            return convertView;
        }
    }
}
