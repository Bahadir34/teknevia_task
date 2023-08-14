package com.teknevia.teknevia_task.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Boat
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boatId;

//    @Pattern(regexp = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$",
//            message = "Please enter valid serial number")

    private int boatSerialNumber;


    private String boatName;


    private Boolean isAvailable;
}
