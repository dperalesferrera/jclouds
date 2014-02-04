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

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

import javax.inject.Named;
import java.beans.ConstructorProperties;
import java.math.BigDecimal;

/**
 * An Openstack Ceilometer Statistic.
 */
public class Statistic {


    public static Builder<?> builder() {
        return new ConcreteBuilder();
    }

    public Builder<?> toBuilder() {
        return new ConcreteBuilder().fromSnapshot(this);
    }

    public abstract static class Builder<T extends Builder<T>> {
        protected abstract T self();

        protected BigDecimal count;
        protected String durationStart;
        protected BigDecimal min;
        protected BigDecimal max;
        protected String durationEnd;
        protected BigDecimal period;
        protected BigDecimal sum;
        protected String periodEnd;
        protected BigDecimal duration;
        protected String periodStart;
        protected BigDecimal avg;
        protected String groupby;
        protected String unit;

        public T count(final BigDecimal count) {
            this.count = count;
            return self();
        }

        public T durationStart(final String durationStart) {
            this.durationStart = durationStart;
            return self();
        }

        public T min(final BigDecimal min) {
            this.min = min;
            return self();
        }

        public T max(final BigDecimal max) {
            this.max = max;
            return self();
        }

        public T durationEnd(final String durationEnd) {
            this.durationEnd = durationEnd;
            return self();
        }

        public T period(final BigDecimal period) {
            this.period = period;
            return self();
        }

        public T sum(final BigDecimal sum) {
            this.sum = sum;
            return self();
        }

        public T periodEnd(final String periodEnd) {
            this.periodEnd = periodEnd;
            return self();
        }

        public T duration(final BigDecimal duration) {
            this.duration = duration;
            return self();
        }

        public T periodStart(final String periodStart) {
            this.periodStart = periodStart;
            return self();
        }

        public T avg(final BigDecimal avg) {
            this.avg = avg;
            return self();
        }

        public T groupby(final String groupby) {
            this.groupby = groupby;
            return self();
        }

        public T unit(final String unit) {
            this.unit = unit;
            return self();
        }


        public Statistic build() {
            return new Statistic(count, durationStart, min, max, durationEnd, period, sum, periodEnd, duration, periodStart, avg, groupby, unit);
        }

        public T fromSnapshot(final Statistic in) {
            return this
                    .count(in.getCount())
                    .durationStart(in.getDurationStart())
                    .min(in.getMin())
                    .max(in.getMax())
                    .durationEnd(in.getDurationEnd())
                    .period(in.getPeriod())
                    .sum(in.getSum())
                    .periodEnd(in.getPeriodEnd())
                    .duration(in.getDuration())
                    .periodStart(in.getPeriodStart())
                    .avg(in.getAvg())
                    .groupby(in.getGroupby())
                    .unit(in.getUnit());
        }
    }

    private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
        @Override
        protected ConcreteBuilder self() {
            return this;
        }
    }

    @Named("count")
    private BigDecimal count;
    @Named("duration_start")
    private String durationStart;
    @Named("min")
    private BigDecimal min;
    @Named("max")
    private BigDecimal max;
    @Named("duration_end")
    private String durationEnd;
    @Named("period")
    private BigDecimal period;
    @Named("sum")
    private BigDecimal sum;
    @Named("period_end")
    private String periodEnd;
    @Named("duration")
    private BigDecimal duration;
    @Named("period_start")
    private String periodStart;
    @Named("avg")
    private BigDecimal avg;
    @Named("groupby")
    private String groupby;
    @Named("unit")
    private String unit;

    @ConstructorProperties({
            "count", "duration_start", "min", "max", "duration_end", "period", "sum", "period_end", "duration", "period_start", "avg", "groupby", "unit"
    })

    protected Statistic(final BigDecimal count, final String durationStart, final BigDecimal min,
                        final BigDecimal max, final String durationEnd, final BigDecimal period,
                        final BigDecimal sum, final String periodEnd, final BigDecimal duration,
                        final String periodStart, final BigDecimal avg, final String groupby,
                        final String unit) {
        this.count = count;
        this.durationStart = durationStart;
        this.min = min;
        this.max = max;
        this.durationEnd = durationEnd;
        this.period = period;
        this.sum = sum;
        this.periodEnd = periodEnd;
        this.duration = duration;
        this.periodStart = periodStart;
        this.avg = avg;
        this.groupby = groupby;
        this.unit = unit;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(final BigDecimal count) {
        this.count = count;
    }

    public String getDurationStart() {
        return durationStart;
    }

    public void setDurationStart(final String durationStart) {
        this.durationStart = durationStart;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(final BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(final BigDecimal max) {
        this.max = max;
    }

    public String getDurationEnd() {
        return durationEnd;
    }

    public void setDurationEnd(final String durationEnd) {
        this.durationEnd = durationEnd;
    }

    public BigDecimal getPeriod() {
        return period;
    }

    public void setPeriod(final BigDecimal period) {
        this.period = period;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(final BigDecimal sum) {
        this.sum = sum;
    }

    public String getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(final String periodEnd) {
        this.periodEnd = periodEnd;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(final BigDecimal duration) {
        this.duration = duration;
    }

    public String getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(final String periodStart) {
        this.periodStart = periodStart;
    }

    public BigDecimal getAvg() {
        return avg;
    }

    public void setAvg(final BigDecimal avg) {
        this.avg = avg;
    }

    public String getGroupby() {
        return groupby;
    }

    public void setGroupby(final String groupby) {
        this.groupby = groupby;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(final String unit) {
        this.unit = unit;
    }

    protected ToStringHelper string() {
        return Objects.toStringHelper(this)
                .add("count", count)
                .add("durationStart", durationStart)
                .add("min", min)
                .add("max", max)
                .add("durationEnd", durationEnd)
                .add("period", period)
                .add("sum", sum)
                .add("periodEnd", periodEnd)
                .add("duration", duration)
                .add("periodStart", periodStart)
                .add("avg", avg)
                .add("groupby", groupby)
                .add("unit", unit);
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "count=" + count +
                ", durationStart=" + durationStart +
                ", min=" + min +
                ", max=" + max +
                ", durationEnd=" + durationEnd +
                ", period=" + period +
                ", sum=" + sum +
                ", periodEnd=" + periodEnd +
                ", duration=" + duration +
                ", periodStart=" + periodStart +
                ", avg=" + avg +
                ", groupby='" + groupby + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
