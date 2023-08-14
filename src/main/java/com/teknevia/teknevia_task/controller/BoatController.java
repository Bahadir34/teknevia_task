package com.teknevia.teknevia_task.controller;

import com.teknevia.teknevia_task.payload.request.BoatRequest;
import com.teknevia.teknevia_task.payload.response.BoatResponse;
import com.teknevia.teknevia_task.payload.response.ResponseMessage;
import com.teknevia.teknevia_task.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/boat")
public class BoatController
{
    @Autowired
    private BoatService boatService;

    // Not : saveBoat()
    @PostMapping("/save")
    public ResponseMessage<BoatResponse> saveBoat(@RequestBody @Valid BoatRequest boatRequest)
    {
        return boatService.saveBoat(boatRequest);
    }


}
