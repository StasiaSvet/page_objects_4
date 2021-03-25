package tests.pageobjects.chain;

import org.junit.jupiter.api.Test;
import tests.TestBase;

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
