package pe.edu.ulima.pokemonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PuntajeActivity extends AppCompatActivity {
    Button reintentar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);
        TextView puntos=(TextView)findViewById(R.id.puntos);
        Bundle bundle=getIntent().getExtras();
        int puntaje=bundle.getInt("puntos");
        puntos.setText(String.valueOf(puntaje));

        reintentar=(Button)findViewById(R.id.reintentar);

        reintentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PuntajeActivity.this,PreguntaActivity.class);
                startActivity(intent);
            }
        });


    }
}
