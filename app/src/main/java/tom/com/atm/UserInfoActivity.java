package tom.com.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);


    }
    EditText userName = (EditText)findViewById(R.id.user_name);
    EditText userTele = (EditText)findViewById(R.id.user_tele);

    public void ok(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}