import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestDemoqaHW4 {

    @Test
    void testDemoqa(){
        Configuration.browserSize = "1920x1080";
        File file = new File("src/test/resources/readme.txt");

        //открыть https://demoqa.com/automation-practice-form
        open("https://demoqa.com/automation-practice-form");
        //ввести имя в поле First Name
        $("#firstName").setValue("Julia");
        //ввести фамилию в поле Last Name
        $("#lastName").setValue("Shkreba");
        //ввести email в поле Email
        $("#userEmail").setValue("julyshk@gmail.com");
        //выбрать femail
        $("#genterWrapper").$(byText("Female")).click();
        //ввести номер телефона в поле Mobile
        $("#userNumber").setValue("1234567890");
        //ввести дату рождения в поле Date of Birth
        ////$("#dateOfBirthInput").click();
       // $("#dateOfBirthInput").setValue("");
       // $("#dateOfBirthInput").setValue("13 Mar 1992");
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
        //$(".table-responsive").shouldHave(text("Build like the best"));
        $(".table-responsive table tbody tr").$(byText("Student Name")).shouldHave(text("Julia Shkreba"));

        sleep(2000);

    }
}
