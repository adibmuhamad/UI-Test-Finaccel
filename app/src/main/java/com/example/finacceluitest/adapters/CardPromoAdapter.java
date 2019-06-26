package com.example.finacceluitest.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.finacceluitest.views.MerchantPromoActivity;
import com.example.finacceluitest.R;
import com.example.finacceluitest.models.PromoModel;

import java.util.ArrayList;

public class CardPromoAdapter extends RecyclerView.Adapter<CardPromoAdapter.ViewHolder> {

    Context mContext;
    ArrayList<PromoModel> mPromoArray;

    public CardPromoAdapter(Context context, ArrayList<PromoModel> model) {
        this.mContext = context;
        this.mPromoArray = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_promo,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imgPromo.setImageResource(mPromoArray.get(position).getImgPromo());
    }

    @Override
    public int getItemCount() {
        return mPromoArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPromo;
        public ViewHolder(View itemView) {
            super(itemView);
            imgPromo = itemView.findViewById(R.id.imgPromo);
            imgPromo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, MerchantPromoActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
