package com.myhijab.myhijab;

/**
 * Created by Ramdhan on 9/15/2016.
 */


import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by johan on 06/09/16.
 */
public interface RequestInterface {


  //  JenisHijab tarikhijab = new JenisHijab();
    //public static final String email = tarikmenuban.getEmail().toString();
    String jsonandroids="jsonandroid";
   // public final static String email = tarikhijab.getEmail().toString();
    @GET("gff@gmail.com")
    Call<JSONResponse> getJSON();
}


