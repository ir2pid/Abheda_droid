package com.noisyninja.abheda_droid.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.print.PrintAttributes;
import android.print.pdf.PrintedPdfDocument;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.noisyninja.abheda_droid.R;
import com.noisyninja.abheda_droid.activity.PDFContentActivity;
import com.noisyninja.abheda_droid.control.ListLessonDetailItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import events.OnPrintEvent;

/**
 * Created by ir2pid on 15/11/15.
 */
public class PDFUtil {

    private static String FILE = "/sdcard/FirstPdf.pdf";
    private static Font fontHeading;
    private static Font fontRegular;
    private static Font fontSmall;
    /*private static Font catFont = new Font(Constants.font, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);*/

    private static View getPDFView(Context context, ListLessonDetailItem item) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.list_lesson_detail_item, null);

        ImageView image = (ImageView) relativeLayout.findViewById(R.id.image);
        TextView name = (TextView) relativeLayout.findViewById(R.id.name);
        TextView text = (TextView) relativeLayout.findViewById(R.id.text);
        TextView ltext = (TextView) relativeLayout.findViewById(R.id.ltext);
        TextView dtext = (TextView) relativeLayout.findViewById(R.id.dtext);
        TextView utext = (TextView) relativeLayout.findViewById(R.id.utext);
        TextView rtext = (TextView) relativeLayout.findViewById(R.id.rtext);
        TextView description = (TextView) relativeLayout.findViewById(R.id.description);
        Button pdfCreate = (Button) relativeLayout.findViewById(R.id.pdfcreate);


        Utils.lazyload(context, image, item.image);

        Utils.setText(name, item.name);
        Utils.addSpeechClickListener(context, name, name.getText().toString());
        Utils.setText(text, item.text);
        Utils.addSpeechClickListener(context, text, text.getText().toString());
        Utils.setText(ltext, item.ltext);
        Utils.addSpeechClickListener(context, ltext, ltext.getText().toString());
        Utils.setText(rtext, item.rtext);
        Utils.addSpeechClickListener(context, rtext, rtext.getText().toString());
        Utils.setText(utext, item.utext);
        Utils.addSpeechClickListener(context, utext, utext.getText().toString());
        Utils.setText(dtext, item.dtext);
        Utils.addSpeechClickListener(context, dtext, dtext.getText().toString());
        Utils.setText(description, item.description);
        Utils.addSpeechClickListener(context, description, description.getText().toString());

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) image.getLayoutParams();
        if (item.ltext != null && item.ltext.length() > 1)
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        else if (item.rtext != null && item.rtext.length() > 1)
            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        image.setLayoutParams(params);

        return relativeLayout;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void makePDF(Context context, OnPrintEvent event) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            Utils.makeToast(context, Utils.getStringResource(context, R.string.pdf_not_supported));
            return;
        }

        // 1. create an intent pass class name or intnet action name
        Intent intent = new Intent(context, PDFContentActivity.class);

        // 2. put key/value data
        intent.putExtra(Constants.FRAGMENT_DATA, event.getData());

        // 5. start the activity
        context.startActivity(intent);
/*
        // Create a object of PdfDocument
        PdfDocument document = new PdfDocument();

        View view = getPDFView(context, item.get(0));
        // crate a page info with attributes as below
        // page number, height and width
        // i have used height and width to that of pdf content view
        int pageNumber = 1;
        int width = view.getWidth();
        int height = view.getHeight();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(768, 1024, pageNumber).create();

        // create a new page from the PageInfo
        PdfDocument.Page page = document.startPage(pageInfo);

        // repaint the user's text into the page
        view.draw(page.getCanvas());


// do final processing of the page
        document.finishPage(page);

// saving pdf document to sdcard

        String pdfName = name + ".pdf";

// all created files will be saved at path /sdcard/Abheda/
        File outputFile = new File("/sdcard/", "FirstPdf.pdf");

        try {
            outputFile.createNewFile();
            OutputStream out = new FileOutputStream(outputFile);
            document.writeTo(out);
            document.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String dump(Context context, View content, String name) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            Utils.makeToast(context, Utils.getStringResource(context, R.string.pdf_not_supported));
            return null;
        }

        // Create a object of PdfDocument
        PdfDocument document = new PdfDocument();

        // crate a page info with attributes as below
        // page number, height and width
        // i have used height and width to that of pdf content view
        int pageNumber = 1;
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(content.getWidth(),
                content.getHeight(), pageNumber).create();

        // create a new page from the PageInfo
        PdfDocument.Page page = document.startPage(pageInfo);

        // repaint the user's text into the page
        content.draw(page.getCanvas());


// do final processing of the page
        document.finishPage(page);

// saving pdf document to sdcard

        String pdfName = name + ".pdf";

// all created files will be saved at path /sdcard/Abheda/
        File outputFile = new File("/sdcard/", pdfName);

        try {
            outputFile.createNewFile();
            OutputStream out = new FileOutputStream(outputFile);
            document.writeTo(out);
            document.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputFile.getAbsolutePath();
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

    /*
        public static void create(Context context, OnPrintEvent event) {
            List<ListLessonDetailItem> item = event.getDetailItem();

            String encoding = "Identity-H";
            try {
                fontHeading = FontFactory.getFont(Constants.font.toString(), encoding, BaseFont.EMBEDDED, 18, Font.NORMAL, BaseColor.GRAY);
                fontRegular = FontFactory.getFont(Constants.font.toString(), encoding, BaseFont.EMBEDDED, 12, Font.NORMAL, BaseColor.BLACK);
                fontSmall = FontFactory.getFont(Constants.font.toString(), encoding, BaseFont.EMBEDDED, 8, Font.NORMAL, BaseColor.DARK_GRAY);

                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(FILE));
                document.open();
                addMetaData(document, event.getTitle());
                for (ListLessonDetailItem listLessonDetailItem : item) {
                    addContent(context, document, listLessonDetailItem);
                }
                document.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void addContent(Context context, Document document, ListLessonDetailItem lessonDetailItem) {
            Anchor anchor = new Anchor(lessonDetailItem.name, fontHeading);
            anchor.setName(lessonDetailItem.description);

            String imageName = Utils.getImageName(context, lessonDetailItem.image);
            Image image = null;
            try {
                AssetManager assetManager = context.getAssets();
                InputStream inputStream = assetManager.open(imageName);
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                inputStream.close();
                image = Image.getInstance(buffer);
                document.add(image);
                // Second parameter is the number of the chapter
                Chapter catPart = new Chapter(new Paragraph(anchor), 1);

                Paragraph paraUp = new Paragraph(lessonDetailItem.utext);
                Paragraph paraDown = new Paragraph(lessonDetailItem.dtext);
                Paragraph paraMain = new Paragraph(lessonDetailItem.text);

                catPart.addSection(paraUp);

                catPart.addSection(paraDown);

                catPart.addSection(paraMain);

                document.add(catPart);

            } catch (BadElementException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            }

        }

        private static String getHTML(String s) {
            return "<html><body>" + s + "</body></html>";
        }

        // iText allows to add metadata to the PDF which can be viewed in your Adobe
        // Reader
        // under File -> Properties
        private static void addMetaData(Document document, String title) {
            document.addTitle(title);
            document.addSubject("Abheda english");
            document.addKeywords(title);
            document.addAuthor("Abheda Foundation");
            document.addCreator("Abheda Foundation");
        }

        private static void addTitlePage(Document document)
                throws DocumentException {
            Paragraph preface = new Paragraph();
            // We add one empty line
            addEmptyLine(preface, 1);
            // Lets write a big header
            preface.add(new Paragraph("Title of the document", fontHeading));

            addEmptyLine(preface, 1);
            // Will create: Report generated by: _name, _date
            preface.add(new Paragraph("Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    fontSmall));
            addEmptyLine(preface, 3);
            preface.add(new Paragraph("This document describes something which is very important ",
                    fontHeading));

            addEmptyLine(preface, 8);

            preface.add(new Paragraph("This document is a preliminary version and not subject to your license agreement or any other agreement with vogella.com ;-).",
                    fontRegular));

            document.add(preface);
            // Start a new page
            document.newPage();
        }

        private static void createTable(Section subCatPart)
                throws BadElementException {
            PdfPTable table = new PdfPTable(3);

            // t.setBorderColor(BaseColor.GRAY);
            // t.setPadding(4);
            // t.setSpacing(4);
            // t.setBorderWidth(1);

            PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Table Header 2"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Table Header 3"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            table.setHeaderRows(1);

            table.addCell("1.0");
            table.addCell("1.1");
            table.addCell("1.2");
            table.addCell("2.1");
            table.addCell("2.2");
            table.addCell("2.3");

            subCatPart.add(table);

        }
    */
    /*
        private static void createList(Section subCatPart) {
            List list = new List(true, false, 10);
            list.add(new ListItem("First point"));
            list.add(new ListItem("Second point"));
            list.add(new ListItem("Third point"));
            subCatPart.add(list);
        }
    */
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
