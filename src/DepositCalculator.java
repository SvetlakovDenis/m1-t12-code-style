import java.util.Scanner;

public class DepositCalculator {
    int places = 2;
    double yearRate = 0.06; //Применено
    
    double calculateComplexPercent(double amountOnDeposit, int depositPeriod) {
        double depositSum = amountOnDeposit * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return roundDepositSum(depositSum);// рассмотри возможность оптимизации метода roundDepositSum, чтобы не пришлось дублировать одну и ту же информацию (цифра 2 повторяется)
    }

    double calculateSimplePercent(double amountOnDeposit, int depositPeriod) { //тоже самое касается переменной yearRate, в целом мы ее нигде не меняем, поэтому можно ее один раз объвить 
        return roundDepositSum(amountOnDeposit + amountOnDeposit * yearRate * depositPeriod);
    }

    double roundDepositSum(double value) {
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
            resultOnDeposit = calculateSimplePercent(amountOfMoney, depositPeriod);
        } else if (action == 2) {
            resultOnDeposit = calculateComplexPercent(amountOfMoney, depositPeriod);
        }
        System.out.println("Результат вклада: " + amountOfMoney + " за " + depositPeriod + " лет превратятся в " // при переносе "+" в конце тоже рекомендуется перенести к resultOnDeposit
                + resultOnDeposit); //Исправлено
    }

    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.outputDepositResults();
    }
}
