package com.zain.uber.service;

// import com.zain.uber.dto.RiderInfo;
import com.zain.uber.entity.Rider;
import com.zain.uber.enums.RideType;
import com.zain.uber.client.OpenRouteServiceClient;
import com.zain.uber.dto.RideLengthSummary;
import com.zain.uber.dto.RiderInfoSummary;
import com.zain.uber.dto.RouteSummary;
import com.zain.uber.repository.RideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RideService {

    @Autowired
    private RideRepo rideRepo;
    @Autowired
    private OpenRouteServiceClient orsClient;

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

    public Rider findRider(Long id) {
        Rider rider = rideRepo.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        return rider;
    }

    public RideLengthSummary routeSummary(Long id) {
        Rider rider = findRider(id);

        double startLat = rider.getStartLat();
        double startLng = rider.getStartLang();
        double endLat = rider.getEndLat();
        double endLang = rider.getEndLang();

        RideLengthSummary routeSummary = orsClient.rideLengthSummary(startLat, startLng, endLat, endLang);
        return routeSummary;
    }

    public List<String> getTripDirections(Long id) {
        Rider rider = findRider(id);
        
        double startLat = rider.getStartLat();
        double startLng = rider.getStartLang();
        double endLat = rider.getEndLat();
        double endLang = rider.getEndLang();

        
        List<String> tripDirections = orsClient.tripDirections(startLat, startLng, endLat, endLang); 
        return tripDirections;
    }

    public double tripFare(Long id){
        Rider rider = riderInfoSummary(id);

        double vehiclePricing = 0.0;
        if (rider.getRideType() == RideType.UBERX) {
            vehiclePricing = 5.0;
        } else if (rider.getRideType() == RideType.UBERXL) {
            vehiclePricing = 7.5;
        } else if (rider.getRideType() == RideType.UBERBLACK) {
            vehiclePricing = 10.0;
        } else if (rider.getRideType() == RideType.WAYMO) {
            vehiclePricing = 12.5;
        }

        RideLengthSummary rideLengthSummary = routeSummary(id);

        double totalDistance = rideLengthSummary.getTotalDistance();
        double totalTime = rideLengthSummary.getTotalDuration();

        double tripFare = (totalDistance/1000 * 5.5)+vehiclePricing;

        return tripFare;
        
    }
}