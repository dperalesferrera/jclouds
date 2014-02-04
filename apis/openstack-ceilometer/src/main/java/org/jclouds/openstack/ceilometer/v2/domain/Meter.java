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
package org.jclouds.openstack.ceilometer.v2.domain;

import com.google.common.base.CaseFormat;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

import javax.inject.Named;
import java.beans.ConstructorProperties;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * An Openstack Ceilometer Meter.
 */
public class Meter {

    public static enum MeasureType {
        GAUGE, DELTA, CUMULATIVE, UNRECOGNIZED;

        public String value() {
            return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, name());
        }

        @Override
        public String toString() {
            return value();
        }

        public static MeasureType fromValue(String type) {
            try {
                return valueOf(CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_UNDERSCORE, checkNotNull(type, "type")));
            } catch (IllegalArgumentException e) {
                return UNRECOGNIZED;
            }
        }
    }

    public static Builder<?> builder() {
        return new ConcreteBuilder();
    }

    public Builder<?> toBuilder() {
        return new ConcreteBuilder().fromSnapshot(this);
    }

    public abstract static class Builder<T extends Builder<T>> {
        protected abstract T self();

        protected String meterId;
        protected String name;
        protected String project;
        protected String resource;
        protected String type;
        protected String unit;
        protected String user;
        protected String source;

        public T meterId(final String meterId) {
            this.meterId = meterId;
            return self();
        }

        public T name(final String name) {
            this.name = name;
            return self();
        }

        public T project(final String project) {
            this.project = project;
            return self();
        }

        public T resource(final String resource) {
            this.resource = resource;
            return self();
        }

        public T type(final String type) {
            this.type = type;
            return self();
        }

        public T unit(final String unit) {
            this.unit = unit;
            return self();
        }

        public T user(final String user) {
            this.user = user;
            return self();
        }

        public T source(final String source) {
            this.source = source;
            return self();
        }

        public Meter build() {
            return new Meter(user, name, resource, source, meterId, project, type, unit);
        }

        public T fromSnapshot(final Meter in) {
            return this
                    .user(in.getUser())
                    .name(in.getName())
                    .resource(in.getResource())
                    .source(in.getSource())
                    .meterId(in.getMeterId())
                    .project(in.getProject())
                    .type(in.getType())
                    .unit(in.getUnit());
        }
    }

    private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
        @Override
        protected ConcreteBuilder self() {
            return this;
        }
    }

    @Named("user_id")
    private String user;

    @Named("name")
    private final String name;

    @Named("resource_id")
    private String resource;

    @Named("source")
    private String source;

    @Named("meter_id")
    private final String meterId;

    @Named("project_id")
    private String project;

    @Named("type")
    private String type;

    @Named("unit")
    private String unit;


    @ConstructorProperties({
            "user_id", "name", "resource_id", "source", "meter_id", "project_id", "type", "unit",
    })

    protected Meter(final String user, final String name, final String resource,
                    final String source, final String meterId, final String project,
                    final String type, final String unit) {
        this.meterId = meterId;
        this.name = name;
        this.project = project;
        this.resource = resource;
        this.type = type;
        this.unit = unit;
        this.user = user;
        this.source = source;
    }

    public String getMeterId() {
        return meterId;
    }

    public String getName() {
        return name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(final String project) {
        this.project = project;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(final String resource) {
        this.resource = resource;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(final String unit) {
        this.unit = unit;
    }

    public String getUser() {
        return user;
    }

    public void setUser(final String user) {
        this.user = user;
    }

    public String getSource() {
        return source;
    }

    public void setSource(final String source) {
        this.source = source;
    }


    protected ToStringHelper string() {
        return Objects.toStringHelper(this)
                .add("user", user)
                .add("name", name)
                .add("resource", resource)
                .add("source", source)
                .add("meterId", meterId)
                .add("project", project)
                .add("type", type)
                .add("unit", unit);
    }

    @Override
    public String toString() {
        return "Meter{" +
                "user='" + user + '\'' +
                ", name='" + name + '\'' +
                ", resource='" + resource + '\'' +
                ", source='" + source + '\'' +
                ", meterId='" + meterId + '\'' +
                ", project='" + project + '\'' +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
