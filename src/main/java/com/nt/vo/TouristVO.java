package com.nt.vo;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class TouristVO {
	
	
    private Integer tid;
    
    @NonNull
    private String tname;
    
    @NonNull
    private String taddrs;
    
    @NonNull
    private LocalDate dob;
    
    @NonNull
    private String startLocation;
    
    @NonNull
    private String endLocation;
    
    @NonNull
    private Double expenditure;
   
}
