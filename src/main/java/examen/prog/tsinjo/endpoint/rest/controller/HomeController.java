package examen.prog.tsinjo.endpoint.rest.controller;

import examen.prog.tsinjo.dto.DonationRequest;
import examen.prog.tsinjo.services.DonationService;
import examen.prog.tsinjo.services.HelpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class HomeController {
  private final DonationService donationService;
  private final HelpService helpService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("form", new DonationRequest());
    model.addAttribute("donations", donationService.getAllDonations());
    model.addAttribute("helps", helpService.getAllHelps());
    return "index";
  }

  @PostMapping("/donate")
  public String submitDonation(@ModelAttribute DonationRequest request) {
    donationService.saveDonation(request);
    return "redirect:/";
  }
}
