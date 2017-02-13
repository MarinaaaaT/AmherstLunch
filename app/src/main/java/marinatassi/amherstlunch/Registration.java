package marinatassi.amherstlunch;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Marina on 2/6/17.
 */
public class Registration extends AppCompatActivity {

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

    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    static final int REQUEST_TAKE_PHOTO = 1;

    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                System.out.println("ERROR");
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                String photoPath = photoFile.getAbsolutePath();
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoPath);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    public void hideError(View view){

        TextView UN1 = (TextView) findViewById(R.id.ErrorUN1);
        UN1.setVisibility(View.INVISIBLE);

        TextView UN2 = (TextView) findViewById(R.id.ErrorUN2);
        UN2.setVisibility(View.INVISIBLE);

        TextView PW = (TextView) findViewById(R.id.ErrorPW);
        PW.setVisibility(View.INVISIBLE);


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

    public void homeOpen(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

}
