package com.example.fragmentpractice.SportsApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiResponse {

   @GET("continents?api_token=kIru1O42a6A4GsS48Y8CIYQPjDhUrzR5tJXlwK41rijzVQ569FqtAXcOEppb")
    Call<SportsResponse> getSportsResponse();
}
