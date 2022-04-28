package fi.jimihautamaki.delta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button saliohjelmat;
    private Button kehitys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kehitys = (Button) findViewById(R.id.kehitys);
        kehitys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOmaKehitys();


                saliohjelmat = (Button) findViewById(R.id.saliohjelmat);
                saliohjelmat.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        openSaliohjelmat();
                    }
                });
            }

            public void openOmaKehitys() {
                Intent intent = new Intent(MainActivity.this, OmaKehitys.class);
                startActivity(intent);
            }

                public void openSaliohjelmat() {
                    Intent sali = new Intent(MainActivity.this, Saliohjelmat.class);
                    startActivity(sali);
                }

            });
        }
    }


