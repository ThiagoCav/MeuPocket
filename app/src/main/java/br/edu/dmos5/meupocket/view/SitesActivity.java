package br.edu.dmos5.meupocket.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.edu.dmos5.meupocket.R;
import br.edu.dmos5.meupocket.dao.SiteDao;
import br.edu.dmos5.meupocket.model.Site;

public class SitesActivity extends AppCompatActivity {
    //Referência para o elemento de RecyclerView
    private RecyclerView sitesRecyclerView;

    private List<Site> siteList;

    private ItemSiteAdapter siteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites);

        sitesRecyclerView = findViewById(R.id.recycler_lista_sites);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        sitesRecyclerView.setLayoutManager(layoutManager);

        siteList = SiteDao.recuperateAll();

        siteAdapter = new ItemSiteAdapter(siteList);
        sitesRecyclerView.setAdapter(siteAdapter);
    }

    private String corrigeEndereco(String endereco){
        String url = endereco.trim().replace("","");
        if(!url.startsWith("http://")){
            return "http://" + url;
        }
        return url;
    }
}

