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
package org.jclouds.openstack.ceilometer.v2.options;

import java.util.ArrayList;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Options used to control the amount of detail in the request.
 *
 * @see <a href="http://wiki.openstack.org/OpenStackAPI_1-1" />
 */
public class StatisticsQueryOptions extends QueryOptions {

   public StatisticsQueryOptions groupby(final ArrayList<String> groupby) {
        checkNotNull(groupby, "groupby");
        queryParameters.putAll("groupby", groupby);
        return this;
    }

    public StatisticsQueryOptions period(final int period) {
        queryParameters.put("period", Integer.toString(period));
        return this;
    }

    public static class Builder {

        public static StatisticsQueryOptions groupby(final ArrayList<String> groupby) {
            final StatisticsQueryOptions options = new StatisticsQueryOptions();
            return options.groupby(groupby);
        }

        public static StatisticsQueryOptions period(final int period) {
            final StatisticsQueryOptions options = new StatisticsQueryOptions();
            return options.period(period);
        }
    }
}
