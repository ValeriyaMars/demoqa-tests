package ru.valeriamarshenina.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillPracticeForm(){
        String studentFirstName = "Valeriya";
        String StudentLastName = "Mars";
        String studentEmail = "test@test.ru";
        String studentNumber = "9270280231";
        String studentCurrentAddress = "Syzran";



        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(studentFirstName);
        $("#lastName").setValue(StudentLastName);
        $("#userEmail").setValue(studentEmail);
        $(byText("Female")).click();
        $("#userNumber").setValue(studentNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__year-select").selectOptionByValue("1988");
        $(byText("28")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("input#uploadPicture").uploadFile(new File("C:/Users/Admin/Desktop/DSC04734.JPG"));
        $("#currentAddress").setValue(studentCurrentAddress);
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();


        $(".modal-body").shouldHave(text("Student Name " + studentFirstName + " " + StudentLastName));
        $(".modal-body").shouldHave(text("Student Email " + studentEmail));
        $(".modal-body").shouldHave(text("Gender Female"));
        $(".modal-body").shouldHave(text("Mobile " + studentNumber));
        $(".modal-body").shouldHave(text("Date of Birth 28 August,1988"));
        $(".modal-body").shouldHave(text("Subjects Maths"));
        $(".modal-body").shouldHave(text("Hobbies Reading"));
        $(".modal-body").shouldHave(text("Picture DSC04734.JPG"));
        $(".modal-body").shouldHave(text("Address " + studentCurrentAddress));
        $(".modal-body").shouldHave(text("State and City NCR Delhi"));
    }
}
