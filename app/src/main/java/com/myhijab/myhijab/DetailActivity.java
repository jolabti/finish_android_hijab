package com.myhijab.myhijab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.apache.http.HttpResponse;

import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class DetailActivity extends AppCompatActivity {

    int a, b, hitungHarga;
    Config base_url = new Config();
    String BASE_URL = base_url.getUrl();

    String str = "";
    ImageView varImage;
    TextView tvIdNamaHijab, tvIdKodeHijab, tvIdBahanHijab, tvIdJenisHijab, tvIdStokHijab, tvIdHargaHijab;
    EditText nml, eml, alm, notelp, juml, edttotal1;
    // EditText ditambahkan pesanan

    Button btnSimpan;
    //  EditText name, email, password;
    String Getname, GetEmail, GetPassword;
    Button register;
    //   String DataParseUrl = "http://apidroid.devgolan.web.id/insert_pengguna.php";
    Boolean CheckEditText;
    String Response;
    HttpResponse response;


    String id_user;
    String kd_hijab;
    int pesanan;
    String email;
    String nama_lengkap;
    String alamat;
    String no_tlp;
    int total;

    InputStream is = null;
    String result = null;
    String line = null;
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;

    String s1idus, s2nama, s3kodehijab, s4email, s5alamat, s6notelp, i7jumlah;
    int i8total = 100;

    int hitungTotal, varHarga, varJumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        varImage = (ImageView) findViewById(R.id.img);
        tvIdKodeHijab = (TextView) findViewById(R.id.kdHijab);
        tvIdNamaHijab = (TextView) findViewById(R.id.namaHijab);
        tvIdJenisHijab = (TextView) findViewById(R.id.jenisHijab);
        tvIdBahanHijab = (TextView) findViewById(R.id.bahanHijab);
        tvIdStokHijab = (TextView) findViewById(R.id.stokHijab);
        tvIdHargaHijab = (TextView) findViewById(R.id.hargaHijab);
        btnSimpan = (Button) findViewById(R.id.btn_simpan);


        nml = (EditText) findViewById(R.id.namaLkp);
        eml = (EditText) findViewById(R.id.et_nama);
        alm = (EditText) findViewById(R.id.et_alamat);
        notelp = (EditText) findViewById(R.id.et_notel);
        juml = (EditText) findViewById(R.id.et_jumlah);
        edttotal1 = (EditText) findViewById(R.id.et_total);


        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {
            String getName = (String) bd.get("name");
            String acceptedUrlImage = (String) bd.get("urltodetail");
            String kodeH = (String) bd.get("kodehijabdetail");
            String hargaH = (String) bd.get("hargahijabdetail");
            String jenisH = (String) bd.get("jenishijabdetail");
            String bahanH = (String) bd.get("bahanhijabdetail");
            String stokH = (String) bd.get("stokhijabdetail");


            tvIdNamaHijab.setText(getName);
            tvIdKodeHijab.setText(kodeH);
            tvIdJenisHijab.setText(jenisH);
            tvIdHargaHijab.setText(hargaH);
            tvIdBahanHijab.setText(bahanH);
            tvIdStokHijab.setText(stokH);

            Picasso.with(DetailActivity.this)
                    .load(acceptedUrlImage)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .resize(300, 300)
                    .into(varImage);
        }


        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s1idus = tvIdKodeHijab.getText().toString();
                s2nama = nml.getText().toString();
             //   varHarga = Integer.parseInt(tvIdHargaHijab.getText().toString());
                //  varJumlah = Integer.parseInt(juml.getText().toString());
           //     hitungTotal = varHarga * varJumlah;
                //insert();
                Log.d("Input Slidus", s1idus);
                Log.d("Hasil Kali", Integer.toString(hitungTotal));

                insertData(s1idus, nml.getText().toString(), 20000,
                         alm.getText().toString(), notelp.getText().toString(), eml.getText().toString(),"023424024",2);

            }
        });
        ;


    }


    public void insertData(String iduser,  String kodehijab, int pesanan, String email,  String namalengkap, String alamat, String notelp, int total) {
        // call InterFace




        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_url.getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI registerAPI = retrofit.create(RegisterAPI.class);
        Call<PembelianResponse> pembelianResponseCall = registerAPI.serverCall(iduser, kodehijab, pesanan, email, namalengkap, alamat, notelp, total);
        pembelianResponseCall.enqueue(new Callback<PembelianResponse>() {
            @Override
            public void onResponse(Response<PembelianResponse> response, Retrofit retrofit) {
                Log.d("========BISA=======","BerHasil");
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
//
//        Retrofit restadapter = new Retrofit.Builder()
//                .baseUrl(BASE_URL+"masukkan.php").addConverterFactory(GsonConverterFactory.create()).build();
//        //RegisterAPI registerAPI = ((RetrofitApplication) getApplication()).getMshoppinpApis();
//
//        RegisterAPI registerAPI = restadapter.create(RegisterAPI.class);
//
//         registerAPI.serverCall(iduser, kodehijab, pesanan, email, namalengkap, alamat, notelp, total, new Callback<PembelianResponse>() {
//             @Override
//             public void onResponse(Response<PembelianResponse> response, Retrofit retrofit) {
//                 PembelianResponse pr = response.body();
//                 Log.d("tes","ppp");
//                 if(pr.getStatus()){
//                     Toast t = Toast.makeText(getApplicationContext(),"Berhasil",Toast.LENGTH_LONG);
//                 } else {
//                     Toast t = Toast.makeText(getApplicationContext(),"Gagal",Toast.LENGTH_LONG);
//                 }
//             }
//
//             @Override
//             public void onFailure(Throwable t) {
//
//             }
//         });
    }

}














































