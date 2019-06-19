package com.alphilippov.studyingmap.utils;

public interface AppConfig {

    String BASE_URL_UDEMY_API = "https://www.udemy.com/api-2.0/";
    String BASE_URL_UDEMY="https://www.udemy.com";
    String BASE_URL_TWO="http://192.168.1.33:5000/";
 interface SharedPrefernce {

 }
    interface Group {
   int REALIST = 1;
    int INTELLECTUAL = 2;
    int SOCIAL = 3;
     int OFFICE = 4;
    int ENTREPRENEURIAL = 5;
    int ARTISTIC = 6;
        int QUANTITY_QUESTIONS = 30;
}
interface Authorization{
     String CLIENT_ID="lL0XU8iNzCRb3pVLcsFllZUQsmENxw0605cs7E7U";
     String CLIENT_SECRET="5j7Z5ETzYUblaHnrPQo9E1A9doFN9ldvDtA83iU8RrTJMgnJTnZloVyzFyhOuLkZFy5C5qJnbCzYQGEsD6niDrA4uYs2i28TUKmviXjJzTGbudBwhQjJXEFckWFBXY9D";
}
interface PropertiesRequest{
     int PAGE_SIZE = 50;
     String PRICE = "price-paid";
     Boolean AFFILIATE = true ;
     String LEVEL_COURSES = "beginner";
     String ORDERING = "highest-rated";
     String LANGUAGE ="en";
     int RATINGS =4 ;

}

}
