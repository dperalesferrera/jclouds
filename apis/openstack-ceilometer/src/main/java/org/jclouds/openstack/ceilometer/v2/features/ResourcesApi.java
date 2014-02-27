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
import org.jclouds.openstack.ceilometer.v2.domain.Resource;
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
 * Provides synchronous access to Ceilometer Resources via their REST API.
 *
 * @see  <a href="http://api.openstack.org/">API Doc</a>
 */
@SkipEncoding({'/', '='})
@RequestFilters(AuthenticateRequest.class)
public interface ResourcesApi {

    /**
     * Lists definitions for all resources.
     *
     * @param options the options
     * @return Lists definitions for all resources.
     */
    @Named("resources:list")
    @GET
    @Path("/v2/resources")
    @Consumes(MediaType.APPLICATION_JSON)
    @Fallback(EmptyFluentIterableOnNotFoundOr404.class)
    FluentIterable<Resource> list(QueryOptions... options);


    /**
     * Return details for a specified resource
     *
     * @param resourceId Id of the Resoruce
     * @return Return details for a specified resource
     */
    @Named("resources:get")
    @GET
    @Path("/v2/resources/{resource_id}")
    @SelectJson("resource")
    @Consumes(MediaType.APPLICATION_JSON)
    @Fallback(NullOnNotFoundOr404.class)
    Resource get(@PathParam("resource_id") String resourceId);



}
