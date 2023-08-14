package com.teknevia.teknevia_task.payload.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BoatRequest
{
    @NotNull(message = "Please enter boat name!")
    @Size(min = 1,max = 20 ,message = "Boat name has to be created between 1 and 20 characters!")
    private String boatName;

    @NotNull(message = "Please enter boat serial number!")
//    @Pattern(regexp = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$",
//            message = "Please enter valid serial number")
    private int boatSerialNumber;

    @NotNull(message = "Please enter availability status of boat.")
    private Boolean isAvailable;


}
