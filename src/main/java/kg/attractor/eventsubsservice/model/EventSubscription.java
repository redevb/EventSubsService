package kg.attractor.eventsubsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventSubscription {
    private long id;
    private long eventId;
    private String email;
    private LocalDateTime dateTimeRegistration;
}
