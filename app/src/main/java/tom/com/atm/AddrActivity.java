package tom.com.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddrActivity extends AppCompatActivity {

    private Spinner spCity;
    private Spinner spArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addr);
        spCity = (Spinner) findViewById(R.id.sp_City);
        spArea = (Spinner) findViewById(R.id.sp_Area);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new String[]{"AA", "BB", "CC"});
        spCity.setAdapter(adapter);
        spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] data = null;
                if (position == 0) {
                    data = new String[]{"1", "2", "3"};
                }
                if (position == 1) {
                    data = new String[]{"4", "5", "6"};
                }
                ArrayAdapter adapter1 = new ArrayAdapter(AddrActivity.this, android.R.layout.simple_list_item_1, data);
                spArea.setAdapter(adapter1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}