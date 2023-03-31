package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SubscriptionPackagePage;
import utilities.AbstractAcceptance;

import static utilities.PropertiesFile.getProperty;

import static org.testng.Assert.assertEquals;

public class SubscriptionPackageTest extends AbstractAcceptance {

    @DataProvider(name = "packageDataProvider")
    public Object[][] PackageDataProvider() {
        return new Object[][]{
                {getProperty("saudiCurrency"), getProperty("sa_country_url"),
                        getProperty("sa_litepackageprice"), getProperty("sa_discoveryAdditionalLitePrice"), getProperty("sa_fightSporAdditionaltLitePrice"),
                        getProperty("sa_classicPackagePrice"), getProperty("sa_discoveryAdditionalClassicPrice"), getProperty("sa_fightSportAdditionalClassicPrice"),
                        getProperty("sa_premiumPackagePrice"), getProperty("additionalAvailable"), getProperty("sa_fightSportAdditionalPremiumPrice"),
                }, //SAUDI

                {getProperty("bahrainCurrency"), getProperty("bh_country_url"),
                        getProperty("bh_litepackageprice"), getProperty("additionalAvailable"), getProperty("additionalAvailable"),
                        getProperty("bh_classicPackagePrice"), getProperty("additionalAvailable"), getProperty("additionalAvailable"),
                        getProperty("bh_premiumPackagePrice"), getProperty("additionalAvailable"), getProperty("additionalAvailable")
                }, //BAHRAIN

                {getProperty("kuwaitCurrency"), getProperty("Kw_country_url"),
                        getProperty("kw_litepackageprice"), getProperty("additionalAvailable"), getProperty("additionalAvailable"),
                        getProperty("kw_classicPackagePrice"), getProperty("additionalAvailable"), getProperty("additionalAvailable"),
                        getProperty("kw_premiumPackagePrice"), getProperty("additionalAvailable"), getProperty("additionalAvailable")
                } //KUWAIT
        };
    }

    @Test(dataProvider = "packageDataProvider")
    public void validateCountriesPackages(String currency, String countryUrl,
                                    String litePrice, String discoveryLitePrice, String fightSportLitePrice,
                                    String classicPrice, String discoveryClassicPrice, String fightSportClassicPrice,
                                    String premiumPrice, String discoveryPremiumPrice, String fightSportPremiumPrice) {


        driver.get("https://subscribe.stctv.com" + countryUrl);
        final SubscriptionPackagePage subscriptionPage = new SubscriptionPackagePage(driver);

        assertEquals(subscriptionPage.getLitePackageName().getText(), getProperty("litePackageName"));
        assertEquals(subscriptionPage.getLitePackagePrice().getText(), litePrice);
        assertEquals(subscriptionPage.getLitePackageCurrency().getText(), currency);

        assertEquals(subscriptionPage.getAdditionalDiscoveryLitePrice().getText(), discoveryLitePrice);
        assertEquals(subscriptionPage.getAdditionalFightSportLitePrice().getText(), fightSportLitePrice);

        assertEquals(subscriptionPage.getClassicPackageName().getText(), getProperty("classicPackageName"));
        assertEquals(subscriptionPage.getClassicPackagePrice().getText(), classicPrice);

        assertEquals(subscriptionPage.getAdditionalDiscoveryClassicPrice().getText(), discoveryClassicPrice);
        assertEquals(subscriptionPage.getAdditionalFightSportClassicPrice().getText(), fightSportClassicPrice);


        assertEquals(subscriptionPage.getPremiumPackageName().getText(), getProperty("premiumPackageName"));
        assertEquals(subscriptionPage.getPremiumPackagePrice().getText(), premiumPrice);

        assertEquals(subscriptionPage.getAdditionalDiscoveryPremiumPrice().getText(), discoveryPremiumPrice);
        assertEquals(subscriptionPage.getAdditionalFightSportPremiumPrice().getText(), fightSportPremiumPrice);
    }
}
