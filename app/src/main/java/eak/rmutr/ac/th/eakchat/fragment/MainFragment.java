package eak.rmutr.ac.th.eakchat.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import eak.rmutr.ac.th.eakchat.R;
import eak.rmutr.ac.th.eakchat.ServiceActivity;
import eak.rmutr.ac.th.eakchat.utility.MyAlert;

/**
 * Created by Slump on 01/27/2018.
 */

public class MainFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Register Controller
        registerController();

//        Login Controller
        loginController();


    }   // Main Method

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("Please wait Minus...");
                progressDialog.setMessage("Continue Connected to Firebase");
                progressDialog.show();

//                Initial View
                EditText emailEditText = getView().findViewById(R.id.edtEmail);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

//                Get Value from EditText
                String emailString = emailEditText.getText().toString().trim();
                String passwordString = passwordEditText.getText().toString().trim();

//                Check Space
                if (emailString.isEmpty() || passwordString.isEmpty()) {

                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.normalDialog("Have Space"
                            , "Please Fill Email and Password");

                } else {

                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                    firebaseAuth.signInWithEmailAndPassword(emailString, passwordString)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {

                                        Toast.makeText(getActivity(), "Welcome"
                                                , Toast.LENGTH_SHORT).show();

                                        progressDialog.dismiss();

                                        Intent intent = new Intent(getActivity(), ServiceActivity.class);

                                        startActivity(intent);
                                        getActivity().finish();

                                    } else {

                                        progressDialog.dismiss();

                                        MyAlert myAlert = new MyAlert(getActivity());
                                        myAlert.normalDialog("Can't login"
                                        , task.getException().getMessage());

                                    }

                                }   // onComplete
                            });

                }   // if

            }   // onClick
        });
    }

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtNewRegister);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Replace Fragment
                getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.contentMainFragment, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();

            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }

}   // Main Class
