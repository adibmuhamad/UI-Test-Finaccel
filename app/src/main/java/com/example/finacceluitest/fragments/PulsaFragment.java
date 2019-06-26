package com.example.finacceluitest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finacceluitest.utils.EditTextWithClear;
import com.example.finacceluitest.R;
import com.example.finacceluitest.adapters.CardPromoAdapter;
import com.example.finacceluitest.adapters.NominalRecycleAdapter;
import com.example.finacceluitest.models.NominalModel;
import com.example.finacceluitest.models.PromoModel;

import java.util.ArrayList;

public class PulsaFragment extends Fragment {

    private Context mContext;
    private RecyclerView mOptionNominalVIew, mCardPromoView;
    private NominalRecycleAdapter mNominalAdapter;
    private CardPromoAdapter mCardPromoAdapter;
    private ArrayList<PromoModel> mPromoArray;
    private ArrayList<NominalModel> mNominalArray;
    private NominalModel mNominalModel;
    private PromoModel mPromoModel;
    private EditTextWithClear txtNominal;

    private String nominal[] = {"25.000","50.000","100.000","150.000","200.000"};
    private String nominalRupiah[] = {"Rp 25.000","Rp 50.000","Rp 100.000","Rp 150.000","Rp 195.000"};
    private Integer promo[] = {R.drawable.ic_promo, R.drawable.ic_promo, R.drawable.ic_promo};

    public PulsaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pulsa,container,false);

        mOptionNominalVIew = view.findViewById(R.id.optionNominal);
        mCardPromoView = view.findViewById(R.id.cardPromo);
        txtNominal = view.findViewById(R.id.inputNominal);

        RecyclerView.LayoutManager layoutManagerNominal = new LinearLayoutManager(mContext);
        mOptionNominalVIew.setLayoutManager(layoutManagerNominal);
        mOptionNominalVIew.setItemAnimator(new DefaultItemAnimator());

        RecyclerView.LayoutManager layoutManagerPromo = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        mCardPromoView.setLayoutManager(layoutManagerPromo);
        mCardPromoView.setItemAnimator(new DefaultItemAnimator());

        mNominalArray = new ArrayList<>();

        mNominalModel = new NominalModel(null,null, null);
        mNominalArray.add(mNominalModel);

        mPromoArray = new ArrayList<>();

        for (int i = 0; i < promo.length; i++) {
            mPromoModel = new PromoModel(promo[i]);
            mPromoArray.add(mPromoModel);
        }
        mCardPromoAdapter = new CardPromoAdapter(mContext, mPromoArray);
        mCardPromoView.setAdapter(mCardPromoAdapter);

        mNominalAdapter = new NominalRecycleAdapter(mContext,mNominalArray);
        mOptionNominalVIew.setAdapter(mNominalAdapter);

        txtNominal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() >= 4){
                    mNominalArray = new ArrayList<>();
                    for (int i = 0; i < nominal.length; i++) {
                        mNominalModel = new NominalModel(nominal[i],nominalRupiah[i], s.toString());
                        mNominalArray.add(mNominalModel);
                    }
                }else{
                    mNominalArray = new ArrayList<>();
                }
                mNominalAdapter.updateNominalOption(mNominalArray);
            }
        });

        return view;
    }

}
