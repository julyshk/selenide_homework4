package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class RegistrationResultsModal {
    public void verifyModalAppears(){
        $(".modal-dialog").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }

    public void verifyResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));

    }

}
