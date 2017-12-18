package tom.com.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static tom.com.atm.R.id.ed_Name;
import static tom.com.atm.R.id.ed_Phone;

public class UserInfoActivity extends AppCompatActivity {


    private EditText edName;
    private EditText edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        EditText edName = (EditText) findViewById(ed_Name);
        EditText edPhone = (EditText) findViewById(ed_Phone);
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


}