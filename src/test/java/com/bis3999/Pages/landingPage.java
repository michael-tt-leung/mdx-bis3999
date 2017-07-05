package com.bis3999.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class landingPage {

    @FindBy(linkText = "i am a link")
    private WebElement theActiveLink;

    @FindBy(id = "your_comments")
    private WebElement yourCommentsSpan;

    @FindBy(id = "comments")
    private WebElement commentsTextAreaInput;

    @FindBy(id = "submit")
    private WebElement submitButton;
	
	@FindBy(tagName = "h2")
	private WebElement helloWorld;

    public WebDriver driver;
//    public static String url = "http://ec2-52-77-255-171.ap-southeast-1.compute.amazonaws.com:8080/bis3999";
    public static String url = "http://ec2-54-179-170-137.ap-southeast-1.compute.amazonaws.com:8080/bis3999";
	
    public static landingPage visitPage(WebDriver driver) {
        landingPage page = new landingPage(driver);
        page.visitPage();
        return page;
    }

    public landingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void followLink() {
        this.theActiveLink.click();
    }

    public void submitComment(String text) {
        this.commentsTextAreaInput.sendKeys(text);
        this.submitButton.click();

        // Race condition for time to populate yourCommentsSpan
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        wait.until(ExpectedConditions.textToBePresentInElement(yourCommentsSpan, text));
    }
	
	public boolean hasHelloWorld() {
		//System.out.println(this.helloWorld.getText());
		//System.out.println(this.helloWorld.getText() == "Hell World!!!!!");		
		String testString = "Hello World!";
		return this.helloWorld.getText() == testString;
	}
	
	public string getH2() {
		return this.helloWorld.getText();
	}

    public String getSubmittedCommentText() {
        return this.yourCommentsSpan.getText();
    }

    public boolean isOnPage() {
        String title = "I am a page title - Sauce Labs";
        return this.driver.getTitle() == title;
    }

}