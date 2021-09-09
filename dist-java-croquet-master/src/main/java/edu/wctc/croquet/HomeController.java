package edu.wctc.croquet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class HomeController {
    private String[] rules;
    private GlossaryTerm[] terms;

    @PostConstruct
    private void initData() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            rules = mapper.readValue(Paths.get("croquetRules.json").toFile(), String[].class);
        } catch (IOException e) {
            e.printStackTrace();
            rules = new String[0];
        }

        try {
            terms = mapper.readValue(Paths.get("croquetGlossary.json").toFile(), GlossaryTerm[].class);
        } catch (IOException e) {
            e.printStackTrace();
            terms = new GlossaryTerm[0];
        }

    }

    @RequestMapping("/rules")
    public String showRulesPage(Model model) {
        model.addAttribute("pageTitle", "Rules of Golf Croquet");
        model.addAttribute("rules", rules);

        return "croquet-rules";
    }

    @RequestMapping("/terms")
    public String showGlossaryPage(Model model) {
        model.addAttribute("pageTitle", "Golf Croquet Glossary");
        model.addAttribute("terms", terms);

        return "croquet-glossary";
    }

    @RequestMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("pageTitle", "Pewaukee Golf Croquet Association");

        return "index";
    }
}
