package sk.mirorucka.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CreditCardDao dao;

    @Override
    public boolean createOrUpdate(CreditCard card) {
        return dao.persist(card);
    }

    @Override
    public boolean deleteCard(Long id) {
        return dao.delete(id);
    }

    @Override
    public CreditCard readCard(Long id) {
        return dao.read(id);
    }

    @Override
    public List<CreditCard> findCards() {
        return dao.findAll();
    }

    @Override
    public List<Provider> findProviders() {
        return Arrays.asList(Provider.values());
    }
}
