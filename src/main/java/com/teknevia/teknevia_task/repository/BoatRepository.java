package com.teknevia.teknevia_task.repository;

import com.teknevia.teknevia_task.entity.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BoatRepository extends JpaRepository<Boat,Long>
{

    boolean existsByBoatSerialNumber(int boatSerialNumber);
}
