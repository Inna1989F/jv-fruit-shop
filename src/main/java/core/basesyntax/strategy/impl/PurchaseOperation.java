package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    private final FruitStorage storage;

    public PurchaseOperation(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        int currentQuantity = storage.getQuantity(transaction.getFruit());

        int newQuantity = currentQuantity - transaction.getQuantity();

        storage.setQuantity(transaction.getFruit(),
                newQuantity);
    }
}
