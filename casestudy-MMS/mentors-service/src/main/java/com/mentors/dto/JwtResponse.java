package com.mentors.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {

//    private String mentorEmail;
    private String token;
}
