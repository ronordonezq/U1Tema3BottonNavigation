package com.example.u1tema3bottonnavigation;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GridFragment extends Fragment {
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view= inflater.inflate(R.layout.fragment_grid,container,false);
    GridView gv = view.findViewById(R.id.migridview);
    ArrayAdapter miarrayadapter= ArrayAdapter.createFromResource(getActivity(),R.array.lista,android.R.layout.simple_list_item_1);
    gv.setAdapter(miarrayadapter);
    return view;
  }
}

