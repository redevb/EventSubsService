package kg.attractor.eventsubsservice.dao;

import kg.attractor.eventsubsservice.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventDAO {
    private final JdbcTemplate jdbcTemplate;

    public List<Event> getAllEvents() {
        String sql = "SELECT * FROM events";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Event.class));
    }

    public Event getEventById(long eventId) {
        String sql = "SELECT * FROM events WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Event.class), eventId);
    }
}
