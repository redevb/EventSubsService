package kg.attractor.eventsubsservice.service;

import kg.attractor.eventsubsservice.dao.EventDAO;
import kg.attractor.eventsubsservice.dao.EventSubscriptionDAO;
import kg.attractor.eventsubsservice.dto.SubscriptionResultDTO;
import kg.attractor.eventsubsservice.model.Event;
import kg.attractor.eventsubsservice.model.EventSubscription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventSubscriptionService {
    private final EventDAO eventDAO;
    private final EventSubscriptionDAO eventSubscriptionDAO;

    public SubscriptionResultDTO subscribeToEvent(long eventId, String email) {
        Event event = eventDAO.getEventById(eventId);
        if (event == null) {
            return new SubscriptionResultDTO(-1, false, "Событие с указанным ID не найдено.");
        }

        LocalDateTime now = LocalDateTime.now();
        if (event.getDateTime().isBefore(now)) {
            return new SubscriptionResultDTO(-1, false, "Невозможно подписаться на прошедшее событие.");
        }

        EventSubscription existingSubscription = eventSubscriptionDAO.getSubscriptionByEmailAndEventId(email, eventId);
        if (existingSubscription != null) {
            return new SubscriptionResultDTO(existingSubscription.getId(), false, "Вы уже подписаны на это событие.");
        }

        EventSubscription newSubscription = new EventSubscription(0, eventId, email, LocalDateTime.now());
        long subscriptionId = eventSubscriptionDAO.addSubscription(newSubscription);

        return new SubscriptionResultDTO(subscriptionId, true, "Вы успешно подписались на событие.");
    }

    public List<EventSubscription> getSubscriptionsByEmail(String email) {
        return eventSubscriptionDAO.getSubscriptionsByEmail(email);
    }

    public boolean cancelSubscription(long subscriptionId, String email) {
        EventSubscription subscription = eventSubscriptionDAO.getSubscriptionByIdAndEmail(subscriptionId, email);
        if (subscription != null) {
            eventSubscriptionDAO.deleteSubscription(subscriptionId);
            return true;
        } else {
            return false;
        }
    }
}
