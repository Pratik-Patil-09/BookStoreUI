package com.pratikPatil.assignment.stepDefinitions;

import com.pratikPatil.assignment.test.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;

public class DemoQaStoreSteps extends BaseTest {

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://demoqa.com/login");
    }

    @And("User enter {string} and {string}")
    public void user_enter_username_and_password(String uName, String password) {
        driver.findElement(By.id("userName")).sendKeys(uName);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.id("login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName-value")));
    }

    @Then("Username & Logout button should be visible")
    public void username_logout_should_be_visible() {
        String usernameText = driver.findElement(By.id("userName-value")).getText();
        WebElement logoutButton = driver.findElement(By.xpath("//button[text()='Log out']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("userName-label"))));
        Assert.assertEquals(usernameText, "PratikPatil");
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button not visible");
    }

    @When("User clicks on Book Store Application")
    public void user_clicks_on_book_store_application() {
        driver.findElement(By.xpath("//span[text()='Book Store']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));
    }

    @And("User searches for {string}")
    public void user_searches_for(String bookName) {
        driver.findElement(By.id("searchBox")).sendKeys(bookName);
    }

    @Then("Search results should include {string}")
    public void search_results_should_include(String expectedTitle) {
        String actualTitle = driver.findElement(By.xpath("//span[@id='see-book-Learning JavaScript Design Patterns']")).getText();
        Assert.assertEquals(actualTitle, expectedTitle, "Expected book not found in search results");
    }

    @And("Book details should be saved to a file")
    public void book_details_should_be_saved_to_a_file() {
        String title =
                driver.findElement(By.xpath("//span[@id='see-book-Learning JavaScript Design Patterns']")).getText();
        String author =
                driver.findElement(By.xpath("//div[@class='rt-tr -odd']//child::div[3]")).getText();
        String publisher =
                driver.findElement(By.xpath("//div[@class='rt-tr -odd']//child::div[4]")).getText();

        System.out.println("Title: " + title + "Author: " + author + "Publisher: " + publisher);

        try (FileWriter bookFileName = new FileWriter("book_details.txt")) {
            bookFileName.write(title + "\n");
            bookFileName.write(author + "\n");
            bookFileName.write(publisher + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Failed to write book details to file", e);
        }
    }

    @When("User clicks on Logout")
    public void user_clicks_on_logout() {
        driver.findElement(By.xpath("//button[text()='Log out']")).click();
    }

    @Then("User should be redirected to login page")
    public void user_should_be_redirected_to_login_page() {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        Assert.assertTrue(loginBtn.isDisplayed(), "User is not on login page");
    }
}
