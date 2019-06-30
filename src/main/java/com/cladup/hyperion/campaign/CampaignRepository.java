package com.cladup.hyperion.campaign;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends CrudRepository<Campaign, Long> {

}
