package pe.edu.ulima.pokemonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pe.edu.ulima.pokemonapp.model.GestorPokemonApp;
import pe.edu.ulima.pokemonapp.model.Pregunta;

public class PreguntaActivity extends AppCompatActivity {

    ImageButton check,siguiente;
    TextView pregunta,txt;
    List<Pregunta> preguntas;
    int i=0;
    EditText respuesta;
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);



        check = (ImageButton)findViewById(R.id.check);
        siguiente = (ImageButton)findViewById(R.id.siguiente);
        pregunta = (TextView)findViewById(R.id.pregunta);
        txt = (TextView)findViewById(R.id.txt);
        respuesta = (EditText)findViewById(R.id.respuesta);
        imagen = (ImageView)findViewById(R.id.imagen);
        //obteniendo preguntas

        GestorPokemonApp gestor= GestorPokemonApp.getInstance();
        preguntas = gestor.obtenerPreguntas();

        //Mostrar preguntas
        pregunta.setText(String.format("Pregunta %s",preguntas.get(i).getId()));
        txt.setText(preguntas.get(i).getPregunta());
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if(preguntas.size()==i){
                    Intent intent=new Intent(PreguntaActivity.this,PuntajeActivity.class);
                    startActivity(intent);

                }else{
                    pregunta.setText(String.format("Pregunta %s",preguntas.get(i).getId()));
                    txt.setText(preguntas.get(i).getPregunta());
                }
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(respuesta.getText().toString().equalsIgnoreCase(preguntas.get(i).getRespuesta())){
                    imagen.setImageResource(preguntas.get(i).getImagen());
                    Toast msg= Toast.makeText(PreguntaActivity.this,"Respuesta correcta!!!!!", Toast.LENGTH_SHORT);
                    msg.show();
                }else{
                    Toast msg= Toast.makeText(PreguntaActivity.this,"Respuesta incorrecta!!!!!", Toast.LENGTH_SHORT);
                    msg.show();
                }
            }
        });











    }
}
