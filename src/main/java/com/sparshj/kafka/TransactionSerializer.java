package com.sparshj.kafka;

import com.sparshj.proto.TransactionProtos.Transaction;

import org.apache.kafka.common.serialization.Serializer;

public class TransactionSerializer extends Adapter implements Serializer<Transaction>{
    @Override
    public byte[] serialize(String topic, Transaction transaction){
        return transaction.toByteArray();
    }
}
