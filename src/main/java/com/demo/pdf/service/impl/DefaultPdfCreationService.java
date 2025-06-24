package com.demo.pdf.service.impl;

import com.demo.pdf.service.PdfCreationService;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.source.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Service("pdfCreationService")
public class DefaultPdfCreationService implements PdfCreationService
{
    Logger LOG = LoggerFactory.getLogger(DefaultPdfCreationService.class);

    @Override
    public byte[] createPdfFile(final String templateName, final Context context)
    {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        try (final ByteArrayOutputStream out = new ByteArrayOutputStream())
        {
            final String htmlContent = templateEngine.process(templateName, context);
            // convert HTML to PDF
            final ConverterProperties properties = new ConverterProperties();
            HtmlConverter.convertToPdf(htmlContent, out, properties);

            return out.toByteArray();
        }
        catch (final Exception e)
        {
            LOG.error(e.getMessage(), e);
        }
        return new byte[0];
    }
}
