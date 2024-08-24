package com.advaya.notificationservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class PaymentNotification implements Serializable {

    private String status;
    private String transactionId;
    private Double amount;


}
