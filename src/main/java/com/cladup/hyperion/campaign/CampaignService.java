package com.cladup.hyperion.campaign;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;
    private final CampaignToCampaignVOConverter campaignToCampaignVOConverter;
    private final CampaignVOToCampaignDTOConverter campaignVOToCampaignDTOConverter;

    /**
     * Get all available campaigns
     *
     * @return List of campaigns
     */
    public @NotNull List<CampaignDTO> getAll() {
        return StreamSupport
                .stream(campaignRepository.findAll().spliterator(), false)
                .map(campaignToCampaignVOConverter::convert)
                .map(campaignVOToCampaignDTOConverter::convert)
                .collect(Collectors.toList());
    }

    /**
     * Get campaign by primary key
     *
     * @param id Primary key
     * @return Found campaign
     */
    public @NotNull CampaignDTO getById(long id) {
        return campaignRepository.findById(id)
                .map(campaignToCampaignVOConverter::convert)
                .map(campaignVOToCampaignDTOConverter::convert)
                .orElseThrow();
    }

}
