package com.example.android.testapp.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.testapp.model.Data;
import com.example.android.testapp.ItemPage.PlaceActivity;
import com.example.android.testapp.R;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Data> data;
    private Context mContext;

    public RecycleViewAdapter(Context context, ArrayList<Data> data) {
        this.data = data;
        this.mContext = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item_row, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(data.get(position).getImage())
                .into(holder.image);

        holder.title.setText(data.get(position).getTitle());
        holder.price.setText(data.get(position).getPrice());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Click: " + data.get(position).getTitle(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(mContext,PlaceActivity.class);

                i.putExtra("Title",data.get(position).getTitle());
                i.putExtra("Image",data.get(position).getImage().toString());

                mContext.startActivity(i);
            }

        });
    }



    @Override
    public int getItemCount() {
        return data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;
        TextView price;
        CardView cardView ;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            cardView = itemView.findViewById(R.id.card_view);
        }

    }

}