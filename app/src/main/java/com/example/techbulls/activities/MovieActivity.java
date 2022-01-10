package com.example.techbulls.activities;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.techbulls.R;
import com.example.techbulls.databinding.ActivityMovieBinding;
import com.example.techbulls.model.MovieModel;
import com.example.techbulls.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity  implements MovieContractor.OnClickListener{

    ActivityMovieBinding binding;
    String name;
    String apikey="44bb3133";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_movie);
        binding.setListener(this);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

    }

    @Override
    public void onClickButtonSearch(View view) {

        name=binding.inputUsername.getEditText().getText().toString().trim();
        if (name != null)
        {
            Call<MovieModel> call= ApiClient.getService().moiveDetails(name);
            call.enqueue(new Callback<MovieModel>() {
                @Override
                public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                    if (!response.isSuccessful())
                    {
                        return;
                    }
                    MovieModel movieModel=response.body();
                    MovieAdapter movieAdapter=new MovieAdapter(getApplicationContext(),movieModel);
                    binding.recyelerMovie.setLayoutManager(new LinearLayoutManager(MovieActivity.this));
                    binding.recyelerMovie.setAdapter(movieAdapter);
                }

                @Override
                public void onFailure(Call<MovieModel> call, Throwable t) {

                }
            });
        }


    }

    @Override
    public void onClickBackButton(View view) {

    }
}
