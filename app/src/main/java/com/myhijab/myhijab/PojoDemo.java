package com.myhijab.myhijab;

/**
 * Created by Ramdhan on 9/15/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoDemo {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("error")
    @Expose
    private String error;

    /**
     *
     * @return
     *     The success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     *     The success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     *
     * @return
     *     The error
     */
    public String getError() {
        return error;
    }

    /**
     *
     * @param error
     *     The error
     */
    public void setError(String error) {
        this.error = error;
    }
}