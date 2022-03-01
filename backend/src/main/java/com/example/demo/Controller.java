package com.example.demo;

import org.apache.coyote.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {

    private final String URL = "https://app.socialinsider.io/api";
    private final RestTemplate restTemplate = new RestTemplate();
    private final RestTemplate restTemplate2 = new RestTemplate();

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/brand")
    public ResponseEntity<List<BrandData>> test1(@RequestBody RequestProfile requestProfile) {
        ArrayList<BrandData> finalBrands = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer API_KEY_TEST");
        headers.add("Content-Type", "application/json");
        Map<String, String> aux = new HashMap<>();
        aux.put("projectname", "API_test");
        Map<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("jsonrpc", "2.0");
        jsonObject.put("id", 0);
        jsonObject.put("method", "socialinsider_api.get_brands");
        jsonObject.put("params", aux);
        HttpEntity<?> httpEntity = new HttpEntity<Object>(jsonObject, headers);
        ResponseEntity<ResponseBrand> responseEntity = restTemplate.postForEntity(URL, httpEntity, ResponseBrand.class);
        for(int i = 0; i < responseEntity.getBody().getResult().size(); i++) {
            BrandData brandData = new BrandData();
            Result result = responseEntity.getBody().getResult().get(i);
            String brandname = result.getBrandname();
            long totalprofiles = result.getProfiles().size();
            brandData.setBrandName(brandname);
            brandData.setTotalProfiles(totalprofiles);
            brandData.setTotalFans(0L);
            brandData.setTotalEngagement(0L);
            for(int j = 0; j < result.getProfiles().size(); j++) {
                Profile profile = result.getProfiles().get(j);
                String id = profile.getId();
                String profile_type = profile.getProfile_type();
                HttpHeaders headersProfile = new HttpHeaders();
                headersProfile.add("Authorization", "Bearer API_KEY_TEST");
                headersProfile.add("Content-Type", "application/json");
                Map<String, String> auxProfile1 = new HashMap<>();
                auxProfile1.put("start", Date.from(requestProfile.getStart().toInstant()).getTime() + "");
                auxProfile1.put("end", Date.from(requestProfile.getEnd().toInstant()).getTime() + "");
                auxProfile1.put("timezone", requestProfile.getTimezone().getID());
                Map<String, Object> auxProfile = new HashMap<>();
                auxProfile.put("id", id);
                auxProfile.put("profile_type", profile_type);
                auxProfile.put("date", auxProfile1);
                Map<String, Object> jsonObjectProfile = new HashMap<>();
                jsonObjectProfile.put("id", 1);
                jsonObjectProfile.put("method", "socialinsider_api.get_profile_data");
                jsonObjectProfile.put("params", auxProfile);
                HttpEntity<?> httpEntityProfile = new HttpEntity<Object>(jsonObjectProfile, headersProfile);
                ResponseEntity<ResponseProfile> responseEntityProfile = restTemplate2.postForEntity(URL, httpEntityProfile, ResponseProfile.class);
                HashMap<String, HashMap<String, HashMap<String, String>>> info = responseEntityProfile.getBody().getResp();
                ProfileData pd = getProfileData(info);
                brandData.addProfileFans(pd.getFans());
                brandData.addProfileEngagement(pd.getEngagement());
            }
            finalBrands.add(brandData);
        }
    return ResponseEntity.ok(finalBrands);
    }

    public ProfileData getProfileData (HashMap<String, HashMap<String, HashMap<String, String>>> info) {
        long fansProfile = 0, fans = 0, engagementProfile = 0, engagement = 0;
        for (Map.Entry<String, HashMap<String, HashMap<String, String>>> mapElement1 : info.entrySet()) {
            String key1 = mapElement1.getKey();
            HashMap<String, HashMap<String, String>> value = mapElement1.getValue();
            for(Map.Entry<String, HashMap<String, String>> mapElement2 : value.entrySet()){
                String key2 = mapElement2.getKey();
                HashMap<String, String> statistics = mapElement2.getValue();
                String engagementString, fansString;
                ArrayList<String> elements = new ArrayList<>();
                for(Map.Entry<String, String> mapElement3 : statistics.entrySet()){
                    String key3 = mapElement3.getKey();
                    String value3 = mapElement3.getValue();
                    if(key3.equals("fans") && value3 != null){
                        fansString = value3;
                        fans = Integer.parseInt(fansString);
                    }
                    if(key3.equals("engagement") && value3 != null) {
                        engagementString = value3;
                        engagement = Integer.parseInt(engagementString);
                    }
                }
                fansProfile += fans;
                engagementProfile += engagement;
            }
        }
        ProfileData profileData = new ProfileData(fansProfile, engagementProfile);
        return profileData;
    }
}
