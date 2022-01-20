package dev.ogabek.java.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Member implements Parcelable {

    int photo;
    String name, username;

    public Member(int photo, String name, String username) {
        this.photo = photo;
        this.name = name;
        this.username = username;
    }

    protected Member(Parcel in) {
        photo = in.readInt();
        name = in.readString();
        username = in.readString();
    }

    public String getName() {
        return name;
    }

    public int getPhoto() {
        return photo;
    }

    public String getUsername() {
        return username;
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photo);
        dest.writeString(name);
        dest.writeString(username);
    }
}
