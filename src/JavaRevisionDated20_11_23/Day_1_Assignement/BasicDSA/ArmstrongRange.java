package JavaRevisionDated20_11_23.Day_1_Assignement.BasicDSA;

/**
 * Find out all the Armstrong number falling in Range 100 - 999.
 */
public class ArmstrongRange {
    public static void main(String[] args) {
        for(int i = 1; i <= 9; i++){
            for(int j = 0; j <= 9 ; j++){
                for(int k = 0; k <= 9; k++){
                    int result = i*100 + j*10 + k*1;
                    if((i*i*i)+(j*j*j)+(k*k*k) == result){
                        System.out.println(result);
                    }
                }
            }
        }
    }
}
