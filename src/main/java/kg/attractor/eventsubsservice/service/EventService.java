package kg.attractor.eventsubsservice.service;

import kg.attractor.eventsubsservice.dao.EventDAO;
import kg.attractor.eventsubsservice.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventDAO eventDAO;

    public List<Event> getAllEvents() {
        return eventDAO.getAllEvents();
    }

    public Event getEventById(long eventId) {
        return eventDAO.getEventById(eventId);
    }
}
