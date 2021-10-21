package com.example.examen_02_t3_videoj_real.services;

import com.example.examen_02_t3_videoj_real.entities.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    @GET("users/CFrank1992/repos")
    Call<List<Repository>> allRepos();

    @GET("repos/CFrank1992/{repo}")
    Call<Repository> findRepo(@Path("repo") String repo);
}
