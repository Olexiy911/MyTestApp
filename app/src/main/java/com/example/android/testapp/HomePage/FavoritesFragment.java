package com.example.android.testapp.HomePage;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.testapp.Utils.QueryUtil;
import com.example.android.testapp.model.Data;
import com.example.android.testapp.R;
import com.example.android.testapp.Utils.RecycleViewAdapter;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {
    Context context;
    public FavoritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_store, container, false);

        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");


        final ArrayList<Data> places = QueryUtil.extractData(context);


        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        RecycleViewAdapter adapter = new RecycleViewAdapter( getActivity(),places);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

        return rootView;
    }

}
