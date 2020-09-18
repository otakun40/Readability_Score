/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];

        int[] numbers = new int[args.length - 1];

        for (int i = 1; i < args.length; i++) {
            numbers[i - 1] = Integer.parseInt(args[i]);
        }

        switch (operator) {
            case "SUM":
                int sum = 0;
                for (int num: numbers) {
                    sum += num;
                }
                System.out.println(sum);
                break;
            case "MAX":
                int max = 0;
                for (int num: numbers) {
                    if (max < num) {
                        max = num;
                    }
                }
                System.out.println(max);
                break;
            case "MIN":
                int min = Integer.MAX_VALUE;
                for (int num: numbers) {
                    if (min > num) {
                        min = num;
                    }
                }
                System.out.println(min);
                break;
            default:break;
        }
    }
}