package anguiano.carlos.testretrofit.interfaces;

import anguiano.carlos.testretrofit.model.MultipleResource;
import anguiano.carlos.testretrofit.model.User;
import anguiano.carlos.testretrofit.model.UserList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Carlos Anguiano on 06/02/18.
 * For more info contact: c.joseanguiano@gmail.com
 */

public interface ApiInterface {
    @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();

    @POST("/api/users")
    Call<User> createUser(@Body User user);

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}

