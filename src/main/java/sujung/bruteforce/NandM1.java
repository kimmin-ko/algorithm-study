package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class NandM1 {

    private static boolean[] used;
    private static int[] sequence;
    private static int N, M;
    private static StringBuilder answer;

    /**
     * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            used = new boolean[N];
            sequence = new int[M];
            answer = new StringBuilder();
            go(0);
            System.out.println(answer);
        }
    }

    private static void go(int index) {
        if(index >= M) {
            for(int x : sequence) {
                answer.append(x+1).append(" ");
            }
            answer.append("\n");
            return;
        }
        for(int i=0; i<N; i++) {
            if(!used[i]) {
                used[i] = true;
                sequence[index] = i;
                go(index+1);
                used[i] = false;
            }
        }
    }
}
