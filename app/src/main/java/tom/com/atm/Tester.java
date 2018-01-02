package tom.com.atm;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

    public class Tester{
        public static void main(String[]args){
            Date now = new Date();
            System.out.println(now);
            System.out.println(now.getTime());
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            System.out.println(sdf.format(now));
            String s = "1998-06-02";
            try {
                Date birthday = sdf.parse(s);
                System.out.println(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
