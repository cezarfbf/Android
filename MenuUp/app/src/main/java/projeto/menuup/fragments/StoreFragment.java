package projeto.menuup.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import projeto.menuup.MainActivity;
import projeto.menuup.R;
import projeto.menuup.adapters.PlaceAdapter;
import projeto.menuup.adapters.StoreAdapter;
import projeto.menuup.interfaces.RecyclerViewOnClickListenerHack;
import projeto.menuup.objetos.Store;

/**
 * Created by cf on 26/08/2015.
 */
public class StoreFragment extends Fragment implements RecyclerViewOnClickListenerHack {

    private static final String TAG = "LOG";
    private RecyclerView mRecyclerView;
    private List<Store> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_place, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                PlaceAdapter adapter = (PlaceAdapter) mRecyclerView.getAdapter();

               /* if (mList.size() == llm.findLastCompletelyVisibleItemPosition() + 1) {
                    List<Place> listAux = ((MainActivity)getActivity()).getSetPlaceList(10);
                    for (int i=0;i<listAux.size();i++){
                        adapter.addListItem(listAux.get(i),mList.size());
                    }

                }*/
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        mList = ((MainActivity)getActivity()).getSetStoreList(10);
        StoreAdapter adapter = new StoreAdapter(getActivity(),mList);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClickListener(View view, int position) {

    }

    @Override
    public void onLongPressClickListener(View view, int position) {

    }
}
