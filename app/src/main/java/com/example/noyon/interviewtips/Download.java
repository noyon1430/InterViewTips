package com.example.noyon.interviewtips;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class Download extends AppCompatActivity implements View.OnClickListener {
    private static Button downloadPdf, downloadDoc, openDownloadedFolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        initViews();
        setListeners();


    }
    private void initViews () {

        downloadPdf = (Button) findViewById(R.id.download_pdf);
        downloadDoc = (Button) findViewById(R.id.download_doc);
        openDownloadedFolder = (Button) findViewById(R.id.open_downloaded_folder);
    }

    private void setListeners() {
        downloadPdf.setOnClickListener(this);
        downloadDoc.setOnClickListener(this);
        openDownloadedFolder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.download_pdf:
                if (isConnectingToInternet())
                    new DownloadTask(Download.this, downloadPdf, Utils.downloadPdfUrl);
                else
                    Toast.makeText(Download.this, "Oops!! There is no internet connection. Please enable internet connection and try again.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.download_doc:
                if (isConnectingToInternet())
                    new DownloadTask(Download.this, downloadDoc, Utils.downloadDocUrl);
                else
                    Toast.makeText(Download.this, "Oops!! There is no internet connection. Please enable internet connection and try again.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.open_downloaded_folder:
                openDownloadedFolder();
                break;

        }

    }
    private void openDownloadedFolder() {
        //First check if SD Card is present or not
        if (new CheckForSDCard().isSDCardPresent()) {

            //Get Download Directory File
            File apkStorage = new File(
                    Environment.getExternalStorageDirectory() + "/"
                            + Utils.downloadDirectory);

            //If file is not present then display Toast
            if (!apkStorage.exists())
                Toast.makeText(Download.this, "Right now there is no directory. Please download some file first.", Toast.LENGTH_SHORT).show();

            else {

                //If directory is present Open Folder

                /** Note: Directory will open only if there is a app to open directory like File Manager, etc.  **/

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()
                        + "/" + Utils.downloadDirectory);
                intent.setDataAndType(uri, "file/*");
                startActivity(Intent.createChooser(intent, "Open Download Folder"));
            }

        } else
            Toast.makeText(Download.this, "Oops!! There is no SD Card.", Toast.LENGTH_SHORT).show();

    }

    //Check if internet is present or not
    private boolean isConnectingToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager
                .getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
}
