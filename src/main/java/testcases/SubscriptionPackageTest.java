package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SubscriptionPackagePage;
import utilities.AbstractAcceptance;

import static utilities.PropertiesFile.getProperty;

import static org.testng.Assert.assertEquals;

public class SubscriptionPackageTest extends AbstractAcceptance {

    private SubscriptionPackagePage subscriptionPage;


    @DataProvider(name = "packageDataProvider")
    public Object[][] PackageDataProvider() {
        return new Object[][]{
                {getProperty("saudiCurrency"), getProperty("sa_country_url"),
                        getProperty("sa_litepackageprice"), getProperty("sa_discoveryAdditionalLitePrice"), getProperty("sa_fightSporAdditionaltLitePrice"),
                        getProperty("sa_classicPackagePrice"), getProperty("sa_discoveryAdditionalClassicPrice"), getProperty("sa_fightSportAdditionalClassicPrice"),
                        getProperty("sa_premiumPackagePrice"), getProperty("additionalAvailable"), getProperty("sa_fightSportAdditionalPremiumPrice"),
                }, // SAUDI

                {getProperty("bahrainCurrency"), getProperty("bh_country_url"),
                        getProperty("bh_litepackageprice"), getProperty("additionalAvailable"), getProperty("additionalAvailable"),
                        getProperty("bh_classicPackagePrice"), getProperty("additionalAvailable"), getProperty("additionalAvailable"),
                        getProperty("bh_premiumPackagePrice"), getProperty("additionalAvailable"), getProperty("additionalAvailable")
                },

                {getProperty("kuwaitCurrency"), getProperty("Kw_country_url"),
                        getProperty("kw_litepackageprice"), getProperty("additionalAvailable"), getProperty("additionalAvailable"),
                        getProperty("kw_classicPackagePrice"), getProperty("additionalAvailable"), getProperty("additionalAvailable"),
                        getProperty("kw_premiumPackagePrice"), getProperty("additionalAvailable"), getProperty("additionalAvailable")
                }
        };
    }

    @Test(dataProvider = "packageDataProvider")
    public void validateCountriesPackages(String currency, String countryUrl,
                                    String litePrice, String discoveryLitePrice, String fightSportLitePrice,
                                    String classicPrice, String discoveryClassicPrice, String fightSportClassicPrice,
                                    String premiumPrice, String discoveryPremiumPrice, String fightSportPremiumPrice) {


        driver.get("https://subscribe.stctv.com" + countryUrl);
        subscriptionPage = new SubscriptionPackagePage(driver);

        System.out.println("Validate the lite package: " + getProperty("litePackageName"));
        assertEquals(subscriptionPage.getLitePackageName().getText(), getProperty("litePackageName"));

        System.out.println("Lite package price: " + litePrice);
        assertEquals(subscriptionPage.getLitePackagePrice().getText(), litePrice);

        assertEquals(subscriptionPage.getLitePackageCurrency().getText(), currency);

        System.out.println("The price of the discovery lite package: " + discoveryLitePrice);
        assertEquals(subscriptionPage.getAdditionalDiscoveryLitePrice().getText(), discoveryLitePrice);

        System.out.println("The price of the fight sport lite package:" + fightSportLitePrice);
        assertEquals(subscriptionPage.getAdditionalFightSportLitePrice().getText(), fightSportLitePrice);
        System.out.println("---------------------------------------------");


        System.out.println("Validate the classic package: " + getProperty("classicPackageName"));
        assertEquals(subscriptionPage.getClassicPackageName().getText(), getProperty("classicPackageName"));

        System.out.println("Classic package price:" + classicPrice);
        assertEquals(subscriptionPage.getClassicPackagePrice().getText(), classicPrice);


        System.out.println("The price of discovery classic package:" + discoveryClassicPrice);
        assertEquals(subscriptionPage.getAdditionalDiscoveryClassicPrice().getText(), discoveryClassicPrice);

        System.out.println("The price of the fight sport classic package:" + fightSportClassicPrice);
        assertEquals(subscriptionPage.getAdditionalFightSportClassicPrice().getText(), fightSportClassicPrice);

        System.out.println("---------------------------------------------");

        System.out.println("Validate the premium package: " + getProperty("premiumPackageName"));
        assertEquals(subscriptionPage.getPremiumPackageName().getText(), getProperty("premiumPackageName"));

        System.out.println("Premium package price:" + premiumPrice);
        assertEquals(subscriptionPage.getPremiumPackagePrice().getText(), premiumPrice);


        System.out.println("The price of discovery premium package: " + discoveryPremiumPrice);
        assertEquals(subscriptionPage.getAdditionalDiscoveryPremiumPrice().getText(), discoveryPremiumPrice);

        System.out.println("The price of fight sport premium package:" + fightSportPremiumPrice);
        assertEquals(subscriptionPage.getAdditionalFightSportPremiumPrice().getText(), fightSportPremiumPrice);
    }
}
