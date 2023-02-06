package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

import static io.qameta.allure.Allure.step;

public class TestDemoqaProperties extends TestBaseExtended {

    @Test
    @Feature("Форма регистрации")
    @Story("Проверка заполнения формы")
    @Owner("shkrebayv")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка заполнения формы регистрации")
    @Tag("remote_properties")
    void testDemoqa() {

        Faker faker = new Faker(new Locale("en"));
        File file = new File("src/test/resources/readme.txt");

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                address = faker.address().streetAddress(),
                userNumber = faker.number().digits(10),
                hobbies = faker.options().option("Reading", "Sports", "Music"),
                gender = faker.options().option("Female", "Male", "Other"),
                subjects = faker.options().option("Biology", "Englis", "Chemistry", "Computer Science",
                        "Commerce", "Economics", "Social Studies", "Arts", "Histpory", "Maths", "Accounting", "Physics",
                        "Hindi", "Civics"),
                selectState = faker.options().option("Haryana"),
                selectCity = faker.options().option("Karnal", "Panipat");


        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Enter first name", () -> {
            registrationPage.setFirstName(firstName);
        });
        step("Enter last name", () -> {
            registrationPage.setLastName(lastName);
        });
        step("Enter email", () -> {
            registrationPage.setEmail(userEmail);
        });
        step("Choose gender", () -> {
            registrationPage.setGender(gender);
        });
        step("Enter mobile phone", () -> {
            registrationPage.setPhone(userNumber);
        });
        step("Enter birth date", () -> {
            registrationPage.setBirthDate("13", "March", "1992");
        });
        step("Choose subject", () -> {
            registrationPage.setSubjects(subjects);
        });
        step("Choose hobbies", () -> {
            registrationPage.setHobbies(hobbies);
        });
        step("Upload picture", () -> {
            registrationPage.uploadPicture(file);
        });
        step("Enter current address", () -> {
            registrationPage.setCurrentAddress(address);
        });
        step("Choose state", () -> {
            registrationPage.selectState(selectState);
        });
        step("Choose city", () -> {
            registrationPage.selectCity(selectCity);
        });
        step("Press button submit", () -> {
            registrationPage.clickButton();
        });

        step("Verify student name", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Student Name", firstName + " " + lastName);
        });
        step("Verify student email", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Student Email", userEmail);
        });
        step("Verify gender", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Gender", gender);
        });
        step("Verify mobile phone", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Mobile", userNumber);
        });
        step("Verify date of birth", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Date of Birth", "13 March,1992");
        });
        step("Verify subject", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Subjects", subjects);
        });
        step("Verify hobbies", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Hobbies", hobbies);
        });
        step("Verify picture", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Picture", "readme.txt");
        });
        step("Verify address", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Address", address);
        });
        step("Verify state and city", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("State and City", selectState + " " + selectCity);
        });

    }
}
