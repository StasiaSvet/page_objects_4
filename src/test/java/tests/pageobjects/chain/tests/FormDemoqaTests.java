package tests.pageobjects.chain.tests;

import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.pageobjects.chain.pages.FormDemoqaPage;

public class FormDemoqaTests extends TestBase {
    FormDemoqaPage formDemoqaPage;

    @Test
    void successfulFillFormTest() {
        formDemoqaPage = new FormDemoqaPage();

        formDemoqaPage.openPage()
                .fillInForm()
                .birthData()
                .submitForm()
                .checkFormData();

    }
}
