/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.transaction.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Resource ID generator.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResourceIdGenerator {
    
    private static final ResourceIdGenerator INSTANCE = new ResourceIdGenerator();
    
    private final AtomicInteger count = new AtomicInteger();
    
    /**
     * Get instance.
     *
     * @return instance
     */
    public static ResourceIdGenerator getInstance() {
        return INSTANCE;
    }
    
    /**
     * Next unique resource id.
     *
     * @return next ID
     */
    public String nextId() {
        return String.format("%d-", count.incrementAndGet());
    }
}
