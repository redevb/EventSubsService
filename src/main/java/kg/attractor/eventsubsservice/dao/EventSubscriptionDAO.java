package kg.attractor.eventsubsservice.dao;

import kg.attractor.eventsubsservice.model.EventSubscription;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EventSubscriptionDAO {
    private final JdbcTemplate jdbcTemplate;

    public EventSubscription getSubscriptionByEmailAndEventId(String email, long eventId) {
        String sql = "SELECT * FROM event_subs WHERE email = ? AND event_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(EventSubscription.class), email, eventId);
    }

    public long addSubscription(EventSubscription subscription) {
        String sql = "INSERT INTO event_subs (event_id, email, date_time_registration) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, subscription.getEventId(), subscription.getEmail(), subscription.getDateTimeRegistration());
        return jdbcTemplate.queryForObject("SELECT last_insert_id()", Long.class);
    }

    public void deleteSubscription(long subscriptionId) {
        String sql = "DELETE FROM event_subs WHERE id = ?";
        jdbcTemplate.update(sql, subscriptionId);
    }

    public List<EventSubscription> getSubscriptionsByEmail(String email) {
        String sql = "SELECT * FROM event_subs WHERE email = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EventSubscription.class), email);
    }

    public EventSubscription getSubscriptionByIdAndEmail(long subscriptionId, String email) {
        String sql = "SELECT * FROM event_subs WHERE id = ? AND email = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(EventSubscription.class), subscriptionId, email);
    }
}
