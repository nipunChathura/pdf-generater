package com.nipunChathura.pdfgenerate;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 5/17/2022
 **/

@RestController
@RequestMapping("/pdf/export")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PDFExportController {

    @GetMapping
    public void exportPDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        PDFCreateUtil createUtil = new PDFCreateUtil("NIPUN CHATHURANGA");
        createUtil.export(response);
    }

}
