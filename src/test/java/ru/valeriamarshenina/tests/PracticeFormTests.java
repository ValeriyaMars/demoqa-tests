package ru.valeriamarshenina.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    String studentFirstName = "Valeriya",
            studentLastName = "Mars";
    String studentEmail = "test@test.ru";
    String studentNumber = "9270280231";
    String studentCurrentAddress = "Syzran";

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillPracticeForm() {

        open("/automation-practice-form");
        $("#firstName").setValue(studentFirstName);
        $("#lastName").setValue(studentLastName);
        $("#userEmail").setValue(studentEmail);
        $(byText("Female")).click();
        $("#userNumber").setValue(studentNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("8");
        $(".react-datepicker__year-select").selectOptionByValue("1988");
        $x("//div[contains(@aria-label, \"September 28th, 1988\")]").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("input#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue(studentCurrentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text("Student Name " + studentFirstName + " " + studentLastName));
        $(".modal-body").shouldHave(text("Student Email " + studentEmail));
        $(".modal-body").shouldHave(text("Gender Female"));
        $(".modal-body").shouldHave(text("Mobile " + studentNumber));
        $(".modal-body").shouldHave(text("Date of Birth 28 September,1988"));
        $(".modal-body").shouldHave(text("Subjects Maths"));
        $(".modal-body").shouldHave(text("Hobbies Reading"));
        $(".modal-body").shouldHave(text("Picture 1.png"));
        $(".modal-body").shouldHave(text("Address " + studentCurrentAddress));
        $(".modal-body").shouldHave(text("State and City NCR Delhi"));

    }
}
