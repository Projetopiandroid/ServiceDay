package com.example.serviceday;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class Servico extends Fragment {



    public Servico() {
        // Required empty public constructor
    }

        public static Servico newInstance() {
        Servico fragment = new Servico();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_servico, container, false);

        EditText procura = v.findViewById(R.id.editText8);
        Button pesquisa = v.findViewById(R.id.button4);
        ListView lista = v.findViewById(R.id.listaid);


        //Ação do Botao--------------------------------------------------------------------------
        View.OnClickListener ver = new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        };
        pesquisa.setOnClickListener(ver);
        //----------------------------------------------------------------------------------------

        return v;
        }
    }

