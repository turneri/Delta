package fi.jimihautamaki.delta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Ohjelma_1 extends AppCompatActivity {


    private TextView ylatalja, kulmapaino, alatalja;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Log.d("MY_TAG","onCreate() called");

            SharedPreferences prefGet = getSharedPreferences("MyTestPref" , Activity.MODE_PRIVATE);
            int creations = prefGet.getInt("Creations", 0);
            int visibles = prefGet.getInt("Visibles", 0);
            int hits = prefGet.getInt("Hits", 0);



            ylatalja = findViewById(R.id.YläTalja_paino);
            kulmapaino = findViewById(R.id.Kulma_Paino);
            alatalja = findViewById(R.id.Alatalja_Paino);




            creationsCounter.addCounter();
            updateUI();
        }

        public void updateUI(){
            ylatalja.setText(Integer.toString(creationsCounter.getCounter()));
            kulmapaino.setText(Integer.toString(visiblesCounter.getCounter()));
            alatalja.setText(Integer.toString(hitsCounter.getCounter()));
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