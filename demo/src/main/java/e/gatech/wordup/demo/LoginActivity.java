package e.gatech.wordup.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    }
}
