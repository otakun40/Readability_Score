import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double ax = scanner.nextDouble();
        double ay = scanner.nextDouble();
        double bx = scanner.nextDouble();
        double by = scanner.nextDouble();
        double angle = Math.acos((ax * bx + ay * by) /
                (Math.sqrt(Math.pow(ax, 2) + Math.pow(ay, 2)) * Math.sqrt(Math.pow(bx, 2) + Math.pow(by, 2))));

        System.out.println(Math.toDegrees(angle));
    }
}