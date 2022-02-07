package edu.epam.jwd.app;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.service.*;
import edu.epam.jwd.service.factory.CalculationArrayServiceFactory;
import edu.epam.jwd.service.factory.PrinterArrayServiceFactory;
import edu.epam.jwd.service.factory.ReaderArrayServiceFactory;
import edu.epam.jwd.service.factory.SortArrayServiceFactory;

public class ConsoleApp {
    public static void main(String[] args) {
        ReaderArrayService readerArrayService = ReaderArrayServiceFactory.getInstance().getDefaultService();
        PrinterArrayService printerArrayService = PrinterArrayServiceFactory.getInstance().getDefaultService();

        NumberArray numberArray = readerArrayService.readFrom("files/array.txt", ReaderArrayService.DEFAULT_DELIM_PATTERN);
        printerArrayService.print(System.out, numberArray);
        System.out.println();

        CalculationArrayService calculationArrayService = CalculationArrayServiceFactory.getInstance().getDefaultService();
        int length = numberArray.length();
        Number min = calculationArrayService.findMin(numberArray);
        Number max = calculationArrayService.findMax(numberArray);
        Number sum = calculationArrayService.sum(numberArray);
        Number average = calculationArrayService.average(numberArray);
        Number countPositive = calculationArrayService.countPositive(numberArray);
        Number countNegative = calculationArrayService.countNegative(numberArray);

        System.out.printf("length:%d\nmin:%s\nmax:%s\nsum:%s\naverage:%s\ncountPositive:%s\ncountNegative:%s\n",
               length, min, max, sum, average, countPositive, countNegative);

        SortArrayService sortArrayService = SortArrayServiceFactory.getInstance().getDefaultService();
        NumberArray sortedNumberArray = sortArrayService.sort(numberArray, NumberArrayService.DEFAULT_COMPARATOR);

        printerArrayService.print(System.out, sortedNumberArray);
    }
}
