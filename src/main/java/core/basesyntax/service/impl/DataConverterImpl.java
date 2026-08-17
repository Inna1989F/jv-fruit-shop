package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < inputReport.size(); i++) {
            String line = inputReport.get(i);
            String[] data = line.split(",");

            String operationCode = data[0].trim();
            String fruit = data[1].trim();
            String quantityValue = data[2].trim();
            int quantity = Integer.parseInt(quantityValue);

            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.getOperationByCode(operationCode);
            FruitTransaction transaction = new FruitTransaction(
                    operation,
                    fruit,
                    quantity
            );
            transactions.add(transaction);
        }
        return transactions;
    }
}
