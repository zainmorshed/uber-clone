package com.zain.uber.client;

// import org.hibernate.mapping.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import com.zain.uber.dto.RideLengthSummary;
import com.zain.uber.dto.RouteSummary;

@Component
public class OpenRouteServiceClient {

    private final RestTemplate restTemplate = new RestTemplate();

    //call ORS endpoint 
    private Map<String, Object> fetchRoute(double startLat,
                                    double startLng,
                                    double endLat,
                                    double endLng
    ) {
        return restTemplate.getForObject(buildUrl(startLat, startLng, endLat, endLng), Map.class);
    }

    private String buildUrl(double startLat,
                            double startLng,
                            double endLat,
                            double endLng
    ) {
        String url = "https://api.openrouteservice.org/v2/directions/driving-car?" +
        "api_key=eyJvcmciOiI1YjNjZTM1OTc4NTExMTAwMDFjZjYyNDgiLCJpZCI6IjljMDk2ZTUwYTQyNDQ3NjE5N2Y2OWVlY2RmZTI5OGIxIiwiaCI6Im11cm11cjY0In0=" +
        "&start=" + startLng + "," + startLat +
        "&end=" + endLng + "," + endLat;

        return url;
    }

    
    //parse response
    private Map<String, Object> extractProperties(Map<String, Object> response) {
        List<?> features = (List<?>) response.get("features");

        Map<String, Object> feature = (Map<String, Object>) features.get(0);
        
        Map<String, Object> properties = (Map<String, Object>) feature.get("properties");
        return properties;
    }

//
    private RideLengthSummary extractSummary(Map<String, Object> response) {
        Map<String, Object> properties = extractProperties(response);
        Map<String, Object> summary = (Map<String, Object>) properties.get("summary");

        double totalDistance = ((Number) summary.get("distance")).doubleValue();
        double totalDuration = ((Number) summary.get("duration")).doubleValue();

        return new RideLengthSummary(totalDistance, totalDuration);

    }


    public List<String> extractInstructions(Map<String, Object> response) {
        Map<String, Object> properties = extractProperties(response);

        List<?> segments = (List<?>) properties.get("segments");

        List<String> instructions = new ArrayList<>();

        for (Object segmentObj : segments) {
            Map<String, Object> segment = (Map<String, Object>) segmentObj;
            List<?> steps = (List<?>) segment.get("steps");

            for(Object stepObj : steps) {
                Map<String, Object> step = (Map<String, Object>) stepObj;
                String instruction = (String) step.get("instruction");

                if(instruction != null){
                    instructions.add(instruction);
                }
            }
        }
        return instructions;

    }

    public RideLengthSummary rideLengthSummary(double startLat,
                                            double startLng,
                                            double endLat,
                                            double endLng){
        Map<String, Object> response = fetchRoute(startLat, startLng, endLat, endLng);
        return extractSummary(response);
    }

    public List<String> tripDirections(double startLat,
                                            double startLng,
                                            double endLat,
                                            double endLng){
        Map<String, Object> response = fetchRoute(startLat, startLng, endLat, endLng);
        List<String> instructions = extractInstructions(response);

        return instructions;
    }                                           


}
