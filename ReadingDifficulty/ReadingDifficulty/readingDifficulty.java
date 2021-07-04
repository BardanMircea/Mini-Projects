package ReadingDifficulty;


import java.util.Scanner;


public class readingDifficulty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write a sentence: ");

        String sentence = scanner.nextLine();
        String[] words = sentence.toLowerCase().split(" ");
        String[] consonants = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
        String[] vowels = {"a", "e", "i", "o", "u"};
        String[] specialPairs = {"ch", "ei", "ie"};


        int[] scoreForWords = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            scoreForWords[i] = scoreForConsonants(words[i], consonants) + scoreForVowels(words[i], vowels) + scoreForSpecialPairs(words[i], specialPairs);
        }


        int scoreForSentence = 0;
        for (int i = 1; i < words.length; i++) {
            if (scoreForWords[i - 1] != 0 && scoreForWords[i] != 0) {
                scoreForSentence += 2;
            }
        }

        for (int i = 2; i < words.length; i++) {
            if (scoreForWords[i - 2] != 0 && scoreForWords[i] != 0) {
                scoreForSentence++;
            }
        }


        int totalScoreForWords = 0;
        for (var i = 0; i < words.length; i++) {
            totalScoreForWords += scoreForWords[i];
        }


        int finalScore = scoreForSentence + totalScoreForWords;

        for (int i = 0; i < words.length; i++) {
            System.out.println("Score for word '" + words[i] + "' is " + scoreForWords[i]);
        }

        System.out.println("Total score form words: " + totalScoreForWords);
        System.out.println("Reading difficulty score for sentence: " + scoreForSentence);
        System.out.println("Reading difficulty total score: " + totalScoreForWords + " + " + scoreForSentence + " = " + finalScore + ".");

    }


    public static int scoreForConsonants(String word, String[] consonants) {
        int pointsForConsonants = 0;

        char[] letters = word.toCharArray();
        int consonantsIndex = 0;
        int lettersIndex = 0;
        while (lettersIndex < letters.length) {
            if (!Character.toString(letters[lettersIndex]).matches(consonants[consonantsIndex])){

                if(consonantsIndex < consonants.length - 1) {
                    consonantsIndex++;

                }   else {
                    lettersIndex++;
                    consonantsIndex = 0;
                }
                continue;
            }

            if (lettersIndex > 0 && Character.toString(letters[lettersIndex - 1]).matches(consonants[consonantsIndex])) {
                pointsForConsonants++;
            }

            lettersIndex++;
        }

        return pointsForConsonants;
    }


    public static int scoreForSpecialPairs(String word, String[] specialPairs) {
        int pointsForPairs = 0;

        for (String specialPair: specialPairs) {
            if (word.contains(specialPair)) {
                pointsForPairs++;
            }
        }

        return pointsForPairs;
    }


    public static int scoreForVowels(String word, String[] vowels) {
        int pointsForVowels = 0;

        char[] letters = word.toCharArray();
        int consecutiveVowels = 0;
        int lettersIndex = 0;
        int vowelsIndex = 0;
        while (lettersIndex < letters.length) {
            if (!Character.toString(letters[lettersIndex]).matches(vowels[vowelsIndex])) {

                if (vowelsIndex < vowels.length - 1) {
                    vowelsIndex++;
                    continue;

                }   else {
                    consecutiveVowels = 0;
                    vowelsIndex = 0;
                }

            }   else {
                consecutiveVowels++;
                vowelsIndex = 0;

                    if (consecutiveVowels == 3) {
                        pointsForVowels++;
                    }
            }

            lettersIndex++;
        }

        return pointsForVowels;



    }

}