package com.example.ps_g8;

import static com.example.ps_g8.App.DB;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaPelisAdapter extends RecyclerView.Adapter<ListaPelisAdapter.PeliculaViewHolder> {
    private final String pelis = DB.getPelis().get(0).getTitulo();
    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_pelis, null, false);
        return new PeliculaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        holder.nombrePeli.setText(pelis.get(position).getTitulo());
        holder.añoPeli.setText(pelis.get(position).getAño());
        holder.generoPeli.setText(pelis.get(position).getGenero());
    }

    @Override
    public int getItemCount() {
        return pelis.size();
        }

    public class PeliculaViewHolder extends RecyclerView.ViewHolder {
        TextView nombrePeli, añoPeli, generoPeli;
        public PeliculaViewHolder(@NonNull View itemView) {
            super(itemView);

            nombrePeli = itemView.findViewById(R.id.viewNombre);
            añoPeli = itemView.findViewById(R.id.viewAño);
            generoPeli = itemView.findViewById(R.id.viewGenero);
        }
    }
}
