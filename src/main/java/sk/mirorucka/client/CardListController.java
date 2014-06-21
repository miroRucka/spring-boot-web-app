package sk.mirorucka.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sk.mirorucka.domain.CreditCard;

/**
 * @author rucka
 */
@Controller
public class CardListController extends BaseController{

    @RequestMapping(value = "/cards")
    public ModelAndView listCards(ModelMap map) {
        map.addAttribute("cards", service.findCards());
        return new ModelAndView("listCards", map);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteCard(@PathVariable Long id) {
        service.deleteCard(id);
        ModelMap map = new ModelMap();
        map.addAttribute("cards", service.findCards());
        return new ModelAndView("listCards", map);
    }
}
