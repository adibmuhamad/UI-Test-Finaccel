package com.example.finacceluitest.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finacceluitest.BaseActivity;
import com.example.finacceluitest.R;

import static com.example.finacceluitest.BaseApplication.backToMain;

public class PaymentDetailActivity extends BaseActivity {

    private Context mContext;
    private TextView txtPhoneNumber, txtPrice, txtTotalPrice;
    private Button btnConfirm;
    private ImageView btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_payment_detail);
        mContext = PaymentDetailActivity.this;

        txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
        txtPrice = findViewById(R.id.txtPrice);
        txtTotalPrice = findViewById(R.id.txtTotalPrice);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnClose = findViewById(R.id.btnClose);

        txtPhoneNumber.setText(storage.getPhoneNumber());
        String price = "Rp " + storage.getNominal();
        txtPrice.setText(price);
        txtTotalPrice.setText(price);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain(mContext);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain(mContext);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
