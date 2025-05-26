import java.util.*;

public class S {

    public static int levenshteinDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i = 0; i<=m; i++) dp[i][0] = i;
        for(int j = 0; j<=n; j++) dp[0][j] = j;
        
        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), 
                    dp[i-1][j-1]);
                }
            }
        }
        
        return dp[m][n];
    }

    public static String Word(String input, List<String> dictionary) {
        String Word = null;
        int minDistance = Integer.MAX_VALUE;

        for (String word : dictionary) {
            int distance = levenshteinDistance(input.toLowerCase(), word.toLowerCase());
            if (distance < minDistance) {
                minDistance = distance;
                Word = word;
            }
        }

        return Word;
    }

    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList(
            "cred", "bet", "shat", "that", "brad", "cart", "brat", "card"
        );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = scanner.nextLine();

        String closestword = Word(input, dictionary);

        System.out.println("Output " + closestword);
        scanner.close();
    }
}

