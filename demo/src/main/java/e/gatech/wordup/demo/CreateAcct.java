package e.gatech.wordup.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

public final class CreateAcct extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.create_acct_info);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        Button create  = (Button) findViewById(R.id.createButton1);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateAcct.this, create_event.class);
                startActivity(intent);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email   = (EditText) findViewById(R.id.email_box);
                EditText pass = (EditText) findViewById(R.id.password_box);
                if (((email != null) && (pass != null))  && (email.length() > 3) && (pass.length() > 4)) {
                    Intent intent = new Intent(CreateAcct.this, MainActivity.class);
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
