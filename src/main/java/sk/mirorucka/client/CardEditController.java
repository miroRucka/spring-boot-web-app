package sk.mirorucka.client;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sk.mirorucka.domain.CreditCard;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rucka
 */
@Controller
public class CardEditController extends BaseController{


    @RequestMapping(value = "/")
    public ModelAndView addCardViewForm(CreditCard card, ModelMap map) {
        map.addAttribute("card", card);
        map.addAttribute("providers", service.findProviders());
        map.addAttribute("newCard", true);
        return new ModelAndView("addCard", map);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView addCardSubmit(CreditCard card) {
        ModelMap map = new ModelMap();
        try {
            service.createOrUpdate(card);
        }catch (Exception e){
            map.addAttribute("error", true);
            logger.error("chyba pr vytvarani/updatovani karty " + card, e);
        }finally {
            map.addAttribute("card", new CreditCard());
            map.addAttribute("newCard", true);
            return new ModelAndView("addCard", map);
        }
    }

    @RequestMapping(value = "/update/{id}")
    public ModelAndView updateCard(@PathVariable Long id) {
        ModelMap map = new ModelMap();
        map.addAttribute("card", service.readCard(id));
        map.addAttribute("updateCard", true);
        return new ModelAndView("addCard", map);
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
