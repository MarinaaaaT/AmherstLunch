package marinatassi.amherstlunch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Marina on 2/6/17.
 */
public class Registration extends AppCompatActivity {

    private Uri file;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        Intent intent = getIntent();

        Bundle extras = getIntent().getExtras();
        String UN = extras.getString("UN");
        String PW = extras.getString("PW");

        EditText username = (EditText) findViewById(R.id.Username);
        EditText password = (EditText) findViewById(R.id.Password);

        username.setText(UN);
        password.setText(PW);
    }

    public void register(View view) throws IOException {
        EditText username = (EditText) findViewById(R.id.Username);
        String un = username.getText().toString();

        EditText password = (EditText) findViewById(R.id.Password);
        String pw = password.getText().toString();

        EditText confirm = (EditText) findViewById(R.id.PasswordConfirm);
        String c = confirm.getText().toString();

        EditText name = (EditText) findViewById(R.id.Name);
        String n = name.getText().toString();

        File userInfo = UtilFile.getFile("userInfo.txt", this.getApplicationContext());

        if(MainActivity.existingUser(un, userInfo) != -1){
            TextView UN1 = (TextView) findViewById(R.id.ErrorUN1);
            UN1.setVisibility(View.VISIBLE);
            //show username error
        }
        else if(!pw.equals(c)){
            //show password error
            TextView PW = (TextView) findViewById(R.id.ErrorPW);
            PW.setVisibility(View.VISIBLE);
        }
        else if(un.contains("%")){
            //show username error
            TextView UN2 = (TextView) findViewById(R.id.ErrorUN2);
            UN2.setVisibility(View.VISIBLE);
        }
        else{
            String userData = un + "%" + pw + "%" + c + "\n";
            System.out.println(userData);
            UtilFile.writeToFile(userData, userInfo);
            homeOpen();
        }
    }

    public void takePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = Uri.fromFile(getOutputMediaFile());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);

        startActivityForResult(intent, 100);
    }

    private static File getOutputMediaFile() {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "CameraDemo");

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("CameraDemo", "failed to create directory");
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_" + timeStamp + ".jpg");
    }

    public void hideError(View view){

        TextView UN1 = (TextView) findViewById(R.id.ErrorUN1);
        UN1.setVisibility(View.INVISIBLE);

        TextView UN2 = (TextView) findViewById(R.id.ErrorUN2);
        UN2.setVisibility(View.INVISIBLE);

        TextView PW = (TextView) findViewById(R.id.ErrorPW);
        PW.setVisibility(View.INVISIBLE);


    }

    public void homeOpen(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

}
