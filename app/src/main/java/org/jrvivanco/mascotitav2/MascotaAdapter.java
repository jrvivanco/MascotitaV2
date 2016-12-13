package org.jrvivanco.mascotitav2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ernesto on 12/12/16.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;

    public MascotaAdapter(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, final int position) {
        final Mascota mascota = mascotas.get(position);
        holder.ivImagen.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRaiting.setText(String.valueOf(mascota.getRating()));

        holder.ibLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Un like para " + mascota.getNombre() + "!", Toast.LENGTH_SHORT).show();
                mascota.setRating(mascota.getRating() + 1);
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImagen;
        private TextView tvNombre;
        private TextView tvRaiting;
        ImageButton ibLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            ivImagen = (ImageView) itemView.findViewById(R.id.ivImagen);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvRaiting = (TextView) itemView.findViewById(R.id.tvRaiting);
            ibLike = (ImageButton) itemView.findViewById(R.id.ibLike);
        }
    }
}
