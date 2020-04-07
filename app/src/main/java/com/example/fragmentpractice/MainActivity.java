package com.example.fragmentpractice;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmentpractice.Fragment.HomeFragment;
import com.example.fragmentpractice.SportsApi.ApiResponse;
import com.example.fragmentpractice.SportsApi.SportsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    public  static final String baseUrl ="https://soccer.sportmonks.com/api/v2.0/";
    private static final String TAG = "Details";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        ft.add(R.id.fragmentContainer,homeFragment);
        ft.addToBackStack(null);
        ft.commit();




        ApiResponse apiResponse = RetrofitClient
                .getClient(baseUrl)
                .create(ApiResponse.class);

        apiResponse.getSportsResponse()
                .enqueue(new Callback<SportsResponse>() {
                    @Override
                    public void onResponse(Call<SportsResponse> call, Response<SportsResponse> response) {
                        if(response.isSuccessful()){
                            SportsResponse sportsResponse = response.body();
                            Toast.makeText(MainActivity.this, "Size: "+sportsResponse.getData().size(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this, "Country Name: "+sportsResponse.getData().get(1).getName(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SportsResponse> call, Throwable t) {

                    }
                });
    }
}
