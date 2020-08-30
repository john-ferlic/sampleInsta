package com.example.sampleinstagram.models;

import com.google.gson.annotations.SerializedName;

public class User{

    @SerializedName("data")
    public Datum datDat;
    @SerializedName("ad")
    public Ad datAd;

    public class Datum {
        @SerializedName("id")
        public int id;
        @SerializedName("email")
        public String email;
        @SerializedName("first_name")
        public String firstName;
        @SerializedName("last_name")
        public String lastName;
        @SerializedName("avatar")
        public String avatarUrl;
    }

    public class Ad {
        @SerializedName("company")
        public String company;
        @SerializedName("url")
        public String adUrl;
        @SerializedName("text")
        public String adText;
    }
}
