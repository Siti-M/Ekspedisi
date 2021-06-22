package com.example.Ekspedisi.rating;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Ekspedisi.R;
import com.example.Ekspedisi.entity.DataDiri;

import java.util.List;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.viewHolder> {
    Context context;
    List<DataDiri> list;
    RatingContract.view view;

    public RatingAdapter(Context context, List<DataDiri> list, RatingContract.view view) {
        this.view = view;
        this.context = context;
        this.list = list;
    }

    class viewHolder extends RecyclerView.ViewHolder{
        TextView tvNama, tvAlamat, tvGender, id;
        CardView cardView;

        public viewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_item_nama);
            tvAlamat = itemView.findViewById(R.id.tv_item_rating);
            tvGender = itemView.findViewById(R.id.tv_item_komentar);
            id = itemView.findViewById(R.id.tv_item_id);
            cardView = itemView.findViewById(R.id.cv_item);
        }
    }

    @NonNull
    @Override
    public RatingAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_rating, parent, false);
        return new viewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final RatingAdapter.viewHolder holder, int position) {
        final DataDiri item = list.get(position);
        holder.tvAlamat.setText(item.getRating());
        holder.tvGender.setText(String.valueOf(item.getKomentar()));
        holder.tvNama.setText(item.getName());
        holder.id.setText(String.valueOf(item.getId()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.editData(item);
            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                view.deleteData(item);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
