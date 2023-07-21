package kg.attractor.eventsubsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionResultDTO {
    private long subscriptionId;
    private boolean success;
    private String message;
}
