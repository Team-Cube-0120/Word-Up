package e.gatech.wordup.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class main_Actvity_two extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main__actvity_two);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


    }
}
