import java.util.*;
import java.util.concurrent.TimeUnit;
public class practice {
    public static void main(String[] arg) {
        //설명 필요하면 게임 설명해주고 아니면 바로 시작
        //양 플레이어 카드 고를 때 상대방의 카드 목록도 볼 수 있게끔
        Scanner Scan = new Scanner(System.in);
        Random rand = new Random();
        boolean incardlist1;
        boolean incardlist2;
        String nextment;
        int player1score = 0;
        int player2score = 0;
        int musungbu = 0;
        int player1cardinput;
        int player2cardinput;
        ArrayList player1cardlist = new ArrayList();
        ArrayList player2cardlist = new ArrayList();
        for (int i = 0; i <= 5; i++) {
            player1cardlist.add(i);
            player2cardlist.add(i);
        }
        System.out.println("숫자 심리 게임 시작합니다!");
        nextment = Scan.nextLine();
        for (int aaaa = 1; aaaa <= 6; aaaa++) {
            System.out.println(aaaa + "번째 게임 시작합니다!");
            System.out.println("카드 선택 시간!");
            nextment = Scan.nextLine();
            System.out.println("player1이 먼저 카드를 선택합니다.\nplayer2는 화면을 보지 말아주세요!");
            nextment = Scan.nextLine();
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
            System.out.print("player1 카드 목록 : ");
            for (int i = 0; i < player1cardlist.size(); i++) {
                System.out.print(player1cardlist.get(i));
                System.out.print(" ");
            }
            System.out.println("\n목록 중 카드를 하나 선택해주세요!");
            do {
                System.out.print("\n카드 입력 : ");
                player1cardinput = Scan.nextInt();
                incardlist1 = false;
                for (int i = 0; i <= player1cardlist.size()-1; i++) {
                    if ((int)player1cardlist.get(i) == player1cardinput) {
                        incardlist1 = true;
                        player1cardlist.remove(i);
                        break;
                    }
                }
                if (!incardlist1) {
                    System.out.println("목록 내에 없는 수입니다!\n다시 입력해주세요!");
                    System.out.print("player1 카드 목록 : ");
                    for (int i = 0; i < 5; i++) {
                        System.out.print(player1cardlist.get(i));
                        System.out.print(" ");
                    }
                } else {
                    break;
                }
            } while (!incardlist1);
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
            System.out.println("player2가  카드를 선택합니다.\nplayer1은 화면을 보지 말아주세요!\n 10초 후에 나타납니다.");
            nextment = Scan.nextLine();
            nextment = Scan.nextLine();
            System.out.print("player2 카드 목록 : ");
            for (int i = 0; i < player2cardlist.size(); i++) {
                System.out.print(player2cardlist.get(i));
                System.out.print(" ");
            }
            System.out.println("\n목록 중 카드를 하나 선택해주세요!");
            do {
                System.out.print("\n카드 입력 : ");
                player2cardinput = Scan.nextInt();
                incardlist2 = false;
                for (int i = 0; i <= player2cardlist.size()-1; i++) {
                    if ((int)player2cardlist.get(i) == player2cardinput) {
                        incardlist2 = true;
                        player2cardlist.remove(i);
                        break;
                    }
                }
                if (!incardlist2) {
                    System.out.println("목록 내에 없는 수입니다!\n다시 입력해주세요!");
                    System.out.print("player1 카드 목록 : ");
                    for (int i = 0; i < 5; i++) {
                        System.out.print(player2cardlist.get(i));
                        System.out.print(" ");
                    }
                } else {
                    break;
                }
            } while (!incardlist2);
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
            nextment = Scan.nextLine();
            System.out.println("player1이 선택한 카드: " + player1cardinput);
            System.out.println("player2가 선택한 카드: " + player2cardinput);
            if ((player1cardinput > player2cardinput && player1cardinput != 0 && player1cardinput != 2) || (player1cardinput == 0 && player2cardinput == 2) || (player1cardinput == 2 && player2cardinput == 5)) {
                System.out.println("player1 승리!");
                player1score += player1cardinput + player2cardinput;
            } else if (player1cardinput < player2cardinput) {
                System.out.println("player2 승리!");
                player2score += player1cardinput + player2cardinput;
            } else {
                System.out.println("무승부입니다!");
                musungbu += 1;
            }
            nextment = Scan.nextLine();
            System.out.println("현재 스코어 " + player1score + ":" + player2score);
            nextment = Scan.nextLine();
        }
        System.out.println("최종 스코어 "  + player1score + ":" + player2score);
        if (player1score > player2score) {
            System.out.println("player1이 이겼습니다!");
        } else if (player2score == player1score) {
            System.out.println("player2가 이겼습니다!");
        } else {
            System.out.println("무승부입니다.");
            //무승부면 게임 다시 시작하게끔
        }
    }
}