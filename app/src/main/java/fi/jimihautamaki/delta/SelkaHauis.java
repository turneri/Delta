package fi.jimihautamaki.delta;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SelkaHauis extends AppCompatActivity  {


    EditText PvM, ylatalja, kulmapaino, alatalja, kasipaino, hauistalja, hauisEz;
    Button Submit1, tarkastele;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohjelma1);

        PvM = findViewById(R.id.PvM);
        ylatalja = findViewById(R.id.YläTalja_paino);
        kulmapaino = findViewById(R.id.Kulma_Paino);
        alatalja = findViewById(R.id.Alatalja_Paino);
        kasipaino = findViewById(R.id.Käsi_Paino);
        hauistalja = findViewById(R.id.HauisTalja_Paino);
        hauisEz = findViewById(R.id.HauisEz_Paino);
        Submit1 = findViewById(R.id.Submit1);
        tarkastele = findViewById(R.id.tarkastele);
        DB = new DBhelper(this);
        Submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pvmTXT = PvM.getText().toString();
                String ylaTXT = ylatalja.getText().toString();
                String kulmaTXT = kulmapaino.getText().toString();
                String alaTXT = alatalja.getText().toString();
                String kasiTXT = kasipaino.getText().toString();
                String hauisTXT = hauistalja.getText().toString();
                String hauisezTXT = hauisEz.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(pvmTXT, ylaTXT, kulmaTXT, alaTXT, kasiTXT, hauisTXT, hauisezTXT);
                if(checkinsertdata==true)
                    Toast.makeText(SelkaHauis.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(SelkaHauis.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });

        tarkastele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View tarkastele) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(SelkaHauis.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Päivänmäärä :"+res.getString(0)+"\n\n");
                    buffer.append("Ylätaljan paino :"+res.getString(1)+"\n\n");
                    buffer.append("Kulmanostojen painot :"+res.getString(2)+"\n\n");
                    buffer.append("Alataljan painot :"+res.getString(3)+"\n\n");
                    buffer.append("Käsipainot :"+res.getString(4)+"\n\n");
                    buffer.append("Hauistaljan painot :"+res.getString(5)+"\n\n");
                    buffer.append("HauisEZ painot :"+res.getString(6)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(SelkaHauis.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }}