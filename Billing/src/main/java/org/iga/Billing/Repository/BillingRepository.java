package org.iga.Billing.Repository;

import org.iga.Billing.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BillingRepository extends JpaRepository<Bill, Long>  {

}
