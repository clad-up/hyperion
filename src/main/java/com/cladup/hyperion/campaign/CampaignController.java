package com.cladup.hyperion.campaign;

import com.cladup.hyperion.campaign.input.CreateCampaignInput;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/campaigns")
public class CampaignController {
    private final CampaignService campaignService;

    /**
     * Get campaign list
     *
     * @return Campaign list
     */
    @GetMapping
    public @NotNull List<CampaignDTO> getAll() {
        return campaignService.getAll();
    }

    /**
     * Get campaign by primary key
     *
     * @param id Primary key
     * @return Found campaign
     */
    @GetMapping("/{id}")
    public @NotNull CampaignDTO getById(@PathVariable long id) {
        return campaignService.getById(id);
    }

    /**
     * Create campaign
     *
     * @param createCampaignInput Input data for campaign creation
     * @return Created campaign
     */
    @PostMapping
    public @NotNull CampaignDTO create(@NotNull CreateCampaignInput createCampaignInput) {
        return campaignService.create(createCampaignInput);
    }

}
