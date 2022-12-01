import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[][] a = new double[3][4];
        double[][] temp = new double[3][4];
        double[][] temp2 = new double[3][4];

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if(j != 3){
                    System.out.println("Print a_" + i + j + " coefficient");
                }
                else{
                    System.out.println("Print b_" + i + " coefficient");
                }

                a[i][j] = in.nextDouble();
                temp[i][j] = a[i][j];
                temp2[i][j] = a[i][j];
            }
        }
        Counter.transpose(temp2);
        temp2 =  Counter.getAlgebraicAdditionsMatrix(temp2);

        double[][] reversed = Counter.getReversed(temp2, Counter.getDeterminant(a));
        double conditionNumber = Counter.getConditionNumber(a, reversed);

        for (int i = 0; i < 3; i++) {
            if (temp[i][i] == 0) {
                for(int j = i + 1; j < 3; j++){
                    if(temp[j][i] != 0.0){
                        for (int k = 0; k < 4; k++){
                            double tmp = temp[j][k];
                            temp[j][k] = temp[i][k];
                            temp[i][k] = tmp;
                        }
                    }
                }
            }
            for (int j = i; j < 3; j++){
                double temp_coef = temp[j][i];
                if(temp_coef == 0.0){
                    continue;
                }
                for (int k = i; k < 4; k++) {
                    temp[j][k] = temp[j][k] / temp_coef;
                }
            }
            for (int j = i; j < 2; j++){
                for (int k = i; k < 4; k++) {
                    if(temp[j + 1][k] == 0.0){
                        break;
                    }
                    temp[j + 1][k] = temp[j + 1][k] - temp[i][k];
                }
            }
        }
        double x3 = temp[2][3] / temp[2][2];
        double x2 = temp[1][3] - temp[1][2] * x3;
        double x1 = temp[0][3] - temp[0][2] * x3 - temp[0][1] * x2;
        double q = Counter.getNorm(a);


        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
        System.out.println("x3 = " + x3);
        System.out.println("Matrix norm = " + q);
        System.out.println("Matrix condition number = " + conditionNumber);
    }
}
