package com.ey.gilbertoayala.corasao.Interfaces;

import com.ey.gilbertoayala.corasao.Model.Cliente;
import com.ey.gilbertoayala.corasao.Model.JsonRes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Gilberto Ayala on 02/12/2018.
 */
public interface ReqInterface {
    @GET("clientes")
    Call<JsonRes> getJSON();

    @FormUrlEncoded
    @POST("clientes")
    Call<Cliente> createCliente(@Body Cliente cliente);
}
