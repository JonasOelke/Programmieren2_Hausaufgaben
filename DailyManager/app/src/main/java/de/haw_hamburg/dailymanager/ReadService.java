package de.haw_hamburg.dailymanager;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReadService {

    public static Object readObject(Context ctx) throws IOException, ClassNotFoundException {
        File file = new File(ctx.getExternalFilesDir(null).getAbsolutePath(),"event");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Log.i("STATE", "Datei wurde gelesen");

        Object event = ois.readObject();
        return event;
    }

    public void readList(Context ctx) {
        throw new NotImplementedException();
    }
}
