package com.fujitsu.primesoft;

public class PsoftResourceGroup implements AutoCloseable {
    public static enum PsoftRollbackMode {
        NOCOUNT,
        NONE
    }

    public <R,K,D> PsoftTable<R,K,D> openTable(PsoftTableSource<R,K,D> tableSource) throws PsoftException {
        throw new PsoftException();
    }

    public <M,D> PsoftQueueSender<M,D> openQueueSender(PsoftQueueSenderSource<M,D> queueSource) throws PsoftException {
        throw new PsoftException();
    }

    @Override
    public void close() {

    }
}