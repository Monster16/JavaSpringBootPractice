package JavaRevisionDated20_11_23.Day_1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeExample {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Before Formatting: " +localDateTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm:ss");
        String formattedDate = dateTimeFormatter.format(localDateTime);
        System.out.println("After Formatting: " +formattedDate);
    }
}
