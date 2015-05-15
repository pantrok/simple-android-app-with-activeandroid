package com.synergy.activeandroidtest.services;

import com.synergy.activeandroidtest.beans.User;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by daniel on 13/05/15.
 */
public class PartsService {

    private static final String API_URL = "http://192.168.2.112/FaeRestServices";

    /*
     * Define a service for getting forecast information using Retrofit by Square
     */
    public interface PartService {
        @GET("/users/{id}")
        public void getUserAsync(
                @Path("id") int id,
                Callback<User> callback
        );
    }

    /*
     * Create an async call to the forecast service
     */
    public void loadUserData(int userId, Callback<User> callback) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();

        PartService service = restAdapter.create(PartService.class);
        service.getUserAsync(userId, callback);
    }

}
