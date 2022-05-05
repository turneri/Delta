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
                builder.setMessage("Tältä sivulta voit tarkastella kehitystäsi eri osa-alueilla.");


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
