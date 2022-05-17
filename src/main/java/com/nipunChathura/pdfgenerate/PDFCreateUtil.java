package com.nipunChathura.pdfgenerate;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 5/17/2022
 **/

public class PDFCreateUtil {

    private String name = "";

    public PDFCreateUtil(String name) {
        this.name = name;
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        Image image = Image.getInstance("C:\\Users\\Nipun\\Desktop\\pdf-generater\\pdf-generate\\src\\main\\java\\com\\nipunChathura\\pdfgenerate\\images\\image.png");

        document.open();

        Font font1 = FontFactory.getFont(FontFactory.TIMES);
        font1.setSize(40F);
        font1.setStyle(Font.BOLD);

        Font font2 = FontFactory.getFont(FontFactory.TIMES);
        font2.setSize(30F);
        font2.setStyle(Font.BOLD);

        Font font3 = FontFactory.getFont(FontFactory.TIMES);
        font3.setSize(20F);

        Paragraph oneLine1 = new Paragraph("WELCOME", font1);
        Paragraph oneLine2 = new Paragraph(name, font2);
        Paragraph oneLine3 = new Paragraph("Wade hari", font3);


        oneLine1.setAlignment(Element.ALIGN_CENTER);
        oneLine2.setAlignment(Element.ALIGN_CENTER);
        oneLine3.setAlignment(Element.ALIGN_CENTER);
        image.setAlignment(Element.ALIGN_CENTER);
        image.scaleAbsolute(500, 500);

        document.add(oneLine1);
        document.add(oneLine2);
        document.add(oneLine3);
        document.add(image);

        document.close();
    }
}
