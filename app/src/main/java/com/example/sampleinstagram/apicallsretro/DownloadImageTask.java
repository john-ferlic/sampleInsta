package com.example.sampleinstagram.apicallsretro;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    ImageView image;

    public DownloadImageTask(ImageView image) {
        this.image = image;
    }

    public Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", "FAILURE in DOWNLOAD IMAGE TASK");
            e.printStackTrace();
        }
        return mIcon11;
    }

    public void onPostExecute(Bitmap result) {
        image.setImageBitmap(result);
    }

}
