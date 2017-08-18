package ourmusic.appjam.org.application.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.jar.Manifest;

import ourmusic.appjam.org.application.GPS_Service;
import ourmusic.appjam.org.application.R;
import ourmusic.appjam.org.application.adpater.RecyclerviewAdapter;
import ourmusic.appjam.org.application.model.Music;
import ourmusic.appjam.org.application.network.HTTPConnection;
import ourmusic.appjam.org.application.network.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.HTTP;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerviewAdapter adapter;
    private ArrayList<Music> musics;
    private RecyclerView recyclerView;
    private BroadcastReceiver broadcastReceiver;
    private RecyclerView.LayoutManager layoutManager;
    private Button button1;
    private TextView temperature;
    private Service service;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        service = HTTPConnection.getInstance().create(Service.class);



        //setBackground(2);
        service.getWeather(32.22, 21.32).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d("hello", response.body().get("weather")+"");

                JsonElement weather=response.body().get("weather");
                String weather_name=weather.getAsString();
                temperature=(TextView)findViewById(R.id.temperature);
                temperature.setText(weather_name);
                getMusicList();
                Log.d("----------aaa---------",weather_name);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });



    }//oncreate

    public void getMusicList(){
        service.getMusicList(2).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonArray jsonObject=response.body().getAsJsonArray("music");
                JsonArray jsonElements=jsonObject.getAsJsonArray();
                adapter = new RecyclerviewAdapter(getApplicationContext(), getArrayList(jsonElements));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }


    public ArrayList<Music> getArrayList(JsonArray jsonElements){
        ArrayList<Music> arrayList=new ArrayList<>();
        for(int i=0;i<jsonElements.size();i++){
            JsonObject jsonObject=(JsonObject)jsonElements.get(i);
            String title=jsonObject.getAsJsonPrimitive("title").getAsString();
            String singer=jsonObject.getAsJsonPrimitive("singer").getAsString();
            String url=jsonObject.getAsJsonPrimitive("musicURL").getAsString();
            String imaurl=jsonObject.getAsJsonPrimitive("imgURL").getAsString();

            arrayList.add(new Music(title,singer,url,imaurl));
        }
        return  arrayList;
    }


    public Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    } // Author: sile
            private boolean runtime_permissions() {
                if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                        ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                                PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{
                            android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION
                    }, 100);
                    return true;
                }

                return false;

            }
} //class
/*
    @Override
    protected void onResume(){
        super.onResume();
        if(broadcastReceiver==null){
            broadcastReceiver=new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    Log.d("Hello",intent.getExtras().getString("coordinates"));

                }
            };
        }
        registerReceiver(broadcastReceiver,new IntentFilter("location_update"));
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        if(broadcastReceiver!=null){
            unregisterReceiver(broadcastReceiver);
        }
    }
*/

             /*   AQuery aQuery=new AQuery(button1);

                aQuery.ajax("52.15.75.60:8080/weather?x="+52.25+"&y="+34.42, String.class, new AjaxCallback<String>(){

                    @Override
                    public void callback(String url, String object, AjaxStatus status) {

                        try {
                            JSONObject jsonObject=new JSONObject(object);
                            String weather=jsonObject.getString("weather");
                            Log.d("Test11111",jsonObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.d("test1",url);
                        Log.d("test",object.toString());

                    }
                });*/

            /*        if(!runtime_permissions()){
                        enable_buttons();
                    }*/



/*    private void enable_buttons(){
        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), GPS_Service.class);
                startActivity(i);
            }
        });

        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),GPS_Service.class);
                stopService(i);
            }
        });

    }*/

/*    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED){
                enable_buttons();
            }else {
                runtime_permissions();
            }
        }
    }*/



/*    public ArrayList<Music> getData() {
        arrayList = new ArrayList<>();
        arrayList.add(new Music("에너제틱", "워너워", R.drawable.ic_person));
        arrayList.add(new Music("에너제틱", "워너워", R.drawable.ic_person));
        arrayList.add(new Music("에너제틱", "워너워", R.drawable.ic_person));
        arrayList.add(new Music("에너제틱", "워너워", R.drawable.ic_person));
        arrayList.add(new Music("에너제틱", "워너워", R.drawable.ic_person));
        arrayList.add(new Music("에너제틱", "워너워", R.drawable.ic_person));
        arrayList.add(new Music("에너제틱", "워너워", R.drawable.ic_person));
        arrayList.add(new Music("에너제틱", "워너워", R.drawable.ic_person));
        return arrayList;
    }*/


            /* public void setBackground(int checkNum){
                 //View view= LayoutInflater.from(getApplicationContext()).inflate(getParent().getCon,R.layout.activity_main,false);

                 if(checkNum==1){
                     view.setBackgroundResource(R.drawable.bg_weather_am_cloud);
                 }else if(checkNum==2){
                     view.setBackgroundResource(R.drawable.bg_weather_am_rain);
                 }else if(checkNum==3){
                     view.setBackgroundResource(R.drawable.bg_weather_am_snow);
                 }
             }*/