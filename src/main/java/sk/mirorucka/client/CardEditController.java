package sk.mirorucka.client;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sk.mirorucka.domain.CreditCard;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rucka
 */
@Controller
public class CardEditController extends BaseController {


    @RequestMapping(value = "/")
    public ModelAndView addCardViewForm(CreditCard card, ModelMap map) {
        map.addAttribute("card", card);
        map.addAttribute("providers", service.findProviders());
        return editorView(map, "newCard");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView addCardSubmit(@Valid @ModelAttribute("card") CreditCard card, BindingResult result) {
        ModelMap map = new ModelMap();
        if (result.hasErrors()) {
            return editorView(map, "newCard");
        }
        try {
            service.createOrUpdate(card);
        } catch (Exception e) {
            map.addAttribute("error", true);
            logger.error("chyba pri vytvarani/updatovani karty: " + card, e);
        } finally {
            return addCardView(map);
        }
    }


    @RequestMapping(value = "/update/{id}")
    public ModelAndView updateCard(@PathVariable Long id) {
        ModelMap map = new ModelMap();
        try {
            map.addAttribute("card", service.readCard(id));
        } catch (Exception e) {
            map.addAttribute("error", true);
            map.addAttribute("card", new CreditCard());
            logger.error("chyba pri citani karty s id: " + id, e);
        } finally {
            return editorView(map, "updateCard");
        }
    }

    private ModelAndView addCardView(ModelMap map) {
        map.addAttribute("card", new CreditCard());
        return editorView(map, "newCard");
    }

    private ModelAndView editorView(ModelMap map, String action) {
        map.addAttribute("updateCard", true);
        return new ModelAndView("addCard", map);
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
