package managers;

public class Timer /*implements Runnable*/ {
    private String writeThis;

    public void start(long startTime, long endTime) {
        long elapsedTime = endTime - startTime;
        elapsedTime = elapsedTime / 1000;

        String seconds = Integer.toString((int) (elapsedTime % 60));
        String minutes = Integer.toString((int) ((elapsedTime % 3600) / 60));
        String hours = Integer.toString((int) (elapsedTime / 3600));

        if (seconds.length() < 2) {
            seconds = "0" + seconds;
        }

        if (minutes.length() < 2) {
            minutes = "0" + minutes;
        }

        if (hours.length() < 2) {
            hours = "0" + hours;
        }

        writeThis = hours + ":" + minutes + ":" + seconds;
        System.out.println(writeThis);
    }
}
//    public void run() {
//        try {
//            int charsWritten = 0;
//            long start = System.currentTimeMillis();
//            while (1 > 0) {
//                Thread.sleep(1000);
//                long elapsedTime = System.currentTimeMillis() - start;
//                elapsedTime = elapsedTime / 1000;
//
//                String seconds = Integer.toString((int) (elapsedTime % 60));
//                String minutes = Integer.toString((int) ((elapsedTime % 3600) / 60));
//                String hours = Integer.toString((int) (elapsedTime / 3600));
//
//                if (seconds.length() < 2) {
//                    seconds = "0" + seconds;
//                }
//
//                if (minutes.length() < 2) {
//                    minutes = "0" + minutes;
//                }
//
//                if (hours.length() < 2) {
//                    hours = "0" + hours;
//                }
//
//                writeThis = hours + ":" + minutes + ":" + seconds;
//
//                for (int i = 0; i < charsWritten; i++) {
//                    System.out.print("\b");
//                }
//
//                //System.out.print(writeThis);
//                charsWritten = writeThis.length();
//            }
//            System.out.println(writeThis);
//        }
//        catch (InterruptedException e) {
//            System.err.println(e.getMessage());
//        }
//    }
//
//    public String getCurrentTime(){
//        return writeThis;
//    }