package e.gatech.wordup.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CreateEventActivity.class);
                startActivity(intent);
            }
        });
    }
}
