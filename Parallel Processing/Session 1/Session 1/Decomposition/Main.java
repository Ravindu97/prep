public class Main {
    public static void main(String[] args) {

        int iterations = 2000000000; // Number of iterations to use for the estimate
        int numThreads =4; // Number of threads to use
        LeibnizThread[] threads = new LeibnizThread[numThreads];

        for (int t = 0; t < numThreads; t++) {
            int start = t * (iterations / numThreads);
            int end = (t + 1) * (iterations / numThreads) - 1;
            threads[t] = new LeibnizThread(start, end);
            threads[t].start();
        }

        // Wait for all threads to finish
        for (int t = 0; t < numThreads; t++) {
            try {
                threads[t].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        double piEstimate = 0.0;
        for (int t = 0; t < numThreads; t++) {
            piEstimate += threads[t].getPartialSum();
        }

        piEstimate *= 4; // Multiply by 4 to get the estimate of π
        System.out.println("Estimated value of π : " + piEstimate);
    }
}
