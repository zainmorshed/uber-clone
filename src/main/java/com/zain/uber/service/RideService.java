package com.zain.uber.service;

// import com.zain.uber.dto.RiderInfo;
import com.zain.uber.entity.Rider;
import com.zain.uber.dto.RiderInfoSummary;
import com.zain.uber.repository.RideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RideService {

    @Autowired
    private RideRepo rideRepo;

    public void saveRide(Rider rider) {
        rideRepo.save(rider);
    }

    public Rider riderInfoSummary(Long id) {
        Rider rider = rideRepo.findById(id).orElseThrow(() -> new RuntimeException("Rider id not found"));
        return rider;
    }

    public void deleteRider(Long id) {
        rideRepo.deleteById(id);
        
    }
}