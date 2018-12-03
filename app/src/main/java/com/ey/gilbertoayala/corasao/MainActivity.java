package com.ey.gilbertoayala.corasao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ey.gilbertoayala.corasao.Adapter.DataAdapter;
import com.ey.gilbertoayala.corasao.Interfaces.ReqInterface;
import com.ey.gilbertoayala.corasao.Model.Cliente;
import com.ey.gilbertoayala.corasao.Model.JsonRes;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Cliente> data;
    private DataAdapter adapter;
    private Button subBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateClient.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        subBtn = findViewById(R.id.btn_client_create);
        recyclerView = findViewById(R.id.clientRV);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://corasa-auth-service.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ReqInterface reqInterface = retrofit.create(ReqInterface.class);

        Call<JsonRes> call = reqInterface.getJSON();
        call.enqueue(new Callback<JsonRes>() {
            @Override
            public void onResponse(Call<JsonRes> call, Response<JsonRes> response) {
                System.out.println(response.toString());
               //Toast.makeText(MainActivity.this, "Res" + response.toString(), Toast.LENGTH_LONG).show();
                JsonRes jsonRes = response.body();
                data = new ArrayList<>(Arrays.asList(jsonRes.getClientes()));
                adapter = new DataAdapter(data);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<JsonRes> call, Throwable t) {

            }
        });
    }
}















