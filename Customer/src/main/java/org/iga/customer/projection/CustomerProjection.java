package org.iga.customer.projection;

import org.iga.customer.model.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1",types = Customer.class)
public interface CustomerProjection {
	public long getId();
	public String getName();
}
