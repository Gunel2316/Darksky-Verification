package framework.webPages;

import cucumber.api.java.en_lol.WEN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HomePage extends BasePage{

	private By emailTextField = By.id("email");
	private By passwordTextField = By.id("pass");
	private By loginButton = By.id("loginbutton");
	private By firstNameTextField = By.id("firstName");
	private By lastNameTextField = By.id("lastName");
	private By mobileNumberTextField = By.id("mobileNumber");
	private By newPasswordTextField = By.id("newPwd");
	private By errorMessage = By.id("errorMessage");
	private By femaleGender = By.id("u_0_9");
	private By maleGender = By.id("u_0_a");
	private By messengerLink = By.id("");
	private By darkSkyHours = By.xpath("//span[contains(@class,'hour')]//span");
	
	public void clickOnLoginButton() {
		clickOn(loginButton);
	}

	public void enterEmail(String enterEmail) {
		setValue(emailTextField, enterEmail);
	}
	
	public void enterPassword(String enterPassword) {
		setValue(passwordTextField, enterPassword);
	}

	public void enterFirstName(String firstName) {
		setValue(firstNameTextField, firstName);
	}

	public void enterLastName(String lastName) {
		setValue(lastNameTextField, lastName);
	}

	public void enterMobileNumber(String mobileNum) {
		setValue(mobileNumberTextField, mobileNum);
	}

	public void enterNewPassword(String password) {
		setValue(newPasswordTextField, password);
	}

	public String getErrorMessage() {
		return getTextFromElement(errorMessage);
	}

	public boolean isGenderFemaleSelected() {
		return isElementSelected(femaleGender);
	}

	public void clickOnFemaleGender() {
		clickOn(femaleGender);
	}

	public boolean isGenderMaleSelected() {
		return isElementSelected(maleGender);
	}

	public void clickOnMaleGender() {
		clickOn(maleGender);
	}

	public void clickOnMessengerLink() {
		clickOn(messengerLink);
	}

	public List getHoursFromDarksky(){getWebElements(darkSkyHours);
		List<String> darkSkyHours = new ArrayList<String>();
	return darkSkyHours;}

	public List<String> darkSkyHrs(){
		List<WebElement> hours=SharedSD.getDriver().findElements(darkSkyHours);
		List<String>HourValues=new ArrayList<String>();
		for (WebElement hour:hours){
			HourValues.add(hour.getText());
		}
		return HourValues;
	}

	String CheckInDate(){
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH,1);
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd");
		return dateFormat.format(calendar.getTime()); }


	public List<String> actualHours() {
		ArrayList<String> hours = new ArrayList<String>();
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat df=new SimpleDateFormat("ha");

		SimpleDateFormat startHourFormat= new SimpleDateFormat("H");
		int startHour = Integer.parseInt(startHourFormat.format(cal.getTime()));

		SimpleDateFormat endHourFormat= new SimpleDateFormat("H");
		cal.add(Calendar.HOUR,22);
		int endHour=Integer.parseInt(endHourFormat.format(cal.getTime()));

		for (int i=startHour+2; i<=startHour+22; i+=2){
			cal.set(Calendar.HOUR_OF_DAY,i);
			hours.add(df.format(cal.getTime()).toLowerCase());}
			hours.add(0,"Now");

			return hours;}}


















