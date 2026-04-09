package com.zain.uber.client;

import org.springframework.stereotype.Component;

import com.zain.uber.dto.RouteSummary;

@Component
public class OpenRouteServiceClient {
    
    public RouteSummary routeSummary(double startLat,
                                    double startLng,
                                    double endLat,
                                    double endLng) {

    String url = "https://api.openrouteservice.org/v2/directions/driving-car?" +
    "api_key=eyJvcmciOiI1YjNjZTM1OTc4NTExMTAwMDFjZjYyNDgiLCJpZCI6IjljMDk2ZTUwYTQyNDQ3NjE5N2Y2OWVlY2RmZTI5OGIxIiwiaCI6Im11cm11cjY0In0" +
    "&start=" + startLng + "," + startLat + "," + 
    "&end=" + endLng + "," + endLat;                                
    }

}
