package com.fujitsu.primesoft.condition;

public interface PsoftKeyValueCondition<K> extends PsoftCondition {
    K getKeyValue();
}
