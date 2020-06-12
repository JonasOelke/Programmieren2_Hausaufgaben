package de.haw_hamburg.dailymanager;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteService {

    public static void writeObject(Context ctx, Object obj) throws IOException {
        File file = new File(ctx.getExternalFilesDir(null).getAbsolutePath(),"event");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(obj);
        oos.close();
        fos.close();

        Log.i("STATE", "Datei wurde geschrieben");

    }
}
