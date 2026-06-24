import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/menus")
@CrossOrigin(origins = "http://localhost:8080")
public class MenuController {

    @GetMapping
    public List<String> getMenus() {
        return Arrays.asList("Home", "Dashboard", "Settings", "Profile");
    }
}