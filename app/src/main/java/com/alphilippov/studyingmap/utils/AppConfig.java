package com.alphilippov.studyingmap.utils;

public interface AppConfig {

    String BASE_URL = "https://www.udemy.com/api-2.0/";
 interface SharedPrefernce {
     String APP_PREFERENCES = "myData";
     String APP_PREFERENCES_LOGIN = " ";
     String APP_PREFERENCES_PASSWORD = " ";
 }
    interface Group {
   int REALIST = 1;
    int INTELLECTUAL = 2;
    int SOCIAL = 3;
     int OFFICE = 4;
    int ENTREPRENEURIAL = 5;
    int ARTISTIC = 6;
}
    int QUANTITY_QUESTIONS = 30;
}
