package Exercise 2;

public class DocumentTypes {
    
}
interface Document {
    void open();
    void close();
    void save();
    String getDocumentType();
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Microsoft Word document...");
    }
    
    @Override
    public void close() {
        System.out.println("Closing Word document");
    }
    
    @Override
    public void save() {
        System.out.println("Saving Word document as .docx file");
    }
    
    @Override
    public String getDocumentType() {
        return "Microsoft Word Document";
    }
}

class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document with Adobe Reader...");
    }
    
    @Override
    public void close() {
        System.out.println("Closing PDF document");
    }
    
    @Override
    public void save() {
        System.out.println("Saving PDF document as .pdf file");
    }
    
    @Override
    public String getDocumentType() {
        return "Portable Document Format";
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel spreadsheet...");
    }
    
    @Override
    public void close() {
        System.out.println("Closing Excel spreadsheet");
    }
    
    @Override
    public void save() {
        System.out.println("Saving Excel document as .xlsx file");
    }
    
    @Override
    public String getDocumentType() {
        return "Microsoft Excel Spreadsheet";
    }
}
