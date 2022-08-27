package ru.valeriamarshenina.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.valeriamarshenina.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.number().digits(10),
            currentAddress = faker.address().fullAddress();

    @Test
    void fillPracticeForm() {

        registrationPage.openPage();

        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail);
        registrationPage.chooseGender();
        registrationPage.typeNumber(userNumber);
        registrationPage.calendar.setDate("7", "1988", "28");
        registrationPage.chooseSubject("Maths").chooseSubject("Hindi");
        registrationPage.chooseHobby();
        registrationPage.uploadPicture("img/1.png");
        registrationPage.typeCurrentAddress(currentAddress);
        registrationPage.chooseState().chooseCity();
        registrationPage.clickSubmitButton();

        registrationPage.checkResultFormTitle();
        registrationPage.checkResultsValue("Student Name", firstName + " " + lastName);
        registrationPage.checkResultsValue("Student Email", userEmail);
        registrationPage.checkResultsValue("Gender", "Female");
        registrationPage.checkResultsValue("Mobile", userNumber);
        registrationPage.checkResultsValue("Date of Birth", "28 August,1988");
        registrationPage.checkResultsValue("Subjects", "Maths");
        registrationPage.checkResultsValue("Hobbies", "Reading");
        registrationPage.checkResultsValue("Picture", "1.png");
        registrationPage.checkResultsValue("Address", currentAddress);
        registrationPage.checkResultsValue("State and City", "NCR Delhi");
    }
}
