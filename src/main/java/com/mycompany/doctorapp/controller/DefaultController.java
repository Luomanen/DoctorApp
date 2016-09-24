
import org.springframework.stereotype.Controller;

@Controller
public class DefaultController {

    public String view() {
        return "index";
    }
}
