package com.teknevia.teknevia_task.payload.mapper;

import com.teknevia.teknevia_task.entity.Boat;
import com.teknevia.teknevia_task.payload.request.BoatRequest;
import com.teknevia.teknevia_task.payload.response.BoatResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class BoatMapper
{
    public Boat mapBoatRequestToBoat(BoatRequest boatRequest)
    {
        return Boat.builder()
                .boatName(boatRequest.getBoatName())
                .boatSerialNumber(boatRequest.getBoatSerialNumber())
                .isAvailable(boatRequest.getIsAvailable())
                .build();
    }

    public BoatResponse mapBoatToBoatResponse(Boat boat)
    {
        return BoatResponse.builder()
                .boatName(boat.getBoatName())
                .boatSerialNumber(boat.getBoatSerialNumber())
                .isAvailable(boat.getIsAvailable())
                .build();
    }
}
