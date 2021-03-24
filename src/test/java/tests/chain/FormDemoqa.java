package tests.chain;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.*;

public class FormDemoqa {
    String firstName = getRandomString(8),
            lastName = getRandomString(10),
            email = getRandomEmail(),
            userNumber = getRandomPhone(),
            dayOfBirth = "02",
            monthOfBirth = "April",
            yearOfBirth = "1986",
            subjectInput1 = "English",
            subjectInput2 = "Biology",
            cAddress = "ABC 123 KKK",
            state = "Rajasthan",
            city = "Jaiselmer";

    public FormDemoqa openPage() {
        //---Open the page
        open("https://demoqa.com/automation-practice-form");

        return this;

    }

    public FormDemoqa fillInForm() {
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

        return this;
    }

    public FormDemoqa birthData() {
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();

        return this;

    }

    public FormDemoqa submitForm() {

        $("#submit").click();

        return this;
    }


    public FormDemoqa checkFormData() {

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

        return this;

    }

}

