import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class StudentProducer {
    public static void main(String[] args) {
        String topic = "student-topic";

        // Kafka producer properties
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // Create a Student object and convert to a simple string
        Student student = new Student(1, "John Doe");
        String studentString = student.toString();

        // Publish the Student object
        producer.send(new ProducerRecord<>(topic, studentString));
        System.out.println("Published: " + studentString);

        producer.close();
    }
}
