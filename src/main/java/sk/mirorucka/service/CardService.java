package sk.mirorucka.service;

import org.springframework.stereotype.Component;
import sk.mirorucka.domain.CreditCard;
import sk.mirorucka.domain.Provider;

import java.util.List;

/**
 * @author rucka
 */
public interface CardService {
    boolean createOrUpdate(CreditCard card);
    boolean deleteCard(Long id);
    CreditCard readCard(Long id);
    List<CreditCard> findCards();
    List<Provider> findProviders();
}
