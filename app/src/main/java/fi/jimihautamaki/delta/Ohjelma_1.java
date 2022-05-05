package fi.jimihautamaki.delta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Ohjelma_1 extends AppCompatActivity {


    private TextView ylatalja, kulmapaino, alatalja, kasipaino, hauistalja, hauisEz;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ohjelma1);

            Log.d("MY_TAG","onCreate() called");

            SharedPreferences prefGet = getSharedPreferences("MyTestPref" , Activity.MODE_PRIVATE);
            int creations = prefGet.getInt("Creations", 0);
            int visibles = prefGet.getInt("Visibles", 0);
            int hits = prefGet.getInt("Hits", 0);



            ylatalja = findViewById(R.id.YläTalja_paino);
            kulmapaino = findViewById(R.id.Kulma_Paino);
            alatalja = findViewById(R.id.Alatalja_Paino);
            kasipaino = findViewById(R.id.Käsi_Paino);
            hauistalja = findViewById(R.id.HauisTalja_Paino);
            hauistalja = findViewById(R.id.HauisEz_Paino);




            updateUI();
        }

        public void updateUI() {

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

