package org.interview.task7;

public class ValidPalindrome {
    //     palindrome is a string that reading right-to-left and left-to-right the same
//    it can be a word or even a sentence with words split by space, commas
    public static boolean isPalindrome(String s) {

//        we need to remove all non-alphabetic letters
        final String alphabeticLettersString = s.replaceAll("[^a-zA-Z0-9]", "");

//        fast track
        if (alphabeticLettersString.length() < 2) {
            return true;
        }
//        convert to all to lover-case
        final String lowerCaseAlphabeticLettersString = alphabeticLettersString.toLowerCase();

//        check that this is polindrome
        final StringBuilder stringBuilder = new StringBuilder(lowerCaseAlphabeticLettersString);
        final String reversedLowerCaseAlphabeticLettersString = stringBuilder.reverse().toString();


        return lowerCaseAlphabeticLettersString.equals(reversedLowerCaseAlphabeticLettersString);
    }
}
