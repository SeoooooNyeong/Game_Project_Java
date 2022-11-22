import java.util.*;
class game3 {
    Random rand = new Random();
    Scanner Scan = new Scanner(System.in);
    String nextment;
    int player1length = 999;
    int player1height = 999;
    int player2length = 999;
    int player2height = 999;
    int poisonlength = rand.nextInt(9) + 1;
    int poisonheight = rand.nextInt(9) + 1;
    String[][] box = new String[9][9];
    int playercnt = 0;
    int break1;
    int breakwhile;
    static int player1score = 0;
    static int player2score = 0;
    String explainaion = "\n";
    void boxmaking() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                box[i][j] = "\uD83E\uDD5B";
            }
        }
    }

    void start() {
        System.out.print("안녕하세요! 독을 피해 물을 마셔라! 게임에 오신 것을 환영합니다!");
        System.out.println(poisonlength + " " + poisonheight);
        nextment = Scan.nextLine();
        System.out.println("설명이 필요하십니까?\nyes or no");
        while (!explainaion.equals("yes") || !explainaion.equals("no")) {
            explainaion = Scan.nextLine();
            if (explainaion.equals("yes")) {
                System.out.println("설명 ~~~~~~~~");
                nextment = Scan.nextLine();
                break;
            } else if (explainaion.equals("no")) {
                break;
            }
        }
        System.out.println("게임을 시작합니다!");
        nextment = Scan.nextLine();
    }

    void player1select() {
        breakwhile = 0;
        break1 = 0;
        playercnt += 1;
        if (playercnt == 1) {
            nowbox();
            player1masilmulselect();
            player1false();
            while (player1length > 9 || player1length < 1 || player1height > 9 || player1height < 1 || box[player1length-1][player1height-1].equals("물")) {
                player1notrange();
                nextment = Scan.nextLine();
                nowbox();
                player1masilmulselect();
            }
        } else {
            playertrue();
            nowbox();
            player1masilmulselect();
            player1false();
            if (breakwhile == 1) {
                return;
            }
            if (break1 == 1) {
                return;
            }
            while (player1length > 9 || player1length < 1 || player1height > 9 || player1height < 1 || box[player1length-1][player1height-1].equals("물")) {
                nextment = Scan.nextLine();
                player1notrange();
                nextment = Scan.nextLine();
                nowbox();
                player1masilmulselect();
            }
        }
        nextment = Scan.nextLine();
        box[player1length-1][player1height-1] = "\uD83D\uDEAB";
        if (playercnt == 5) {
            System.out.println("물을 마셨어요!");
            nextment = Scan.nextLine();
            System.out.println("player1은 독을 마시지 않았네요!");
            nextment = Scan.nextLine();
        }
    }

    void playertrue() {
        System.out.println("물을 마셨어요!");
        nextment = Scan.nextLine();

    }

    void player1false() {
        if (player1length == poisonlength && player1height == poisonheight) {
            System.out.println("player1이 독을 마셨습니다. ㅠㅠ");
            System.out.println("player2 승!");
            breakwhile = 1;
            player2score += 1;
        }
        if (playercnt != 1) {
            if (player1length == 99 && player1height == 99) {
                break1 = 1;
            }
        }
    }
    void player1notrange() {
        if (player1length > 9 || player1length < 1 || player1height > 9 || player1height < 1) {
            System.out.println("범위를 벗어났습니다. \n다시 입력해주세요!");
        } else {
            System.out.println("빈병이에요,, \n다시 입력해주세요.");
        }
    }

    void nowbox() {
        for (int l = 0; l < 9; l++) {
            for (int k = 0; k < 9; k++) {
                System.out.print(box[l][k] + " ");
            }
            System.out.println();
        }
    }

    void player1masilmulselect() {
        System.out.print("player1 마실 물 위치 선택 : ");
        player1length = Scan.nextInt();
        player1height = Scan.nextInt();
    }

    void player2select() {
        breakwhile = 0;
        break1 = 0;
        playercnt += 1;
        if (playercnt == 1) {
            nowbox();
            player2masilmulselect();
            player2false();
            while (player2length > 9 || player2length < 1 || player2height > 9 || player2height < 1 || box[player2length-1][player2height-1].equals("물")) {
                player2notrange();
                nextment = Scan.nextLine();
                nowbox();
                player2masilmulselect();
            }
        } else {
            playertrue();
            nowbox();
            player2masilmulselect();
            player2false();
            if (breakwhile == 1) {
                return;
            }
            if (break1 == 1) {
                return;
            }
            while (player2length > 9 || player2length < 1 || player2height > 9 || player2height < 1 || box[player2length-1][player2height-1].equals("물")) {
                nextment = Scan.nextLine();
                player2notrange();
                nextment = Scan.nextLine();
                nowbox();
                player2masilmulselect();
            }
        }
        nextment = Scan.nextLine();
        box[player2length-1][player2height-1] = "\uD83D\uDEAB";
        if (playercnt == 5) {
            System.out.println("물을 마셨어요!");
            nextment = Scan.nextLine();
            System.out.println("player1은 독을 마시지 않았네요!");
            nextment = Scan.nextLine();
        }
    }

    void player2false() {
        if (player2length == poisonlength && player2height == poisonheight) {
            System.out.println("player2이 독을 마셨습니다. ㅠㅠ");
            System.out.println("player1 승!");
            breakwhile = 1;
            player1score += 1;
        }
        if (playercnt != 1) {
            if (player1length == 99 && player1height == 99) {
                break1 = 1;
            }
        }
    }
    void player2notrange() {
        if (player2length > 9 || player2length < 1 || player2height > 9 || player2height < 1) {
            System.out.println("범위를 벗어났습니다. \n다시 입력해주세요!");
        } else {
            System.out.println("빈병이에요,, \n다시 입력해주세요.");
        }
    }

    void player2masilmulselect() {
        System.out.print("player2 마실 물 위치 선택 : ");
        player2length = Scan.nextInt();
        player2height = Scan.nextInt();
    }

    void whowin() {
        if (player1score > player2score) {
            System.out.println("player1이 이겼습니다!");
        } else {
            System.out.println("player2가 이겼습니다!");
        }
    }
}

public class game3modify {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        for (int kkk = 0; kkk < 3; kkk++) {
            game3 a = new game3();
            a.boxmaking();
            a.start();
            outwhile : while (true) {
                a.playercnt = 0;
                for (int i = 0; i < 5; i++) {
                    a.player1select();
                    if (a.breakwhile == 1) {
                        break outwhile;
                    }
                    if (a.break1 == 1) {
                        break;
                    }
                }
                a.playercnt = 0;
                for (int i = 0; i < 5; i++) {
                    a.player2select();
                    if (a.breakwhile == 1) {
                        break outwhile;
                    }
                    if (a.break1 == 1) {
                        break;
                    }
                }
            }
            if (kkk == 2) {
                a.whowin();
            }
        }
    }
}
