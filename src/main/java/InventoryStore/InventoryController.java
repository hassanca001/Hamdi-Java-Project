package InventoryStore;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class InventoryController {

    public final InventoryService service;


    public InventoryController(InventoryService service) {
        this.service = service;
    }

    //requests
    @GetMapping("/")
    public String getHomePage(){
        return "home";

    }

    @GetMapping("/Register")
    public String getAddItemPage(){
        return "Register";
    }

//    @GetMapping("/view")
//    public String getViewItemPage(){
//        return "viewAll";
//    }

    @PostMapping("/save")
    public String saveInventory(@ModelAttribute InventoryItem item){
        service.insertInventory(item);
        return "redirect:/";

    }

    @GetMapping("/All")
    public String getAllInventory(Model model, @Param("keyword") Long keyword){

        List< InventoryItem> list=service.getAllInventory(keyword);
        model.addAttribute("inventories", list);
        model.addAttribute("keyword", keyword);
        return "viewAll";

    }

    @RequestMapping("/delete/{id}")
    public String deleteInventory(@PathVariable Long id){
        service.deleteInventory(id);
        return "redirect:/All";

    }

    @RequestMapping("/Edit/{id}")
    public String updateInventory(@PathVariable Long id, Model model){
        InventoryItem item=service.getInventoryById(id);
        model.addAttribute("inventory", item);
        return "EditItem";
    }




}


