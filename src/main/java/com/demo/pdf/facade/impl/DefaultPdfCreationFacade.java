package com.demo.pdf.facade.impl;

import com.demo.pdf.dto.UserDTO;
import com.demo.pdf.facade.PdfCreationFacade;
import com.demo.pdf.service.PdfCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

@Component("pdfCreationFacade")
public class DefaultPdfCreationFacade implements PdfCreationFacade
{
    @Autowired
    PdfCreationService pdfCreationService;

    @Override
    public byte[] createPdfFile()
    {
        final Context context = new Context();
        UserDTO userDTO = new UserDTO();
        userDTO.setUid(1L);
        userDTO.setFirstName("Alex");
        userDTO.setLastName("Rider");
        context.setVariable("user", userDTO);
        return pdfCreationService.createPdfFile("user-template", context);
    }
}
