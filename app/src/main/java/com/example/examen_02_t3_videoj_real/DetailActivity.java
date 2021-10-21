package com.example.examen_02_t3_videoj_real;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.examen_02_t3_videoj_real.Adapters.NameAdapter;
import com.example.examen_02_t3_videoj_real.Adapters.RepositoryAdapter;
import com.example.examen_02_t3_videoj_real.entities.Repository;
import com.example.examen_02_t3_videoj_real.services.GitHubService;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.i("MAIN_APP", "Iniciando Segunda actividad");

        /*Intent intent = getIntent();
        String value = intent.getStringExtra("value");*/

        /*TextView tv = findViewById(R.id.tvMessage);
        tv.setText(value);*/
        RecyclerView rv = findViewById(R.id.rvNames);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        service.findRepo("Examen_02_Videoj").enqueue(new Callback<Repository>() {
            @Override
            public void onResponse(Call<Repository> call, Response<Repository> response) {

            }

            @Override
            public void onFailure(Call<Repository> call, Throwable t) {

            }
        });


        service.allRepos().enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                Log.i("MAIN_APP", String.valueOf(response.code()));

                if(response.code() == 200) {
                    RepositoryAdapter adapter = new RepositoryAdapter(response.body());
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Log.i("MAIN_APP", "No hubo comunicación con el servidor");
            }
        });

        //List<String> datos = Arrays.asList("Usuario1","Usuario2","Usuario3","Usuario4","Usuario5","Usuario6","Usuario7","Usuario8","Usuario9","Usuario10");




    }
}