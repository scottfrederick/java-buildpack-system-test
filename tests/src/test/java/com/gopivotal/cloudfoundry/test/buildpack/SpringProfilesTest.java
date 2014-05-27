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

package com.gopivotal.cloudfoundry.test.buildpack;

import com.gopivotal.cloudfoundry.test.support.application.Application;
import com.gopivotal.cloudfoundry.test.support.runner.ExcludedApplications;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@ExcludedApplications({"groovy", "java-main", "play", "ratpack", "spring-boot-cli", "spring-boot-cli-jar"})
public final class SpringProfilesTest extends AbstractTest {

    @Test
    public void springProfiles(Application application) {
        assertTrue(application.getTestOperations().springProfiles().contains("cloud"));
    }

    @Test
    public void cloudProperties(Application application) {
        Map<String, String> cloudProperties = application.getTestOperations().cloudProperties();
        for (Map.Entry<String, String> entry : cloudProperties.entrySet()) {
            assertNotNull("Value for key " + entry.getKey() + " is null", entry.getValue());
        }
    }
}
