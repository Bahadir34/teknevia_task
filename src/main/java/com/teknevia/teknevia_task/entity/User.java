package com.teknevia.teknevia_task.entity;

import com.teknevia.teknevia_task.entity.enums.RoleTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    @NotNull(message = "Please enter ssn number!")
    private int ssnNumber;

    @NotNull(message = "Please enter name!")
    private String name;

    @NotNull(message = "Please enter lastname!")
    private String lastname;

    @NotNull(message = "Please enter Boat Rented field!")
    private Boolean isBoatRented;

    @ManyToMany
    @JoinTable(name = "user_role" , joinColumns = @JoinColumn(name = "user_id"),
                                    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleTypes> roles = new HashSet<>();

    private Long boatId; // hiç teklif vermemiş kullanıcının boatId'si null olabilir.

    private Double boatOffer;
}
