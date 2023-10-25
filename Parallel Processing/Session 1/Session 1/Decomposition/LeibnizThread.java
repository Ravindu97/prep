public class LeibnizThread extends Thread {
    private int start;
    private int end;
    private double partialSum;

    public LeibnizThread(int start, int end) {
        this.start = start;
        this.end = end;
        this.partialSum = 0.0;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            double term = 1.0 / (2 * i + 1);
            if (i % 2 == 0) {
                partialSum += term; // Add the positive term
            } else {
                partialSum -= term; // Subtract the negative term
            }
        }
    }

    public double getPartialSum() {
        return partialSum;
    }
}