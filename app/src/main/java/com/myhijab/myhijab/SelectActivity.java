package com.myhijab.myhijab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {
    private ListView listview;
    private ArrayList<Hijabku> books;
    private ArrayAdapter<Hijabku> adapter;
    Spinner spin;

    // String arrayURL [] ={"http://www.json-generator.com/api/json/get/ccLAsEcOSq?indent=2"."http://www.json-generator.com/api/json/get/ccLAsEcOSq?indent=2"."http://www.json-generator.com/api/json/get/ccLAsEcOSq?indent=2"};

    private final static String TAG = SelectActivity.class.getSimpleName();
    Config base_url = new Config();
    String url = base_url.getUrl()+"index.php/maincontroller/get_product_controller_bergo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        listview = (ListView) findViewById(R.id.listview);



        setListViewAdapter();
        getDataFromInternet();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                try {

                    String hku_name = books.get(position).getNamaHijab().toString();
                    String lain = books.get(position).getKodeHijab().toUpperCase().toString();
                    String kode_hijab_detail = books.get(position).getKodeHijab().toString();
                    String jenis_hijab_detail = books.get(position).getJenisHijab().toString();
                    String harga_hijab_detail = String.valueOf(books.get(position).getHargaHijab());
                    String bahan_hijab_detail = books.get(position).getBahanHijab().toString();
                    String url_to_detail = books.get(position).getImgUrl().toString();
                    String stok_hijab_detail = String.valueOf(books.get(position).getStokHijab());


                    Toast.makeText(SelectActivity.this, hku_name + " is created by " + lain, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SelectActivity.this, DetailActivity.class);
                    intent.putExtra("name", hku_name + " " + lain);
                    intent.putExtra("urltodetail", url_to_detail);
                    intent.putExtra("kodehijabdetail", kode_hijab_detail);
                    intent.putExtra("jenishijabdetail", jenis_hijab_detail);
                    intent.putExtra("hargahijabdetail", harga_hijab_detail);
                    intent.putExtra("bahanhijabdetail", bahan_hijab_detail);
                    intent.putExtra("stokhijabdetail", stok_hijab_detail);
                    startActivity(intent);

                    //String project_location = list_data.get(position).get("project_location");


                } catch (Exception e) {

                    Log.d("Error Error", e.getMessage().toString());
                }


            }
        });
    }

    private void getDataFromInternet() {


        new GetJsonFromUrlTask(this, url).execute();
    }

    private void setListViewAdapter() {
        books = new ArrayList<Hijabku>();
        adapter = new CustomListViewAdapter(this, R.layout.item_listview, books);
        adapter.notifyDataSetChanged();
        listview.setAdapter(adapter);
    }

    public void parseJsonResponse(String result) {
        Log.i(TAG, result);
        try {
            JSONObject json = new JSONObject(result);
            JSONArray jArray = new JSONArray(json.getString("book_array"));
            for (int i = 0; i < jArray.length(); i++) {

                JSONObject jObject = jArray.getJSONObject(i);

                Hijabku book = new Hijabku();
                book.setNamaHijab(jObject.getString("nama_hijab"));
                book.setKodeHijab(jObject.getString("kd_hijab"));
                book.setHargaHijab(jObject.getString("harga_hijab"));
                book.setStokHijab(jObject.getInt("stok"));
                book.setBahanHijab(jObject.getString("bahan"));
                book.setJenisHijab(jObject.getString("jenis_hijab"));
                book.setImgUrl("http://192.168.88.16/hijabadmin/media/" + jObject.getString("urlimage"));
                book.setKodeHijab(jObject.getString("kd_ban"));
                books.add(book);
            }

            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
