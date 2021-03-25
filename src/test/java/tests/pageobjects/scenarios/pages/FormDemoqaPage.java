package tests.pageobjects.scenarios.pages;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormDemoqaPage {
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            userNumber = faker.numerify("##########"),
            dayOfBirth = "02",
            monthOfBirth = "April",
            yearOfBirth = "1986",
            subjectInput1 = "English",
            subjectInput2 = "Biology",
            cAddress = faker.address().fullAddress(),
            state = "Rajasthan",
            city = "Jaiselmer";

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public void fillInForm() {
        //---Data input
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        $(byText("Male")).click();
        $("#userNumber").val(userNumber);
        //---Subjects
        $("#subjectsInput").setValue(subjectInput1).pressEnter();
        $("#subjectsInput").setValue(subjectInput2).pressEnter();
        //---Hobby
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        //---Address
        $("#currentAddress").setValue(cAddress);
        $("#state").scrollIntoView(true);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        //---Uploading picture
        $("#uploadPicture").uploadFromClasspath("111.jpg");
    }

    public void birthData() {
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();
    }

    public void submitForm() {
        $("#submit").click();
    }

    public void checkFormData() {
        //---Checking the data in the modal form
        $(".modal-content").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text("Male"),
                text(userNumber),
                text("02 April,1986"),
                text(subjectInput1 + ", " + subjectInput2),
                text("Sports, Reading"),
                text("111.jpg"),
                text(cAddress),
                text(state + " " + city));
        $("#closeLargeModal").click();
        $(".modal-content").shouldNotBe(visible);
    }
}
