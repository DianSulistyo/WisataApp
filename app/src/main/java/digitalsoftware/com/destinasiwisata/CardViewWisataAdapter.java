package digitalsoftware.com.destinasiwisata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewWisataAdapter extends RecyclerView.Adapter<CardViewWisataAdapter.CardViewHolder> {
    private ArrayList<Wisata> listWisata;

    public CardViewWisataAdapter(ArrayList<Wisata> list) {
        this.listWisata = list;
    }


    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_wisata, parent, false);
        return new CardViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Wisata wisata = listWisata.get(position);

        Glide.with(holder.itemView.getContext())
                .load(wisata.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(wisata.getName());
        holder.tvDeskripsi.setText(wisata.getDeskripsi());
    }


    @Override
    public int getItemCount() {
        return listWisata.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDeskripsi;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.tv_deskripsi_name);

        }
    }
}
