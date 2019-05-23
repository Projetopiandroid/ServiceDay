package com.example.serviceday;

import android.content.Context;
import android.net.Uri;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Contatos extends Fragment {



    public Contatos() {


    }



    public static Contatos newInstance(){
        Contatos fragment = new Contatos();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            View v = inflater.inflate(R.layout.fragment_contatos, container, false);


            return v;
        }


}
