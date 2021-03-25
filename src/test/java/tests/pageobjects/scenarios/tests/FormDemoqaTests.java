package tests.pageobjects.scenarios.tests;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pageobjects.scenarios.pages.FormDemoqaPage;

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