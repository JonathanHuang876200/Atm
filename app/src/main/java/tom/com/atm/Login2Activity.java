package tom.com.atm;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
    }

    private EditText edUserid;
    private EditText edPasswd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUserid = (EditText) findViewById(R.id.userid);
        edPasswd = (EditText) findViewById(R.id.passwd);
        String userid = getSharedPreferences("atm", MODE_PRIVATE)
                .getString("USERID", "");
        edUserid.setText(userid);
//        SharedPreferences s = getSharedPreferences("atm", MODE_PRIVATE);
//        edUserid.setText(s.getString("USERID", ""));
    }

    public void login(View view) {
        EditText edUserid = (EditText) findViewById(R.id.edUserid);
        EditText edPasswd = (EditText) findViewById(R.id.edPasswd);
        String userid = edUserid.getText().toString();
        String passwd = edPasswd.getText().toString();
        if ("jonathan".equals(userid) && "1234".equals(passwd)) {
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
            getIntent().putExtra("LOGIN_USERID", userid); // 不知道?
            getIntent().putExtra("LOGIN_PASSWD", passwd); // 不知道?
            setResult(RESULT_OK, getIntent()); //  不知道?
            Intent intent = new Intent(this, MainActivity.class);
            finish();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("登入")
                    .setMessage("登入失敗")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
}
