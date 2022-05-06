package fi.jimihautamaki.delta;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class rintaselka extends AppCompatActivity {







    EditText PvM2, penkki, vinopenkki, peckdeck, kasipaino, hauistalja, vipunostotsivu,ojentajaez, ojentajatalja ;
    Button Submit2, tarkastele2;
    DBhelper2 DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rintaselka);




        PvM2 = findViewById(R.id.PvM2);
        penkki = findViewById(R.id.Penkki_Paino);
        vinopenkki = findViewById(R.id.VinoPenkki_Paino);
        peckdeck = findViewById(R.id.PeckDeck_Paino);
        kasipaino = findViewById(R.id.Käsi_Paino);
        hauistalja = findViewById(R.id.HauisTalja_Paino);
        vipunostotsivu = findViewById(R.id.VipunostotSivu_Paino);
        ojentajaez = findViewById(R.id.OjentajaEz_Paino);
        ojentajatalja = findViewById(R.id.OjentajaTalja_Paino);
        Submit2 = findViewById(R.id.Submit1);
        tarkastele2 = findViewById(R.id.tarkastele3);
        DB = new DBhelper2(this);
        Submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pvmTXT = PvM2.getText().toString();
                String penkkiTXT = penkki.getText().toString();
                String vinoTXT = vinopenkki.getText().toString();
                String peckTXT = peckdeck.getText().toString();
                String kasipTXT = kasipaino.getText().toString();
                String hauisTXT = hauistalja.getText().toString();
                String vipuTXT = vipunostotsivu.getText().toString();
                String ezTXT = ojentajaez.getText().toString();
                String ojentajaTXT = ojentajatalja.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(pvmTXT, penkkiTXT, vinoTXT, peckTXT, kasipTXT, hauisTXT, vipuTXT, ezTXT, ojentajaTXT);
                if(checkinsertdata==true)
                    Toast.makeText(fi.jimihautamaki.delta.rintaselka.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(fi.jimihautamaki.delta.rintaselka.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });

        tarkastele2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View tarkastele) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(fi.jimihautamaki.delta.rintaselka.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Päivänmäärä :"+res.getString(0)+"\n");
                    buffer.append("Penkin paino :"+res.getString(1)+"\n");
                    buffer.append("Vinopenkin painot :"+res.getString(2)+"\n");
                    buffer.append("PeckDeck painot :"+res.getString(3)+"\n");
                    buffer.append("Käsipainot :"+res.getString(4)+"\n");
                    buffer.append("Hauiskäännön painot :"+res.getString(5)+"\n");
                    buffer.append("Vipunosto painot :"+res.getString(6)+"\n");
                    buffer.append("Ez painot :"+res.getString(6)+"\n");
                    buffer.append("Ojentajatalja painot :"+res.getString(6)+"\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(fi.jimihautamaki.delta.rintaselka.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }}
