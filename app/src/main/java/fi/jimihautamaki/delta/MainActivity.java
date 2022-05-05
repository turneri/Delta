package fi.jimihautamaki.delta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button infoButton;
    private TextView infoTextView;

    private Button saliohjelmat;
    private Button kehitys;
    private Button omaTreeni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoButton = (Button) findViewById(R.id.Info_Button);
        infoTextView = (TextView) findViewById(R.id.InfoTextView);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setCancelable(true);
                builder.setTitle("Tarvitsetko apua?");
                builder.setMessage("Saliohjelmat: Nappia painamalla voit tarkastella valmiita treeniohjelmia. \n\nOma kehitys: Kuvajainen näyttää sinulle viimeaikaisen kehityksen harjoitteluistasi.\n\n Omat treenit: Tänne voit täyttää treenisiisi liittyvät tiedot ja painot millä olet harjoitellut");



                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        infoTextView.setVisibility(View.VISIBLE);
                    }
                });

                builder.show();

            }
        });

        kehitys = (Button) findViewById(R.id.Kehitys_Button);
        saliohjelmat = (Button) findViewById(R.id.Ohjelmat_Button);
        omaTreeni = (Button) findViewById(R.id.Treenit_Button);

        kehitys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OmaKehitys.class);
                startActivity(intent);
            }
        });

        saliohjelmat.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent sali = new Intent(MainActivity.this, Saliohjelmat.class);
                 startActivity(sali);
              }
        });

        omaTreeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oma = new Intent(MainActivity.this, OmaTreeni.class);
                startActivity(oma);
            }
        });




            }
        }



