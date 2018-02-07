package anguiano.carlos.testretrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Carlos Anguiano on 06/02/18.
 * For more info contact: c.joseanguiano@gmail.com
 */

public class User {


    @SerializedName("name")
    public String name;
    @SerializedName("job")
    public String job;
    @SerializedName("id")
    public String id;
    @SerializedName("createdAt")
    public String createdAt;

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }


}
