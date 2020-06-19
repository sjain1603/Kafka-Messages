package com.sparshj.kafka;
import com.sparshj.proto.TransactionProtos.Transaction;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;


public class ProtobufKafkaProducer {
    private Producer <String, Transaction> producer = null;
    private Properties kafkaProducerProps = null;

    public ProtobufKafkaProducer() {
        kafkaProducerProps = new Properties();
        kafkaProducerProps.put("bootstrap.servers", "localhost:9092");
        kafkaProducerProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProducerProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<String, Transaction>(kafkaProducerProps);

    }

    public void writeToKafkaTopic(Transaction transaction, String topicName){
        producer.send(new ProducerRecord<>(topicName, transaction));
    }
}
