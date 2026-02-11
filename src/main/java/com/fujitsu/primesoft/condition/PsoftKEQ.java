package com.fujitsu.primesoft.condition;

public final class PsoftKEQ<K> implements PsoftKeyValueCondition<K> {
    private final K keyValue;

    public PsoftKEQ(K keyValue) {
        this.keyValue = keyValue;
    }

    @Override
    public PsoftConditionKind getConditionKind() {
        return PsoftConditionKind.KEQ;
    }

    @Override
    public K getKeyValue() {
        return this.keyValue;
    }
}

