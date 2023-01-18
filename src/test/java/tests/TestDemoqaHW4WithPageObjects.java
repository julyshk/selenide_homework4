package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

public class TestDemoqaHW4WithPageObjects extends TestBase {

    @Test
    void testDemoqa() {

        File file = new File("src/test/resources/readme.txt");
        String firstName = "Julia";
        String lastName = "Shkreba";
        String userEmail = "julyshk@gmail.com";
        String gender = "Female";
        String userNumber = "9991112222";
        String subjects = "biology";
        String hobbies = "Reading";
        String currentAddress = "Novosibirsk, Krashyi prospect";
        String selectState = "Haryana";
        String selectCity = "Karnal";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhone(userNumber)
                .setBirthDate("13", "March", "1992")
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(file)
                .setCurrentAddress(currentAddress)
                .selectState(selectState)
                .selectCity(selectCity)
                .clickButton();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", "13 March,1992")
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", "readme.txt")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", selectState + " " + selectCity);

    }
}
