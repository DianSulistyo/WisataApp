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


public class ListWisataAdapter extends RecyclerView.Adapter<ListWisataAdapter.ListViewolder> {

    private ArrayList<Wisata> listwisata;

    private OnListClick onListClick;

    public ListWisataAdapter(ArrayList<Wisata> list) {
        this.listwisata = list;
    }

    public void setOnListClick(OnListClick onListClick) {
        this.onListClick = onListClick;
    }

    @NonNull
    @Override
    public ListViewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_wisata, parent, false);

        return new ListViewolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewolder holder, int position) {
        final Wisata wisata = listwisata.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListClick.OnItemClick(listwisata.get(holder.getAdapterPosition()));
            }
        });


        Glide.with(holder.itemView.getContext())
                .load(wisata.getPhoto())
                .apply(new RequestOptions().override(60, 60))
                .into(holder.imgPhoto);

        holder.tvName.setText(wisata.getName());
        holder.TvDeskripsi.setText(wisata.getDeskripsi());

    }


    @Override
    public int getItemCount() {
        return listwisata.size();
    }

    public class ListViewolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, TvDeskripsi;


        public ListViewolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            TvDeskripsi = itemView.findViewById(R.id.tv_deskripsi_name);
        }
    }

    public interface OnListClick{
        void OnItemClick(Wisata wisata);
    }

}