package com.example.serviceday;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;


//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class Principal extends AppCompatActivity {
    private TextView mTextMessage;
    private TextView teste;
    private final String TAG  = "DocsFirebase";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentManager fx = getFragmentManager();
                    FragmentTransaction fa = fx.beginTransaction();
                    fa.replace(R.id.frameid,new Contatos());
                    fa.commit();
                    return true;

                case R.id.navigation_service:

                    FragmentManager fe = getFragmentManager();
                    FragmentTransaction fl = fe.beginTransaction();
                    fl.replace(R.id.frameid,new Servico());
                    fl.commit();
                    return true;

                case R.id.navigation_profile:

                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frameid,new Perfil());
                    ft.commit();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportActionBar().hide();
        Usuario usuario = new Usuario();

        FirebaseUser userAuth = FirebaseAuth.getInstance().getCurrentUser();
        if (userAuth != null) {
            //PEGAR DADOS DO AUTHETICADOR

            // Name, email address, and profile photo Url
            usuario.setNome(userAuth.getDisplayName());
            usuario.setEmail(userAuth.getEmail());
            usuario.setFoto(userAuth.getPhotoUrl());

            // Check if user's email is verified
            boolean emailVerified = userAuth.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            usuario.setId(userAuth.getUid());


            // SALVAR NO BANCO
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            // Create a new user with a first and last name

            /*Map<String, Object> user = new HashMap<>();
            user.put("id", usuario.getId());
            user.put("nome", usuario.getNome());
            user.put("email", usuario.getEmail());
            //user.put("foto", usuario.getFoto());


            // Add a new document with a generated ID
            db.collection("users")
                    .add(user)
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
            */


            // PEGAR NO BANCO
            db.collection("users")
                    .whereEqualTo("id", "vP2LbwyqObPdnwcld5hxDsZ2ars2")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Log.d(TAG, document.getId() + " => " + document.getData());
                                }
                            } else {
                                Log.w(TAG, "Error getting documents.", task.getException());
                            }
                        }
                    });



        }



    }

}
