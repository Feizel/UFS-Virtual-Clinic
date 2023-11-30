package wolvesofwallstreet.UFS.ufsclinic;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {
    private LinearLayout btnHealthTips, btnCampaigns;
    private TextView lblGreet, lblHealthWellness;
    private ImageView ivProfilePicture;
    private CardView cardProfilePicture;
    private ImageView iconSearch, iconMic;
    private EditText editTxtSearch;
    private ImageSwitcher imgSwitcherHome;
    private View viewDotOne, viewDotTwo, viewDotThree, viewDotFour;
    private CardView cardNotifications;
    private TextView txtHealthTips, txtCampaign, txtSCD;
    private ImageView imgHealthTips, imgCampaign, imgSCD;
    private FloatingActionButton addFab;
    private BottomNavigationView bottomNavigationView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        //Initialize myView
        lblGreet = myView.findViewById(R.id.lblGreet);
        ivProfilePicture = myView.findViewById(R.id.ivProfilePicture);
        cardProfilePicture = myView.findViewById(R.id.cardProfilePicture);
        iconSearch = myView.findViewById(R.id.iconSearch);
        iconMic = myView.findViewById(R.id.iconMic);
        editTxtSearch = myView.findViewById(R.id.editTxtSearch);
        lblHealthWellness = myView.findViewById(R.id.lblHealthWellness);
        imgSwitcherHome = myView.findViewById(R.id.imgSwitcherHome);
        viewDotOne = myView.findViewById(R.id.viewDotOne);
        viewDotTwo = myView.findViewById(R.id.viewDotTwo);
        viewDotThree = myView.findViewById(R.id.viewDotThree);
        viewDotFour = myView.findViewById(R.id.viewDotFour);
        cardNotifications = myView.findViewById(R.id.cardNotifications);
        txtHealthTips = myView.findViewById(R.id.txtHealthTips);
        txtCampaign = myView.findViewById(R.id.txtCampaign);
        txtSCD = myView.findViewById(R.id.txtSCD);
        imgHealthTips = myView.findViewById(R.id.imgHealthTips);
        imgCampaign = myView.findViewById(R.id.imgCampaign);
        imgSCD = myView.findViewById(R.id.imgSCD);
        addFab = myView.findViewById(R.id.add_fab);
        bottomNavigationView = myView.findViewById(R.id.bottomNavigationView);

        //Event Listeners & Logic

        // Add click listener to the FAB
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSetAppointmentsFrag = new Intent(getContext(), AppointmentsFragment.class);
                startActivity(goToSetAppointmentsFrag);
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

        // Add click listener to the health tips section
        txtHealthTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHealthTips();
            }
        });

        // Add click listener to the campaign section
        txtCampaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCampaign();
            }
        });

        // Add click listener to the student counselling section
        txtSCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToStudentCounselling();
            }
        });

        // Add your additional logic and event listeners here

        return myView;
    }

    private void performSearch() {
        // Get the search query from your EditText
        EditText editTextSearch = getView().findViewById(R.id.editTxtSearch);
        String searchQuery = editTextSearch.getText().toString();

        // Perform the search using the searchQuery


        // Implement search logic here


        Toast.makeText(getActivity(), "Search: " + searchQuery, Toast.LENGTH_SHORT).show();
    }

    private void startVoiceRecognition() {
        // Implement voice recognition logic here


        Toast.makeText(getActivity(), "Voice recognition not implemented", Toast.LENGTH_SHORT).show();
    }

    private void navigateToHealthTips() {
        // Implement navigation logic to health tips here

        // start a new activity or fragment


        Toast.makeText(getActivity(), "Navigate to Health Tips", Toast.LENGTH_SHORT).show();
    }

    private void navigateToCampaign() {
        // Implement navigation logic to campaign here

        // start a new activity or fragment


        Toast.makeText(getActivity(), "Navigate to Campaign", Toast.LENGTH_SHORT).show();
    }

    private void navigateToStudentCounselling() {
        // Implement navigation logic to student counselling here

        // start a new activity or fragment

        Toast.makeText(getActivity(), "Navigate to Student Counselling", Toast.LENGTH_SHORT).show();
    }


}