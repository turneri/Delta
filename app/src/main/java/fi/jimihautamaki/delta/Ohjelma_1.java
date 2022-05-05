package fi.jimihautamaki.delta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class Ohjelma_1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohjelma1);
    }
    public class MainActivity extends AppCompatActivity {
        private Counter creationsCounter,visiblesCounter,hitsCounter;
        private TextView creationsCount,visiblesCount,hitsCount;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Log.d("MY_TAG","onCreate() called");

            SharedPreferences prefGet = getSharedPreferences("MyTestPref" ,Activity.MODE_PRIVATE);
            int creations = prefGet.getInt("Creations", 0);
            int visibles = prefGet.getInt("Visibles", 0);
            int hits = prefGet.getInt("Hits", 0);

            creationsCounter = new Counter(0,100,creations,1);
            visiblesCounter = new Counter(0,100,visibles,1);
            hitsCounter = new Counter(0,100,hits,1);

            creationsCount = findViewById(R.id.creationCount);
            visiblesCount = findViewById(R.id.visibleCount);
            hitsCount = findViewById(R.id.hitCount);




            creationsCounter.addCounter();
            updateUI();
        }

        public void updateUI(){
            creationsCount.setText(Integer.toString(creationsCounter.getCounter()));
            visiblesCount.setText(Integer.toString(visiblesCounter.getCounter()));
            hitsCount.setText(Integer.toString(hitsCounter.getCounter()));
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
