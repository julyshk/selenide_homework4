package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestDemoqaHW4 {

    @Test
    void testDemoqa(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        File file = new File("src/test/resources/readme.txt");
        String firstName = "Julia";
        String lastName = "Shkreba";
        String userEmail = "julyshk@gmail.com";
        String userNumber = "9991112222";

        //открыть https://demoqa.com/automation-practice-form
        open("/automation-practice-form");
        //ввести имя в поле First Name
        $("#firstName").setValue(firstName);
        //ввести фамилию в поле Last Name
        $("#lastName").setValue(lastName);
        //ввести email в поле Email
        $("#userEmail").setValue(userEmail);
        //выбрать femail
        $("#genterWrapper").$(byText("Female")).click();
        //ввести номер телефона в поле Mobile
        $("#userNumber").setValue(userNumber);
        //ввести дату рождения в поле Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--013").click();
        //заполнить поле Subjects
       $("#subjectsInput").setValue("biology").pressEnter();
       //Выбрать Hobbies
        $("#hobbiesWrapper").$(byText("Reading")).click();
       //загрузить файл
        $("#uploadPicture").uploadFile(file);
        //ввести адрес в поле Current Address
        $("#currentAddress").setValue("Novosibirsk, Krashyi prospect");
        //заполнить Select State
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        //заполнить Select City
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        //заблокировать баннеры
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        //Нажать кнопку Submit
        $("#submit").click();
        //Проверки
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail),
                text("Female"), text(userNumber), text ("13 March,1992"), text("Biology"), text("Reading"), text("Novosibirsk, Krashyi prospect"),
                text("Haryana"), text("Karnal"), text("readme.txt"));
    }
}
