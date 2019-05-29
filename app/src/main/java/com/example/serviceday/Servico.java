package com.example.serviceday;

import android.content.Context;
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


    private final String TAG  = "DocsFirebase";

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




        // SALVAR NO BANCO
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // PEGAR NO BANCO
        db.collection("Services")
                //.whereEqualTo("email", userAuth.getEmail())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            boolean naocadastrado=true;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                tipoServ.setText(document.get("nomeServico").toString());
                                bairro.setText(document.get("Bairro").toString());
                                tel.setText(document.get("Telefone").toString());
                                desc.setText(document.get("DescricaoServe").toString());
                                email.setText(document.get("email").toString());

                            }
                        } else{
                            Log.w(TAG, "Error getting documents.", task.getException());
                            Log.d(TAG, " ------------------------------- CONSULTA DEU ERRADO AO MOSTRAR SERVICO ------------------------------- " );

                        }
                    }
                });
        Log.d(TAG, " ENTROU NO FRAGMENTO" );
        return v;
        }
    }

