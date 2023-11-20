package mcqspractice;

public class Main1 {

    public static void main(String[] args) {
        char[] str = {'G','5','T',' ','A','Z','F'};
        for (int i=0; i<6;i++){
            ++i;
            if(Character.isDigit(str[i]))
                System.out.println("Digit");
            if(Character.isWhitespace(str[i]))
                System.out.println("Space");
            if(Character.isUpperCase(str[i]))
                System.out.println("Upper");
            if(Character.isLowerCase(str[i]))
                System.out.println("Lower");
            i++;
        }
    }
}
