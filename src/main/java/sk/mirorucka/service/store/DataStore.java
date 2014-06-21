package sk.mirorucka.service.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.mirorucka.domain.CreditCard;

import java.util.List;

/**
 * @author rucka
 */
@Component("store")
public class DataStore {

    @Autowired
    protected List<CreditCard> cards;

    public List<CreditCard> getCards() {
        return cards;
    }
}
