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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class ServicoCadastro extends Fragment {
    Usuario usuario = new Usuario();
    services servicosbanco = new services();
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

        final EditText descricao = v.findViewById(R.id.editText12);
        final EditText bairro = v.findViewById(R.id.editText11);
        final EditText telefone = v.findViewById(R.id.editText10);
        final Spinner spinner = v.findViewById(R.id.spinnerid);
        Button Salvar = v.findViewById(R.id.button3);
        final Usuario usuario = new Usuario();

        final String TAG  = "DocsFirebase";


        //Criando o Spiner e Populando valores
        String [] valores ={"Selecione o Tipo do Serviço","Marcenaria","Carpintaria","Energia","outros"};

        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, valores);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(LTRadapter);
        //-----------------------------------------------------------------------------------------------


        servicosbanco.setNomeServico(spinner.getSelectedItem().toString());
        Log.d(TAG, "SPINERRRRRRRRRRR: " +  servicosbanco.getNomeServico());



        //Ação de Salvar no Banco
        View.OnClickListener enviar = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                servicosbanco.setTelefone(telefone.getText().toString());
                servicosbanco.setBairro(bairro.getText().toString());
                servicosbanco.setDescrição(descricao.getText().toString());
                servicosbanco.setNomeServico(spinner.getSelectedItem().toString());


                FirebaseFirestore db = FirebaseFirestore.getInstance();
                Map<String, Object> ServicosBanco = new HashMap<>();
                ServicosBanco.put("email", usuario.getEmail());
                ServicosBanco.put("tipo", servicosbanco.getNomeServico());
                ServicosBanco.put("descricao", servicosbanco.getDescrição());
                ServicosBanco.put("bairro", servicosbanco.getBairro());
                ServicosBanco.put("tel", servicosbanco.getTelefone());

                // Add a new document with a generated ID
                db.collection("services")
                        .add(ServicosBanco)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });



            }
        };
        Salvar.setOnClickListener(enviar);
        //--------------------------------------------------------------------------------

        return v;
    }


}
