package com.viquitor.calendar.view.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.viquitor.calendar.R;
import com.viquitor.calendar.model.Evento;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Evento> {
    public ListAdapter(@NonNull Context context, ArrayList<Evento> dataArrayList){
        super(context, R.layout.activity_lista, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent){
       Evento evento = getItem(position);

       if(view == null) {
           view = LayoutInflater.from(getContext()).inflate(R.layout.activity_lista, parent, false);
       }
           ImageView eventoImage = view.findViewById(R.id.listImage);
           TextView eventoName = view.findViewById(R.id.listNames);
           TextView eventoData = view.findViewById(R.id.listData);

           eventoImage.setImageResource(Integer.parseInt(evento.getFoto()));
           eventoName.setText(evento.getNome());
           eventoData.setText(evento.getData());

           return view;
    }


}
