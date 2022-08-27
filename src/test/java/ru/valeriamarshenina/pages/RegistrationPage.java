package ru.valeriamarshenina.pages;

import com.codeborne.selenide.SelenideElement;
import ru.valeriamarshenina.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private final String RESULT_FORM_TITLE = "Thanks for submitting the form";
    private SelenideElement formTitle = $(".practice-form-wrapper"),
            resultFormTitle = $(".modal-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            userGender = $(byText("Female")),
            subjectInput = $("#subjectsInput"),
            userHobby = $(byText("Reading")),
            selectPictureInput = $("input#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#stateCity-wrapper").$(byText("NCR")),
            cityInput = $("#stateCity-wrapper").$(byText("Delhi")),
            submitButton = $("#submit");

    public CalendarComponent calendar = new CalendarComponent();

    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage typeNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public void chooseGender() {
        userGender.click();
    }

    public RegistrationPage chooseSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public void chooseHobby() {
        userHobby.click();
    }

    public void uploadPicture(String value) {
        selectPictureInput.uploadFromClasspath(value);
    }

    public void typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
    }

    public RegistrationPage chooseState() {
        $("#state").click();
        stateInput.click();

        return this;
    }

    public RegistrationPage chooseCity() {
        $("#city").click();
        cityInput.click();

        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void checkResultFormTitle() {
        resultFormTitle.shouldHave(text(RESULT_FORM_TITLE));
    }

    public void checkResultsValue(String key, String value) {
        ($x("//td[text()='" + key + "']")).parent()
                .shouldHave(text(value));
    }
}
