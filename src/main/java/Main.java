import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * En esta prueba se están utiliando funciones diferentes que en el CRM, pero la funcionalidad es la misma. 
 * En vez de descargar el pdf lo genera en el fichero raiz del proyecto
 * En vez de leer el fichero jasper lee el jrxml y lo compila en tiempo de ejecucion
 * @author asanchez
 *
 */
public class Main {

    public static void main(String[] args) throws JRException, IOException {
        String jrxmlFileName = "src/main/resources/prueba.jrxml";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("devolucion", new Devolucion(1, "1234", "0",new Date(), "Beyond Mobility S.L", "Ninguna","5", "",1 ));
        
        //Carga y compila la plantilla
        JasperDesign design = JRXmlLoader.load(jrxmlFileName);
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        //Rellena el fihcero con los parametros
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros,new JREmptyDataSource());
        //Exporta el fichero
        JRPdfExporter pdfExporter = new JRPdfExporter();
        pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        
        ByteArrayOutputStream pdfReportStream = new ByteArrayOutputStream();
        OutputStream responseOutputStream = null;
        
        try {
            pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfReportStream));
            pdfExporter.exportReport();
        	responseOutputStream = new FileOutputStream("prueba.pdf");
            responseOutputStream.write(pdfReportStream.toByteArray());
        }catch(Exception e) {
        	throw e;
        }finally {
        	if(responseOutputStream != null) {
                responseOutputStream.close();
        	}
            pdfReportStream.close();
        }
    }
}
