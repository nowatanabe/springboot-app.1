package com.fujitsu.primesoft;

import com.fujitsu.primesoft.condition.PsoftCondition;

public class PsoftTable<R, K, D> extends PsoftMemoryTable implements AutoCloseable {
    public static enum PsoftAccessMode {
        READONLY,
        READWRITE
    }

    public static enum PsoftWaitMode {
        NOWAIT,
        NOWAIT_RETURN,
        WAIT
    }

    public R select(PsoftCondition conditionValue, D divKeyvalue, PsoftWaitMode waitMode) throws PsoftException {
        throw new PsoftException();
    }

    public int insert(R data) throws PsoftException {
        throw new PsoftException();
    }

    public int update(R data, K keyValue, D divKeyValue) throws PsoftException {
        throw new PsoftException();
    }

    public int upsert(R data, D divKeyValue) throws PsoftException {
        throw new PsoftException();
    }

    public int delete(K keyValue, D divKeyValue) throws PsoftException {
        throw new PsoftException();
    }

    public PsoftRecordset<R> openRecordset(PsoftCondition conditionValue, D divKeyValue, PsoftWaitMode waitmode) throws PsoftException {
        throw new PsoftException();
    }

    @Override
    public void close() throws PsoftException {

    }

    public final String getTableName() {
        return "";
    }

    public final PsoftRecordset<R> getRecordset() throws PsoftNotFoundException {
        return null;
    }

    public final PsoftTableSource<R, K, D> getTableSource() {
        return null;
    }

    public final long getTransactionID() {
        return -1L;
    }

    public boolean isClosed() {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }
}
