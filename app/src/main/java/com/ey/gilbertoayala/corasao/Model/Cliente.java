package com.ey.gilbertoayala.corasao.Model;

/**
 * Created by Gilberto Ayala on 02/12/2018.
 */
public class Cliente {

    private String RFC;
    private String email;
    private String createdAt;
    private String dropboxToken;
    //private String servicios;

    public Cliente(String RFC, String email, String createdAt, String dropboxToken) {
        this.RFC = RFC;
        this.email = email;
        this.createdAt = createdAt;
        this.dropboxToken = dropboxToken;
        //this.servicios = servicios;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getDropboxToken() {
        return dropboxToken;
    }

    public void setDropboxToken(String dropboxToken) {
        this.dropboxToken = dropboxToken;
    }

//    public String getServicios() {
//        return servicios;
//    }
//
//    public void setServicios(String servicios) {
//        this.servicios = servicios;
//    }
}
