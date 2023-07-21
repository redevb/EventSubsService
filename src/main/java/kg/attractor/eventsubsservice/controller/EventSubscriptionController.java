package kg.attractor.eventsubsservice.controller;

import kg.attractor.eventsubsservice.dto.SubscriptionResultDTO;
import kg.attractor.eventsubsservice.model.EventSubscription;
import kg.attractor.eventsubsservice.service.EventSubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@AllArgsConstructor
public class EventSubscriptionController {
    private final EventSubscriptionService eventSubscriptionService;

    @PostMapping("/subscribe")
    public ResponseEntity<SubscriptionResultDTO> subscribeToEvent(@RequestParam long eventId, @RequestParam String email) {
        SubscriptionResultDTO resultDTO = eventSubscriptionService.subscribeToEvent(eventId, email);
        return ResponseEntity.ok(resultDTO);
    }

    @GetMapping("/user")
    public ResponseEntity<List<EventSubscription>> getSubscriptionsByEmail(@RequestParam String email) {
        List<EventSubscription> subscriptions = eventSubscriptionService.getSubscriptionsByEmail(email);
        return ResponseEntity.ok(subscriptions);
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<String> cancelSubscription(@RequestParam long subscriptionId, @RequestParam String email) {
        boolean success = eventSubscriptionService.cancelSubscription(subscriptionId, email);
        if (success) {
            return ResponseEntity.ok("Подписка успешно отменена.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
