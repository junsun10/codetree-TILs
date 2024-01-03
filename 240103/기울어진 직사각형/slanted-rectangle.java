import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
    }

    static void solution() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                re(i,j);
            }
        }
        System.out.println(answer);
    }

    static void re(int x, int y) {
        int temp = 0;
        for(int i=1; i<=n-2; i++) {
            for(int j=1; j<=n-2; j++) {
                if (x+i<n & y-i>=0 & x+i+j<n & y-i+j<n & x+j<n & y+j<n) {
                    temp = count(x,y,i,j);
                    answer = Math.max(temp, answer);
                }
            }
        }
    }

    static int count(int x, int y, int l1, int l2) {
        int c = 0;
        for(int i=0; i<=l1; i++) {
            c += arr[x+i][y-i];
        }
        for(int i=0; i<=l2; i++) {
            c += arr[x+l1+i][y-l1+i];
        }
        for(int i=0; i<=l1; i++) {
            c += arr[x+l2+i][y+l2-i];
        }
        for(int i=0; i<=l2; i++) {
            c += arr[x+i][y+i];
        }
        // System.out.println(c);
        c -= arr[x][y] + arr[x+l1][y-l1] + arr[x+l1+l2][y-l1+l2] + arr[x+l2][y+l2];
        // System.out.printf("%d %d %d %d %d\n",x, y, l1, l2, c);
        return c;
    }
}