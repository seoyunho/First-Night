package ourmusic.appjam.org.application.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ourmusic.appjam.org.application.R;
import ourmusic.appjam.org.application.network.HTTPConnection;
import ourmusic.appjam.org.application.network.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button loginBuuton;
    private EditText idEditText;
    private EditText passwordEditText;
    private Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBuuton=(Button)findViewById(R.id.loginButton);
        loginBuuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);
            }
        });

      /*
        loginBuuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                idEditText=(EditText)findViewById(R.id.id);
                passwordEditText=(EditText)findViewById(R.id.password);

                final String id=idEditText.getText().toString();
                final String password=passwordEditText.getText().toString();

                if (id.equals("")) {
                    Toast.makeText(LoginActivity.this, "아이디를 입력하세요", Toast.LENGTH_SHORT)
                            .show();


                } else if (password.equals("")) {
                    Toast.makeText(LoginActivity.this, "패스워드를 입력하세요", Toast.LENGTH_SHORT)
                            .show();
                } else {

                    try {
                        login(id, password);

                    } catch (IOException e) {
                        System.out.println("IOException in LoginActivity: login()");
                        e.printStackTrace();
                    }
                }
            }
        });*/

    }

    public void checkButton(Button button){

    }


   private void login(final String id, final String password) throws IOException {
       service = HTTPConnection.getInstance().create(Service.class);
        Call<Void> call = service.signIn(id, password);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                int code = response.code();
                switch (code) {
                    case Service.HTTP_CREATED:
                        Toast.makeText(LoginActivity.this, id + getString(R.string.login_created), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
