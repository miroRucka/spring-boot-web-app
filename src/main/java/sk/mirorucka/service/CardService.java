package sk.mirorucka.service;

import org.springframework.stereotype.Component;
import sk.mirorucka.domain.CreditCard;
import sk.mirorucka.domain.Provider;

import java.util.List;

/**
 * @author rucka
 */
public interface CardService {
    void addCard(CreditCard card);
    void deleteCard(Long id);
    void updateCard(CreditCard card);
    List<CreditCard> findCards();
    List<Provider> findProviders();
}
