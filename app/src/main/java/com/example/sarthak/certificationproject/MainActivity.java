package com.example.sarthak.certificationproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.sarthak.certificationproject.Model.MovieAdapter;
import com.example.sarthak.certificationproject.Model.MovieModel;

import com.google.gson.GsonBuilder;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;



public class MainActivity extends AppCompatActivity {


    ListView myListView;
    ProgressDialog pd;
    private String url="http://www.json-generator.com/api/json/get/cpLylIjqWa?indent=2";
    MovieModel[] model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView=(ListView)findViewById(R.id.myListView);

        pd=new ProgressDialog(this);
        pd.setMessage("fetching data");
        pd.setCancelable(false);
        pd.show();

        getNetworkMovies();
    }

    private boolean isNetworkAvailable(){
        ConnectivityManager manager=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=manager.getActiveNetworkInfo();
        return info!=null&&info.isConnected();
    }

    private void getNetworkMovies(){
        if(isNetworkAvailable()){
            OkHttpClient client=new OkHttpClient();
            Request request=new Request.Builder().url(url).build();

            Call call=client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    showError();
                }

                @Override
                public void onResponse(final Response response) throws IOException {
                    if(response.isSuccessful()){
                        final String responseData=response.body().string();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                parseResponse(responseData);
                            }
                        });
                    }

                }
            });

        }

    }

    private void showError(){
        Toast.makeText(MainActivity.this,"Please try after some time",Toast.LENGTH_LONG).show();
    }

    private void parseResponse(String responseData){

        if(!TextUtils.isEmpty(responseData)){

            model=new GsonBuilder().create().fromJson(responseData, MovieModel[].class);
            MovieAdapter adapter=new MovieAdapter(this,model);
            myListView.setAdapter(adapter);
            myListView.setOnItemClickListener(listClickListener);

            pd.dismiss();

        }else{
            pd.dismiss();
            Toast.makeText(this,"error in response",Toast.LENGTH_LONG).show();
        }

    }

    AdapterView.OnItemClickListener listClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent i=new Intent(MainActivity.this,DetailsActivity.class);
            i.putExtra("movie",model[position].movie);
            startActivity(i);
        }
    };
}
