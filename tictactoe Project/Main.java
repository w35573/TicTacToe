package tictactoe;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    static Scanner scan = new Scanner(System.in);
    static char[][] arr = new char[3][3];
    static int count=0, cont=0;
    //sumD1 is left diagonal and D2 is right
    static int sumD1 = 0, sumD2 = 0, Xn=0, On=0;
    static int[] sumR = {0,0,0};
    static int[] sumC = {0,0,0};

    static void display() {
        System.out.println("---------");
        for (int i=0; i<3; i++) {
            System.out.print("| ");
            for (int j=0; j<3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    static void Check() {
        sumD1=sumD2=sumR[0]=sumR[1]=sumR[2]=sumC[0]=sumC[1]=sumC[2]=0;
        for (int i=0;i<3;i++) {
            sumD1 = sumD1 + (int)arr[i][i];
            sumD2 = sumD2 + (int)arr[i][2-i];
            for (int j=0;j<3;j++) {
                sumR[i] = sumR[i] + (int)arr[i][j];
                sumC[i] = sumC[i] + (int)arr[j][i];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("---------");
        for (int i=0;i<3;i++) {
            System.out.print("| ");
            for (int j=0;j<3;j++) {
                arr[i][j] = ' ';
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
        do {
            try {
                System.out.print("Enter the coordinates: ");
                int x = scan.nextInt();
                int y = scan.nextInt();
                if(x<1 || x>3 || y<1 || y>3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                } else if(arr[x-1][y-1]==' ') {
                    count++;
                    if(count%2==0) {
                        On++;
                        arr[x-1][y-1]='O';
                    } else {
                        Xn++;
                        arr[x-1][y-1]='X';
                    }
                    display();
                    Check();
                    if(sumR[0]==264 || sumR[1]==264 || sumR[2]==264 || sumC[0]==264 || sumC[1]==264 || sumC[2]==264 || sumD1==264 ||sumD2==264) {
                        System.out.println("X wins");
                        break;
                    } else if(sumR[0]==237 || sumR[1]==237 || sumR[2]==237 || sumC[0]==237 || sumC[1]==237 || sumC[2]==237 || sumD1==237 ||sumD2==237) {
                        System.out.println("O wins");
                        break;
                    } else if(Xn+On==9) {
                        System.out.println("Draw");
                        break;
                    }
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                continue;
            }
        }while(cont==0);
    }
}
