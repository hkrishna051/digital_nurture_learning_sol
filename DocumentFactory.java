package Exercise 2;

public class DocumentFactory {
    
}
abstract class DocumentFactory {
    public abstract Document createDocument();
    
    public void processDocument() {
        Document document = createDocument();
        document.open();
        System.out.println("Processing " + document.getDocumentType());
        document.save();
        document.close();
    }
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

class DocumentManager {
    public static DocumentFactory getDocumentFactory(String documentType) {
        switch (documentType.toLowerCase()) {
            case "word":
                return new WordDocumentFactory();
            case "pdf":
                return new PdfDocumentFactory();
            case "excel":
                return new ExcelDocumentFactory();
            default:
                throw new IllegalArgumentException("Unsupported document type: " + documentType);
        }
    }
    
    public static void createAndProcessDocument(String documentType) {
        try {
            DocumentFactory factory = getDocumentFactory(documentType);
            factory.processDocument();
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
