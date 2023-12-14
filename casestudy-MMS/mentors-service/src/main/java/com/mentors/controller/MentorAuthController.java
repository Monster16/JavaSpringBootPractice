//package com.mentors.controller;
//
//
//import com.mentors.dto.JwtResponse;
//import com.mentors.dto.MentorLogin;
//import com.mentors.securityconfig.JwtHelper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/mentors")
//public class MentorAuthController {
//
//        @Autowired
//        private UserDetailsService userDetailsService;
//
//        @Autowired
//        private AuthenticationManager manager;
//
//
//        @Autowired
//        private JwtHelper helper;
//
//        private Logger logger = LoggerFactory.getLogger(MentorAuthController.class);
//
//
//        @PostMapping("/login")
//        public ResponseEntity<JwtResponse> login(@RequestBody MentorLogin request) {
//
//            this.doAuthenticate(request.getMentorEmail(), request.getMentorPassword());
//
//
//            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getMentorEmail());
//            String token = this.helper.generateToken(userDetails);
//
//            JwtResponse response = JwtResponse.builder()
//                    .token(token)
//                    .mentorEmail(userDetails.getUsername()).build();
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        }
//
//        private void doAuthenticate(String mentorEmail, String mentorPassword) {
//
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(mentorEmail, mentorPassword);
//            try {
//                manager.authenticate(authentication);
//
//
//            } catch (BadCredentialsException e) {
//                throw new BadCredentialsException(" Invalid Username or Password  !!");
//            }
//
//        }
//
//        @ExceptionHandler(BadCredentialsException.class)
//        public String exceptionHandler() {
//            return "Credentials Invalid !!";
//        }
//
//    }
//
