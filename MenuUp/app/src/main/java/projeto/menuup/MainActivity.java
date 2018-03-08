package projeto.menuup;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import projeto.menuup.fragments.PlaceFragment;
import projeto.menuup.objetos.Place;
import projeto.menuup.objetos.Store;

public class MainActivity extends ActionBarActivity {
    private Toolbar toolbar;
    private Toolbar toolbarBotton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tb_main);
        toolbar.setTitle("MenuUp");
        toolbar.setSubtitle("seu app de promoções");
        toolbar.setLogo(R.drawable.food);
        setSupportActionBar(toolbar);

        toolbarBotton = (Toolbar) findViewById(R.id.inc_tb_botton);
        toolbarBotton.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent it = null;

                switch (menuItem.getItemId()){
                    case R.id.action_facebook:
                        it = new Intent(Intent.ACTION_VIEW);
                        it.setData(Uri.parse("http://www.facebook.com"));
                        break;
                    case R.id.action_youtube:
                        it = new Intent(Intent.ACTION_VIEW);
                        it.setData(Uri.parse("http://www.youtube.com"));
                        break;
                    case R.id.action_twitter:
                        it = new Intent(Intent.ACTION_VIEW);
                        it.setData(Uri.parse("http://www.twitter.com"));
                        break;
                    case R.id.action_whatsapp:
                        it = new Intent(Intent.ACTION_VIEW);
                        it.setData(Uri.parse("http://www.whasapp.com"));
                        break;
                }

                startActivity(it);
                return true;
            }
        });
        toolbarBotton.inflateMenu(R.menu.menu_bottom);
        toolbarBotton.findViewById(R.id.iv_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"settings press",Toast.LENGTH_SHORT).show();
            }
        });

        //fragment
        PlaceFragment frag = (PlaceFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
        if(frag == null) {
            frag = new PlaceFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_fragment_cotainer, frag, "mainFrag");
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public List<Place> getSetPlaceList(int qtd){
         List<Place> listAux = new ArrayList<>();
        Place rioMar = new Place();
        rioMar.setNome("RioMar Shopping");
        rioMar.setRua("Av. República do Líbano");
        rioMar.setNumero(251);
        rioMar.setFoto(R.drawable.riomar);
        rioMar.set_id(1001);

        Place paco = new Place();
        paco.setNome("Paço Alfândega");
        paco.setRua("Rua da Alfândega");
        paco.setNumero(35);
        paco.setFoto(R.drawable.paco);
        paco.set_id(1002);

        Place recife = new Place();
        recife.setNome("Shopping Recife");
        recife.setRua("R. Padre Carapuceiro");
        recife.setNumero(777);
        recife.setFoto(R.drawable.recife);
        recife.set_id(1003);

        listAux.add(paco);
        listAux.add(rioMar);
        listAux.add(recife);


        return(listAux);
    }

    public List<Store> getSetStoreList(int qtd){
        List<Store> listAux = new ArrayList<>();
        Store michelli = new Store();
        michelli.setNome("Michelli");
        michelli.setRua("Loja P250 1° PISO");
        michelli.setPlace(1003);
        michelli.setFoto(R.drawable.michelli);

        Store outback = new Store();
        outback.setNome("Outback");
        outback.setRua("Loja P325 1° PISO");
        outback.setPlace(1003);
        outback.setFoto(R.drawable.outback);

        Store outbackrm = new Store();
        outbackrm.setNome("OUTBACK STEAKHOUSE");
        outbackrm.setRua("R. Padre Carapuceiro");
        outbackrm.setPlace(1003);
        outbackrm.setFoto(R.drawable.recife);

        listAux.add(outback);
        listAux.add(michelli);
        listAux.add(outbackrm);


        return(listAux);
    }
}
