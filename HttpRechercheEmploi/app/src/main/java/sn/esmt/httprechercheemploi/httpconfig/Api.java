package sn.esmt.httprechercheemploi.httpconfig;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("/users/all")
    public Call<ArrayList<CvApiResponse>> all();
}
