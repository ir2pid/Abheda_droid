package com.noisyninja.abheda_droid.util;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.noisyninja.abheda_droid.util.Constants.PROGRESS_STYLE;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
/**
 * Created by ir2pi on 1/10/2015.
 */
public class DownloadFileAsync extends AsyncTask<String, String, String> {

    IDownloadFileAsync iDownloadFileAsync;
    Context context;

    private DownloadFileAsync()
    {

    }

    public DownloadFileAsync(IDownloadFileAsync iDownloadFileAsync, Context context)
    {
        this.iDownloadFileAsync = iDownloadFileAsync;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(iDownloadFileAsync == null)
            return;
        iDownloadFileAsync.init();
        Utils.showProgress(context, PROGRESS_STYLE.INDETERMINATE);
    }

    @Override
    protected String doInBackground(String... aurl) {

        if(iDownloadFileAsync == null || !Utils.isNetworkAvailable(context)) {
            return null;
        }
        iDownloadFileAsync.start();
        int count;

        try {

            URL url = new URL(aurl[0]);
            String path = aurl[1];
            URLConnection conexion = url.openConnection();
            conexion.connect();

            int lenghtOfFile = conexion.getContentLength();
            Log.d("ANDRO_ASYNC", "Lenght of file: " + lenghtOfFile);

            InputStream input = new BufferedInputStream(url.openStream());
            OutputStream output = new FileOutputStream(path);

            byte data[] = new byte[1024];

            long total = 0;

            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress(""+(int)((total*100)/lenghtOfFile));
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {

            Utils.handleError(context, e);
        }
        return "";

    }
    protected void onProgressUpdate(String... progress) {
        Log.d("ANDRO_ASYNC", progress[0]);
        Log.i(DownloadFileAsync.class.getSimpleName(),"progress: "+progress[0]);
        //Utils.updateProgressDeterminate(Integer.valueOf(progress[0]));
    }

    @Override
    protected void onPostExecute(String unused) {

        if(iDownloadFileAsync == null || unused == null )
        {
            Utils.handleError(context, Constants.ERROR_NO_NETWORK);
            Utils.hideProgress();
            return;
        }
        iDownloadFileAsync.end();
        Utils.hideProgress();
    }

}
