package com.example.serviceday;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
        TextView Email = v.findViewById(R.id.idEmail);
        TextView Nome = v.findViewById(R.id.idNome);
        TextView Tel = v.findViewById(R.id.idTel);
        LinearLayout whatsAcao = v.findViewById(R.id.idLayout_Contato_Whats);
        LinearLayout emailAcao = v.findViewById(R.id.idLayout_Contato_Email);
        //TextView Servicos = v.findViewById(R.id.idNome);

        whatsAcao.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //TODO  FAZER METODO PARA PEGAR TELEFONE DO PROFISSIONAL CLICADO
                //DICA CRIAR CLASSE PROFISSIONAL OU CRIAR ESPECIALIZAÇÃO COM HERANÇA
                String url = "https://api.whatsapp.com/send?phone="+usuario.getTelefone()+"&text=sua%20mensagem";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                return false;
            }
        });

        Nome.setText(usuario.getNome());
        Email.setText(usuario.getEmail());
        Tel.setText(usuario.getTelefone());

        //

        return v;
    }





}
