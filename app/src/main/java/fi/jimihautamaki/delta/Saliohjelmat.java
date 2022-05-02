package fi.jimihautamaki.delta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Saliohjelmat extends AppCompatActivity {
    private Button infoButton;
    private TextView infoTextView;
    private Button rintaOlka;
    private  Button selkaHauis;
    private Button jalat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saliohjelmat);

        infoButton = (Button) findViewById(R.id.Info_Button);
        rintaOlka = (Button) findViewById(R.id.rinta);
        selkaHauis = (Button) findViewById(R.id.selka);
        jalat = (Button) findViewById(R.id.jalkapaiva);
        infoTextView = (TextView) findViewById(R.id.InfoTextView);

        jalat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Saliohjelmat.this);

                builder.setCancelable(true);
                builder.setTitle("Jalkatreeni");
                builder.setMessage("Kyykky tangolla 4x10\nJalkaprässi 4x10\nReiden ojennus 3x10\nReiden loitonnus 3x10\n" +
                        "Bulgarialainen kyykky 3x10\nPohkeet 4x12\nIstumaannousu 3x20\nLankutus 1xMax");


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        infoTextView.setVisibility(View.VISIBLE);
                    }
                });

                builder.show();
            }
        });

        selkaHauis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Saliohjelmat.this);

                builder.setCancelable(true);
                builder.setTitle("Selkä ja Hauis");
                builder.setMessage("Ylätalja 4x8\nKulmasoutu tangolla 3x10\nAlatalja 4x8\nLeuanveto\n" +
                        "Hauiskääntö käsipainoilla 3x10\nHauiskääntö taljassa 3x10\nHauiskääntö EZ tangolla 3x10");


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        infoTextView.setVisibility(View.VISIBLE);
                    }
                });

                builder.show();
            }
        });

        rintaOlka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Saliohjelmat.this);

                builder.setCancelable(true);
                builder.setTitle("Rinta/Olkapää/Ojentaja");
                builder.setMessage("Penkkipunnerrus 4x8\nVinopenkki käsipainoilla 3x8\nPec deck 3x10\n" +
                        "Pystypunnerrus tangolla 3x8\nVipunostot eteen 3x10\nVipunostot sivuille 3x10\nOjentaja punnerrus taljassa 4x8\n" +
                        "Ojentajapunnerrus EZ tangolla 3x10");


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        infoTextView.setVisibility(View.VISIBLE);
                    }
                });

                builder.show();
            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Saliohjelmat.this);

                builder.setCancelable(true);
                builder.setTitle("Saliohjelmat");
                builder.setMessage("Tältä sivulta voit tarkastella saliohjelmia ja valita itsellesi mielestäsi sopivimman.");


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        infoTextView.setVisibility(View.VISIBLE);
                    }
                });

                builder.show();

            }
        });
    }
}
