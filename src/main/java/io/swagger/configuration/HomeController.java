package io.swagger.configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**
 * Home redirection to swagger api documentation 
 */
@Controller
public class HomeController {
    private final ResourceLoader resourceLoader;

    public HomeController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping(value = "/")
    public String index() {
        return "forward:/index.html"; // Загружаем React на главной странице
    }

    @RequestMapping(value = "/{path:[^\\.]*}") // Все пути, кроме статических файлов, ведут на React
    public String reactRoutes(HttpServletRequest request) {
        Resource indexHtml = resourceLoader.getResource("classpath:/static/index.html");

        try {
            if (indexHtml.exists() && indexHtml.getFile().length() > 0) {
                return "forward:/index.html";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "error/404";
    }
    @RequestMapping(value = "/swagger-ui/")
    public String swagger() {
        return "redirect:/swagger-ui/index.html";
    }
    /*
    @RequestMapping(value = "/")
    public String index() {
        return "forward:/index.html"; // Главная страница загружает React
    }



    @RequestMapping(value = "/{path:[^\\.]*}") // Все пути, кроме файлов с точкой, ведут на React
    public String reactRoutes() {
        return "forward:/index.html";
    }
    *
     */
}
