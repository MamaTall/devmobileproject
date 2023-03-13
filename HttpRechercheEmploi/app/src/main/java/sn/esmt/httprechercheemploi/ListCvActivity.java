package sn.esmt.httprechercheemploi;


import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.httprechercheemploi.httpconfig.Api;
import sn.esmt.httprechercheemploi.httpconfig.CvApiResponse;
import sn.esmt.httprechercheemploi.tools.MyAdapter;

public class ListCvActivity extends AppCompatActivity {
    private ListView list;
    private ArrayList<CvApiResponse> cvs = new ArrayList<CvApiResponse>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cv);
        list = (ListView) findViewById(R.id.listCv);
        chargerListe();
    }
    public void chargerListe(){

        //Création de l'objet Retrofit pour accéder à l'Api
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.7:8081") //URL de base de l'Api
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Crée une instance de l'interface Api,
        //qui définit les méthodes pour les appels HTTP.
        Api api = retrofit.create(Api.class);

        //creation d'un objet Call pour l'appel à la méthode login() de l'interface Api.
        Call<ArrayList<CvApiResponse>> call = api.all();

        call.enqueue(new Callback<ArrayList<CvApiResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<CvApiResponse>> call, Response<ArrayList<CvApiResponse>> response) {
                if (response.isSuccessful()) {
                    Log.d("Response :", response.body().get(0).getEmail());
                    response.body().stream().forEach(usersResponse -> cvs.add(usersResponse));
                    MyAdapter adpt = new MyAdapter(ListCvActivity.this,cvs);
                    Log.d("Debbugage : " , cvs.get(0).getNom());
                    list.setAdapter(adpt);
                } else {
                    Log.d("error message exception", response.toString());

                }
            }

            @Override
            public void onFailure(Call<ArrayList<CvApiResponse>> call, Throwable t) {
                Log.d("Error : ", t.getMessage());
                //D/Error :: CLEARTEXT communication to 192.168.90.167 not permitted by network security policy
            }

        });


    }


}