package com.example.examen_02_t3_videoj_real;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.examen_02_t3_videoj_real.entities.User;
import com.example.examen_02_t3_videoj_real.services.UserService;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    /*public class ButtonClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            TextView tv = findViewById(R.id.tvSaludo);
            tv.setText("Hola Franco");
            Log.i("MAIN_APP", "Click en el Boton");
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btnChangeText);

        ImageView imageView = findViewById(R.id.ivMain);

        String url = "https://i.pinimg.com/originals/fd/34/02/fd340255b0159bcec7ae93f397d491b8.jpg";
        Picasso.get().load(url).into(imageView);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //EditText input = findViewById(R.id.inputHello);
                //String value = String.valueOf(input.getText());
               // Log.i("MAIN_APP", "El valor de input es: " + value);


                //pasar a otra actividad
               // Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
               // intent.putExtra("value",value);
               // startActivity(intent);

                //llamar por telefono

                /*Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", value, null));
                startActivity(intent);*/


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://examen02t3.free.beeceptor.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                UserService service = retrofit.create(UserService.class);

                User user = new User();
                user.setFirstName("Lionel");
                user.setLastName("Messi");
                user.setEmail("messientoenparis@gmail.com");

                //service.all().enqueue(new Callback<List<User>>() {
                //    @Override
                //    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                //        Log.i("MAIN_APP", new Gson().toJson(response.body()));
                //    }

                //    @Override
                //    public void onFailure(Call<List<User>> call, Throwable t) {
                //        Log.i("MAIN_APP", "No se puede establecer comunicación con el API");
                //    }
                //});


                service.create(user).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.i("MAIN_APP", new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.i("MAIN_APP", "No se puede establecer comunicación con el API");
                    }
                });
            }
        });

    }
}