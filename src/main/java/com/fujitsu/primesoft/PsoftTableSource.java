package com.fujitsu.primesoft;

import java.util.List;

import com.fujitsu.primesoft.PsoftTable.PsoftAccessMode;
import com.fujitsu.primesoft.annotation.entity.PsoftMemoryTableEntity;
import com.fujitsu.primesoft.annotation.entity.PsoftMemoryTableEntityClass;
import com.fujitsu.primesoft.custom.table.PsoftTableConverterClass;

/**
 * Primesoftテーブルのオープン情報を表すクラスです。
 * Primesoftテーブルのオープン情報の指定は大きく次の2つです。
 * <ul>
 * <li>ユーザーコンバーター機能を使用する場合
 * Primesoftテーブル名およびユーザーコンバーターの情報を指定します。
 * <li>テーブルメタ情報指定O-R変換機能を使用する場合
 * <code>PsoftMemoryTableEntity</code>クラスの情報を指定します。
 * </ul>
 * 分割されていないPrimesoftテーブルに対してオープンする場合は分割キー値およびデータドメイン名を 指定するパラメーターのないコンストラクターを使用します。 その場合、型パラメーター<D>には<code>PsoftNonePartition</code>を指定します。
 * Primesoftキューに格納されたメッセージを参照 / 更新する場合は、 本クラスを使用してPrimesoftキューをPrimesoftテーブルとしてオープンします。 このとき、Primesoftキューのメッセージ通番を管理するシステム用のインデックスを使用する場合は、 型パラメーター<K>にPsoftSerialNoIndexを指定し、 インデックス名にPsoftSerialNoIndex.getName()で取得したインデックス名 またはPsoftSerialNoIndex.QUEUE_SYSTEM_INDEX_NAMEを指定してください。
 * @since V1.1 L50
 */
public class PsoftTableSource<R, K, D> {

    public PsoftTableSource(String name, String tableName, String indexName, PsoftAccessMode accessMode, List<D> divKeyList, boolean partialMode, PsoftTableConverterClass converterClass)  {

    }

    public PsoftTableSource(String name, String tableName, String indexName, PsoftAccessMode accessMode, PsoftDataDomain[] dataDomains, boolean partialMode, PsoftTableConverterClass converterClass)  {

    }

    public PsoftTableSource(String name, String tableName, String indexName, PsoftAccessMode accessMode, PsoftTableConverterClass converterClass)  {

    }

    public PsoftTableSource(String name, String tableName, String indexName, PsoftAccessMode accessMode, List<D> divKeyList, boolean partialMode, PsoftMemoryTableEntityClass<PsoftMemoryTableEntity> tableEntityClass) {

    }

}
