package com.ait;

//     {
//                "confidence": 100,
//                "tag": {
//                    "de": "Turbine",
//                    "en": "turbine"
//                }
//            },

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@NoArgsConstructor
@Getter
@ToString
public class TagDto {
    private double confidence;
    private Map<String, String> tag;
}
