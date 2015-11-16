package com.noisyninja.abheda_droid.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.print.PrintAttributes;
import android.print.pdf.PrintedPdfDocument;
import android.view.View;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.noisyninja.abheda_droid.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by ir2pid on 15/11/15.
 */
public class PDFUtil {

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void dump(Context context, View content, String name) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            Utils.makeToast(context, Utils.getStringResource(context, R.string.pdf_not_supported));
            return;
        }

        // Create a object of PdfDocument
        PdfDocument document = new PdfDocument();

        // crate a page info with attributes as below
        // page number, height and width
        // i have used height and width to that of pdf content view
        int pageNumber = 1;
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(content.getWidth(),
                content.getHeight() - 20, pageNumber).create();

        // create a new page from the PageInfo
        PdfDocument.Page page = document.startPage(pageInfo);

        // repaint the user's text into the page
        content.draw(page.getCanvas());


// do final processing of the page
        document.finishPage(page);

// saving pdf document to sdcard

        String pdfName = name + ".pdf";

// all created files will be saved at path /sdcard/Abheda/
        File outputFile = new File("/sdcard/Abheda/", pdfName);

        try {
            outputFile.createNewFile();
            OutputStream out = new FileOutputStream(outputFile);
            document.writeTo(out);
            document.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void createview(Context context, View view) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            Utils.makeToast(context, Utils.getStringResource(context, R.string.pdf_not_supported));
            return;
        }
        // open a new document
        PrintAttributes printAttributes = new PrintAttributes.Builder()
                .setColorMode(PrintAttributes.COLOR_MODE_COLOR)
                .setMediaSize(PrintAttributes.MediaSize.ISO_A4)
                .setMinMargins(PrintAttributes.Margins.NO_MARGINS).build();
        PrintedPdfDocument document = new PrintedPdfDocument(context,
                printAttributes);

// start a page
        PdfDocument.Page page = document.startPage(0);

// draw something on the page
        //View content = getContentView();
        view.draw(page.getCanvas());

// finish the page
        document.finishPage(page);

// write the document content
        //document.writeTo(getOutputStream());

//close the document
        document.close();
    }

    public static void create(View view) {

        Bitmap b = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        view.draw(c);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        try {
            Image image = Image.getInstance(byteArray);
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document document = new Document();

        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream("Image.pdf"));
            document.open();

            Image image1 = Image.getInstance("watermark.png");
            document.add(image1);


            String imageUrl = "http://jenkov.com/images/" +
                    "20081123-20081123-3E1W7902-small-portrait.jpg";

            Image image2 = Image.getInstance(new URL(imageUrl));
            document.add(image2);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
