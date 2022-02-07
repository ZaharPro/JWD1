package edu.epam.jwd.app;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.BaseRuntimeException;
import edu.epam.jwd.service.*;
import edu.epam.jwd.service.factory.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintStream;

public class ConsoleApp {
    public static void main(String[] args) {
        PrintStream out = System.out;
        try {
            ReaderArrayServiceFactory readerArrayServiceFactory = ReaderArrayServiceFactory.getInstance();
            ReaderArrayService readerArrayService = readerArrayServiceFactory.getDefaultService();
            PrinterArrayServiceFactory printerArrayServiceFactory = PrinterArrayServiceFactory.getInstance();
            PrinterArrayService printerArrayService = printerArrayServiceFactory.getDefaultService();

            NumberArray array = readerArrayService.readFrom("files/array.txt",ReaderArrayService.DEFAULT_DELIM_PATTERN);

            out.println("Array:");
            printerArrayService.print(out, array);
            out.println('\n');

            CalculationArrayServiceFactory calculationArrayServiceFactory = CalculationArrayServiceFactory.getInstance();
            CalculationArrayService calculationArrayService = calculationArrayServiceFactory.getDefaultService();
            Number min = calculationArrayService.findMin(array);
            Number max = calculationArrayService.findMax(array);
            Number sum = calculationArrayService.sum(array);
            Number average = calculationArrayService.average(array);
            Number countPositive = calculationArrayService.countPositive(array);
            Number countNegative = calculationArrayService.countNegative(array);
            int length = array.length();

            out.printf("length:%d\nmin:%s\nmax:%s\nsum:%s\naverage:%s\ncountPositive:%s\ncountNegative:%s\n\n",
                    length, min, max, sum, average, countPositive, countNegative);

            SortArrayServiceFactory sortArrayServiceFactory = SortArrayServiceFactory.getInstance();
            SortArrayService sortArrayService = sortArrayServiceFactory.getDefaultService();
            NumberArray sortedNumberArray = sortArrayService.sort(array, NumberArrayService.DEFAULT_COMPARATOR);

            out.println("Sorted:");
            printerArrayService.print(out, sortedNumberArray);
            out.println('\n');

            NumberArrayServiceFactory numberArrayServiceFactory = NumberArrayServiceFactory.getInstance();
            NumberArrayService numberArrayService = numberArrayServiceFactory.getDefaultService();
            NumberArray replaced = numberArrayService.replaceIf(array, n -> n.doubleValue() < 0, 31);

            out.println("Replaced:");
            printerArrayService.print(out, replaced);
            out.println();
        } catch (BaseRuntimeException e) {
            Logger logger = LogManager.getLogger();
            logger.log(Level.ERROR, e);
        } finally {
            out.flush();
        }
    }
}
