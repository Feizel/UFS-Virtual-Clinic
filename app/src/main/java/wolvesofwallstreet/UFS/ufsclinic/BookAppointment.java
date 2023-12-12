package wolvesofwallstreet.UFS.ufsclinic;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class BookAppointment extends AppCompatActivity {
    private AutoCompleteTextView conditionDropdown;
Onboarding
    private EditText dateEditText, timeEditText;

    private EditText dateEditText;
    private EditText timeEditText;
 master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goHome = new Intent(BookAppointment.this, Dashboard.class);
                startActivity(goHome);
            }
        });

        conditionDropdown = findViewById(R.id.conditionDropdown);
        dateEditText = findViewById(R.id.dateEditText);
        timeEditText = findViewById(R.id.timeEditText);

        // Set up condition dropdown
        String[] conditions = {"Flu", "Cold", "Headache", "Fever", "Back Pain", "Allergies", "STDs", "COVID-19", "Migraine", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, conditions);
        conditionDropdown.setAdapter(adapter);

        // Set up date and time pickers
        dateEditText.setOnClickListener(view -> showDatePicker());
        timeEditText.setOnClickListener(view -> showTimePicker());

        Button bookAppointmentButton = findViewById(R.id.bookAppointment );
        bookAppointmentButton.setOnClickListener(view -> showConfirmationDialog());

        Button contactUsButton = findViewById(R.id.getHelp);
        contactUsButton.setOnClickListener(view -> contactUs());
    }

    private void showDatePicker() {
        // Get current date
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        // Launch Date Picker Dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year, monthOfYear, dayOfMonth) ->
                        dateEditText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year),
                mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void showTimePicker() {
        // Get current time
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minute) ->
                        timeEditText.setText(hourOfDay + ":" + minute),
                mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Appointment Confirmation");
        builder.setMessage("Confirm your appointment details:\n\n" +
                "Condition: " + conditionDropdown.getText() + "\n" +
                "Date: " + dateEditText.getText() + "\n" +
                "Time: " + timeEditText.getText());

        builder.setPositiveButton("Book", (dialog, which) -> {
            // Handle booking logic
            String condition = conditionDropdown.getText().toString();
            String date = dateEditText.getText().toString();
            String time = timeEditText.getText().toString();

            // Save appointment details using SharedPreferences
            saveAppointmentDetails(condition, date, time);

            // Navigate to the "pending appointments" activity
            navigateToPendingAppointments();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        builder.show();
    }

    private void contactUs() {
        // Implement contact us logic
    }

    private void saveAppointmentDetails(String condition, String date, String time) {
        // Use SharedPreferences to save the appointment details
        // You can modify this part based on your data storage needs
        // For simplicity, using SharedPreferences in this example
        getSharedPreferences("Appointments", MODE_PRIVATE)
                .edit()
                .putString("condition", condition)
                .putString("date", date)
                .putString("time", time)
                .apply();
    }

    private void navigateToPendingAppointments() {
        // Navigate to the "pending appointments" activity
        // You need to replace PendingAppointmentsActivity.class with the actual class of your pending appointments activity
        Intent intent = new Intent(this, AppointmentsFragment.class);
        startActivity(intent);
        finish(); // Optional: Close the current activity after navigating
    }

}
