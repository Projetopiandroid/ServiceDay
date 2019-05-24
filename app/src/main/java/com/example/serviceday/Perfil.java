package com.example.serviceday;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Perfil extends Fragment {

    Usuario usuario = new Usuario();
    TextView txt;
    public Perfil() {

    }

    public static Perfil newInstance() {
        Perfil fragment = new Perfil();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        //usuario.setEmail("leandro.almeida98@hotmail.com");
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        //txt = v.findViewById(R.id.idDesc);
        //txt.setText(usuario.getEmail());
        return v;
    }



}
