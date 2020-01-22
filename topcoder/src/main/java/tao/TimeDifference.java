package tao;

public class TimeDifference {

    public String calculate(String time1, String time2) {
        final int[] time1Array = getHourMinutes(time1);
        final int[] time2Array = getHourMinutes(time2);
        int minuteResult = 0;
        int hourResult = 0;
        int hourMinuse1 = 0;
        if (time2Array[0] >= time1Array[0]) {
            if (time2Array[1]<time1Array[1]){
                minuteResult = time2Array[1]+60 -time1Array[1];
                hourMinuse1 = 1;
            } else {
                minuteResult = time2Array[1] -time1Array[1];
            }
            hourResult = time2Array[0] - time1Array[0] - hourMinuse1;
        }else {
            if (time1Array[1] < time2Array[1]){
                minuteResult = time1Array[1]+60 -time2Array[1];
                hourMinuse1 = 1;
            } else {
                minuteResult = time1Array[1] -time2Array[1];
            }
            hourResult = -(time1Array[0] - time2Array[0] - hourMinuse1);
        }


        final String minuteString = buildMinute(minuteResult);
        return hourResult +":"+minuteString;

    }

    private String buildMinute(int minuteResult) {
        if (minuteResult<10) return "0"+ minuteResult;
        return String.valueOf(minuteResult);
    }

    private int[] getHourMinutes(String time1) {
        final String[] timeArrays = time1.split(":");
        int[] result = new int[2];
        result[0] = Integer.parseInt(timeArrays[0]);
        result[1] = Integer.parseInt(timeArrays[1]);
        return  result;

    }

    public static void main(String[] args) {
        TimeDifference timeDifference = new TimeDifference();
        final String result = timeDifference.calculate("10:47", "010:47");
        System.out.println(result);
    }

}
