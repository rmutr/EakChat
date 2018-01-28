package eak.rmutr.ac.th.eakchat.utility;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Slump on 01/28/2018.
 */

public class RegisterModel implements Parcelable {

    private String userUIDString, nameString;

    public RegisterModel() {

    }   // Constructor set Value to Firebase

    public RegisterModel(String userUIDString, String nameString) {
        this.userUIDString = userUIDString;
        this.nameString = nameString;
    }   // Constructor get Value

    protected RegisterModel(Parcel in) {
        userUIDString = in.readString();
        nameString = in.readString();
    }

    public static final Creator<RegisterModel> CREATOR = new Creator<RegisterModel>() {
        @Override
        public RegisterModel createFromParcel(Parcel in) {
            return new RegisterModel(in);
        }

        @Override
        public RegisterModel[] newArray(int size) {
            return new RegisterModel[size];
        }
    };

    public String getUserUIDString() {
        return userUIDString;
    }

    public void setUserUIDString(String userUIDString) {
        this.userUIDString = userUIDString;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userUIDString);
        dest.writeString(nameString);
    }
}   // Main Class

