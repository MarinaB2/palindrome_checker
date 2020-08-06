package com.example.palindrome_checker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class PalindromeController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "input", required = false, defaultValue = "madam") String palindrome, Model model) {
        String[] words = palindrome.split(",");
        HashMap<String, Boolean> checkedWords = new HashMap<>();

        for (String word : words) {
            checkedWords.put(word.trim(), isPalindrome(word.toLowerCase().trim()));
        }

        model.addAttribute("words", checkedWords);
        return "Greeting";
    }

    public static boolean isPalindrome(String palindrome) {

        StringBuilder isPalindrome = new StringBuilder(palindrome);

        StringBuilder reverse = isPalindrome.reverse();

        if ((reverse.toString()).equals(palindrome)) {
            return true;

        }
        return false;
    }


}
