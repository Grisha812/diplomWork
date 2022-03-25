import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Random;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Тестирование сайта  www.vstu.ru ")
public class VstuUITest extends AfterTest{

    @Description(value = "1. Открыть сайт https://www.vstu.ru\n" +
            "2. Клик по кнопке Поступающим\n" +
            "3. Клик по вкладке Учись в политехе\n" +
            "4. Клик по вкладке Выбор специальности\n" +
            "5. Клик по вкладке Приём 2022\n" +
            "6. Клик по вкладке Контакты\n" +
            "7. Проверить, что каждая страница загрузилась\n")
    @Test
    @Order(1)
    @DisplayName("Приёмная комиссия. Навигация")
    public void checkAbiturient() {
        driver.get("https://www.vstu.ru");
        EntrantPage entrantPage = new EntrantPage();
        entrantPage.abiturient();
        return;
    }

    @Description(value = "1. Открыть сайт https://www.vstu.ru\n" +
            "2. Клик по вкладке Университет\n" +
            "3. Клик по вкладке Образование\n" +
            "4. Клик по вкладке Наука\n" +
            "5. Клик по вкладке Развитие\n" +
            "6. Клик по вкладке Сотрудничество\n" +
            "7. Клик по вкладке Справка\n" +
            "8. Клик по вкладке Точка кипения\n" +
            "9. Клик по вкладке Опорный университет\n" +
            "10. Клик по Доступная среда\n" +
            "11. Клик по Версия для слабовидящих\n" +
            " - клик по белый А (страница отобразилась согласно выбранному контрасту)\n" +
            " - клик по чёрный А (страница отобразилась согласно выбранному контрасту)\n" +
            " - клик по синей А (страница отобразилась согласно выбранному контрасту)\n" +
            "12. Клик по Версия для слабовидящих\n" +
            "13. Клик по кнопке ВолгГТУ\n" +
            "14. Проверить, что каждая страница загрузилась\n" +
            "15. На всех страницах отображаются иконки : vk, ok, youtube, telegram, доступная среда и версия для слабовидящих\n")
    @Test
    @Order(2)
    @DisplayName("Переход по вкладкам сайта")
    public void checkWallking() {

        driver.get("https://www.vstu.ru");
        SurfingPage surfingPage = new SurfingPage();
        surfingPage.wallkSite();
        surfingPage.checkIcons();
        return;
    }

    @Description(value = "1. Перейти на страницу авторизации http://dump.vstu.ru/\n" +
            "2. Ввести логин : fpik\n" +
            "3. Пароль : guest\n" +
            "4. Нажать кнопку : войти\n" +
            "5. Проверить что отбразился title страницы\n" +
            "6. Перейти в раздел : Факультет подготовки и переподготовки инжинерных кадров\n" +
            "7. Проверить, что произошёл переход в выбранный раздел\n" +
            "8. Нажать кнопку : выйти\n" +
            "9. Проверить, что после выхода поля логина и пароля - пусты\n" +
            "10. Негативная проверка : \n" +
                    " - ввод только логина (появилось сообщение о ошибке)\n" +
                    " - ввод только пароля (появилось сообщение о ошибке)\n")
    @Test
    @Order(3)
    @DisplayName("Авторизация в файловом хранилище")
    public void loginTest() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        driver.get("https://www.vstu.ru");

        loginPage.auth("fpik", "guest");
        String title = driver.getTitle();
        Assertions.assertEquals(title, "Главная страница | Файловое хранилище ВолгГТУ");
        String result = driver.findElement(By.xpath("//input[@id='edit-name']")).getText();
        Assertions.assertEquals("", result);
        String result2 = driver.findElement(By.xpath("//input[@id='edit-pass']")).getText();
        Assertions.assertEquals("", result2);
        
        loginPage.negativeLog("fpik");
        String result3 = driver.findElement(By.xpath("//input[@id='edit-pass']")).getText();
        Assertions.assertEquals("", result3);
        loginPage.negativePass("guest");
        String result4 = driver.findElement(By.xpath("//input[@id='edit-name']")).getText();
        Assertions.assertEquals("", result4);
    }

    @Description(value = "1. Открыть сайт https://www.vstu.ru\n" +
            "2. Клик по значку Поиск (проверить, что данная страница загрузилась)\n" +
            "3. Ввести искомое слово\n")
    @Test
    @Order(4)
    @DisplayName("Проверка работы поисковой строки")
    public void checkFind() {

        driver.get("https://www.vstu.ru");
        SearchPage searchPage = new SearchPage();

        Random random = new Random();
        int n = random.nextInt(31) + 1; // для запроса : "Новости " + n + " марта"

        searchPage.findWord("проведение централизованного тестирования");  // "Новости " + n + " марта"

        String secondTitle = driver.findElement(By.xpath("//h1[contains(text(),'Поиск')]")).getText();
        Assertions.assertEquals("Поиск", secondTitle);
    }
}
