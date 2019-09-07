package digitalsoftware.com.destinasiwisata;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailWisata extends AppCompatActivity {
    public static String photo, nama_wisata, deskripsi;

    private String title = "Detail Wisata";

    ImageView img_wisata;
    TextView namawisata, deskripsiwisata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_cardview_wisata);
        setActionBarTitle(title);


        nama_wisata = getIntent().getStringExtra("nama");
        deskripsi = getIntent().getStringExtra("deskripsi");
        photo = getIntent().getStringExtra("foto");

        img_wisata = findViewById(R.id.img_item_photo);
        namawisata = findViewById(R.id.tv_item_name);
        deskripsiwisata = findViewById(R.id.tv_deskripsi_name);


        Glide.with(this)
                .load(photo)
                .apply(new RequestOptions().centerCrop())
                .into(img_wisata);


        namawisata.setText(nama_wisata);
        deskripsiwisata.setText(deskripsi);

    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

}
