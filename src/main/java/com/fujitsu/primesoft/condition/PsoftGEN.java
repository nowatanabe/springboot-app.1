package com.fujitsu.primesoft.condition;

import com.fujitsu.primesoft.PsoftIllegalArgumentException;

public final class PsoftGEN<K> implements PsoftKeyValueCondition<K> {
    private K keyValue;
    private int length;

    public PsoftGEN​(K keyValue, int length) throws PsoftIllegalArgumentException {
        this.keyValue = keyValue;
        this.length = length;
        if (this.length <= 0) {
            throw new PsoftIllegalArgumentException();
        }
    }

    @Override
    public PsoftConditionKind getConditionKind() {
        return PsoftConditionKind.GEN;
    }

    @Override
    public K getKeyValue() {
        return this.keyValue;
    }
}
