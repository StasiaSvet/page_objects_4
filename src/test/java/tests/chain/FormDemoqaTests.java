package tests.chain;

import org.junit.jupiter.api.Test;
import tests.TestBase;

public class FormDemoqaTests extends TestBase {
    FormDemoqa formDemoqa;

    @Test
    void successfulFillFormTest() {
        formDemoqa = new FormDemoqa();

        formDemoqa.openPage()
                .fillInForm()
                .birthData()
                .submitForm()
                .checkFormData();

    }
}
