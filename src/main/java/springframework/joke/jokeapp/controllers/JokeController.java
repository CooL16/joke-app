package springframework.joke.jokeapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springframework.joke.jokeapp.services.JokeService;

@Controller
public class JokeController {

    private JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String showJoke(Model model) {

        model.addAttribute("joke", jokeService.getJoke());

        return "chucknorris";
    }

}
