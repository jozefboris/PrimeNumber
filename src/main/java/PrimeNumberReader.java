
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrimeNumberReader {

    public void readerXLSX(String filename) throws IOException {
        File excel = new File(filename);
        FileInputStream fis = new FileInputStream(excel);

        XSSFWorkbook book = new XSSFWorkbook(fis);
        XSSFSheet sheet = book.getSheetAt(0);
        Iterator<Row> itr = sheet.iterator();

        while (itr.hasNext()) {
            Row row = itr.next();
            printPrimeNumber(row.getCell(1).getStringCellValue());
        }
    }

    private boolean isPrimeNumber(Long number){

        if(number == 0 || number == 1){
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }



    public void printPrimeNumber(String primeNumber){
        if(primeNumber.indexOf('+', 0) == 0){
            primeNumber = primeNumber.substring(1, primeNumber.length());
        }
        Matcher matcherPositiveNumber;
        matcherPositiveNumber = Pattern.compile("^\\d*$").matcher(primeNumber);
        if(matcherPositiveNumber.find()){
            if(isPrimeNumber(Long.parseLong(primeNumber))){
                System.out.println(primeNumber);
            }
        }
    }

}
