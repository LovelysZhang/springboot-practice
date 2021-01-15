package com.config.patition;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.InvalidRecordException;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.utils.Utils;

import java.util.List;
import java.util.Map;

/**
 * 实现自定义分区策略
 * 除了散列分区之外，有时候也需要对数据进行不一样的分区。假设你是一个B2B 供应商，你有一个大客户，
 * 它是手持设备Banana 的制造商。Banana 占据了你整体业务10% 的份额。如果使用默认的散列分区算法，
 * Banana 的账号记录将和其他账号记录一起被分配给相同的分区，导致这个分区比其他分区要大一些。服务器
 * 可能因此出现存储空间不足、处理缓慢等问题。我们需要给Banana 分配单独的分区，然后使用散列分区算法
 * 处理其他账号。
 *
 * @author lovely
 * on 2020/1/15
 */
public class BananaPartition implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        List<PartitionInfo> partitionInfos = cluster.partitionsForTopic(topic);
        int numPartitons = partitionInfos.size();
        if (keyBytes == null || !(key instanceof String)) {
            throw new InvalidRecordException("expect all message to have customer name as key");
        }
        if ("Banana".equals(key)) {
            // banana 总是被分配到最后一个分区
            return numPartitons;
        }
        // 其他记录被散列到其他分区
        return Math.abs(Utils.murmur2(keyBytes)) % (numPartitons - 1);
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {
        //不应该在partition 方法里硬编码客户的名字，而应该通过configure 方法传进来。
    }
}
