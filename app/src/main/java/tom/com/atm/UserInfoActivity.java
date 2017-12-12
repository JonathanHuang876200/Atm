package tom.com.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);


    }
    public void ok(View view) {
        EditText userName = (EditText)findViewById(R.id.user_name);
        EditText userTele = (EditText)findViewById(R.id.user_tele);
        String username = userName.getText().toString();
        String usertele = userTele.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME",username);
        getIntent().putExtra("EXTRA_PHONE",usertele);
        setResult(RESULT_OK,getIntent());
        Toast.makeText(this, "匿名"+username, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "電話"+usertele, Toast.LENGTH_LONG).show();
        finish();
    }


}