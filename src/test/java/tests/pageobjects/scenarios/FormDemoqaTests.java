package tests.pageobjects.scenarios;

import org.junit.jupiter.api.Test;
import tests.TestBase;

public class FormDemoqaTests extends TestBase {
    FormDemoqaPage formDemoqaPage;

    @Test
    void successfulFillFormTest() {
        formDemoqaPage = new FormDemoqaPage();

        formDemoqaPage.openPage();
        formDemoqaPage.fillInForm();
        formDemoqaPage.birthData();
        formDemoqaPage.submitForm();
        formDemoqaPage.checkFormData();

    }
}