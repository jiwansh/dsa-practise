package Patterns;
public class Patterns {
    //----------------Pattern1------------
    // ******
    // ******
    // ******
    // ******
    // ******
    // ******
    void Pattern1(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
    //----------------Pattern2------------
     void printTriangle(int n) {
    
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
    //-Patter 3---------------
    void printTriangle2(int n) {
        // code here
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    //--------Pattern 4-----
     void trianglePyramid2(int n) {
        // code here
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Patterns pat= new Patterns();
        pat.Pattern1(5);
        pat.printTriangle(5);
        pat.printTriangle2(5);
        pat.trianglePyramid2(5);
    }

}
