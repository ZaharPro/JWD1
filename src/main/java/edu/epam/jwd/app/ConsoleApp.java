package edu.epam.jwd.app;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.exception.BaseRuntimeException;
import edu.epam.jwd.service.*;
import edu.epam.jwd.service.factory.CalculationArrayServiceFactory;
import edu.epam.jwd.service.factory.PrinterArrayServiceFactory;
import edu.epam.jwd.service.factory.ReaderArrayServiceFactory;
import edu.epam.jwd.service.factory.SortArrayServiceFactory;
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

            NumberArray numberArray = readerArrayService.readFrom("files/array.txt",ReaderArrayService.DEFAULT_DELIM_PATTERN);
            printerArrayService.print(out, numberArray);
            out.println();

            CalculationArrayServiceFactory calculationArrayServiceFactory = CalculationArrayServiceFactory.getInstance();
            CalculationArrayService calculationArrayService = calculationArrayServiceFactory.getDefaultService();
            Number min = calculationArrayService.findMin(numberArray);
            Number max = calculationArrayService.findMax(numberArray);
            Number sum = calculationArrayService.sum(numberArray);
            Number average = calculationArrayService.average(numberArray);
            Number countPositive = calculationArrayService.countPositive(numberArray);
            Number countNegative = calculationArrayService.countNegative(numberArray);
            int length = numberArray.length();

            out.printf("length:%d\nmin:%s\nmax:%s\nsum:%s\naverage:%s\ncountPositive:%s\ncountNegative:%s\n",
                    length, min, max, sum, average, countPositive, countNegative);

            SortArrayServiceFactory sortArrayServiceFactory = SortArrayServiceFactory.getInstance();
            SortArrayService sortArrayService = sortArrayServiceFactory.getDefaultService();
            NumberArray sortedNumberArray = sortArrayService.sort(numberArray, NumberArrayService.DEFAULT_COMPARATOR);

            printerArrayService.print(out, sortedNumberArray);
        } catch (BaseRuntimeException e) {
            Logger logger = LogManager.getLogger();
            logger.log(Level.ERROR, e);
        } finally {
            out.flush();
        }
    }
}
