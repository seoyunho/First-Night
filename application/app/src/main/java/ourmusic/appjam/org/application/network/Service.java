package ourmusic.appjam.org.application.network;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by dsm2016 on 2017-08-12.
 */

public interface Service {

    int HTTP_OK = 200;
    int HTTP_CREATED = 201;
    int HTTP_NO_CONTENT = 204;
    int HTTP_BAD_REQUEST = 400;
    int HTTP_INTERNAL_SERVER_ERROR = 500;

    String SERVER_URL="52.15.75.60:8080/";


    @POST("account/signin")
    Call<Void> signIn(@Field("id")String id,@Field("password") String password);

    @POST("account/signup")
    Call<Void> singUp(@Field("id")String id,@Field("name") String name,@Field("password")String password
    ,@Field("phone")String phone);

    @POST("account/idCheck")
    Call<Void> nameCheck(@Field("id")String id);

    @GET("account/")
    Call<JsonObject> findID(@Query("id") String id);

    @PUT("account/")
    Call<Void> findPassword(@Field("id") String id,@Field("password")String password);

    @GET("weather")
    Call<JsonObject> getWeather(@Query("x") double x,@Query("y") double y);

    @GET("playlist")
    Call<JsonObject> getMusicList(@Query("tag") int tag);

}
