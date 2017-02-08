package marinatassi.amherstlunch;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Marina on 2/6/17.
 */
public class HomePage extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        Intent intent = getIntent();
    }

    public void menuOpen(View view){

        Intent intent = new Intent(this, DiningMenu.class);
        startActivity(intent);
    }

}
