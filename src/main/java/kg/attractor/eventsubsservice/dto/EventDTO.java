package kg.attractor.eventsubsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private long id;
    private String name;
    private String description;
    private String dateTime;
}
