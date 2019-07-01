package com.cladup.hyperion.campaign;

import com.cladup.hyperion.campaign.input.CreateCampaignInput;
import com.cladup.hyperion.campaign.input.UpdateCampaignInput;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
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
    public @NotNull CampaignDTO create(@RequestBody @Validated CreateCampaignInput createCampaignInput) {
        return campaignService.create(createCampaignInput);
    }

    /**
     * Update campaign
     *
     * @param id Primary key
     * @param updateCampaignInput Input data for campaign update
     * @return Updated campaign
     */
    @PutMapping("/{id}")
    public @NotNull CampaignDTO update(@PathVariable long id,
                                       @RequestBody @Validated UpdateCampaignInput updateCampaignInput) {
        return campaignService.update(id, updateCampaignInput);
    }

    /**
     * Delete campaign
     *
     * @param id Primary key
     * @return Deleted campaign
     */
    @DeleteMapping("/{id}")
    public @NotNull CampaignDTO delete(@PathVariable long id) {
        return campaignService.delete(id);
    }

}
