package e.gatech.wordup.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

public final class LoginActivity extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        Button login = (Button) findViewById(R.id.loginButton);
        Button create  = (Button) findViewById(R.id.createButton);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, create_event.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email   = (EditText) findViewById(R.id.email_box);
                EditText pass = (EditText) findViewById(R.id.password_box);
                if (((email != null) && (pass != null))  && (email.length() > 3) && (pass.length() > 4)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                   Toast toast =  Toast.makeText(getApplicationContext(),"Identification information is not valid. Try again!", Toast.LENGTH_LONG);
                   toast.setGravity(Gravity.CENTER, 0, 0);
                   toast.show();
                }
            }
        });
    }
}
