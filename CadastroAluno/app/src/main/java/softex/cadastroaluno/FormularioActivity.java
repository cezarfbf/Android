package softex.cadastroaluno;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.FileNotFoundException;


public class FormularioActivity extends ActionBarActivity {

    ImageView foto;
    EditText nome;
    EditText telefone;
    EditText site;
    EditText email;
    EditText endereco;
    SeekBar seekBar;
    Button btnSalvarDados;
    Aluno aluno = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_layout);

        foto = (ImageView) findViewById(R.id.imageView);
        nome = (EditText) findViewById(R.id.nome);
        telefone = (EditText) findViewById(R.id.telefone);
        site = (EditText) findViewById(R.id.site);
        email = (EditText) findViewById(R.id.email);
        endereco = (EditText) findViewById(R.id.endereco);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        btnSalvarDados = (Button) findViewById(R.id.btn_salvar_dados);


        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    openFileOutput("", Context.MODE_PRIVATE);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

        btnSalvarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //aluno.setFoto();
                //aluno.setNome(nome.getText().toString());
                //aluno.setTelefone(telefone.getText().toString());
                //aluno.setEmail(email.getText().toString());
                //aluno.setSite(site.getText().toString());
                //aluno.setEndereco(endereco.getText().toString());
                //aluno.setNota();

            }
        });
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_aplication, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.action_formulario:
                //Toast.makeText(FormularioActivity.this,"cadastrar aluno clicado",Toast.LENGTH_SHORT).show();

                return false;
            case R.id.action_listar_alunos:
                Intent intent = new Intent(FormularioActivity.this, ListaAlunosActivity.class);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
