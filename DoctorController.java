package com.javaquest1.doctorwho;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    public class DoctorDetails {
        private int number;
        private String name;

        public DoctorDetails(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    @GetMapping("/")
    public String home() {
        return "<ul>" +
                "<li><a href='/doctor/1'>Doctor 1</a></li>" +
                "<li><a href='/doctor/2'>Doctor 2</a></li>" +
                "<li><a href='/doctor/3'>Doctor 3</a></li>" +
                "<li><a href='/doctor/4'>Doctor 4</a></li>" +
                "<li><a href='/doctor/5'>Doctor 5</a></li>" +
                "<li><a href='/doctor/6'>Doctor 6</a></li>" +
                "<li><a href='/doctor/7'>Doctor 7</a></li>" +
                "<li><a href='/doctor/8'>Doctor 8</a></li>" +
                "<li><a href='/doctor/9'>Doctor 9</a></li>" +
                "<li><a href='/doctor/10'>Doctor 10</a></li>" +
                "<li><a href='/doctor/11'>Doctor 11</a></li>" +
                "<li><a href='/doctor/12'>Doctor 12</a></li>" +
                "<li><a href='/doctor/13'>Doctor 13</a></li>" +
                "<li><a href='/other'>Other Route</a></li>" +
                "</ul>";
    }

    @GetMapping("/{number}")
    public ResponseEntity<Object> getDoctorDetails(@PathVariable int number) {
        String doctorName = getDoctorName(number);

        if (doctorName.equals("Unknown Doctor")) {
            String message = "Impossible to retrieve the incarnation " + number;
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else if (number >= 9 && number <= 13) {
            DoctorDetails doctorDetails = new DoctorDetails(number, doctorName);
            return new ResponseEntity<>(doctorDetails, HttpStatus.OK);
        } else if (number >= 1 && number <= 8) {
            // For doctors 1 to 8, return a 303 status
            return new ResponseEntity<>("Error 303",HttpStatus.SEE_OTHER);
        } else {
            // For any other route, return a 404 status
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private String getDoctorName(int number) {
        switch (number) {
            case 1:
                return "William Hartnell";
            case 2:
                return "Patrick Troughton";
            case 3:
                return "Jon Pertwee";
            case 4:
                return "Tom Baker";
            case 5:
                return "Peter Davison";
            case 6:
                return "Colin Baker";
            case 7:
                return "Sylvester McCoy";
            case 8:
                return "Paul McGann";
            case 9:
                return "Christopher Eccleston";
            case 10:
                return "David Tennant";
            case 11:
                return "Matt Smith";
            case 12:
                return "Peter Capaldi";
            case 13:
                return "Jodie Whittaker";
            default:
                return "Unknown Doctor";
        }
    }
}
