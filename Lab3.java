
class Lab3 {

    static void spaces(int numberOfSpaces) {

        for (int i = 0; i < numberOfSpaces; i++) {
            System.out.print(" ");
        }
    }

    static void rulerRec(int width, int number) {

        if (number > 0) {
            rulerRec(width, number - 2);

            spaces((-number + width) / 2);
            for (int i = 0; i < number; i++) {
                System.out.print("-");
            }
            System.out.println("");
            rulerRec(width, number - 2);
        }
    }

    static void ruler(int width, int length) {
        for (int j = 0; j < length; j++) {

            for (int i = 0; i < width; i++) {
                System.out.print("-");
            }
            System.out.println(" " + j);

            rulerRec(width, width - 2);
        }
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println(" " + length);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        ruler(a, b);
    }
}
