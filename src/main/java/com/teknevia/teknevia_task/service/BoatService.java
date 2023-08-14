package com.teknevia.teknevia_task.service;

import com.teknevia.teknevia_task.entity.Boat;
import com.teknevia.teknevia_task.exception.ConflictException;
import com.teknevia.teknevia_task.payload.mapper.BoatMapper;
import com.teknevia.teknevia_task.payload.messages.ErrorMessages;
import com.teknevia.teknevia_task.payload.messages.SuccessMessages;
import com.teknevia.teknevia_task.payload.request.BoatRequest;
import com.teknevia.teknevia_task.payload.response.BoatResponse;
import com.teknevia.teknevia_task.payload.response.ResponseMessage;
import com.teknevia.teknevia_task.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BoatService
{
    @Autowired
    private BoatRepository boatRepository;

    @Autowired
    private BoatMapper boatMapper;

    public ResponseMessage<BoatResponse> saveBoat(BoatRequest boatRequest)
    {
        isBoatExist(boatRequest.getBoatSerialNumber());
        Boat boat = boatRepository.save(boatMapper.mapBoatRequestToBoat(boatRequest));

        return ResponseMessage.<BoatResponse>builder()
                .message(SuccessMessages.BOAT_SAVE)
                .object(boatMapper.mapBoatToBoatResponse(boat))
                .httpStatus(HttpStatus.CREATED)
                .build();

    }

    private void isBoatExist(int boatSerialNumber)
    {
         if(boatRepository.existsByBoatSerialNumber(boatSerialNumber))
         {
             throw new ConflictException(String.format(ErrorMessages.BOAT_ALREADY_EXIST_ERROR_MESSAGE,boatSerialNumber));
         }
    }
}
