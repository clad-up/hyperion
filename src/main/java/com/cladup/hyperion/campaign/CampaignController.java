package com.cladup.hyperion.campaign;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
