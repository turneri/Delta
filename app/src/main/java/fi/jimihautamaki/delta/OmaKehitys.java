package fi.jimihautamaki.delta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class OmaKehitys extends AppCompatActivity {

    private TextView infoTextView;
    private Button rintaK;
    private  Button selkaK;
    private Button jalkaK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oma_kehitys);


        rintaK = (Button) findViewById(R.id.rintaK);
        selkaK = (Button) findViewById(R.id.selkaK);
        jalkaK = (Button) findViewById(R.id.jalkaK);



        rintaK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OmaKehitys.this, Kehitys1.class);
                startActivity(intent);
            }
        });

        selkaK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sali = new Intent(OmaKehitys.this, Kehitys2.class);
                startActivity(sali);
            }
        });

        jalkaK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oma = new Intent(OmaKehitys.this, Kehitys3.class);
                startActivity(oma);
            }
        });




    }
}