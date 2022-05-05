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


    String fileNameString = sharedPreferencesBinding.fileNameEditView.getText().toString();
    SharedPreferences sharedPreferences;
if(fileNameString.isEmpty()) {
        sharedPreferences = getPreferences(MODE_PRIVATE);
    }
else {
        sharedPreferences = getSharedPreferences(fileNameString, MODE_PRIVATE);
    }
}