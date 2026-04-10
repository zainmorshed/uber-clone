package com.zain.uber.controller;

import com.zain.uber.service.RideService;
import com.zain.uber.dto.RiderInfoSummary;
import com.zain.uber.dto.RouteSummary;
import com.zain.uber.entity.Rider;
// import com.zain.uber.dto.RiderInfo;
import com.zain.uber.enums.RideType;
import com.zain.uber.dto.RideLengthSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/ride")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("/save-ride")
    public String saveRide(@RequestBody Rider rider) {
        rideService.saveRide(rider);
        return "Ride saved successfully!";
    }


    // public RiderInfoSummary estimateRide() {

    // }

    // @GetMapping("route-summary/{id}")    
    // public RouteSummary routeSummary(@PathVariable Long id) {
        
    // }


    @GetMapping("/ride-order-summary/{id}")
    public RiderInfoSummary riderInfoSummary(@PathVariable Long id) {
        Rider riderInfo = rideService.riderInfoSummary(id);

        String riderName = riderInfo.getName();
        String destination = riderInfo.getDestination();
        String location = riderInfo.getLocation();
        RideType rideType = riderInfo.getRideType();

        RideLengthSummary routeSummary = rideService.routeSummary(id);
        double totalDistance = routeSummary.getTotalDistance();
        double totalDuration = routeSummary.getTotalDuration();

        double tripFare = rideService.tripFare(id);

        return new RiderInfoSummary(riderName, destination, location, rideType, totalDistance, totalDuration, tripFare); 
        
    }
    // @GetMapping("/ride-summary/{id}")
    // public Rider riderSummary(@PathVariable Long id) {
    //     return rideService.riderInfoSummary(id);
    // }

    @GetMapping("/trip-directions/{id}")
    public List<String> getTripDirections(@PathVariable Long id) {
        return rideService.getTripDirections(id);
    }

    @DeleteMapping("/delete-rider/{id}")
    public String deleteRider(@PathVariable Long id) {
        return "Rider succesfully deleted";
    }


}
