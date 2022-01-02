package com.ascendant.ekwin.Method;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;

import com.ascendant.ekwin.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class Musupadi {
    public String BASE_URL(){
        String URL = "https://jadwalibadah.the-urbandev.com";
        return URL;
    }
    public String SmallText(String description){
        String Des = description;
        if (description.length() >= 50){
            Des = description.substring(0,50)+"...";
        }
        return Des;
    }
    public String MagicDateChange(String dates){
        String result = "";
        String year = dates.substring(0,4);
        String month = dates.substring(5,7);
        String day = dates.substring(8,10);

        String MONTH = "Januari";
        if (month.equals("01") || month.equals("1")){
            MONTH = "Januari";
        }else if (month.equals("02") || month.equals("2")){
            MONTH = "Februari";
        }else if (month.equals("03") || month.equals("3")){
            MONTH = "Maret";
        }else if (month.equals("04") || month.equals("4")){
            MONTH = "April";
        }else if (month.equals("05") || month.equals("5")){
            MONTH = "Mei";
        }else if (month.equals("06") || month.equals("6")){
            MONTH = "Juni";
        }else if (month.equals("07") || month.equals("7")){
            MONTH = "Juli";
        }else if (month.equals("08") || month.equals("8")){
            MONTH = "Agustus";
        }else if (month.equals("09") || month.equals("9")){
            MONTH = "September";
        }else if (month.equals("10")){
            MONTH = "Oktober";
        }else if (month.equals("11")){
            MONTH = "November";
        }else if (month.equals("12")){
            MONTH = "Desember";
        }
        result = day+" "+MONTH+" "+year;
        return result;

    }
    public void Download(final Context ctx, final String file, final String link, final String nama){
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setMessage("Download File ?")
                .setCancelable(false)
                .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (file.equals("pdf")){
                            DownloadPDF(link,nama,ctx);
                        }else{
                            DownloadPPT(link,nama,ctx);
                        }
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                //Set your icon here
                .setTitle("Perhatian !!!")
                .setIcon(R.drawable.ic_baseline_print_24);
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void DownloadPDF(String url, String judul, Context ctx){
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(BASE_URL()+url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle(judul);
        request.setDescription("Downloading "+judul);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"/eBusiness/"+judul+".pdf");
        DownloadManager manager = (DownloadManager)ctx.getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }
    public void DownloadPPT(String url,String judul,Context ctx){
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(BASE_URL()+url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle(judul);
        request.setDescription("Downloading "+judul);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"/eBusiness/"+judul+".ppsx");
        DownloadManager manager = (DownloadManager)ctx.getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }
    public String SmallDescription(String description){
        String Des = description;
        if (description.length() >= 100){
            Des = description.substring(0,100)+"...";
        }
        return Des;
    }
    public String AUTH(){
        String username = "gade-api";
        String password = "963852741";

        String base = username+":"+password;

        String authHeader = "Basic "+ Base64.encodeToString(base.getBytes(),Base64.NO_WRAP);
        return authHeader;
    }
    public String ApiKey(){
        String key = "845sq21zx54eqw231x583";
        return key;
    }
    public String MagicRP(double nilai){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        BigDecimal bd1 = new BigDecimal(nilai).setScale(0, RoundingMode.HALF_UP);
        String Format = formatRupiah.format(bd1);
        String MAGIC1 = Format.replace("Rp","Rp.");
        return MAGIC1;
    }
    public String Zero(int num){
        String result = "01";
        if (num<10){
            result="0"+String.valueOf(num);
        }else{
            result=String.valueOf(num);
        }
        return result;
    }
    public String MagicChange(String magic){
        String MAGIC1 = magic.replace("Rp","");
        String MAGIC2 = MAGIC1.replace(",","");
        return MAGIC2.replace(".","");
    }
}
