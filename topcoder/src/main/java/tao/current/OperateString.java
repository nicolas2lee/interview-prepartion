package tao.current;

public class OperateString {

    public String operate(String s, int[] moves) {
        int length = s.length();
        for (int i=0; i<moves.length;i++){
            int current = moves[i]%length;
            if (current>0){
                final String toMove = s.substring(0, current);
                final String donotMove = s.substring(current, length);
                s = donotMove + toMove;
            } else if (current <0){
                int index=current*(-1);
                final String toMove = s.substring(length-index, length);
                final String donotMove = s.substring(0, length-index);
                s= (toMove)+donotMove;
            }
        }
        return s;
    }
    private String reverse(String s){
        final char[] chars = s.toCharArray();
        final char[] result = new char[chars.length];
        for (int i=0; i<chars.length;i++){
            result[i] = chars[chars.length-1-i];
        }
        return new String(result);
    }

    public static void main(String[] args) {
        OperateString o = new OperateString();
        final String result = o.operate("abracadabra", new int[]{-3});
        System.out.println(result);
    }

}
