package com.mbh.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;
import com.ts.commons.TSPageFactory.PageFactory;

public class LoginPage extends Page{

	@FindBy (id= "user_login" )
	private WebElement loginField;
	@FindBy (id= "user_password" )
	private WebElement passwordField;
	@FindBy(xpath = ".//*[@id='new_user']/div[2]/div[5]/div/input")
	private WebElement button;
	@FindBy(xpath = ".//*[@id='asset_or_company_select']/form/div[2]/div[2]/div/input")
	private WebElement chooseAssetButton;
	@FindBy(xpath = ".//*[@id='asset_or_company_select']/form/div[2]/div[1]/label")
	private WebElement assetLabel;
		
	@Override
	public LoginPage and() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public LoginPage then() {
		// TODO Auto-generated method stub
		return this;
	}

	public LoginPage fillLoginForm(String user, String password)
	{
		loginField.sendKeys(user);
		passwordField.sendKeys(password);
		button.click();
		return this;
	}
	
	public MeterPage selectAsset()
	{
		chooseAssetButton.click();
		MeterPage meter = PageFactory.initElements(this.getUI().getDriver(), MeterPage.class);
		meter.setUI(this.getUI());
		return meter;
	}
	
	public Validator validateThatAssetPageisOpen()
	{
		return (
				new Validator() {   
			   @Override
			   public void Validate() 
			   {
				  Assert.assertTrue (assetLabel != null);  
			   }
			   }
			   );
	}
}
