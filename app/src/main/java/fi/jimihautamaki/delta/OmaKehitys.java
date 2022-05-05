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
                Intent kehitys1 = new Intent(OmaKehitys.this, Kehitys1.class);
                startActivity(kehitys1);
            }
        });

        selkaK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kehitys2 = new Intent(OmaKehitys.this, Kehitys2.class);
                startActivity(kehitys2);
            }
        });

        jalkaK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kehitys3 = new Intent(OmaKehitys.this, Kehitys3.class);
                startActivity(kehitys3);
            }
        });




    }
}