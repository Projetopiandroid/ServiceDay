package com.example.serviceday;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;


public class Servico extends Fragment {

    public static String[][] listaDados = new String[50][50];
    private final String TAG  = "DocsFirebase";
    int y = 0, i =0;
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

        final TextView tipoServ = v.findViewById(R.id.idTipoServ);
        final TextView bairro = v.findViewById(R.id.idBairro);
        final TextView tel = v.findViewById(R.id.idTel);
        final TextView desc = v.findViewById(R.id.idDesc);
        final TextView email = v.findViewById(R.id.idEmail);

        final Button ButtonProx = v.findViewById(R.id.idButtonProx);

        tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DICA CRIAR CLASSE PROFISSIONAL OU CRIAR ESPECIALIZAÇÃO COM HERANÇA
                String url = "https://api.whatsapp.com/send?phone="+tel.getText().toString()+"&text=sua%20mensagem";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("mailto:" + email.getText().toString()));
                startActivity(intent);
            }
        });




        // SALVAR NO BANCO
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        // PEGAR NO BANCO
        db.collection("services")
                //.whereEqualTo("email", userAuth.getEmail())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {


                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                tipoServ.setText("#"+document.get("tipo").toString());
                                bairro.setText(document.get("bairro").toString());
                                tel.setText(document.get("tel").toString());
                                desc.setText(document.get("descricao").toString());
                                email.setText(document.get("email").toString());
                            }
                        } else{
                            Log.w(TAG, "Error getting documents.", task.getException());
                            Log.d(TAG, " ------------------------------- CONSULTA DEU ERRADO AO MOSTRAR SERVICO ------------------------------- " );
                        }

                    }

                });



        /*
        */

        Log.d(TAG, " ENTROU NO FRAGMENTO" );
        return v;
        }


    }

