import parser.LiteralNumberParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputProcessorThread extends Thread {

    private InputStorage inputStorage;

    private static final String STOP = "stop";


    public static void main(String[] args) {
        InputStorage inputStorage = new InputStorage();
        InputProcessorThread inputProcessorThread = new InputProcessorThread(inputStorage);
        MinValueSearcherThread minValueSearcherThread = new MinValueSearcherThread(inputStorage);
        minValueSearcherThread.setName("minValueSearcherThread");

        inputProcessorThread.start();
        minValueSearcherThread.start();
    }


    public InputProcessorThread(InputStorage inputStorage) {
        this.inputStorage = inputStorage;
    }

    public void run() {
        while (true) {
            String line = readInputLine();
            if (isStop(line)) {
                System.exit(0);
            } else {
                try {
                    int inputNumber = getNumberFromLine(line);
                    System.out.println("input is " + inputNumber);
                    inputStorage.addToList(inputNumber);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                } catch (Exception anyEx) {
                    anyEx.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }

    public int getNumberFromLine(String line) {
        return LiteralNumberParser.convertStringToNumber(line);
    }

    private String readInputLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("print a number:");
        String line = "";
        try {
            line = reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }

    private static boolean isStop(String line) {
        return STOP.equals(line);
    }


}
