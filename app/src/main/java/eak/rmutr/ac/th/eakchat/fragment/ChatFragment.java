package eak.rmutr.ac.th.eakchat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import eak.rmutr.ac.th.eakchat.R;
import eak.rmutr.ac.th.eakchat.utility.MyAlert;

/**
 * Created by Slump on 01/28/2018.
 */

public class ChatFragment extends Fragment {

//    Explicit
    private String displayNameString, timeChatString, chatString;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Chat Controller
        chatController();


    }

    private void chatController() {

        ImageView imageView = getView().findViewById(R.id.imvChat);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = getView().findViewById(R.id.edtChat);
                chatString = editText.getText().toString().trim();

                if (chatString.isEmpty()) {
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.normalDialog("Have Space"
                            , "Please fill text on the blank");
                } else {
//                    No Space
//                    Find DisplayUser
                    firebaseAuth = FirebaseAuth.getInstance();
                    firebaseUser = firebaseAuth.getCurrentUser();
                    displayNameString = firebaseUser.getDisplayName();

//                    Find Date and Time
                    Calendar calendar = Calendar.getInstance();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                    timeChatString = dateFormat.format(calendar.getTime());

//                    Show Log
                    String tag = "28JanV1";
                    Log.d(tag, "DisplayName ==> " + displayNameString);
                    Log.d(tag, "timeChat ==> " + timeChatString);
                    Log.d(tag, "chatString ==> " + chatString);

//                    Clear Text
                    editText.setText("");

                }

            }   // onClick
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.flagment_chat, container, false);

        return view;
    }
}

