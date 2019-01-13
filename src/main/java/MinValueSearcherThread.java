public class MinValueSearcherThread extends Thread {

    private InputStorage inputStorage;


    public MinValueSearcherThread(InputStorage inputStorage) {
        this.inputStorage = inputStorage;
    }

    private static final int SLEEP_TIME_MILLIS = 5_000;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(SLEEP_TIME_MILLIS);
                deleteMinValue();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void deleteMinValue() {
        try {
            int deletedNumber = inputStorage.findMinValueAndDelete();
            System.out.println("min value is: " + deletedNumber);
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
