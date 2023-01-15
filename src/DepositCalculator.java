import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amountOnDeposit, double yearRate, int depositPeriod) {
        double depositSum = amountOnDeposit * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return roundDepositSum(depositSum, 2);
    }

    double calculateSimplePercent(double amountOnDeposit, double yearRate, int depositPeriod) {
        return roundDepositSum(amountOnDeposit + amountOnDeposit * yearRate * depositPeriod, 2);
    }

    double roundDepositSum(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void outputDepositResults() {
        int depositPeriod;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amountOfMoney = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double resultOnDeposit = 0;

        if (action == 1) {
            resultOnDeposit = calculateSimplePercent(amountOfMoney, 0.06, depositPeriod);
        } else if (action == 2) {
            resultOnDeposit = calculateComplexPercent(amountOfMoney, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amountOfMoney + " за " + depositPeriod + " лет превратятся в " +
                resultOnDeposit);
    }

    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.outputDepositResults();
    }
}
