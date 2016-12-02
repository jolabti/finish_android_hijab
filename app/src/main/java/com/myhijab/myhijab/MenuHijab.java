package com.myhijab.myhijab;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;

public class MenuHijab extends AppCompatActivity {
    Button katalog, toko, bantuan, keluar , transaksionklik;
    Intent intentku = getIntent();
    // Bundle bd = intentku.getExtras();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_hijab);
        //menginisiasi dan memanggil widget button pada file layout
        katalog = (Button) findViewById(R.id.katalog_button);
        toko = (Button) findViewById(R.id.toko_button);
        bantuan = (Button) findViewById(R.id.bantuan_button);
        keluar = (Button) findViewById(R.id.keluar_button);
        transaksionklik = (Button) findViewById(R.id.trxbutton);
        katalog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View argO) {


                //       String tampungemail = (String) bd.get("emailsession");



                //TODO Auto-generated method stub
                Intent pindah = new Intent(MenuHijab.this, JenisHijab.class);
                //   pindah.putExtra("emailsestopemesanan", tampungemail);
                startActivity(pindah);
                //menghubungkan antar activity dengan inten
            }
        });

        //Tampilan untuk menu Tentang Toko dengan menggunakan AlertDialog
        toko.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (view == toko) {
                    new AlertDialog.Builder(MenuHijab.this)
                            .setTitle("Tentang Toko")
                            .setMessage("Aplikasi ini adalah sebuah aplikasi yang menyediakan berbagai produk seperti Jilbab, Bergo, Dalaman Jilbab, Pashmina dengan harga yang terjangkau serta dengan kualitas yang terbaik. \n" +
                                    "\n" +
                                    "Tujuan kami menyediakanaplikasi ini adalah untuk menampilkan produk kami secara online serta untuk membantu Anda mendapatkan produk seperti Jilbab, Bergo, Dalaman Jilbab, Pashmina dengan kualitas terbaik dengan harga yang terjangkau.\n" +
                                    "\n" +
                                    "Didukung dengan layanan prima, pelayanan yang ramah dan respon kami yang cepat tanggap kami siap memberi kepuasaan kepada Anda sebagai konsumen atau customer. \n" +
                                    "\n" +
                                    "Kami berharap dengan adanya website ini kami bisa memberi banyak manfaat dan dapat membantu serta memudahkan Anda.\n " +
                                    "\n " +
                                    "Salam Kami.\n" +
                                    "\n" +
                                    "Asra Store - Store With Attitude\n" +
                                    "www.asrastore.com")
                            .setNeutralButton("Close", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dlg, int sumthin) {

                                }
                            }).show();
                }
            }
        });

        bantuan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (view == bantuan) {
                    new AlertDialog.Builder(MenuHijab.this)
                            .setTitle("Bantuan")
                            .setMessage("FAQ :" +
                                    "                                                                                                      " +
                                    "1. Berapa Minimal Order ?\n" +
                                    "Tidak ada minimal order untuk item/barang jenis apapun, anda pesan 1 item/barang pun kami siap melayani." +
                                    "                                   \n                                                                                    " +
                                    "2. Bagaimana Cara Pembayarannya ?\n" +
                                    "Setelah order/pesanan anda selesai/checkout akan ada invoice/tagihan melalui email yang akan menginformasikan anda kemana harus membayar tagihan dari pesanan Anda atau dapat langsung mentransfer ke no rekening berikut:\n" +
                                    "\n" +
                                    "Bank BNI\n" +
                                    "Rek : 0267542097\n" +
                                    "a/n : HASTRIA\n" +
                                    "\n" +
                                    "Bank BCA\n" +
                                    "1650013715\n" +
                                    "a/n : HASTRIA\n" +
                                    "\n" +
                                    "Bank Mandiri\n" +
                                    "1290010720296\n" +
                                    "a/n : HASTRIA\n" +
                                    "\n" +
                                    "Setelah melakukan pembayaran harap segera konfirmasi pembayaran melalui\n" +
                                    "Konfirmasi pembayaran juga dapat dilakukan via SMS, Telepon, Whatsapp ke 021 8096604 / 082210900063\n" +
                                    "Konfirmasi pembayaran juga dapat dilakukan melalui E-mail ke asrahijabstore@yahoo.com\n" +
                                    "Jika anda sudah melakukan konfirmasi pembayaran, maka pesanan Anda dapat kami proses segera.\n" +
                                    "                                                                                                      " +
                                    "3. Bagaimana saya dapat menerima barang pesanan saya ?\n" +
                                    "Pesanan Anda akan kami kirim dengan jasa pengiriman barang Fedex, JNE, Tiki, Pos Indonesia, DHL.\n" +
                                    "Ongkos kirim sesuai dengan harga serta jasa pengiriman yang Anda pilih." +
                                    "                                                                                                      " +
                                    "\n"+
                                    "6. Saya sudah order/pesan tapi belum sempat untuk konfirmasi pembayaran, bagaimana dengan pesanan saya ?\n" +
                                    "Kami beri tenggat waktu 14 Hari untuk melakukan konfirmasi pembayaran, jika lebih dari itu kami anggap pesanan Anda tidak di ambil.")
                            .setNeutralButton("Close", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dlg, int sumthin) {

                                }
                            }).show();
                }
            }
        });
        //Tampilan untuk menu keluar dengan menggunakan AlertDialog
        keluar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuHijab.this);
                builder.setMessage("Apakah Kamu Yakin Ingin Keluar?")
                        .setCancelable(false)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MenuHijab.this.finish();
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int arg1) {
                                dialog.cancel();
                            }

                        }).show();
            }
        });

        transaksionklik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahkepemesanan = new Intent(MenuHijab.this, Pemesanan.class);
                startActivity(pindahkepemesanan);
            }
        });
    }


}
