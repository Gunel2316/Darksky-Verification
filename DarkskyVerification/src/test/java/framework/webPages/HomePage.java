package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Primary;
import stepdefinition.SharedSD;
import sun.security.provider.SHA;

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
	private By darkSkyTemperatures= By.xpath("//span[contains(@style,'opacity')]//span");
	private By darkSkyLowestTemperature=By.xpath("//span[@class='first']");
	private By darkSkyCurrentTemperature=By.xpath("//span[@class='summary swap']");
	private By darkSkyLowestTemp=By.xpath("//span[@class='summary-high-low']//span[contains(text(),'˚')][2]");
	private By darkSkyHighestTemp=By.xpath("//span[@class='summary-high-low']//span[contains(text(),'˚')][3]");
	private By darkSkyTimeLine=By.xpath("//a[1]//span[2]//span[2]");
	private By darkSkyTimelineHigh=By.xpath("//span[@class='lowTemp swap']//span[@class='temp'][contains(text(),'˚')]");
	private By darkSkyTimelineLow=By.xpath("//span[@class='highTemp swip']//span[@class='temp'][contains(text(),'˚')]");


////span[@class='temp'][contains(text(),'˚')]
	//span[@class='lowTemp swap']//span[@class='temp']

	public boolean VerifyGreaterLowerThanCurrentTemp(){
		//getTextFromElement(darkSkyCurrentTemperature);
		//String currentt=SharedSD.getDriver().findElement(By.xpath("//span[@class='summary swap']")).getText();
		getTextFromElement(darkSkyLowestTemp);
		getTextFromElement(darkSkyHighestTemp);
		int currentTemperature=Integer.parseInt(getTextFromElement(darkSkyCurrentTemperature).substring(0,2));
		int lowestTemperature=Integer.parseInt(getTextFromElement(darkSkyLowestTemp).substring(5,7));
		int highestTemperature=Integer.parseInt(getTextFromElement(darkSkyHighestTemp).substring(6,8));
		if(currentTemperature>=lowestTemperature && currentTemperature<=highestTemperature){
			return true;
		}
		else {
			return false;
		}

	}

	public boolean verifyHighLowtempDisplayedCorrectly(){
		getTextFromElement(darkSkyTimelineLow);
		getTextFromElement(darkSkyTimelineHigh);
		getTextFromElement(darkSkyLowestTemp);
		getTextFromElement(darkSkyHighestTemp);

		int lowestTemperature=Integer.parseInt(getTextFromElement(darkSkyLowestTemp).substring(5,7));
		int highestTemperature=Integer.parseInt(getTextFromElement(darkSkyHighestTemp).substring(6,8));
		int timeLineLowTemp=Integer.parseInt(getTextFromElement(darkSkyTimelineLow).substring(0,2));
		int timeLineHighTemp=Integer.parseInt(getTextFromElement(darkSkyTimelineHigh).substring(0,2));
		if(timeLineLowTemp<=timeLineHighTemp && timeLineLowTemp==lowestTemperature && timeLineHighTemp==highestTemperature){
			return true;
		}
else{
	return false;
		}
	}

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

	public void clickOnDarkSkyHourTimeline() throws InterruptedException {

		((JavascriptExecutor)SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);",darkSkyTimeLine);
		Thread.sleep(3000);
		clickOn(darkSkyTimeLine);}

		public void clickOnTimeLine() throws InterruptedException {

	WebElement element = SharedSD.getDriver().findElement(By.xpath("//a[1]//span[2]//span[2]"));
        ((JavascriptExecutor) SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
        element.click();
        Thread.sleep(3000);}


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

	public int[] darkSkyTemperatured(){
		List<WebElement>dailyTemperatures=SharedSD.getDriver().findElements(darkSkyTemperatures);
		int [] dailyTemp={};
		for(int i=0; i<dailyTemperatures.size();i++){
			String text=dailyTemperatures.get(i).getText();
			dailyTemp[i]=Integer.parseInt(text);

		}
		return dailyTemp;
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

			return hours;}



	}


















