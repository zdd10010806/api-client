package com.takipi.api.client.request.event;

import java.util.Collection;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.takipi.api.client.request.ServiceRequest;
import com.takipi.api.client.result.EmptyResult;
import com.takipi.api.client.util.validation.ValidationUtil;
import com.takipi.api.core.request.intf.ApiPostRequest;
import com.takipi.common.util.JsonUtil;

public class BatchForceSnapshotsRequest extends ServiceRequest implements ApiPostRequest<EmptyResult> {
	private final Collection<String> eventIds;

	BatchForceSnapshotsRequest(String serviceId, Collection<String> eventIds) {
		super(serviceId);

		this.eventIds = eventIds;
	}

	@Override
	public Class<EmptyResult> resultClass() {
		return EmptyResult.class;
	}

	@Override
	public String postData() {
		Collection<String> itemJsons = Lists.newArrayListWithCapacity(eventIds.size());

		for (String eventId : eventIds) {
			String itemJson = JsonUtil.createSimpleJson(ImmutableMap.of("event_id", JsonUtil.stringify(eventId)));

			itemJsons.add(itemJson);
		}

		return JsonUtil.createSimpleJson(ImmutableMap.of("items", JsonUtil.createSimpleJson(itemJsons, false)));
	}

	@Override
	public String urlPath() {
		return baseUrlPath() + "/events/force-snapshots";
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static class Builder extends ServiceRequest.Builder {
		private final Set<String> eventIds;

		Builder() {
			this.eventIds = Sets.newHashSet();
		}

		@Override
		public Builder setServiceId(String serviceId) {
			super.setServiceId(serviceId);

			return this;
		}

		public Builder addEventId(String eventId) {
			this.eventIds.add(eventId);

			return this;
		}

		public Builder addEventIds(Collection<String> eventIds) {
			this.eventIds.addAll(eventIds);

			return this;
		}

		@Override
		protected void validate() {
			super.validate();

			if (eventIds.isEmpty()) {
				throw new IllegalArgumentException("No events provided");
			}

			for (String eventId : eventIds) {
				if (!ValidationUtil.isLegalEventId(eventId)) {
					throw new IllegalArgumentException("Illegal event id - " + eventId);
				}
			}
		}

		public BatchForceSnapshotsRequest build() {
			validate();

			return new BatchForceSnapshotsRequest(serviceId, eventIds);
		}
	}
}
