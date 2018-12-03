package com.ey.gilbertoayala.corasao.Interfaces;

import com.ey.gilbertoayala.corasao.Model.JsonRes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Gilberto Ayala on 02/12/2018.
 */
public interface ReqInterface {
    @GET("clientes")
    Call<JsonRes> getJSON();
}
