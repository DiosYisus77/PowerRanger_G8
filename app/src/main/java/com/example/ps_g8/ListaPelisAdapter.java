package com.example.ps_g8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*public class ListaPelisAdapter extends RecyclerView.Adapter<ListaPelisAdapter.PeliculaViewHolder> {
    public Database userData;
    public ListaPelisAdapter(Database userData) {
        this.userData = userData;
    }

    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_pelis, null, false);
        return new PeliculaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        for (int i = 0; i<userData.getListP().size();i++){
            Pelicula pelis = new Pelicula(userData.getListP().get(i).getTitulo(), userData.getListP().get(i).getAño(), userData.getListP().get(i).getGenero());
            holder.nombrePeli.setText(pelis.getTitulo());
            holder.añoPeli.setText(pelis.getAño());
            holder.generoPeli.setText(pelis.getGenero());
        }
    }

    @Override
    public int getItemCount() {
        return userData.getListP().size();
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

 */
