package digitalsoftware.com.destinasiwisata;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvWisata;
    private ArrayList<Wisata> list = new ArrayList<>();

    public static String photo, nama_wisata, deskripsi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvWisata = findViewById(R.id.rv_wisata);
        rvWisata.setHasFixedSize(true);


        list.addAll(WisataData.getListData());
        showRecylerList();


    }

    private void showRecylerList() {
        rvWisata.setLayoutManager(new LinearLayoutManager(this));
        ListWisataAdapter listWisataAdapter = new ListWisataAdapter(list);
        rvWisata.setAdapter(listWisataAdapter);
        listWisataAdapter.setOnListClick(new ListWisataAdapter.OnListClick() {
            @Override
            public void OnItemClick(Wisata wisata) {
                showDetailWisata(wisata);
            }
        });

    }

    private void showRecylerCardView() {
        rvWisata.setLayoutManager(new LinearLayoutManager(this));
        CardViewWisataAdapter cardViewWisataAdapter = new CardViewWisataAdapter(list);
        rvWisata.setAdapter(cardViewWisataAdapter);
    }

    private void showDetailWisata(Wisata wisata) {
        nama_wisata = wisata.getName();
        deskripsi = wisata.getDeskripsi();
        photo = wisata.getPhoto();

        Intent intent = new Intent(this, DetailWisata.class);
        intent.putExtra("nama", nama_wisata);
        intent.putExtra("deskripsi", deskripsi);
        intent.putExtra("foto", photo);
        startActivity(intent);


    }

    private void showProfile() {
        rvWisata.setLayoutManager(new LinearLayoutManager(this));
        ListWisataAdapter listWisataAdapter = new ListWisataAdapter(list);
        rvWisata.setAdapter(listWisataAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.miProfile:
                Intent intent = new Intent(this, ProfileAct.class);
                startActivity(intent);
                break;
        }
    }


}
