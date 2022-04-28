package fi.jimihautamaki.delta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
            }
        });
    }
    public void openOmaKehitys() {
        Intent intent = new Intent(this, OmaKehitys.class);
        startActivity(intent);
    }
}