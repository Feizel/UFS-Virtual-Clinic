package wolvesofwallstreet.UFS.ufsclinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText signupName, signupEmail, signupPassword, signupConfirmPassword, signupPhoneNumber;
    private Button signupButton;
    private TextView loginRedirectText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Initialize the FirebaseAuth instance in the onCreate()
        auth = FirebaseAuth.getInstance();
        signupName = findViewById(R.id.txtInputName);
        signupEmail = findViewById(R.id.txtInputEmail);
        signupPassword = findViewById(R.id.txtInputPassword);
        signupConfirmPassword = findViewById(R.id.txtInputConfirmPassword);
        signupPhoneNumber = findViewById(R.id.txtinputPhoneNumber);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get User Input
                String name = signupName.getText().toString().trim();
                String email = signupEmail.getText().toString().trim();
                String pass = signupPassword.getText().toString().trim();
                String passConfirm = signupConfirmPassword.getText().toString().trim();
                String phone = signupPhoneNumber.getText().toString().trim();

                // Check if the password and confirm password match
                if (!pass.equals(passConfirm)) {
                    signupConfirmPassword.setError("Passwords do not match");
                    return; // Stop the registration process
                }

                // Continue with the registration process
                if(name.isEmpty()){
                    signupName.setError("Name cannot be empty");
                } if (email.isEmpty()){
                    signupEmail.setError("Email cannot be empty");
                } if(pass.isEmpty()){
                    signupPassword.setError("Password cannot be empty");
                } if(passConfirm.isEmpty()){
                    signupConfirmPassword.setError("Password confirmation cannot be empty");
                } if(phone.isEmpty()){
                    signupPhoneNumber.setError("Phone Number cannot be empty");
                } else{
                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUp.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUp.this, LoginActivity.class));
                            } else{
                                Toast.makeText(SignUp.this, "Signup Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, LoginActivity.class));
            }
        });

    }
}