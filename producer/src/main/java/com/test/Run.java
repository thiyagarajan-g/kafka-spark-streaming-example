/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.test;

import com.test.beans.RecordBean;
import com.test.config.ConfigurationFactory;
import com.test.config.objects.Config;
import com.test.producer.Producer;
import com.test.utils.JsonUtils;

import org.apache.log4j.Logger;

import java.util.Random;
import java.util.UUID;

public class Run {
    private static final Logger LOGGER = Logger.getLogger(Run.class);

    private static final Random RANDOM = new Random();

    private static final Config CONFIG = ConfigurationFactory.load();

    public static void main(String[] args) {
        final Producer producer = new Producer();

        // catches ctrl+c action
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOGGER.info("Generator application stopping ...");

            producer.close();
        }));

        // sleep time as milliseconds for each step
        int sleep = RANDOM.nextInt(CONFIG.getGenerator().getRandomRange()) + 10;

        RecordBean record;
        while (true) {
            try {
                record = generate();
                producer.produce(record.getType(), JsonUtils.serialize(record));

                Thread.sleep(sleep);
            } catch (Throwable t) {
                LOGGER.error(t.getMessage(), t);
            }
        }
    }

    /**
     * Generates random record
     *
     * @return Returns record object with random values
     */
    private static RecordBean generate() {
        RecordBean data = new RecordBean();
        data.setType(RecordBean.getTypeName(RANDOM.nextInt(6)));
        data.setCommodity(RecordBean.getCommodity(RANDOM.nextInt(6)));
        data.setPartition(RecordBean.getPartition(RANDOM.nextInt(4)));
        data.setTs(System.currentTimeMillis());
        data.setUuid(UUID.randomUUID().toString());
        data.setValue(RANDOM.nextDouble() * 100);
        return data;
    }
}