package com.example.finacceluitest.views;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finacceluitest.BaseActivity;
import com.example.finacceluitest.R;

import static com.example.finacceluitest.BaseApplication.backToMain;

public class MerchantPromoActivity extends BaseActivity {

    private Context mContext;
    private TextView txtTermCond;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_merchant_promo);
        mContext = MerchantPromoActivity.this;

        txtTermCond = findViewById(R.id.txtTermCond);
        btnBack = findViewById(R.id.btnBack);

        String TermCondition = "Promo berlaku untuk transaksi yang dilakukan\n" +
                "diaplikasikan terbaru Bukalapak.\n\n"+
                "Gunakan kode BIRTDAY9 untuk dapatkan \ncashback sebesar 3%.\n\n"+
                "Promo hanya berlaku untuk transaksi yang \nmenggunakan metode "+
                "pengiriman J&T Express \ndan Ninja Xpress (REG dan FAST).\n\n"+
                "Setiap pengguna bisa menggunkan promo \nsebanyak 1 (satu) kali dan "+
                "maksimal 2 (dua)\nkali selama periode Promo.\n\n"+
                "Promo bisa digunakan untuk belanja produk \nkategori apa saja "+
                "yang ada di Bukalapak, kecuali\nkategori tiket dan voucher, produk virtual "+
                "(pulsa,\npaket data, voucher game, listrik prabayar &amp;\n"+
                "pascabayar, tiket event, tiket pesawat, tiket kereta,\n"+
                "pembayaran zakat online, pembayaran tagihan\n"+
                "listrik, air PDAM, dan BPJS) dan produk keuangan\n"+
                "(BukaEmas dan BukaReksa).";

        String arr[] = TermCondition.split("\n\n");

        int bulletGap = (int) dp(10);

        SpannableStringBuilder ssb = new SpannableStringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String line = arr[i];
            SpannableString ss = new SpannableString(line);
            ss.setSpan(new BulletSpan(bulletGap), 0, line.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ssb.append(ss);

            //avoid last "\n"
            if(i+1<arr.length)
                ssb.append("\n\n");
        }

        txtTermCond.setText(ssb);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain(mContext);
            }
        });
    }

    private float dp(int i) {
        return getResources().getDisplayMetrics().density * i;
    }

    @Override
    public void onBackPressed() {
        backToMain(mContext);
    }
}
