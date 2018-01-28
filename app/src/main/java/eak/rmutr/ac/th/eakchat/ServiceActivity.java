package eak.rmutr.ac.th.eakchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import eak.rmutr.ac.th.eakchat.fragment.ChatFragment;
import eak.rmutr.ac.th.eakchat.fragment.RegisterFragment;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        if (savedInstanceState == null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentServiceFragment, new ChatFragment())
                    .commit();

        } else {

        }



    }   // Main Method

}   // Main Class
