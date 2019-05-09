package com.finalproject.couchpotato.controller;

import com.finalproject.couchpotato.Reviews;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
    Reviews review = new Reviews();

    @GetMapping("/editDeleteReview")
    public String editDeleteReview(Model model) {
        review.getAllReviews();
        model.addAttribute("review", Reviews.reviews);
        model.addAttribute("reviewEdit", new Reviews());
        return "editDeleteReview";
    }

        @GetMapping("/deleteReview")
    public String reviewToDelete(@RequestParam(value = "review_id", required = false,
            defaultValue = "1") int review_id, @ModelAttribute Reviews review, Model model) {
        Reviews r = new Reviews();
        for (Reviews rev : Reviews.reviews) {
            if (rev.getReview_id() == review.getReview_id()) {
                r = rev;
            }
        }
        model.addAttribute("review", r);
        review.deleteReview(review);
        return "editDeleteReview";
    }
    @GetMapping("/addReview")
    public String reviewToAdd(Model model) {
        int nextID = Reviews.reviews.size() + 1;
        System.out.println(nextID);
        Reviews review = new Reviews();
        review.setReview_id(nextID);
        model.addAttribute("review", review);
        return "addReview";
    }

    @PostMapping("/addingReview")
    public String reviewAdded(@ModelAttribute Reviews review) {
        review.addNewReview(review);
        return "editDeleteReview";
    }

    @PostMapping("/reviewSaved")
    public String reviewSaved(@ModelAttribute Reviews review) {
        review.updateReview(review);
        return "editDeleteReview";
    }
}
