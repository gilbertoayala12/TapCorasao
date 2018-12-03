package com.ey.gilbertoayala.corasao.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ey.gilbertoayala.corasao.Model.Cliente;
import com.ey.gilbertoayala.corasao.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Gilberto Ayala on 02/12/2018.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Cliente> cliente;

    public DataAdapter(ArrayList<Cliente> cliente) {
        this.cliente = cliente;
    }



    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv_rfc.setText(cliente.get(i).getRFC());
        viewHolder.tv_email.setText(cliente.get(i).getEmail());
        viewHolder.tv_dropboxToken.setText(cliente.get(i).getDropboxToken());
        viewHolder.tv_createdAt.setText(cliente.get(i).getCreatedAt());
        //viewHolder.tv_servicios.setText(cliente.get(i).getServicios());

    }

    @Override
    public int getItemCount() {
        return cliente.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_rfc;
        private TextView tv_email;
       // private TextView tv_servicios;
        private TextView tv_dropboxToken;
        private TextView tv_createdAt;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_rfc = itemView.findViewById(R.id.clientRFCTextView);
            tv_email = itemView.findViewById(R.id.EmailTextView);
           // tv_servicios = itemView.findViewById(R.id.serviciosTextView);
            tv_dropboxToken = itemView.findViewById(R.id.dropboxTokenTextView);
            tv_createdAt = itemView.findViewById(R.id.createdAtTextView);
        }
    }
}
