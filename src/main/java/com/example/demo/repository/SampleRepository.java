package com.example.demo.repository;

public class SampleRepository {
/*
    private ResourceGroupControl resourceGroupControl;

    @TamAutowired
    public OGC041010001Repository(ResourceGroupControl resourceGroupControl) {
        this.resourceGroupControl = resourceGroupControl;
    }

    public void deleteScreenHandingManagementIfExisit(String screenId, String keyItems, String screenHandlingId) {
        PSoftTable<TScreenHandlingManagementEntity, TScreenHandlingManagementPkEntity, PsoftNonePartition> table =
            resourceGroupControl.getTable("OGC0401010010", "TP_T_SCREEN_HANDLING_MANAGEMENT.PK.W");
        PSoftKEQ<TScreenHandilingManagementPkEntity> condition = new PsoftKEQ<>(new TScreenHandlingManagementPkEntity(screenId, keyItems));
        PsoftRecordset<TScreenHandlingManagementEntity> recordset = table.openRecordset(condition, PsoftNonePartition, PsoftWaitMode.WAIT);
        if (recordset.isAvailableRecord()) {
            TScreenHadlingManagementEntity record = recordset.getRecord();
            if (record.getScreenHandlingId() == screenHandlingId) {
                recordset.delete(record);
            }
        }
        recordset.close();
    }
*/
}
