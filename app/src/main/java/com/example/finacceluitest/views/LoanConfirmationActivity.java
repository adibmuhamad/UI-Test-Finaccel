package com.example.finacceluitest.views;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finacceluitest.BaseActivity;
import com.example.finacceluitest.R;

import java.util.Objects;

import static com.example.finacceluitest.BaseApplication.backToMain;

public class LoanConfirmationActivity extends BaseActivity {

    private Context mContext;
    private String phoneNumber, nominal;
    private TextView txtPhoneNumber, txtOtpALert, txtPrice, txtTotalPrice;
    private TextInputEditText mInputPIN;
    private Button btnPay;
    private ImageView btnBack;
    private CoordinatorLayout mCoordinatorLyt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_loan_confirmation);
        mContext = LoanConfirmationActivity.this;

        txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
        txtOtpALert = findViewById(R.id.txtOTPAlert);
        txtPrice = findViewById(R.id.txtPrice);
        txtTotalPrice = findViewById(R.id.txtTotalPrice);
        mInputPIN = findViewById(R.id.inputPIN);
        btnPay = findViewById(R.id.btnPay);
        btnBack = findViewById(R.id.btnBack);
        mCoordinatorLyt = findViewById(R.id.coordinatorLyt);

        mInputPIN.setTransformationMethod(new PasswordTransformationMethod());

        nominal = storage.getNominal();
        phoneNumber = storage.getPhoneNumber();
        txtPhoneNumber.setText(phoneNumber);

        if(Integer.parseInt(nominal.replace(".","")) < 200000){
            txtOtpALert.setVisibility(View.VISIBLE);
        }else{
            txtOtpALert.setVisibility(View.GONE);
        }

        String price = "Rp " + nominal;
        txtPrice.setText(price);
        txtTotalPrice.setText(price);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    if(Objects.requireNonNull(mInputPIN.getText()).length() < 1 || mInputPIN.getText() == null){
                        //Toast.makeText(LoanConfirmationActivity.this, "Please Insert PIN First", Toast.LENGTH_SHORT).show();
                        Snackbar snackbar = Snackbar
                                .make(mCoordinatorLyt, getString(R.string.txt_input_pin), Snackbar.LENGTH_LONG);

                        snackbar.show();
                    }else{
                        Intent intent = new Intent(mContext, PaymentDetailActivity.class);
                        storage.setNominal(nominal);
                        storage.setPhoneNumber(phoneNumber);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain(mContext);
            }
        });
    }

    @Override
    public void onBackPressed() {
        backToMain(mContext);
    }
}
