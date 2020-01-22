package tao;

public class AccountBalance {

    public int processTransactions(int balance, String[] operations) {
        int finalBalance = balance;
        for (int i=0;i<operations.length;i++){
            finalBalance += doOperation(operations[i]);
        }
        return finalBalance;
    }

    private int doOperation(String operation) {
        final String[] operationArray = operation.split(" ");
        return "C".equals(operationArray[0]) ? Integer.parseInt(operationArray[1]) : -Integer.parseInt(operationArray[1]);
    }

}
