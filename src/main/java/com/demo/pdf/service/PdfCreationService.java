package com.demo.pdf.service;

import org.thymeleaf.context.Context;

public interface PdfCreationService
{
    /**
     *
     * @param templateName
     * @param context
     * @return generated PDF file
     */
    byte[] createPdfFile(final String templateName, final Context context);
}
