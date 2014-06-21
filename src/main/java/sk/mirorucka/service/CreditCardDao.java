package sk.mirorucka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.mirorucka.domain.CreditCard;
import sk.mirorucka.service.store.DataStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author rucka
 */
@Component("creditCardDao")
public class CreditCardDao {

    @Autowired
    private DataStore store;

    public boolean persist(CreditCard card) {
        if (card.getId() == null) {
            card.setId(lastId() + 1);
            store.getCards().add(card);
            return true;
        } else {
            update(card);
            return true;
        }
    }

    public List<CreditCard> findAll() {
        return store.getCards();
    }

    public CreditCard read(Long id) {
        assert id != null;
        for (CreditCard creditCard : store.getCards()) {
            if (id.compareTo(creditCard.getId()) == 0) {
                return creditCard;
            }
        }
        throw new IllegalArgumentException(String.valueOf(id));
    }

    public boolean update(CreditCard creditCard) {
        assert creditCard != null;
        assert creditCard.getId() != null;
        store.getCards().set(store.getCards().indexOf(creditCard), creditCard);
        return true;
    }

    public boolean delete(Long id) {
        assert id != null;
        for (CreditCard creditCard : store.getCards()) {
            if (id.compareTo(creditCard.getId()) == 0) {
                store.getCards().remove(creditCard);
                return true;
            }
        }
        throw new IllegalArgumentException(String.valueOf(id));
    }

    private Long lastId() {
        List<CreditCard> result = new ArrayList<>(store.getCards());
        Collections.sort(result, new Comparator<CreditCard>() {
            @Override
            public int compare(CreditCard o1, CreditCard o2) {
                return o2.getId().compareTo(o1.getId());
            }
        });
        return result != null && result.iterator().hasNext() ? result.iterator().next().getId() : null;
    }


}
