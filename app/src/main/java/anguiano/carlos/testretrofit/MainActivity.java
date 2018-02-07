package anguiano.carlos.testretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import anguiano.carlos.testretrofit.api.ApiClient;
import anguiano.carlos.testretrofit.interfaces.ApiInterface;
import anguiano.carlos.testretrofit.model.MultipleResource;
import anguiano.carlos.testretrofit.model.User;
import anguiano.carlos.testretrofit.model.UserList;
import retrofit2.Callback;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    TextView responseText;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = findViewById(R.id.responseText);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        /**
         GET List Resources
         **/
        retrofit2.Call<MultipleResource> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(retrofit2.Call<MultipleResource> call, Response<MultipleResource> response) {
                Log.i(TAG, "onResponse: ");
                String displayResponse = "";
                MultipleResource resource = response.body();
                Integer text = resource.page;
                Integer total = resource.total;
                Integer totalPages = resource.totalPages;
                List<MultipleResource.Datum> datumList = resource.data;

                displayResponse += text + " Page\n" + total + " Total\n" + totalPages + " Total Pages\n";

                for (MultipleResource.Datum datum : datumList) {
                    displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n";
                }
                responseText.setText(displayResponse);
            }

            @Override
            public void onFailure(retrofit2.Call<MultipleResource> call, Throwable t) {
                Log.i(TAG, "onFailure: ");
                call.cancel();
            }
        });

        /**
         Create new user
         **/
        final User user = new User("Jose Anguiano", "Developer");
        retrofit2.Call<User> call1 = apiInterface.createUser(user);
        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(retrofit2.Call<User> call, Response<User> response) {
                User user1 = response.body();
                Toast.makeText(getApplicationContext(), user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(retrofit2.Call<User> call, Throwable t) {
                call.cancel();
            }
        });

        /**
         GET List Users
         **/
        retrofit2.Call<UserList> call2 = apiInterface.doGetUserList("2");
        call2.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(retrofit2.Call<UserList> call, Response<UserList> response) {
                UserList userList = response.body();
                Integer text = userList.page;
                Integer total = userList.total;
                Integer totalPages = userList.totalPages;
                List<UserList.Datum> datumList = userList.data;
                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();

                for (UserList.Datum datum : datumList) {
                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<UserList> call, Throwable t) {
                call.cancel();
            }
        });

        /**
         POST name and job Url encoded.
         **/

        retrofit2.Call<UserList> call3 = apiInterface.doCreateUserWithField("Jose Anguiano", "Developer");
        call3.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(retrofit2.Call<UserList> call, Response<UserList> response) {
                UserList userList = response.body();
                Integer text = userList.page;
                Integer total = userList.total;
                Integer totalPages = userList.totalPages;
                List<UserList.Datum> datumList = userList.data;
                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();

                for (UserList.Datum datum : datumList) {
                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<UserList> call, Throwable t) {
                call.cancel();
            }
        });
    }
}


