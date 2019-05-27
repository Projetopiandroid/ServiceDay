package com.example.serviceday;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Perfil extends Fragment {

    Usuario usuario = new Usuario();
    private final String TAG  = "DocsFirebase";

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
        TextView Descricao = v.findViewById(R.id.idDesc);
        TextView Nome = v.findViewById(R.id.idNome);
        //TextView Servicos = v.findViewById(R.id.idNome);

        Nome.setText(usuario.getNome());

        //https://api.whatsapp.com/send?phone=5571983735644&text=sua%20mensagem

        return v;
    }





}
