

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emanuel Rivera Aguilar Correo: elmenny_32@hotmail.com
 */
public class Pdf {

    
    // Fonts definitions (Definición de fuentes).
    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
         
    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
     
    private static final String iTextExampleImage = "C:\\Users\\elmen\\Desktop\\pc-bre.jpg";
    
    public Pdf() {
    }
    
    public void generarPdf(){
    
//
//    Document documento = new Document();
//
//    FileOutputStream ficheroPdf;
//    //(Luego colocamos el siguiente código sustituyendo "/home/ejemplos/" con la ruta donde vamos a guardar tu PDF.
//    try{
//        
//        ficheroPdf = new FileOutputStream("C:\\Users\\elmen\\Desktop\\ejemplo.PDF");
//        PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
//        
//    }catch (Exception ex){
//        
//        System.out.println(ex.toString());
//    }
//    
//    
//
//    try{
//     documento.open();
//           //aqui agregamos todo el contenido del PDF...
//     documento.close();
//    }catch(Exception ex){
//     System.out.println(ex.toString());
//    }
//
//    //Para un párrafo solo colocamos:
//
//    documento.add(new Paragraph("nuestro texto"));


        //Si queremos el documento en modo landscape:
        //Document documento = new Document(PageSize.LETTER.rotate());
        //Ahora necesitamos un nuevo documento en el cual vamos a agregar todo lo que queremos en el PDF
        Document documento = new Document();  
        //y un stream para escribir en el archivo PDF
        FileOutputStream ficheroPdf;
        try{
            
            ficheroPdf = new FileOutputStream("C:\\Users\\ejemplo.PDF");
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
            
        }catch (Exception ex){
            
            System.out.println(ex.toString());
            
        }
        //Ahora hacemos un cascaron donde en el medio insertaremos todo el contenido del PDF.
        try{
            documento.open();
            
             // Añadimos los metadatos del PDF
            documento.addTitle("Table export to PDF (Exportamos la tabla a PDF)");
            documento.addSubject("Using iText (usando iText)");
            documento.addKeywords("Java, PDF, iText");
            documento.addAuthor("Código Xules");
            documento.addCreator("Código Xules");
            
            for (int i = 0; i < 5; i++) {
                 Paragraph parrafo2 = new Paragraph("nuestro segundo Texto alig");
                parrafo2.setAlignment(0);//el 1 es para centrar
                documento.add(parrafo2);
               
            }
            
            documento.add(new Paragraph("nuestro texto"));
            Paragraph parrafo2 = new Paragraph("nuestro segundo Texto alig");
            parrafo2.setAlignment(2);//el 1 es para centrar
            documento.add(parrafo2);
            documento.add(new Paragraph(" "));
            PdfPTable tabla = new PdfPTable(3);
            //el numero indica la cantidad de Columnas
            tabla.addCell("celda1");
            tabla.addCell("celda2");
            tabla.addCell("celda3");
            tabla.addCell("celda4");
            tabla.addCell("celda5");
            tabla.addCell("celda6");
            // esto nos crea una tabla de 3 Columnas por dos Filas
            documento.add(tabla);
            documento.add(new Paragraph(" "));
            PdfPTable tabla2 = new PdfPTable(3);
            PdfPCell celda = new PdfPCell(new Paragraph("celda \n modificada"));
            celda.setColspan(2);
           //cantidad de columnas que ocupa esta celda
            celda.setRowspan(2);
           //cantidad de filas que ocupa esta celda
            tabla2.addCell(celda);
           tabla2.addCell("celda5");
            tabla2.addCell("celda6");
            tabla2.addCell("celda7");
            tabla2.addCell("celda8");
            tabla2.addCell("celda9");
            documento.add(tabla2);
            documento.close();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
   
        try {
        File path = new File ("C://Users//ejemplo.pdf");
        Desktop.getDesktop().open(path);
        }catch (IOException ex) {
        ex.printStackTrace();
        }
    }

     public void createPDF(Object lista[][],int filas, String total) {
        // We create the document and set the file name.        
        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Document document = new Document(PageSize.A6);
            //y un stream para escribir en el archivo PDF
            FileOutputStream ficheroPdf;
            try {
 
                ficheroPdf = new FileOutputStream("C:\\ejemplo.pdf");
                PdfWriter.getInstance(document,ficheroPdf).setInitialLeading(20);
                //PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
 
            } catch (FileNotFoundException fileNotFoundException) {
                //System.out.println("No such file was found to generate the PDF "+ "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
                System.out.println(fileNotFoundException.toString());
            }
            document.open();
            // We add metadata to PDF
            // Añadimos los metadatos del PDF
            document.addTitle("Table export to PDF (Exportamos la tabla a PDF)");
            document.addSubject("Using iText (usando iText)");
            document.addKeywords("Java, PDF, iText");
            document.addAuthor("Emanuel Rivera Aguilar");
            document.addCreator("STELLER");
             
            // First page
            // Primera página 
            Chunk chunk = new Chunk("STELLER", chapterFont);
            chunk.setBackground(BaseColor.GRAY);
            // Let's create de first Chapter (Creemos el primer capítulo)
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);
            chapter.add(new Paragraph("TICKET DE COMPRA", paragraphFont));
            
            // We add an image (Añadimos una imagen)
//            Image image;
//            try {
//                image = Image.getInstance(iTextExampleImage);  
//                image.setAbsolutePosition(2, 150);
//                chapter.add(image);
//            } catch (BadElementException ex) {
//                System.out.println("Image BadElementException" +  ex);
//            } catch (IOException ex) {
//                System.out.println("Image IOException " +  ex);
//            }
            document.add(chapter);
            document.add(new Paragraph(" "));
           
             int columnas = 0;
             Paragraph parrafo_enca = new Paragraph(" COD   CATEGORIA           CANT.     COST.U", smallBold);
             parrafo_enca.setAlignment(0);//el 1 es para centrar
             document.add(parrafo_enca);
             for (int i = 0; i < filas; i++) {

                 String cod_prod = (String)(lista[i][columnas]);
                 columnas=1;
                 String categoria = (String)(lista[i][columnas]);
                 columnas=3;
                 String categoria_espacio = categoria(categoria);
                 int cant = (int)(lista[i][columnas]);
                 columnas=4;
                 String cantidad_espacio = cantidad(cant);
                 float cos_unit = (float)(lista[i][columnas]);
                 columnas=0;
                 String cost_unit_espacio = costo_unit(cos_unit);
                //parrafo = cod_prod+" "+desc+" "+cant+cos_unit;
                                 
                Paragraph parrafo2 = new Paragraph(cod_prod+" "+categoria+categoria_espacio+cant+cost_unit_espacio+cost_unit_espacio+"$"+cos_unit, smallBold);
                parrafo2.setAlignment(0);//el 1 es para centrar
                document.add(parrafo2);
             }
             document.add(new Paragraph(" "));
          
            Paragraph parrafo_total = new Paragraph("Total: $"+total, smallBold);
            parrafo_total.setAlignment(2);//el 1 es para centrar
            document.add(parrafo_total);
             
//            // Second page - some elements
//            // Segunda página - Algunos elementos
//            Chapter chapSecond = new Chapter(new Paragraph(new Anchor("Some elements (Añadimos varios elementos)")), 1);
//            Paragraph paragraphS = new Paragraph("Do it by Xules (Realizado por Xules)", subcategoryFont);
//             
//            // Underline a paragraph by iText (subrayando un párrafo por iText)
//            Paragraph paragraphE = new Paragraph("This line will be underlined with a dotted line (Está línea será subrayada con una línea de puntos).");
//            DottedLineSeparator dottedline = new DottedLineSeparator();
//            dottedline.setOffset(-2);
//            dottedline.setGap(2f);
//            paragraphE.add(dottedline);
//            chapter.addSection(paragraphE);
//             
//            Section paragraphMoreS = chapSecond.addSection(paragraphS);
//            // List by iText (listas por iText)
//            String text = "test 1 2 3 ";
//            for (int i = 0; i < 5; i++) {
//                text = text + text;
//            }
//            List list = new List(List.UNORDERED);
//            ListItem item = new ListItem(text);
//            item.setAlignment(Element.ALIGN_JUSTIFIED);
//            list.add(item);
//            text = "a b c align ";
//            for (int i = 0; i < 5; i++) {
//                text = text + text;
//            }
//            item = new ListItem(text);
//            item.setAlignment(Element.ALIGN_JUSTIFIED);
//            list.add(item);
//            text = "supercalifragilisticexpialidocious ";
//            for (int i = 0; i < 3; i++) {
//                text = text + text;
//            }
//            item = new ListItem(text);
//            item.setAlignment(Element.ALIGN_JUSTIFIED);
//            list.add(item);
//            paragraphMoreS.add(list);
//            document.add(chapSecond);
//             
//            // How to use PdfPTable
            // Utilización de PdfPTable
             
            // We use various elements to add title and subtitle
//             Usamos varios elementos para añadir título y subtítulo
//            Anchor anchor = new Anchor("Table export to PDF (Exportamos la tabla a PDF)", categoryFont);
//            anchor.setName("Table export to PDF (Exportamos la tabla a PDF)");            
//            Chapter chapTitle = new Chapter(new Paragraph(anchor), 1);
//            Paragraph paragraph = new Paragraph("Do it by Xules (Realizado por Xules)", subcategoryFont);
//            Section paragraphMore = chapTitle.addSection(paragraph);
//            paragraphMore.add(new Paragraph("This is a simple example (Este es un ejemplo sencillo)"));
//            Integer numColumns = 4;
//            Integer numRows = filas;
//            // We create the table (Creamos la tabla).
//            PdfPTable table = new PdfPTable(numColumns); 
//            // Now we fill the PDF table 
//            // Ahora llenamos la tabla del PDF
//            PdfPCell columnHeader;
//            // Fill table rows (rellenamos las filas de la tabla).                
//            for (int column = 0; column < numColumns; column++) {
//                columnHeader = new PdfPCell(new Phrase("COL " + column));
//                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table.addCell(columnHeader);
//            }
//            table.setHeaderRows(1);
//            // Fill table rows (rellenamos las filas de la tabla).                
//            for (int row = 0; row < numRows; row++) {
//                for (int column = 0; column < numColumns; column++) {
//                    table.addCell((String) lista[row][numColumns]);
//                }
//            }
//            // We add the table (Añadimos la tabla)
//            paragraphMore.add(table);
//            // We add the paragraph with the table (Añadimos el elemento con la tabla).
//            document.add(chapTitle);
            document.close();
            System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
        
        try {
        File path = new File ("C:\\ejemplo.pdf");
        Desktop.getDesktop().open(path);
        }catch (IOException ex) {
        ex.printStackTrace();
        }
    }
     
     public String costo_unit(float cos_unit ){
         
         String cost_unit_ = String.valueOf(cos_unit);
         int num = cost_unit_.length();
         int cont = 8 -num;
         
         String espacios = "";
         for (int i = 0; i < cont; i++) {
             espacios+="_";
         }
         
         return espacios;
     }
     
     public String cantidad(int cantidad ){
         
         String cost_unit_ = String.valueOf(cantidad);
         int num = cost_unit_.length();
         int cont = 10 -num;
         
         String espacios = "";
         for (int i = 0; i < cont; i++) {
             espacios+="_";
         }
         
         return espacios;
     }
     
     public String categoria(String categoria){
         
         int num = categoria.length();
         int cont = 20 -num;
        
         String espacios = "";
         for (int i = 0; i < cont; i++) {
             espacios+="_";
         }
         
         return espacios;
     }

}
