public class Solution {
    public static  int Operations(int N){
        int ops=0;
        int num = N;
        if(N<10){
            return 1;
        }
        while(N>0){
            N=N-getfirstdigit(N);
            ops++;
        }
        return ops;
    }

    private static int getfirstdigit(int num) {
        while(num>=10){
            num=num/10;
        }
        return num;
    }

    public static void main(String[] args){
        int N = 5;
        System.out.println(Operations(N));
    }
}

