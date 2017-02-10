package marinatassi.amherstlunch;


import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Marina on 2/9/17.
 */

public class UtilFile extends MainActivity{

    public static File getFile(String filename, Context context) throws IOException{
        File path = context.getExternalFilesDir(null);
        File file = new File(path, filename);
        file.createNewFile();
        return file;
    }

    public static File writeToFile(String toWrite, File file) throws IOException{
        FileOutputStream stream = new FileOutputStream(file);
        try {
            stream.write(toWrite.getBytes());
        }
        catch (FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
        }
        finally {
            stream.close();
        }
        return file;
    }

    public static String fileToString(File file) throws IOException{
        int length = (int) file.length();

        byte[] bytes = new byte[length];

        FileInputStream in = new FileInputStream(file);
        try {
            in.read(bytes);
        }
        catch (FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
        }
        finally {
            in.close();
        }

        String contents = new String(bytes);

        return contents;
    }

}
