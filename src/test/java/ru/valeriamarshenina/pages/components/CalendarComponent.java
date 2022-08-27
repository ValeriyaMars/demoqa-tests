package ru.valeriamarshenina.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {

    public void setDate(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day--0" + day +
        ":not(.react-datepicker__day--outside-month)").click();
    }
}
