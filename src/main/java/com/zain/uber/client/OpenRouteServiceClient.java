package com.zain.uber.client;

// import org.hibernate.mapping.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import java.util.List;

import com.zain.uber.dto.RideLengthSummary;

@Component
public class OpenRouteServiceClient {

    private final RestTemplate restTemplate = new RestTemplate();
    
    public RideLengthSummary routeSummary(double startLat,
                                    double startLng,
                                    double endLat,
                                    double endLng
    ) {

    String url = "https://api.openrouteservice.org/v2/directions/driving-car?" +
    "api_key=eyJvcmciOiI1YjNjZTM1OTc4NTExMTAwMDFjZjYyNDgiLCJpZCI6IjljMDk2ZTUwYTQyNDQ3NjE5N2Y2OWVlY2RmZTI5OGIxIiwiaCI6Im11cm11cjY0In0=" +
    "&start=" + startLng + "," + startLat +
    "&end=" + endLng + "," + endLat;

    //call ORS endpoint
    Map<String, Object> response = restTemplate.getForObject(url, Map.class);
    
    //parse response
    List<?> features = (List<?>) response.get("features");

    Map<String, Object> feature = (Map<String, Object>) features.get(0);

    Map<String, Object> properties = (Map<String, Object>) feature.get("properties");

    Map<String, Object> summary = (Map<String, Object>) properties.get("summary");

    double totalDistance = ((Number) summary.get("distance")).doubleValue();
    double totalDuration = ((Number) summary.get("duration")).doubleValue();
        
    return new RideLengthSummary(totalDistance, totalDuration);

    }


}
