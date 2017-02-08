package marinatassi.amherstlunch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    public final static String UN = "test";
    public final static String PW = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void keyboardAdjust(View view){
        //adjust padding to account for keyboard
        View parent = (View) view.getParent();

    }

    public boolean existingUser(String us) throws IOException {
        return true;
    }

    public boolean correctPassword(String pw) throws IOException{
        return true;
    }

    public void login(View view) throws IOException {

        EditText username = (EditText) findViewById(R.id.editText1);
        EditText password = (EditText) findViewById(R.id.editText2);
        TextView loginFail = (TextView) findViewById(R.id.loginFail);
        Button register = (Button) findViewById(R.id.registerButton);

        //correct username and password
        if (existingUser(username.getText().toString()) && correctPassword(password.getText().toString())) {
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        }
        //wrong username or password
        else {
            loginFail.setVisibility(View.VISIBLE);
        }
    }

    public void register(View view){

        Intent intent = new Intent(this, Registration.class);
        EditText username = (EditText) findViewById(R.id.editText1);
        String un = username.getText().toString();
        intent.putExtra(UN, un);
        EditText password = (EditText) findViewById(R.id.editText2);
        String pw = password.getText().toString();
        intent.putExtra(PW, pw);
        startActivity(intent);
    }
}
