package wolvesofwallstreet.UFS.ufsclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin, btnContinue, btnForgotPassword;
    private TextView txtEmail, txtPassword;
    private final DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnForgotPassword = findViewById(R.id.btnForgotPassword);
        btnContinue = findViewById(R.id.btnContinue);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sEmail = txtEmail.getText().toString();
                String sPassword = txtPassword.getText().toString();

                if (sEmail.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter your email address", Toast.LENGTH_SHORT).show();
                } else if (sPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                } else {
                    boolean loginSuccessful = login(sEmail, sPassword);
                    if (loginSuccessful) {
                        Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        navigateToDashboard();
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed! Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToDashboard();
            }
        });

    }

    private void navigateToDashboard() {
        Intent toDashboard = new Intent(this, Dashboard.class);
        startActivity(toDashboard);
        finish();
    }

    private boolean login(String sEmail, String sPassword) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {DatabaseHelper.COLUMN_EMAIL, DatabaseHelper.COLUMN_PASSWORD};
        String selection = DatabaseHelper.COLUMN_EMAIL + " = ? AND " + DatabaseHelper.COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {sEmail, sPassword};

        Cursor cursor = db.query(DatabaseHelper.TABLE_STUDENTS, projection, selection, selectionArgs,
                null, null, null);
        if (cursor.getCount() > 0) {
            //User exists & credentials are correct
            cursor.close();
            return true;
        } else {
            //User does not exist or credentials are incorrect
            cursor.close();
            return false;
        }
    }
}