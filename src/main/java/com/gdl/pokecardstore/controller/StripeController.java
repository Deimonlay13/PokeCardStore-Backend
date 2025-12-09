package com.gdl.pokecardstore.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@RestController
@RequestMapping("/pago")
@CrossOrigin("*")
public class StripeController {

    @Value("${stripe.secret.key}")
    private String secretKey;

    @PostMapping("/crear-intent")
    public Map<String, Object> crearIntent(@RequestBody Map<String, Object> data) throws Exception {

        Stripe.apiKey = secretKey;

        Long amount = Long.valueOf(data.get("monto").toString()); // en centavos (Ej: 2990 => 299000)
        String currency = "clp";

        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(amount)
                        .setCurrency(currency)
                        .build();

        PaymentIntent intent = PaymentIntent.create(params);

        Map<String, Object> response = new HashMap<>();
        response.put("clientSecret", intent.getClientSecret());
        return response;
    }
}

