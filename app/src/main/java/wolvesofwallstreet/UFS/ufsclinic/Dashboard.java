package wolvesofwallstreet.UFS.ufsclinic;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class Dashboard extends AppCompatActivity {
    ViewPager viewPager;
    View dot1, dot2, dot3, dot4;
    ImageView iconSearch, iconMic, toolbar_hamburger_menu;
    EditText editTxtSearch;
    CardView ailmentsCard, medicineCard, screeningsCard, women_healthCard, men_healthCard, helplineCard;
    FloatingActionButton addFab;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar_hamburger_menu = findViewById(R.id.toolbar_menu_icon);
        iconSearch = findViewById(R.id.iconSearch);
        iconMic = findViewById(R.id.iconMic);
        editTxtSearch = findViewById(R.id.editTxtSearch);

        //ViewPager
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        dot1 = findViewById(R.id.dot1);
        dot2 = findViewById(R.id.dot2);
        dot3 = findViewById(R.id.dot3);
        dot4 = findViewById(R.id.dot4);

        updateDots();

        ailmentsCard = findViewById(R.id.ailmentsCard);
        medicineCard = findViewById(R.id.medicineCard);
        screeningsCard = findViewById(R.id.screeningsCard);
        women_healthCard = findViewById(R.id.women_healthCard);
        men_healthCard = findViewById(R.id.men_healthCard);
        helplineCard = findViewById(R.id.helplineCard);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        addFab = findViewById(R.id.fab);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);

        // Event Listeners & Logic

        //Services
        ailmentsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAilments = new Intent(Dashboard.this, minor_ailments.class);
                startActivity(goToAilments);
            }
        });
        medicineCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMedicine = new Intent(Dashboard.this, chronic_medication.class);
                startActivity(goToMedicine);
            }
        });
        screeningsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToScreenings = new Intent(Dashboard.this, screenings.class);
                startActivity(goToScreenings);
            }
        });
        medicineCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMedicine = new Intent(Dashboard.this, chronic_medication.class);
                startActivity(goToMedicine);
            }
        });
        women_healthCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToWomenHealth = new Intent(Dashboard.this, women_health.class);
                startActivity(goToWomenHealth);
            }
        });
        men_healthCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMenHealth = new Intent(Dashboard.this, men_health.class);
                startActivity(goToMenHealth);
            }
        });
        helplineCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHelpline = new Intent(Dashboard.this, helpline.class);
                startActivity(goToHelpline);
            }
        });

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        replaceFragment(new HomeFragment());

        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.appointments:
                    replaceFragment(new AppointmentsFragment());
                    break;
                case R.id.notifications:
                    replaceFragment(new NotificationsFragment());
                    break;
                case R.id.settings:
                    replaceFragment(new SettingsFragment());
                    break;
            }

            return true;
        });

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomDialog();
            }
        });

        toolbar_hamburger_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMenuIconClick(view);
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
    private void updateDots() {
//        switch (currentIndex) {
//            case 0:
//                dot1.setImageResource(R.drawable.dot_active);
//                dot2.setImageResource(R.drawable.dot_inactive);
//                dot3.setImageResource(R.drawable.dot_inactive);
//                break;
//            case 1:
//                dot1.setImageResource(R.drawable.dot_inactive);
//                dot2.setImageResource(R.drawable.dot_active);
//                dot3.setImageResource(R.drawable.dot_inactive);
//                break;
//            case 2:
//                dot1.setImageResource(R.drawable.dot_inactive);
//                dot2.setImageResource(R.drawable.dot_inactive);
//                dot3.setImageResource(R.drawable.dot_active);
//                break;
//            default:
//        }
    }

    public void onMenuIconClick(View view) {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.openDrawer(GravityCompat.START);
    }

    //Outside onCreate()
    private  void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private void showBottomDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

//        LinearLayout newBooking = dialog.findViewById(R.id.layoutVideo);
        Button newBooking = dialog.findViewById(R.id.btnNewBooking);
        Button viewAppointments = dialog.findViewById(R.id.btnViewAppointmentsHistory);
        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

//        videoLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.dismiss();
//                Toast.makeText(Dashboard.this,"Upload a Video is clicked",Toast.LENGTH_SHORT).show();
//
//            }
//        });

        newBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(Dashboard.this,"Select available date & time slot",Toast.LENGTH_SHORT).show();

                Intent booNewAppointment = new Intent(Dashboard.this, BookAppointment.class);
                startActivity(booNewAppointment);

            }
        });

        viewAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToAppointmentHistory = new Intent(Dashboard.this, AppointmentsFragment.class);
                startActivity(goToAppointmentHistory);

                dialog.dismiss();
                Toast.makeText(Dashboard.this,"Going to appointment history",Toast.LENGTH_SHORT).show();

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

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
