package anguiano.carlos.testretrofit.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Carlos Anguiano on 06/02/18.
 * For more info contact: c.joseanguiano@gmail.com
 * https://api.foursquare.com/v2/venues/explore?client_id=TDQG4LF1M1O5SZESHJ42BRSZQDPJY4B53NQN5RDTRRZZPNYM&client_secret=PGLQ4RV5R0FDIPHAPJO4RT3KJXO02ARZ4LQ3NWS3TPFIUUJ0&v=20130815&ne=19.241143,72.994881&query=history&sw=18.912417,72.82397
 */

public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }
}
