package sk.mirorucka.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sk.mirorucka.domain.CreditCard;

import java.util.List;

/**
 * @author rucka
 */
@Controller
public class ApiController extends BaseController {

    @RequestMapping(value = "/api/cards")
    @ResponseBody
    public List<CreditCard> listCards() {
        return service.findCards();
    }
}
