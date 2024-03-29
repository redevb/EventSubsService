package kg.attractor.eventsubsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private long id;
    private String name;
    private String description;
    private LocalDateTime dateTime;
}
