import java.util.Scanner;
class Solution {
    public int editDistance(String s1, String s2, int Ci, int Cd, int Cs) {
        int m = s1.length();
        int n = s2.length();
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i = 0; i<=m; i++) dp[i][0] = i * Cd;
        for(int j = 0; j<=n; j++) dp[0][j] = j * Ci;
        
        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1]+Ci, dp[i-1][j]+Cd), 
                    dp[i-1][j-1]+Cs);
                }
            }
        }
        
        return dp[m][n];
    }
}

public class StringCharacterInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input ");
        String s1 = scanner.next();
        String s2 = scanner.next();
        System.out.print("Ci=");
        Integer Ci = scanner.nextInt();
        System.out.print("Cd=");
        Integer Cd = scanner.nextInt();
        System.out.print("Cs=");
        Integer Cs = scanner.nextInt();
        Solution sl = new Solution();
        int s = sl.editDistance(s1, s2, Ci, Cd, Cs);
        System.out.println("Output " +s);
        scanner.close();
    }
}
