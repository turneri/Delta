package fi.jimihautamaki.delta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

            creationsCounter = new Counter(0,100,creations,1);
            visiblesCounter = new Counter(0,100,visibles,1);
            hitsCounter = new Counter(0,100,hits,1);

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
            penkkipaino.setText(Integer.toString(creationsCounter.getCounter()));
            vinopenkki.setText(Integer.toString(visiblesCounter.getCounter()));
            pecDeck.setText(Integer.toString(hitsCounter.getCounter()));
            kasiPaino.setText(Integer.toString(hitsCounter.getCounter()));
            vipunostoEteen.setText(Integer.toString(hitsCounter.getCounter()));
            vipunostoSivuille.setText(Integer.toString(hitsCounter.getCounter()));
            ojentajaTalja.setText(Integer.toString(hitsCounter.getCounter()));
        }

        public void hitButtonPressed(View view){
            hitsCounter.addCounter();

            updateUI();
        }
        public void resetButtonPressed(View view){
            creationsCounter.resetCounter();
            visiblesCounter.resetCounter();
            hitsCounter.resetCounter();

            updateUI();
        }

        @Override
        protected void onStart() {
            super.onStart();
            Log.d("MY_TAG","onStart() called");

            visiblesCounter.addCounter();
            updateUI();
        }

        @Override
        protected void onStop() {
            super.onStop();
            Log.d("MY_TAG","onStop() called");
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.d("MY_TAG","onDestroy() called");
        }

        @Override
        protected void onPause() {
            super.onPause();
            Log.d("MY_TAG","onPause() called");

            SharedPreferences prefPut = getSharedPreferences("MyTestPref", Activity.MODE_PRIVATE);
            SharedPreferences.Editor prefEditor = prefPut.edit();

            prefEditor.putInt("Creations",creationsCounter.getCounter() );
            prefEditor.putInt("Visibles",visiblesCounter.getCounter() );
            prefEditor.putInt("Hits",hitsCounter.getCounter() );


            prefEditor.commit();

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
}