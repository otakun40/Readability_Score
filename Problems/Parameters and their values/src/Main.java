class Problem {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 0) {
                System.out.printf("%s=%s\n", args[i], args[i + 1]);
            }
        }
    }
}