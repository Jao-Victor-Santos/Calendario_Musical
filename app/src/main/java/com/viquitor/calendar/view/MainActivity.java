package com.viquitor.calendar.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.viquitor.calendar.R;

import android.view.View;
import android.widget.AdapterView;

import com.viquitor.calendar.databinding.ActivityMainBinding;
import com.viquitor.calendar.model.Evento;
import com.viquitor.calendar.view.Adapter.ListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Evento> eventoList;
    ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String data = "";

        try {
            URL url = new URL("https://script.google.com/macros/s/AKfycbxInOqu_1PZqe07gPbysHdZ4-zOf43pQdqYfoiPwMA6lRE8bhrPxrv8OpwUC_jFMUol/exec");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputSteam = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputSteam));
            String line;

            while((line = bufferedReader.readLine()) != null){
                data = data+line;
            }

            if (!data.isEmpty()){
                JSONObject jsonObject = new JSONObject(data);
                JSONArray datas = jsonObject.getJSONArray("data");
                eventoList.clear();
                for (int i = 0; i < datas.length(); i++) {
                    JSONObject item = datas.getJSONObject(i);

                    String nome = item.getString("nome");
                    String cidade = item.getString("cidade");
                    String endereco = item.getString("endereco");
                    String comum = item.getString("comum");
                    String date = item.getString("data");
                    String horario = item.getString("horario");
                    String foto = item.getString("imagem");

                    Evento e = new Evento(nome, cidade, endereco, comum, date, horario, foto);

                    eventoList.add(e);
                }
            }

        } catch (MalformedURLException e) {
            System.out.println("Deu erro 1");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Deu erro 2");
            throw new RuntimeException(e);
        } catch (JSONException e) {
            System.out.println("Deu erro 3");
            throw new RuntimeException(e);
        }

        listAdapter = new ListAdapter(MainActivity.this, eventoList);
        binding.mainList.setAdapter(listAdapter);
        binding.mainList.setClickable(true);
        binding.mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalhesActivity.class);

                for (Evento e: eventoList) {
                    intent.putExtra("nome", e.getNome());
                    intent.putExtra("foto", e.getFoto());
                    intent.putExtra("data", e.getData());
                    intent.putExtra("horario", e.getHorario());
                    intent.putExtra("cidade", e.getCidade());
                    intent.putExtra("comum", e.getComum());
                    intent.putExtra("endereco", e.getEndereco());


                    startActivity(intent);
                }
            }
        });
    }
}