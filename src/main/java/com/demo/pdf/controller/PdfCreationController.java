package com.demo.pdf.controller;

import com.demo.pdf.facade.PdfCreationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PdfCreationController
{
    @Autowired
    PdfCreationFacade pdfCreationFacade;


    @GetMapping("/pdf/user")
    public ResponseEntity<byte[]> downloadUserPDF()
    {

        final byte[] pdfContent = pdfCreationFacade.createPdfFile();
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=user-info.pdf" )
            .contentType(MediaType.APPLICATION_PDF)
            .body(pdfContent);
    }
}
