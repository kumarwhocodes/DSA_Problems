package P0624;

public class P1906 {
    // Striver DSA Sheet Patterns
    public static void main(String[] args) {
        final int rows = 5;
        // P1
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("------------------");
        // P2
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("$");
            }
            System.out.println();
        }
        System.out.println("------------------");
        // P3
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println("------------------");
        // P4
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
        System.out.println("------------------");
        // P5
        for (int i = 1; i <= 5; i++) {
            for (int j = 5 - i + 1; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("------------------");
        // P6
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j < 6 - i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println("------------------");
        // P7
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("#");
            }
            for (int j = 0; j < 5 - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("------------------");
        // P8
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * rows - (2 * i + 1); j++) {
                System.out.print("#");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("------------------");
    
        

    }
}
