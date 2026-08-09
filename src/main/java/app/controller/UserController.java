package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Найти/показать пользователя, просто выводит все его поля
    @GetMapping("/{id}")
    public String findUserById(
            @PathVariable("id") Long id,
            Model model
    ){
        model.addAttribute("user", userService.findById(id));
       return "users/show";
    }

    // Стартовая строка/все пользователи
    @GetMapping("")
    public String findAll(ModelMap model) {

        model.addAttribute("users", userService.findAll());

        return "users/index";
    }

    // Создание нового пользователя. перенаправляет на -> метод create
    @GetMapping("/new")
    public String newUser(Model model) {

        model.addAttribute("user", new User());

        return "users/new";
    }

    // Метод извлекает атрибуты, находит нужные, создает пользователя
    @PostMapping("")
    public String create(
            @ModelAttribute("user") User user
    ) {

        userService.save(user);

        return "redirect:/users";
    }

    // обновляем поля пользователя. возвращает все поля,
    @GetMapping("/{id}/edit")
    public String edit(
            Model model,
            @PathVariable("id") Long id) {

        model.addAttribute(
                "user",
                userService.findById(id));

        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(
            @ModelAttribute("user") User user,
            @PathVariable("id") Long id) {

        userService.update(user);

        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable("id") Long id) {

        userService.delete(id);

        return "redirect:/users";
    }

}




