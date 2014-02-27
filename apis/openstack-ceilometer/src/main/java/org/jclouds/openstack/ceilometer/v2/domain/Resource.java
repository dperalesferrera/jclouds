package org.jclouds.openstack.ceilometer.v2.domain;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.jclouds.javax.annotation.Nullable;

import javax.inject.Named;
import java.beans.ConstructorProperties;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

public class Resource {

    public static Builder<?> builder() {
        return new ConcreteBuilder();
    }

    public Builder<?> toBuilder() {
        return new ConcreteBuilder().fromResource(this);
    }

    public abstract static class Builder<T extends Builder<T>> {
        protected Builder() {
        }

        protected abstract T self();

        private Date firstSampleTimestamp;
        private Date lastSampleTimestamp;
        private Set<Link> links = ImmutableSet.of();
        protected Map<String, String> metadata = ImmutableMap.of();
        private String projectId;
        private String resourceId;
        private String source;
        private String userId;

        public T firstSampleTimestamp(final Date firstSampleTimestamp) {
            this.firstSampleTimestamp = firstSampleTimestamp;
            return self();
        }

        public T lastSampleTimestamp(final Date lastSampleTimestamp) {
            this.lastSampleTimestamp = lastSampleTimestamp;
            return self();
        }

        public T links(final Link... links) {
            return links(ImmutableSet.copyOf(checkNotNull(links, "links")));
        }

        public T links(final Set<Link> links) {
            this.links = links;
            return self();
        }

        public T metadata(final Map<String, String> metadata) {
            this.metadata = ImmutableMap.copyOf(checkNotNull(metadata, "metadata"));
            return self();
        }

        public T projectId(final String projectId) {
            this.projectId = projectId;
            return self();
        }

        public T resourceId(final String resourceId) {
            this.resourceId = resourceId;
            return self();
        }

        public T userId(final String userId) {
            this.userId = userId;
            return self();
        }

        public T source(final String source) {
            this.source = source;
            return self();
        }

        public Resource build() {
            return new Resource(firstSampleTimestamp, lastSampleTimestamp, links, metadata, projectId, resourceId, userId, source);
        }


        public T fromResource(final Resource in) {
            return this
                    .firstSampleTimestamp(in.getFirstSampleTimestamp())
                    .lastSampleTimestamp(in.getLastSampleTimestamp())
                    .links(in.getLinks())
                    .metadata(in.getMetadata())
                    .projectId(in.getProjectId())
                    .resourceId(in.getResourceId())
                    .userId(in.getUserId())
                    .source(in.getSource());
        }
    }

    private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
        @Override
        protected ConcreteBuilder self() {
            return this;
        }
    }

    @Named("first_sample_timestamp")
    private final Date firstSampleTimestamp;
    @Named("last_sample_timestamp")
    private final Date lastSampleTimestamp;
    @Named("links")
    private Set<Link> links = ImmutableSet.of();
    @Named("metadata")
    private final Map<String, String> metadata;
    @Named("project_id")
    private final String projectId;
    @Named("resource_id")
    private final String resourceId;
    @Named("user_id")
    private final String userId;
    @Named("source")
    private final String source;


    @ConstructorProperties({
            "first_sample_timestamp", "last_sample_timestamp", "links", "metadata", "project_id", "resource_id", "userid", "source"
    })
    protected Resource(
            @Nullable Date firstSampleTimestamp,
            @Nullable Date lastSampleTimestamp,
            @Nullable Set<Link> links,
            @Nullable Map<String, String> metadata,
            @Nullable final String projectId,
            @Nullable final String resourceId,
            @Nullable final String userId,
            @Nullable final String source) {

        this.firstSampleTimestamp = firstSampleTimestamp;
        this.lastSampleTimestamp = lastSampleTimestamp;
        this.links = links == null ? ImmutableSet.<Link>of() : ImmutableSet.copyOf(links);
        this.metadata = metadata == null ? ImmutableMap.<String, String>of() : ImmutableMap.copyOf(metadata);
        this.projectId = projectId;
        this.resourceId = resourceId;
        this.userId = userId;
        this.source = source;
    }

    @Nullable
    public Date getFirstSampleTimestamp() {
        return this.firstSampleTimestamp;
    }

    @Nullable
    public Date getLastSampleTimestamp() {
        return this.lastSampleTimestamp;
    }

    @Nullable
    public Set<Link> getLinks() {
        return Collections.unmodifiableSet(this.links);
    }

    @Nullable
    public Map<String, String> getMetadata() {
        return this.metadata;
    }


    @Nullable
    public String getProjectId() {
        return projectId;
    }

    @Nullable
    public String getResourceId() {
        return resourceId;
    }

    @Nullable
    public String getUserId() {
        return userId;
    }

    @Nullable
    public String getSource() {
        return source;
    }

    @Override
    public int hashCode() {
        int result = firstSampleTimestamp != null ? firstSampleTimestamp.hashCode() : 0;
        result = 31 * result + (lastSampleTimestamp != null ? lastSampleTimestamp.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (resourceId != null ? resourceId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource)) return false;

        Resource resource = (Resource) o;

        if (!firstSampleTimestamp.equals(resource.firstSampleTimestamp)) return false;
        if (!lastSampleTimestamp.equals(resource.lastSampleTimestamp)) return false;
        if (!links.equals(resource.links)) return false;
        if (!metadata.equals(resource.metadata)) return false;
        if (!projectId.equals(resource.projectId)) return false;
        if (!resourceId.equals(resource.resourceId)) return false;
        if (!source.equals(resource.source)) return false;
        if (!userId.equals(resource.userId)) return false;

        return true;
    }

    protected Objects.ToStringHelper string() {
        return Objects.toStringHelper(this)
                .add("first_sample_timestamp", firstSampleTimestamp)
                .add("last_sample_timestamp", lastSampleTimestamp)
                .add("links", links)
                .add("metadata", metadata)
                .add("project_id", projectId)
                .add("resource_id", resourceId)
                .add("user_id", userId)
                .add("source", source);
    }

    @Override
    public String toString() {
        return "Resource{" +
                "firstSampleTimestamp=" + firstSampleTimestamp +
                ", lastSampleTimestamp=" + lastSampleTimestamp +
                ", links=" + links +
                ", metadata=" + metadata +
                ", projectId='" + projectId + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", userId='" + userId + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
