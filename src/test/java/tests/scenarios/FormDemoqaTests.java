package tests.scenarios;

import org.junit.jupiter.api.Test;
import tests.TestBase;

public class FormDemoqaTests extends TestBase {
    FormDemoqa formDemoqa;

    @Test
    void successfulFillFormTest() {
        formDemoqa = new FormDemoqa();

        formDemoqa.openPage();
        formDemoqa.fillInForm();
        formDemoqa.birthData();
        formDemoqa.submitForm();
        formDemoqa.checkFormData();

    }
}