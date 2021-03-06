package tom.com.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static int REQUEST_LOGIN = 102;
    private final static int REQUEST_USERINFO = 105;
    boolean logon = false;

    @Override
//        if (requestCode == REQUEST_LOGIN) {
//            if (resultCode == RESULT_OK) {
//              Toast.makeText(this, "成功", Toast.LENGTH_LONG).show();
//                String userid = data.getStringExtra("LOGIN_USERID");
//                String passwd = data.getStringExtra("LOGIN_PASSWD");
//                Log.d("RESULT", userid + "/" + passwd);
//
//            } else {
//                finish();
//            }
//        }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_LOGIN:
                if (resultCode == RESULT_OK) {
                    String userid = data.getStringExtra("LOGIN_USERID");
                    String passwd = data.getStringExtra("LOGIN_PASSWD");
                    Toast.makeText(this, "登入帳號為: " + userid, Toast.LENGTH_LONG).show();
                    getSharedPreferences("atm", MODE_PRIVATE)
                            .edit()
                            .putString("USERID", userid)
                            .apply();
                } else {
                    finish();
                }
                break;
            case REQUEST_USERINFO:
                if (resultCode == RESULT_OK) {
                    String edname = data.getStringExtra("EXTRA_NAME");
                    String edphone = data.getStringExtra("EXTRA_PHONE");
                    Toast.makeText(this, "暱稱為: " + edname + " 電話為: " + edphone, Toast.LENGTH_LONG).show();
                    getSharedPreferences("info", MODE_PRIVATE)
                            .edit()
                            .putString("NAME", edname)
                            .putString("PHONE", edphone)
                            .apply();
                }
        }

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (!logon) {
            Intent intent = new Intent(this, Login2Activity.class);
//            startActivity(intent);
            startActivityForResult(intent, REQUEST_LOGIN);
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, UserInfoActivity.class);
                startActivityForResult(i, REQUEST_USERINFO);    //ForResult是重點
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}