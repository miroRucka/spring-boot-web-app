package sk.mirorucka.service;

import org.springframework.stereotype.Service;
import sk.mirorucka.domain.CreditCard;
import sk.mirorucka.domain.Provider;

import java.util.Arrays;
import java.util.List;

/**
 * @author rucka
 */
@Service("cardService")
public class CardServiceImpl implements CardService {

    @Override
    public void addCard(CreditCard card) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteCard(Long id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateCard(CreditCard card) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<CreditCard> findCards() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Provider> findProviders() {
        return Arrays.asList(Provider.values());
    }
}
