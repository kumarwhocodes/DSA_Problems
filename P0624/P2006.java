package P0624;

public class P2006 {
    public static void main(String[] args) {
        final int rows = 5;
        // Strivers A2Z Sheet Patterns
        // P9
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
        System.out.print("---------------------");
        // P10
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-------------------");
        // P11
        int start = 1;
        for (int i = 1; i <= rows; i++) {
            if (i % 2 == 0) {
                start = 0;
            } else {
                start = 1;
            }
            for (int j = 0; j < i; j++) {
                System.out.print(start);
                start = 1 - start;
            }
            System.out.println();
        }
        System.out.println("----------------------");
        // P12
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = (2 * rows - 2 * i); j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println("----------------");
        // P13
        int index = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(index + " ");
                index++;
            }
            System.out.println();
        }
        System.out.println("-------------------");
        // P14
        for (int i = 1; i <= rows; i++) {
            int letter = 65;
            for (int j = 1; j <= i; j++) {
                System.out.print((char) letter + " ");
                letter++;
            }
            System.out.println();
        }
        System.out.println("---------------");
        // P15
        for (int i = rows; i >= 1; i--) {
            int letter = 65;
            for (int j = 1; j <= i; j++) {
                System.out.print((char) letter + " ");
                letter++;
            }
            System.out.println();
        }
        System.out.println("-------------------");
        // P16
        int letter = 65;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((char) letter + " ");
            }
            letter++;
            System.out.println();
        }
        System.out.println("-----------------");
        // P17 baad m theek krenge
        for (int i = 1; i <= rows; i++) {

            for (int j = 0; j < rows - i; j++) {
                System.out.print(" ");
            }

            char alpha = 'A';
            int breakpoint = (2 * i + 1) / 2;
            for (int j = 1; j < 2 * i + 1; j++) {
                System.out.print(alpha);
                if (j < breakpoint)
                    alpha++;
                else
                    alpha--;
            }

            for (int j = 0; j < rows - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");

    }




}
