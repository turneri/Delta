package fi.jimihautamaki.delta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ohjelma_3 extends AppCompatActivity {

    EditText PvM, kyykky, jalkaprassi, reidenojennus, reidenloitonnus, bulgarialainen, pohkeet,istumaannousu ;
    Button Submit3, tarkastele3;
    DBhelper DB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohjelma3);




        PvM = findViewById(R.id.PvM);
        kyykky = findViewById(R.id.Kyykky_Paino);
        jalkaprassi = findViewById(R.id.Jalkaprässi_Paino);
        reidenojennus = findViewById(R.id.ReidenOjennus_Paino);
        reidenloitonnus = findViewById(R.id.ReidenLoitonnus_Paino);
        bulgarialainen = findViewById(R.id.Bulgarialainen_Paino);
        pohkeet = findViewById(R.id.Pohkeet_Paino);
        istumaannousu = findViewById(R.id.IstumaanNousu_Paino);
        Submit3 = findViewById(R.id.Submit1);
        tarkastele3 = findViewById(R.id.tarkastele3);
        DB = new DBhelper(this);
        Submit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pvmTXT = PvM.getText().toString();
                String kyykkyTXT = kyykky.getText().toString();
                String jalkaTXT = jalkaprassi.getText().toString();
                String rojennusTXT = reidenojennus.getText().toString();
                String rloitonnusTXT = reidenloitonnus.getText().toString();
                String bulgTXT = bulgarialainen.getText().toString();
                String pohkTXT = pohkeet.getText().toString();
                String istuTXT = istumaannousu.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(pvmTXT, kyykkyTXT, jalkaTXT, rojennusTXT, rloitonnusTXT, bulgTXT, pohkTXT);
                if(checkinsertdata==true)
                    Toast.makeText(Ohjelma_3.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Ohjelma_3.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });

        tarkastele3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View tarkastele) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(Ohjelma_3.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Päivänmäärä :"+res.getString(0)+"\n");
                    buffer.append("Kyykyn paino :"+res.getString(1)+"\n");
                    buffer.append("Jalkaprässin painot :"+res.getString(2)+"\n\n");
                    buffer.append("Reidenojennus painot :"+res.getString(3)+"\n\n\n");
                    buffer.append("Reidenloitonnus :"+res.getString(4)+"\n\n\n\n");
                    buffer.append("Bulgarialaisen painot :"+res.getString(5)+"\n\n\n\n\n");
                    buffer.append("Pohkeitten painot :"+res.getString(6)+"\n\n\n\n\n\n");
                    buffer.append("Istumaannousun painot :"+res.getString(6)+"\n\n\n\n\n\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(Ohjelma_3.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }}
