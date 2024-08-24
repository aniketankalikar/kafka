package com.advaya.notificationservice.dtos;

import com.advaya.notificationservice.config.NotificationProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final NotificationProducer notificationProducer;

    @PostMapping("/process")
    public String processPayment(@RequestParam Boolean success, @RequestParam String transactionId, @RequestParam Double amount)
    {
        PaymentNotification notification = new PaymentNotification(
                success ? "Payment successful" : "Payment failed",
                transactionId,
                amount
        );

        notificationProducer.sendNotification(notification);
        return "Payment processed.";
    }


}
