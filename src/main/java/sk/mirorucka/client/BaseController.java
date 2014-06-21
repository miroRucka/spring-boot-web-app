package sk.mirorucka.client;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sk.mirorucka.service.CardService;

/**
 * @author rucka
 */
@Controller
public class BaseController {

    @Autowired
    protected CardService service;

    protected Logger logger = Logger.getLogger(getClass());
}
