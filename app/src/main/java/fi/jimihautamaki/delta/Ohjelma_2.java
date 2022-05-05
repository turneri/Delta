/*package fi.jimihautamaki.delta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Ohjelma_2 extends AppCompatActivity {

    private TextView penkkipaino,vinopenkki,pecDeck,kasiPaino,vipunostoEteen,vipunostoSivuille,ojentajaTalja,ojentajaEZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohjelma2);


            Log.d("MY_TAG","onCreate() called");

            SharedPreferences prefGet = getSharedPreferences("MyTestPref" , Activity.MODE_PRIVATE);
            int creations = prefGet.getInt("Creations", 0);
            int visibles = prefGet.getInt("Visibles", 0);
            int hits = prefGet.getInt("Hits", 0);


            penkkipaino = findViewById(R.id.Penkki_Paino);
            vinopenkki = findViewById(R.id.VinoPenkki_Paino);
            pecDeck = findViewById(R.id.PeckDeck_Paino);
            kasiPaino = findViewById(R.id.Käsi_Paino);
            vipunostoEteen = findViewById(R.id.HauisTalja_Paino);
            vipunostoSivuille = findViewById(R.id.VipunostotSivu_Paino);
            ojentajaTalja = findViewById(R.id.OjentajaEz_Paino);
            ojentajaEZ = findViewById(R.id.OjentajaTalja_Paino);






            creationsCounter.addCounter();
            updateUI();
        }

        public void updateUI(){
            penkkipaino.setText(Integer.toString(.getCounter()));
            vinopenkki.setText(Integer.toString(.getCounter()));
            pecDeck.setText(Integer.toString(.getCounter()));
            kasiPaino.setText(Integer.toString(.getCounter()));
            vipunostoEteen.setText(Integer.toString(.getCounter()));
            vipunostoSivuille.setText(Integer.toString(.getCounter()));
            ojentajaTalja.setText(Integer.toString(.getCounter()));
        }




        }

        @Override
        protected void onStart() {
            super.onStart();
            Log.d("MY_TAG","onStart() called");

            updateUI();
        }



        @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.d("MY_TAG","onDestroy() called");
        }



        @Override
        protected void onResume() {
            super.onResume();
            Log.d("MY_TAG","onResume() called");
        }

        @Override
        protected void onRestart() {
            super.onRestart();
            Log.d("MY_TAG","onRestart() called");
        }
    }
}*/