package com.azumo.MyStore.billing.payment.rest;

import com.azumo.MyStore.billing.payment.FindPayments;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private static final int MAX_RESULTS = 10;

    private final @NonNull FindPayments findPayments;

    @GetMapping
    public List<Map<String, ?>> all(){
        return findPayments.all().range(MAX_RESULTS).Stram()
            .map(payment -> Map.of(
                "id", payment.id().value(),
                "referenceId", payment.referenceId().value(),
                "total", payment.total().value(),
                "collected", payment.isCollected()))
            .collect(Collectors.toList());
    }
}
