package org.jrvivanco.mascotitav2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionbar = (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(actionbar);

        ImageButton ibTop = (ImageButton) findViewById(R.id.ibTop);
        ibTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FavMascotas.class);
                startActivity(intent);

            }
        });

        FloatingActionButton fabFoto = (FloatingActionButton) findViewById(R.id.fabFoto);
        fabFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Proximamente", Toast.LENGTH_SHORT).show();
            }
        });

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador() {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas);
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Ashera", R.drawable.ashera));
        mascotas.add(new Mascota("Maine Coon", R.drawable.maine_coon));
        mascotas.add(new Mascota("Persa", R.drawable.persa));
        mascotas.add(new Mascota("Ragdoll", R.drawable.ragdoll));
        mascotas.add(new Mascota("Ruso Azul", R.drawable.ruso_azul));
        mascotas.add(new Mascota("Siames", R.drawable.siames));
        mascotas.add(new Mascota("Siberiano", R.drawable.siberiano));
    }
}
