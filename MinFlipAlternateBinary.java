class MinFlipAlternateBinary{
    public static void main(String[] args) {
        if(
            fun("011")==1 &&
            fun("010")==0
            ){
            System.out.println("all tests passed");
        }
        else{
            System.out.println("some tests failed");
        }
    }

    public static int fun(String str){
        int len=str.length();
        int flipCount=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(i%2==0 && ch=='0'){
                flipCount++;
            }
            else if( i%2==1 && ch=='1'){
                flipCount++;
            }
        }
        return Math.min(flipCount,len-flipCount);
    }
}