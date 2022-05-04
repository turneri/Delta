package fi.jimihautamaki.delta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class OmaKehitys extends AppCompatActivity {

    ProgressBar pb;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oma_kehitys);

        prog();

    }

    public void prog()
    {
        pb = (ProgressBar) findViewById(R.id.pb);

    }
}