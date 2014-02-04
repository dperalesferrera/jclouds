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
package org.jclouds.openstack.ceilometer.v2;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Module;
import org.jclouds.openstack.ceilometer.v2.config.CeilometerHttpApiModule;
import org.jclouds.openstack.ceilometer.v2.config.CeilometerParserModule;
import org.jclouds.openstack.keystone.v2_0.config.AuthenticationApiModule;
import org.jclouds.openstack.keystone.v2_0.config.CredentialTypes;
import org.jclouds.openstack.keystone.v2_0.config.KeystoneAuthenticationModule;
import org.jclouds.openstack.keystone.v2_0.config.KeystoneAuthenticationModule.ZoneModule;
import org.jclouds.openstack.v2_0.ServiceType;
import org.jclouds.rest.internal.BaseHttpApiMetadata;

import java.net.URI;
import java.util.Properties;

import static org.jclouds.openstack.keystone.v2_0.config.KeystoneProperties.CREDENTIAL_TYPE;
import static org.jclouds.openstack.keystone.v2_0.config.KeystoneProperties.SERVICE_TYPE;

/**
 * Implementation of {@link org.jclouds.apis.ApiMetadata} for Ceilometer v2 API
 * 
 * @author David Perales
 */
public class CeilometerApiMetadata extends BaseHttpApiMetadata<CeilometerApi> {
   
   @Override
   public Builder toBuilder() {
      return new Builder().fromApiMetadata(this);
   }

   public CeilometerApiMetadata() {
      this(new Builder());
   }

   protected CeilometerApiMetadata(Builder builder) {
      super(builder);
   }

   public static Properties defaultProperties() {
      Properties properties = BaseHttpApiMetadata.defaultProperties();
      properties.setProperty(SERVICE_TYPE, ServiceType.METERING);
      properties.setProperty(CREDENTIAL_TYPE, CredentialTypes.PASSWORD_CREDENTIALS);
      return properties;
   }

   public static class Builder extends BaseHttpApiMetadata.Builder<CeilometerApi, Builder> {

      protected Builder() {
          id("openstack-ceilometer")
         .name("OpenStack Ceilometer Havana API")
         .identityName("${tenantName}:${userName} or ${userName}, if your keystone supports a default tenant")
         .credentialName("${password}")
         .endpointName("Keystone base URL ending in /v2.0/")
         .documentation(URI.create("http://api.openstack.org/"))
         .version("2")
         .defaultEndpoint("http://localhost:5000/v2.0/")
         .defaultProperties(CeilometerApiMetadata.defaultProperties())
         .defaultModules(ImmutableSet.<Class<? extends Module>>builder()
                 .add(AuthenticationApiModule.class)
                 .add(KeystoneAuthenticationModule.class)
                 .add(ZoneModule.class)
                 .add(CeilometerParserModule.class)
                 .add(CeilometerHttpApiModule.class)
                 .build());
      }
      
      @Override
      public CeilometerApiMetadata build() {
         return new CeilometerApiMetadata(this);
      }

      @Override
      protected Builder self() {
         return this;
      }
   }
}
