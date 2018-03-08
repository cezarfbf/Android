package projeto.menuup.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import projeto.menuup.R;
import projeto.menuup.interfaces.RecyclerViewOnClickListenerHack;
import projeto.menuup.objetos.Place;
import projeto.menuup.objetos.Store;


/**
 * Created by cezar on 05/08/2015.
 */
public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
    private List<Store> list;
    private LayoutInflater layoutInflater;
    private RecyclerViewOnClickListenerHack rvocl;

    public StoreAdapter(Context context, List<Store> list) {
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.objeto_store, parent, false);
        MyViewHolder mvh = new MyViewHolder(view);
        return mvh;
    }

    @Override
    public void onBindViewHolder(StoreAdapter.MyViewHolder holder, int position) {
        holder.ivStore.setImageResource(list.get(position).getFoto());
        holder.tvStore.setText(list.get(position).getNome());
        holder.tvLocalizacao.setText(list.get(position).getRua()+","+list.get(position).getNumero());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        rvocl = r;
    }

    public void addListItem(Store store,int position){
        list.add(store);
        notifyItemInserted(position);
    }

    public void removeListItem(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView ivStore;
        public TextView tvStore;
        public TextView tvLocalizacao;


        public MyViewHolder(View itemView) {
            super(itemView);
            ivStore = (ImageView) itemView.findViewById(R.id.iv_place);
            tvStore = (TextView) itemView.findViewById(R.id.tv_nome);
            tvLocalizacao = (TextView) itemView.findViewById(R.id.tv_endereco);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (rvocl != null){
                rvocl.onClickListener(v,getPosition());
            }
        }
    }


}
