package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OfferController {

    // Controller -> Service -> Dao
    @Autowired
    private OfferService offerService;

    @GetMapping("/offers")
    public String showOffers(Model model) {
        List<Offer> offers = offerService.getAllOffers();
        model.addAttribute("id_offers", offers);

        return "offers";
    }

    @GetMapping("/createoffer")
    public String createOffer(Model model) {

        model.addAttribute("offer", new Offer());  // 새로운 Offer Bean 객체를 만들고 Model에 넣어준다.

        return "createoffer";   // 그리고 view로 return
    }

    @PostMapping("/docreate")
    public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
        // offer class는 Model/Offer 안의 클래스에 data binding됨(name, email, text).
        // @Valid를 하여 검증 결과를 result에 넣음.
        // result만 보면 검증 결과를 확인할 수 있음.

//        System.out.println(offer);
        if (result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for (ObjectError error : errors) {
                System.out.println(error.getDefaultMessage());  // for loop를 돌며 각각의 error print
            }

            return "createoffer";
        }

        // Controller -> Service -> Dao
        offerService.insert(offer);   // error가 없으면 DB에 offer정보를 저장.

        return "offercreated";
    }
}
