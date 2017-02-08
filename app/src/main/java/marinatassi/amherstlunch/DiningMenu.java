package marinatassi.amherstlunch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Marina on 2/7/17.
 */
public class DiningMenu extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Intent intent = getIntent();
    }
}
