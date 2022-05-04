package fi.jimihautamaki.delta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class OmaTreeni extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private String valittuTreeni;
    private Button aloitaTreeni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oma_treeni);

        aloitaTreeni = (Button) findViewById(R.id.Treeni_Button);
        Spinner spinner = findViewById(R.id.Ohjelmat_spinner);
        String[] ohjelmaArray = new String[]{"Rinta/Olkapää/Ojentaja", "Selkä/Hauis", "Jalat"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ohjelmaArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        aloitaTreeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oma;
                switch (valittuTreeni) {
                    case "Rinta":
                        oma = new Intent(OmaTreeni.this, Saliohjelmat.class);
                        break;
                    case "Selkä":
                        oma = new Intent(OmaTreeni.this, MainActivity.class);
                        break;
                    case "Jalat":
                        oma = new Intent(OmaTreeni.this, OmaKehitys.class);
                        break;
                    default:
                        oma = new Intent(OmaTreeni.this, Saliohjelmat.class);
                        break;
                }
                startActivity(oma);
            }
        });
    }

    private void setIntent(){

    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                valittuTreeni="Rinta";
                break;
            case 1:
                valittuTreeni="Selkä";
                break;
            case 2:
                valittuTreeni="Jalat";
                break;

        }
    }





    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}