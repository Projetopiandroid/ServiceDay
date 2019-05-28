package com.example.serviceday;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class ServicoCadastro extends Fragment {

    public ServicoCadastro() {

    }


    public static ServicoCadastro newInstance() {

        ServicoCadastro fragment = new ServicoCadastro();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_servico_cadastro, container, false);

        EditText descricao = v.findViewById(R.id.editText12);
        EditText servico = v.findViewById(R.id.editText9);
        EditText bairro = v.findViewById(R.id.editText11);
        Spinner spinner = v.findViewById(R.id.spinnerid);
        Button Salvar = v.findViewById(R.id.button3);


        //Criando o Spiner e Populando valores
        String [] valores ={"Marcenaria","Carpintaria","Energia","outros"};

        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, valores);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(LTRadapter);
        //-----------------------------------------------------------------------------------------------

        //Ação de Salvar no Banco
        View.OnClickListener enviar = new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        };

        Salvar.setOnClickListener(enviar);
        //--------------------------------------------------------------------------------




        return v;
    }


}
