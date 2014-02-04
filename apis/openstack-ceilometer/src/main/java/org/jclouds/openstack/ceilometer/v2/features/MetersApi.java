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
package org.jclouds.openstack.ceilometer.v2.features;

import com.google.common.collect.FluentIterable;
import org.jclouds.Fallbacks.EmptyFluentIterableOnNotFoundOr404;
import org.jclouds.Fallbacks.NullOnNotFoundOr404;
import org.jclouds.openstack.ceilometer.v2.domain.Meter;
import org.jclouds.openstack.ceilometer.v2.domain.Statistic;
import org.jclouds.openstack.ceilometer.v2.options.QueryOptions;
import org.jclouds.openstack.keystone.v2_0.filters.AuthenticateRequest;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;
import org.jclouds.rest.annotations.SkipEncoding;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * Provides synchronous access to Ceilometer Meters via their REST API.
 *
 * @see <a href="http://api.openstack.org/">API Doc</a>
 */
@SkipEncoding({'/', '='})
@RequestFilters(AuthenticateRequest.class)
public interface MetersApi {

    /**
     * Return all known meters, based on the data recorded so far..
     *
     * @return Gets information for meters
     */
    @Named("meters:list")
    @GET
    @Path("/v2/meters")
    @Consumes(MediaType.APPLICATION_JSON)
    @Fallback(EmptyFluentIterableOnNotFoundOr404.class)
    FluentIterable<Meter> list();


    /**
     * Return samples for the meter..
     *
     * @param id Id of the Meter
     * @return Return samples for the meter.
     */
    @Named("meters:get")
    @GET
    @Path("/v2/meters/{id}")
    @SelectJson("meter")
    @Consumes(MediaType.APPLICATION_JSON)
    @Fallback(NullOnNotFoundOr404.class)
    Meter get(@PathParam("id") String id);

    /**
     * Computes the statistics of the samples in a specified time range
     *
     * @param id Id of the Meter
     * @return Return samples for the meter.
     */
    @Named("meters:statistics")
    @GET
    @Path("/v2/meters/{id}/statistics")
    @Consumes(MediaType.APPLICATION_JSON)
    @Fallback(NullOnNotFoundOr404.class)
    FluentIterable<Statistic> statistics(@PathParam("id") String id, QueryOptions... options);


}
