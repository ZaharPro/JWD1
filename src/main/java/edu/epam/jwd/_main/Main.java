package edu.epam.jwd._main;

import edu.epam.jwd.entity.IntArray;
import edu.epam.jwd.exception.BaseRuntimeException;
import edu.epam.jwd.service.*;
import edu.epam.jwd.service.factory.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintStream;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        PrintStream out = System.out;
        try {
            ReaderArrayServiceFactory readerArrayServiceFactory = ReaderArrayServiceFactory.getInstance();
            ReaderArrayService readerArrayService = readerArrayServiceFactory.getDefaultService();
            PrinterArrayServiceFactory printerArrayServiceFactory = PrinterArrayServiceFactory.getInstance();
            PrinterArrayService printerArrayService = printerArrayServiceFactory.getDefaultService();

            IntArray array = readerArrayService.readFrom("files/array.txt", ReaderArrayService.DEFAULT_DELIM_PATTERN);

            out.println("Array:");
            printerArrayService.print(out, array);
            out.println('\n');

            CalculationArrayServiceFactory calculationArrayServiceFactory = CalculationArrayServiceFactory.getInstance();
            CalculationArrayService calculationArrayService = calculationArrayServiceFactory.getDefaultService();
            String min = toString(calculationArrayService.findMin(array));
            String max = toString(calculationArrayService.findMax(array));
            String sum = toString(calculationArrayService.sum(array));
            String average = toString(calculationArrayService.average(array));
            Number countPositive = calculationArrayService.countPositive(array);
            Number countNegative = calculationArrayService.countNegative(array);
            int length = array.length();

            out.printf("length:%d\nmin:%s\nmax:%s\nsum:%s\naverage:%s\ncountPositive:%s\ncountNegative:%s\n\n",
                    length, min, max, sum, average, countPositive, countNegative);

            SortArrayServiceFactory sortArrayServiceFactory = SortArrayServiceFactory.getInstance();
            SortArrayService sortArrayService = sortArrayServiceFactory.getDefaultService();
            IntArray sortedIntArray = sortArrayService.sort(array, IntArrayService.DEFAULT_COMPARATOR);

            out.println("Sorted:");
            printerArrayService.print(out, sortedIntArray);
            out.println('\n');

            NumberArrayServiceFactory numberArrayServiceFactory = NumberArrayServiceFactory.getInstance();
            IntArrayService intArrayService = numberArrayServiceFactory.getDefaultService();
            IntArray replaced = intArrayService.replaceIf(array, n -> n.doubleValue() < 0, 31);

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

    private static String toString(OptionalInt optionalInt) {
        return optionalInt.isPresent() ?
                Integer.toString(optionalInt.getAsInt()) :
                "Undefined";
    }
}
