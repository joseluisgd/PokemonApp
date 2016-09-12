package pe.edu.ulima.pokemonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText usu;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usu = (EditText)findViewById(R.id.usu);
        Button but= (Button)findViewById(R.id.but);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario= usu.getText().toString();
                Intent intent = new Intent(LoginActivity.this,PreguntaActivity.class);
                intent.putExtra("usu",usuario);
                startActivity(intent);

            }
        });
    }
}
