package com.thoughtworks.kanjuice.restService.controllers;

import com.thoughtworks.kanjuice.restService.exceptions.InvalidOrderTypeException;
import com.thoughtworks.kanjuice.restService.models.Order;
import com.thoughtworks.kanjuice.restService.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.validation.Valid;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.POST)
    String createOrder(@RequestBody @Valid Order order) throws IOException, InvalidOrderTypeException, NoSuchAlgorithmException, KeyManagementException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, ShortBufferException, IllegalBlockSizeException {
        return orderService.createOrder(order);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"type", "deviceID", "cardID"})
    public String createGetOrder(@RequestParam(name = "type") String type, @RequestParam(name = "deviceID") String deviceID, @RequestParam(name = "cardID") String cardID) throws KeyManagementException, NoSuchAlgorithmException, InvalidOrderTypeException, IOException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, ShortBufferException, InvalidKeyException {
        return orderService.createOrder(type, deviceID, cardID);
    }
}