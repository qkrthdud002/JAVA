package Subject03;

import java.lang.reflect.Array;
import java.util.Scanner;

public class game {

    public static void main(String[] args) {

        int win=0, lose=0, draw=0;

        String[] game = {"가위", "바위", "보"};

        Scanner sc = new Scanner(System.in);

        while(true) {
            double random = Math.random() * (game.length);
            int num = (int)random;

            System.out.println("** 가위바위보 가운데 하나를 입력하세요 **");
            System.out.println("--------------------------------------");
            System.out.print("(사용자) : ");
            String user = sc.next();

            try {
                if ((user.equals("가위") && game[num].equals("바위")) || (user.equals("바위") && game[num].equals("보")) || (user.equals("보") && game[num].equals("가위"))) {
                    System.out.println(user + " vs " + game[num]);
                    System.out.println("졌습니다.");
                    lose++;

                } else if ((user.equals("가위") && game[num].equals("보")) || (user.equals("바위") && game[num].equals("가위")) || (user.equals("보") && game[num].equals("바위"))) {
                    System.out.println(user + " vs " + game[num]);
                    System.out.println("이겼습니다.");
                    win++;

                } else if (user.equals(game[num])) {
                    System.out.println(user + " vs " + game[num]);
                    System.out.println("비겼습니다.");
                    draw++;

                } else if (user.equals("quit")) {
                    break;
                }

                System.out.println("====================================");
                System.out.printf("전적 : %d %d %d\n", win, draw, lose);
                System.out.println();

            }catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }
        System.out.printf("총전적 : %d %d %d", win, draw, lose);
    }
}
