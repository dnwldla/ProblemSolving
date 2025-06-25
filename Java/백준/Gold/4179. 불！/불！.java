import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] fireVisited;
    static boolean[][] locVisited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= R || y < 0 || y >= C;
    }

    static boolean isWall(int x, int y) {
        return map[x][y] == '#';
    }

    static boolean isEdge(int x, int y) {
        return x == 0 || y == 0 || x == R - 1 || y == C - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        fireVisited = new boolean[R][C];
        locVisited = new boolean[R][C];

        Queue<int[]> fireQ = new LinkedList<>();
        Queue<int[]> locQ = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'J') {
                    locQ.add(new int[]{i, j});
                    locVisited[i][j] = true;
                } else if (map[i][j] == 'F') {
                    fireQ.add(new int[]{i, j});
                    fireVisited[i][j] = true;
                }
            }
        }

        // 시작부터 가장자리면 탈출 성공
        int[] start = locQ.peek();
        if (isEdge(start[0], start[1])) {
            System.out.println(1);
            return;
        }

        int time = 0;
        while (!locQ.isEmpty()) {
            time++;

            // 불 먼저 확산
            int fireSize = fireQ.size();
            while (fireSize-- > 0) {
                int[] fire = fireQ.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = fire[0] + dx[d];
                    int ny = fire[1] + dy[d];

                    if (outOfRange(nx, ny)) continue;
                    if (isWall(nx, ny) || fireVisited[nx][ny]) continue;

                    fireVisited[nx][ny] = true;
                    fireQ.add(new int[]{nx, ny});
                }
            }

            // 지훈 이동
            int locSize = locQ.size();
            while (locSize-- > 0) {
                int[] loc = locQ.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = loc[0] + dx[d];
                    int ny = loc[1] + dy[d];

                    if (outOfRange(nx, ny)) continue;
                    if (isWall(nx, ny) || locVisited[nx][ny] || fireVisited[nx][ny]) continue;

                    if (isEdge(nx, ny)) {
                        System.out.println(time + 1);
                        return;
                    }

                    locVisited[nx][ny] = true;
                    locQ.add(new int[]{nx, ny});
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
