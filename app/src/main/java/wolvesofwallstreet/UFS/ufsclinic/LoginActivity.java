package wolvesofwallstreet.UFS.ufsclinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import xyz.hasnat.sweettoast.SweetToast;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private Button btnLogin, btnContinue, btnForgotPassword;
    private TextView loginEmail, loginPassword, signupRedirectText;
    private final DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        btnLogin = findViewById(R.id.btnLogin);
        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);
        btnForgotPassword = findViewById(R.id.btnForgotPassword);
        signupRedirectText = findViewById(R.id.signupRedirectText);
        btnContinue = findViewById(R.id.btnContinue);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString();
                String pass = loginPassword.getText().toString();

                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        SweetToast.success(LoginActivity.this, "Login Successful");
//                                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this, Dashboard.class ));
                                        finish();

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        SweetToast.error(LoginActivity.this, "Login Failed. Enter corret credentials");
//                                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        loginPassword.setError("Password cannot be empty");
                    }

                } else if (email.isEmpty()) {
                    loginEmail.setError("Email cannot be empty");
                } else {
                    loginEmail.setError("Please enter a valid email");
                }
            }
        });

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUp.class));
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
        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToSignUp();
            }
        });

    }

    private void navigateToSignUp() {
        Intent toSignUp = new Intent(this, SignUp.class);
        startActivity(toSignUp);
        finish();
    }

    private void navigateToDashboard() {
        Intent toDashboard = new Intent(this, Onboarding.class);
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