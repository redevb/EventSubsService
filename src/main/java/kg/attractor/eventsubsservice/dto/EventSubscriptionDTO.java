package kg.attractor.eventsubsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventSubscriptionDTO {
    private long id;
    private long eventId;
    private String email;
    private String registrationDateTime;
}
