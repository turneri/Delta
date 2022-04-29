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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saliohjelmat);

        infoButton = (Button) findViewById(R.id.Info_Button);
        infoTextView = (TextView) findViewById(R.id.InfoTextView);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Saliohjelmat.this);

                builder.setCancelable(true);
                builder.setTitle("Tarvitsetko apua?");
                builder.setMessage("Saliohjelmat: Nappia painamalla voit valita listasta mieleisen treeniohjelman \n\nOma kehitys: Kuvajainen näyttää sinulle viimeaikaisen kehityksen harjoitteluistasi.\n\n Omat treenit: Tänne voit täyttää treenisiisi liittyvät tiedot ja painot millä olet harjoitellut");


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
