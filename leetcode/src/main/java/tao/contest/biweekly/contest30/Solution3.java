package tao.contest.biweekly.contest30;

class Solution3 {
    static String[] monthArry = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public String reformatDate(String date) {
        final String[] arr = date.split(" ");
        String year = arr[2];
        int montheIndex = -1;
        for (int i = 0; i < monthArry.length; i++) {
            if (monthArry[i].equals(arr[1])){
                montheIndex = i; break;
            }
        }
        String month ="";
        if (montheIndex<9) month = "0"+(montheIndex+1);
        else month = String.valueOf(montheIndex+1);
        final String substring = arr[0].substring(0, 2);
        String day ="";
        if (substring.charAt(1)>='0' && substring.charAt(1)<='9'){
            day = substring;
        }else{
            day = "0" + substring.charAt(0);
        }
        return String.format("%s-%s-%s", year, month, day);
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        final String result = s.reformatDate("20th Oct 2052");
        System.out.println(result);
    }
}