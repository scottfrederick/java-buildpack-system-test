/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gopivotal.cloudfoundry.test.support.service;

import java.net.URI;
import java.util.Map;

import org.cloudfoundry.client.lib.CloudFoundryOperations;

import com.gopivotal.cloudfoundry.test.support.util.RandomizedNameFactory;

/**
 * Represents an instance of the Redis service
 */
public final class RedisService extends AbstractService {

    RedisService(CloudFoundryOperations cloudFoundryOperations, RandomizedNameFactory randomizedNameFactory) {
        super(cloudFoundryOperations, "rediscloud", "25mb", randomizedNameFactory);
    }

    @Override
    public final URI getEndpoint(Map<String, String> environmentVariables) {
        Map<String, ?> credentials = getCredentials(environmentVariables);
        String host = credentials.get("hostname").toString();
        int port = Integer.parseInt(credentials.get("port").toString());
        return URI.create(String.format("redis://%s:%d", host, port));
    }
}
