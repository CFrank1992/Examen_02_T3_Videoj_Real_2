package com.example.examen_02_t3_videoj_real.services;

import com.example.examen_02_t3_videoj_real.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("users")
    Call<List<User>> all();

    @POST("users")
    Call<User> create(@Body User user);

    @PUT("users/{id}")
    Call<User> update(@Path ("id") long id,@Body User user);
}
