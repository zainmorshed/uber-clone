package com.zain.uber.controller;

import com.zain.uber.service.RideService;
import com.zain.uber.dto.RiderInfoSummary;
import com.zain.uber.entity.Rider;
// import com.zain.uber.dto.RiderInfo;
import com.zain.uber.enums.RideType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/https://api.openrouteservice.org/v2/directions/driving-car?api_key=eyJvcmciOiI1YjNjZTM1OTc4NTExMTAwMDFjZjYyNDgiLCJpZCI6IjljMDk2ZTUwYTQyNDQ3NjE5N2Y2OWVlY2RmZTI5OGIxIiwiaCI6Im11cm11cjY0In0=&start={startLat},{startLong}&end={endLat},{endLong}}")
    public double getTotalDistance() {
        
    }

    public double getTotalDuration()


    @GetMapping("/ride-order-summary/{id}")
    public RiderInfoSummary riderInfoSummary(@PathVariable Long id) {
        Rider riderInfo = rideService.riderInfoSummary(id);

        String riderName = riderInfo.getName();
        String destination = riderInfo.getDestination();
        String location = riderInfo.getLocation();
        RideType rideType = riderInfo.getRideType();

        double startLat = riderInfo.getStartLat();
        double startLang = riderInfo.getStartLang();
        double endLat = riderInfo.getEndLat();
        double endLang = riderInfo.getEndLang();



        
        return new RiderInfoSummary(riderName, destination, location, rideType); 
        
    }
    // @GetMapping("/ride-summary/{id}")
    // public Rider riderSummary(@PathVariable Long id) {
    //     return rideService.riderInfoSummary(id);
    // }

    @DeleteMapping("/delete-rider/{id}")
    public String deleteRider(@PathVariable Long id) {
        return "Rider succesfully deleted";
    }


}
