package tom.com.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import static tom.com.atm.R.id.ed_Name;
import static tom.com.atm.R.id.ed_Phone;

public class UserInfoActivity extends AppCompatActivity {


    private EditText edName;
    private EditText edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        Spinner ages = (Spinner)findViewById(R.id.ages);
        ArrayList<String> data = new ArrayList<>();
        for(int i= 15; i<=40;i++){
            data.add(i+"");
        }
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, data);
        ages.setAdapter(adapter);

         edName = (EditText) findViewById(ed_Name);
         edPhone = (EditText) findViewById(ed_Phone);
        String name = getSharedPreferences("info", MODE_PRIVATE)
                .getString("NAME","");
        String phone = getSharedPreferences("info", MODE_PRIVATE)
                .getString("PHONE", "");
        edName.setText(name);
        edPhone.setText(phone);

    }

    public void back(View view) {
        String name = edName.getText().toString();
        String phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NAME", name);
        getIntent().putExtra("EXTRA_PHONE", phone);
        setResult(RESULT_OK, getIntent());
        finish();

    }
    public void address (View view) {
        Intent intent = new Intent(this, CityActivity.class);
        startActivity(intent);
    }


    }