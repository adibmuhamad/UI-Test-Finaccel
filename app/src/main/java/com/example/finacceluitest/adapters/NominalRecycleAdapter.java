package com.example.finacceluitest.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.finacceluitest.views.LoanConfirmationActivity;
import com.example.finacceluitest.R;
import com.example.finacceluitest.contracts.NominalAdapterContract;
import com.example.finacceluitest.models.NominalModel;

import java.util.List;

import static com.example.finacceluitest.BaseActivity.storage;

public class NominalRecycleAdapter extends RecyclerView.Adapter<NominalRecycleAdapter.MyViewHolder>
implements NominalAdapterContract {

    Context mContext;
    private List<NominalModel> mNominalList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nominal, nominalRupiah;
        LinearLayout itemNominal;

        public MyViewHolder(View view) {
            super(view);
            itemNominal = view.findViewById(R.id.itemNominal);
            nominal = view.findViewById(R.id.txtNominal);
            nominalRupiah = view.findViewById(R.id.btnNominal);
        }
    }

    public NominalRecycleAdapter(Context context, List<NominalModel> nominalList) {
        this.mNominalList = nominalList;
        this.mContext = context;
    }

    @Override
    public NominalRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_option_nominal, parent, false);
        return new NominalRecycleAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final NominalModel lists = mNominalList.get(position);
        if(lists.getNominal() != null){
            holder.itemNominal.setVisibility(View.VISIBLE);
            holder.nominal.setText(lists.getNominal());
            holder.nominalRupiah.setText(lists.getNominalRupiah());

            holder.nominalRupiah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, LoanConfirmationActivity.class);
                    storage.setPhoneNumber(lists.getPhoneNumber());
                    storage.setNominal(lists.getNominal());
                    mContext.startActivity(intent);
                }
            });
        }else{
            holder.itemNominal.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mNominalList.size();
    }

    @Override
    public void updateNominalOption(List<NominalModel> nominalModel) {
        Log.d("DEMO", "ARRAY LIST = "+nominalModel.size());
        mNominalList = nominalModel;
        notifyDataSetChanged();
    }
}
