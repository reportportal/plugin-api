package com.epam.reportportal.extension.event;

import com.epam.ta.reportportal.ws.model.launch.cluster.ClusterInfoResource;

import java.util.Collection;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class GetClusterResourcesEvent extends EntityCollectionEvent<ClusterInfoResource> {

	public GetClusterResourcesEvent(Collection<ClusterInfoResource> entities) {
		super(entities);
	}
}
