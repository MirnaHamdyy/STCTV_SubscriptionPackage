package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubscriptionPackagePage {

    private WebDriver driver;

    private By litePackageNameLocator = By.xpath("//div[@class='plan-names']//div[1]//strong[1]");
    private By litePackagePriceLocator = By.xpath("//div[@class='plan-row']//div[1]//div[1]//b[1]");

    ////div[@class='plan-section']//div[1]//div[1]//i[1]
    ////body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/i[1]
    private By litePackageCurrencyLocator = By.xpath("//div[@class='plan-section']//div[1]//div[1]//i[1]");

    private By classicPackageNameLocator = By.xpath("//div[@class='classic']//strong[@class='plan-title']");
    private By classicPackagePriceLocator = By.xpath("//div[@class='classic']//b");
    private By classicPackageCurrencyLocator = By.xpath("//div[@class='classic']//i");

    private By premiumPackageNameLocator = By.xpath("//div[@class='container']//div[3]//strong[1]");
    private By premiumPackagePriceLocator = By.xpath("//div[@class='plan-row']//div[3]//div[1]//b[1]");
    private By premiumPackageCurrencyLocator = By.xpath("//div[@class='plan-row']//div[3]//div[1]//i[1]");

    //Additional packages
    private By discoveryAdditionalLitePrice = By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]");
    private By fightSporAdditionaltLitePrice = By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]");

    // XPaths for classic package
    private By discoveryAdditionalClassicPrice = By.xpath("//body/div[@id='wrapper']/div[@id='minisub-container']/div/div[@id='main']/div/div/div[2]/div[2]/div[1]");
    private By fightSportAdditionalClassicPrice = By.xpath("//div[2]//div[3]//div[2]//div[1]");

    // XPaths for premium package
    private By discoveryAdditionalPremiumAvailable = By.xpath("//body//div[@id='wrapper']//div[@id='main']//div//div//div[2]//div[2]//div[3]");
    private By fightSportAdditionalPremiumPrice = By.xpath("//div[2]//div[3]//div[2]//div[3]");

    public SubscriptionPackagePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLitePackageName() {
        return ElementFinder.findAndWaitForElement(driver,litePackageNameLocator);
    }

    public WebElement getLitePackagePrice() {
        return ElementFinder.findAndWaitForElement (driver, litePackagePriceLocator);
    }

    public WebElement getLitePackageCurrency() {
        
        return ElementFinder.findAndWaitForElement(driver, litePackageCurrencyLocator);
    }

    public WebElement getClassicPackageName() {
        return ElementFinder.findAndWaitForElement(driver,classicPackageNameLocator);
    }

    public WebElement getClassicPackagePrice() {
        return ElementFinder.findAndWaitForElement(driver,classicPackagePriceLocator);
    }

    public WebElement getClassicPackageCurrency() {
        return ElementFinder.findAndWaitForElement(driver,classicPackageCurrencyLocator);
    }

    public WebElement getPremiumPackageName() {
        return ElementFinder.findAndWaitForElement(driver,premiumPackageNameLocator);
    }

    public WebElement getPremiumPackagePrice() {
        return ElementFinder.findAndWaitForElement(driver,premiumPackagePriceLocator);
    }

    public WebElement getPremiumPackageCurrency() {
        return ElementFinder.findAndWaitForElement(driver,premiumPackageCurrencyLocator);
    }


    public WebElement getAdditionalDiscoveryLitePrice() {
        return ElementFinder.findAndWaitForElement(driver,discoveryAdditionalLitePrice);
    }

    public WebElement getAdditionalFightSportLitePrice() {
        return ElementFinder.findAndWaitForElement(driver,fightSporAdditionaltLitePrice);
    }

    public WebElement getAdditionalDiscoveryClassicPrice() {
        return ElementFinder.findAndWaitForElement(driver,discoveryAdditionalClassicPrice);
    }

    public WebElement getAdditionalFightSportClassicPrice() {
        return ElementFinder.findAndWaitForElement(driver,fightSportAdditionalClassicPrice);
    }

    public WebElement getAdditionalDiscoveryPremiumPrice() {
        return ElementFinder.findAndWaitForElement(driver,discoveryAdditionalPremiumAvailable);
    }

    public WebElement getAdditionalFightSportPremiumPrice() {
        return ElementFinder.findAndWaitForElement(driver,fightSportAdditionalPremiumPrice);
    }

}
