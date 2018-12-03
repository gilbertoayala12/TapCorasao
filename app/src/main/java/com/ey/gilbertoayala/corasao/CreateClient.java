package com.ey.gilbertoayala.corasao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CreateClient extends AppCompatActivity {
    private EditText et_rfc;
    private EditText et_email;
    private EditText et_dropbox;
    private Button submitClient;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    Call post(String url, String json, Callback callback) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_create);
        initViews();

        submitClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sRFC, sEmail, sDropbox;
                sRFC = et_rfc.getText().toString();
                sEmail = et_email.getText().toString();
                sDropbox = et_dropbox.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (!sRFC.matches("") && !sEmail.matches("") && !sDropbox.matches("") && sEmail.matches(emailPattern)) {
                    // if you're watching this im sorry lmao shit's wack, it works tho
                    // "{\n    \"clientInfo\": {\n        \"rfc\": \"Q#34\",\n        \"email\": \"hola@hola.com\",\n        \"dropboxToken\": \"asdfasdf\"\n    }\n}";
                    String json = "{\n    \"clientInfo\": {\n        \"rfc\": \"" + sRFC + "\",\n        \"email\": \"" + sEmail + "\",\n        \"dropboxToken\": \"" + sDropbox + "\"\n    }\n}";


                    post("http://corasa-auth-service.herokuapp.com/clientes", json, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            // shits broken
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            // shits broken
                        }
                    });
                    Intent intent = new Intent(CreateClient.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(CreateClient.this, "Please fill the form correctly", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void initViews() {
        et_rfc = findViewById(R.id.input_RFC);
        et_email = findViewById(R.id.input_email);
        et_dropbox = findViewById(R.id.input_token);
        submitClient = findViewById(R.id.btn_submit);
    }


}
