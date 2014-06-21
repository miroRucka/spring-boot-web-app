package sk.mirorucka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import sk.mirorucka.domain.CreditCard;
import sk.mirorucka.domain.Provider;
import sk.mirorucka.service.CardService;
import sk.mirorucka.spring.SpringConfigurationTest;

import java.util.Date;

/**
 * @author rucka
 */
@ContextConfiguration(classes = {SpringConfigurationTest.class})
public class ServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected CardService service;

    @Test
    public void findCards() {
        Assert.assertNotNull(service.findCards());
        Assert.assertEquals(service.findCards().isEmpty(), false);
    }

    @Test
    public void findProviders() {
        Assert.assertNotNull(service.findProviders());
        Assert.assertEquals(service.findProviders().isEmpty(), false);
    }

    @Test
    public void addCard() {
        boolean result = service.createOrUpdate(createNewCard()) ;
        Assert.assertEquals(result, true);
    }

    @Test
    public void updateCard() {
        CreditCard c = createNewCard();
        c.setId(2l);
        boolean result = service.createOrUpdate(c) ;
        Assert.assertEquals(result, true);
    }

    @Test
    public void deleteCard() {
        boolean result = service.deleteCard(1l) ;
        Assert.assertEquals(result, true);
    }

    @Test
    public void readCard() {
        Assert.assertNotNull(service.readCard(2l));
    }

    private CreditCard createNewCard(){
        CreditCard c = new CreditCard();
        c.setCardNumber("457856");
        c.setOwner("Miro");
        c.setProvider(Provider.CSOB);
        c.setValidTo(new Date());
        return c;
    }


}
