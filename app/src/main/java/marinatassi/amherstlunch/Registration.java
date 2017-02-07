package marinatassi.amherstlunch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Marina on 2/6/17.
 */
public class Registration extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        Intent intent = getIntent();
        String UN = intent.getStringExtra(MainActivity.UN);
        String PW = intent.getStringExtra(MainActivity.PW);

        EditText username = (EditText) findViewById(R.id.Username);
        EditText password = (EditText) findViewById(R.id.Password);

        username.setText(UN);
        password.setText(PW);

    }

}
