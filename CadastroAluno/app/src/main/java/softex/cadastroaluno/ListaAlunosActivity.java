package softex.cadastroaluno;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListaAlunosActivity extends ActionBarActivity {

    private EditText edNome;
    private Button botao;
    private ListView lvListagem;

    private List<String> listaAlunos;

    private ArrayAdapter<String> adapter;

    private int adapterLayout = android.R.layout.simple_list_item_1;

    private final String TAG = "CADASTRO_ALUNO";
    private final String ALUNOS_KEY = "LISTA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        edNome = (EditText) findViewById(R.id.editText);
        botao = (Button) findViewById(R.id.button);
        lvListagem = (ListView) findViewById(R.id.listView);

        listaAlunos = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this, adapterLayout, listaAlunos);

        lvListagem.setAdapter(adapter);


        botao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (!edNome.getText().toString().isEmpty()) {
                    listaAlunos.add(edNome.getText().toString());
                } else {
                    Toast.makeText(ListaAlunosActivity.this, "Digite um nome!", Toast.LENGTH_SHORT).show();
                }
                edNome.setText("");
                adapter.notifyDataSetChanged();

                Log.i("Array: ", listaAlunos.toString());
            }
        });

        lvListagem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaAlunosActivity.this,
                        "Aluno: " + listaAlunos.get(position), Toast.LENGTH_LONG).show();
            }
        });

        lvListagem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ListaAlunosActivity.this, "Aluno:" + listaAlunos.get(position) + "[click longo]", Toast.LENGTH_LONG).show();

                return true;
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {


        outState.putStringArrayList(ALUNOS_KEY, (ArrayList<String>) listaAlunos);

        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState(): " + listaAlunos);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        listaAlunos = savedInstanceState.getStringArrayList(ALUNOS_KEY);

        Log.i(TAG, "onSavaRestoreState(): " + listaAlunos);
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

        switch (item.getItemId()) {
            case R.id.action_formulario:
                Intent intent = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
