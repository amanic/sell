package com.imooc.test.mqTest;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Created by chenhaitao on 2018/4/13.
 */
@Component
public class TestProduct {

    private static String namesrvAddr = "172.20.100.121:9876";

    private static final DefaultMQProducer producer = new DefaultMQProducer("CHT_SELL_PRODUCE_GROUP");
    /**
     * 初始化
     */
    static{
        try {
            producer.setNamesrvAddr(namesrvAddr);
            producer.start();
        } catch (MQClientException e) {
//            LOGGER.error("MQ：启动生产者失败：{}-{}", e.getResponseCode(), e.getErrorMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    /**
     * 发送消息
     */
    public void sendMessage(String data) {
        try {
            byte[] messageBody = data.getBytes(RemotingHelper.DEFAULT_CHARSET);

            Message mqMsg = new Message("CHT_SELL_TOPIC", "1", messageBody);

            producer.send(mqMsg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
//                    LOGGER.info("MQ: 生产者发送消息 {}", sendResult);
                    System.out.println("成功");
                }
                @Override
                public void onException(Throwable throwable) {
//                    LOGGER.error(throwable.getMessage(), throwable);
                }
            });
        } catch (Exception e) {
//            LOGGER.error(e.getMessage(), e);
        }
    }

    @PreDestroy
    public void stop() {
        if (producer != null) {
            producer.shutdown();
        }
    }
}
