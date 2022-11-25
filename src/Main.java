import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[][] augmented_matrix = new double[3][4];
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if(j != 3){
                    System.out.println("Print a_" + i + j + " coefficient");
                }
                else{
                    System.out.println("Print b_" + i + " coefficient");
                }

                augmented_matrix[i][j] = in.nextDouble();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (augmented_matrix[i][i] == 0) {
                System.out.println("Bad input");
                break;
            }
            for (int j = i; j < 3; j++){
                double temp_coef = augmented_matrix[j][i];
                if(temp_coef == 0.0){
                    continue;
                }
                for (int k = i; k < 4; k++) {
                    augmented_matrix[j][k] = augmented_matrix[j][k] / temp_coef;
                }
            }
            for (int j = i; j < 2; j++){
                for (int k = i; k < 4; k++) {
                    augmented_matrix[j + 1][k] = augmented_matrix[j + 1][k] - augmented_matrix[i][k];
                }
            }
        }
        double x3 = augmented_matrix[2][3] / augmented_matrix[2][2];
        double x2 = augmented_matrix[1][3] - augmented_matrix[1][2] * x3;
        double x1 = augmented_matrix[0][3] - augmented_matrix[0][2] * x3 - augmented_matrix[0][1] * x2;

        System.out.println("x1 =" + x1);
        System.out.println("x2 =" + x2);
        System.out.println("x3 =" + x3);
    }
}
