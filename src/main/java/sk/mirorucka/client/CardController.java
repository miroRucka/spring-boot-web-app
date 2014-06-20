package sk.mirorucka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sk.mirorucka.domain.CreditCard;
import sk.mirorucka.service.CardService;

/**
 * @author rucka
 */
@Controller
public class CardController {

    @Autowired
    private CardService service;

    @RequestMapping(value = "/")
    public ModelAndView addCard(CreditCard card, ModelMap map) {
        map.addAttribute("card", card);
        map.addAttribute("providers", service.findProviders());
        return new ModelAndView("addCard", map);
    }
}
