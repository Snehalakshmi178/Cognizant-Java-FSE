package test;


	import documents.Document;
	import factories.DocumentFactory;
	import factories.WordDocumentFactory;
	import factories.PdfDocumentFactory;
	import factories.ExcelDocumentFactory;

	public class FactoryMethodPatternTest {
	    public static void main(String[] args) {
	        // Create a Word Document
	        DocumentFactory wordFactory = new WordDocumentFactory();
	        Document wordDoc = wordFactory.createDocument();
	        System.out.println("--- Word Document Operations ---");
	        wordDoc.open();
	        wordDoc.save();
	        wordDoc.close();
	        System.out.println();

	        // Create a PDF Document
	        DocumentFactory pdfFactory = new PdfDocumentFactory();
	        Document pdfDoc = pdfFactory.createDocument();
	        System.out.println("--- PDF Document Operations ---");
	        pdfDoc.open();
	        pdfDoc.save();
	        pdfDoc.close();
	        System.out.println();

	        // Create an Excel Document
	        DocumentFactory excelFactory = new ExcelDocumentFactory();
	        Document excelDoc = excelFactory.createDocument();
	        System.out.println("--- Excel Document Operations ---");
	        excelDoc.open();
	        excelDoc.save();
	        excelDoc.close();
	        System.out.println();
	    }

}
