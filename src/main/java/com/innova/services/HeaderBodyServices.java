package com.innova.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
//Server
@RestController
@Log4j2
public class HeaderBodyServices {

    // REQUEST HEADER
    // Amaç client Header oluşturup
    // http://localhost:8080/service/client/header
    @GetMapping("/service/client/header")
    public ResponseEntity<?> getRequestHeader(@RequestHeader(value ="key_header",defaultValue = "default header")String gelenHeader){
        String headerData = gelenHeader;
        log.info(headerData);
        return  ResponseEntity.ok(headerData);
    }

    // Response HEADER
    // Amaç: Server Header oluşturuo Client'a Göndermesi
    // http://localhost:8080/service/response/header
    @GetMapping("/service/response/header")
    public ResponseEntity<?> getResponseHeader(){
        return ResponseEntity.ok()
                .header("key_response","Serverdan gelen Header Response")
                .body("@RestController: gelen veri");
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // REQUEST COOKIE
    // Amaç: Client cookie oluşturup Servera göndermesi
    // http://localhost:8080/service/client/cookie
    @GetMapping("/service/client/cookie")
    public ResponseEntity<?> getRequestCookie(@CookieValue(value = "key_cookie", defaultValue = "default cookie") String gelenCookie) {
        log.info("@RestController(Server): " + gelenCookie);
        return ResponseEntity.ok(gelenCookie);
    }

    // RESPONSE COOKIE
    // Amaç: Client cookie oluşturup Servera göndermesi
    // http://localhost:8080/service/response/cookie
    @GetMapping("/service/response/cookie")
    public ResponseEntity<?> getResponseCookie() {
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE,"key_cookie")
                .body("@RestController: gelen cookie verisi");
    }

}
