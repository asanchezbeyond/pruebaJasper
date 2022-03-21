import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws JRException, IOException {
        String jrxmlFileName = "src/main/resources/prueba.jrxml";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("saludo","Haga click para editar el campo");
        
        JasperDesign design = JRXmlLoader.load(jrxmlFileName);
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros,new JREmptyDataSource());
        
        JRPdfExporter pdfExporter = new JRPdfExporter();
        pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        
        ByteArrayOutputStream pdfReportStream = new ByteArrayOutputStream();
        pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfReportStream));
        pdfExporter.exportReport();
        
        OutputStream responseOutputStream = new FileOutputStream("prueba.pdf");
        responseOutputStream.write(pdfReportStream.toByteArray());
        responseOutputStream.close();
        pdfReportStream.close();
    }
}
