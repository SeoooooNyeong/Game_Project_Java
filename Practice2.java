package Game;
import java.util.*;
class maingame {
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    String[][] a = new String[10][10];
    int x1=0,y1=0;
    int x2=9, y2=9;
    String nextment = "\n";
    int playerheart = 100;
    void boardmaking() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                a[i][j] = "\uD83D\uDFE3"; // 일반칸
            }
        }
        a[0][0] = "\u2B55"; // 플레이어 말
        a[9][9] = "\u26AB"; // 몬스터 
        for (int i = 0; i < 10; i++) {
            int k = rand.nextInt(9)+1;
            int l = rand.nextInt(9)+1;
            while(!a[k][l].equals("\uD83D\uDFE3")) {
                k = rand.nextInt(9) + 1;
                l = rand.nextInt(9) + 1;
            }
            a[k][l] = "\uD83D\uDEAB"; // 금지칸
        }
        for (int i = 0; i < 3; i++) {
            int k = rand.nextInt(9) + 1;
            int l = rand.nextInt(9) + 1;
            while(!a[k][l].equals("\uD83D\uDFE3")) {
                k = rand.nextInt(9) + 1;
                l = rand.nextInt(9) + 1;
            }
            a[k][l] = "\u2665"; // 하트칸
        }
        for (int i = 0; i < 3; i++) {
            int k = rand.nextInt(9) + 1;
            int l = rand.nextInt(9) + 1;
            while(!a[k][l].equals("\uD83D\uDFE3")) {
                k = rand.nextInt(9) + 1;
                l = rand.nextInt(9) + 1;
            }
            a[k][l] = "\u24BC"; // 미니게임칸 유니코드 추가해야함
        }
    }
    void start() {
        System.out.print("안녕하세요! 탈출구 찾기! 게임에 오신 것을 환영합니다!");
        nextment = in.nextLine();
        // 설명 gui 추가
    }
    void banmaking() {
        System.out.println("몬스터측 플레이어는 원하는 3곳에 벽을 쌓을 수 있습니다.");
        System.out.println("단 미니게임칸이나 체력칸, 플레이어 시작 지점을 완전히 막는 행위는 금지됩니다.");
        nextment = in.nextLine();
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 10; k++) {
                for (int l = 0; l < 10; l++) {
                    System.out.print(a[k][l]);
                }
                System.out.println();
            }
            System.out.print("벽을 쌓을 곳을 선택해주세요 : ");
            int k = in.nextInt();
            int l = in.nextInt();
            while(k - 1 > 10 || k - 1 < 0 || l - 1 > 10 || l - 1 < 0 || (!a[k-1][l-1].equals("\uD83D\uDFE3"))) {
                System.out.println("벽을 쌓을 수 없습니다. 다시 선택해주세요");
                nextment = in.nextLine();
                nextment = in.nextLine();
                for (int q = 0; q < 10; q++) {
                    for (int w = 0; w < 10; w++) {
                        System.out.print(a[q][w]);
                    }
                    System.out.println();
                }
                System.out.print("벽을 쌓을 곳을 선택해주세요 : ");
                k = in.nextInt();
                l = in.nextInt();
            }
            a[k-1][l-1] = "\uD83D\uDEAB"; // 금지칸
        }
    }
    void peopleplayermoving() {
    	int minigamecnt = 0;
        String direction1 = "";
        Dice2 d = new Dice2();
        d.DiceNum();
        int cnt = d.ran;
        while (true){
            if (cnt == 0) {
                break;
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(a[i][j]);
                }
                System.out.println();
            }
            System.out.println("용사 플레이어 한 칸씩 이동하게 됩니다. 원하시는 방향을 입력해주세요 ex)동, 서, 남, 북");
            System.out.print("방향 입력 : ");
            direction1 = in.next();
            if(direction1.equals("동")) {
                if(y1 == 9) {
                    System.out.println("갈 곳이 없어요!");
                    continue;
                } else if(a[x1][y1+1].equals("\uD83D\uDEAB")) { // 금지
                    System.out.println("금지 구역이에요!");
                    continue;
                }else if (a[x1][y1+1].equals("\u2665")) {
                    System.out.println("하트를 먹어서 체력 30 증가");
                    playerheart += 30;
                    if (playerheart > 100) {
                        playerheart = 100;
                    }
                    System.out.println("현제 플레이어 체력 : " + playerheart);
                    System.out.println("현재 플레이어 체력 : " + playerheart);
                } else if (a[x1][y1+1].equals("\u26AB")) {
                    // 인간 체력감소, 말 따로 저장해놔
                } else if(a[x1][y1+1].equals("\\u24BC")){
                	minigamecnt ++;
                	if(minigamecnt == 1) {
                		Minigame1.mini1main(null);
                	}else if(minigamecnt == 2) {
                		MiniGame2.mimigame2(null);
                	}else if(minigamecnt == 3) {
                		Minigame3.mini3main(null);
                		minigamecnt = 0;
                	}
                }
                else {
                    a[x1][y1] = "\uD83D\uDFE3";
                    y1++;
                    a[x1][y1] = "\u2B55";
                    cnt -= 1;
                }
            } else if(direction1.equals("서")){
                if(y1 == 0) {
                    System.out.println("갈 곳이 없어요!");
                    continue;
                }else if(a[x1][y1-1].equals("\uD83D\uDEAB")) {
                    System.out.println("금지 구역이에요!");
                    continue;
                }else if (a[x1][y1-1].equals("\u2665")) {
                    System.out.println("하트를 먹어서 체력 30 증가");
                    playerheart += 30;
                    if (playerheart > 100) {
                        playerheart = 100;
                    }
                    System.out.println("현제 플레이어 체력 : " + playerheart);
                }  else if(a[x1][y1-1].equals("\\u24BC")){
                	minigamecnt ++;
                	if(minigamecnt == 1) {
                		Minigame1.mini1main(null);
                	}else if(minigamecnt == 2) {
                		MiniGame2.mimigame2(null);
                	}else if(minigamecnt == 3) {
                		Minigame3.mini3main(null);
                		minigamecnt = 0;
                	}
                }else {
                    a[x1][y1] = "\uD83D\uDFE3";
                    y1--;
                    a[x1][y1] = "\u2B55";
                    cnt -= 1;
                }
            } else if(direction1.equals("남")) {
                if(x1 == 9) {
                    System.out.println("갈 곳이 없어요!");
                    continue;
                } else if(a[x1+1][y1].equals("\uD83D\uDEAB")) {
                    System.out.println("금지 구역이에요!");
                    continue;
                } else if (a[x1+1][y1].equals("\u2665")) {
                    System.out.println("하트를 먹어서 체력 30 증가");
                    playerheart += 30;
                    if (playerheart > 100) {
                        playerheart = 100;
                    }
                    System.out.println("현제 플레이어 체력 : " + playerheart);
                }  else if(a[x1+1][y1].equals("\\u24BC")){
                	minigamecnt ++;
                	if(minigamecnt == 1) {
                		Minigame1.mini1main(null);
                	}else if(minigamecnt == 2) {
                		MiniGame2.mimigame2(null);
                	}else if(minigamecnt == 3) {
                		Minigame3.mini3main(null);
                		minigamecnt = 0;
                	}
                }else {
                    a[x1][y1] = "\uD83D\uDFE3";
                    x1++;
                    a[x1][y1] = "\u2B55";
                    cnt -= 1;
                }
            }else if(direction1.equals("북")) {
                if(x1 == 0) {
                    System.out.println("갈 곳이 없어요!");
                    continue;
                } else if(a[x1-1][y1].equals("\uD83D\uDEAB")) {
                    System.out.println("금지 구역이에요!");
                    continue;
                } else if (a[x1-1][y1].equals("\u2665")) {
                    System.out.println("하트를 먹어서 체력 30 증가");
                    playerheart += 30;
                    if (playerheart > 100) {
                        playerheart = 100;
                    }
                    System.out.println("현제 플레이어 체력 : " + playerheart);
                } else if(a[x1-1][y1].equals("\\u24BC")){
                	minigamecnt ++;
                	if(minigamecnt == 1) {
                		Minigame1.mini1main(null);
                	}else if(minigamecnt == 2) {
                		MiniGame2.mimigame2(null);
                	}else if(minigamecnt == 3) {
                		Minigame3.mini3main(null);
                		minigamecnt = 0;
                	}
                } else {
                    a[x1][y1] = "\uD83D\uDFE3";
                    x1--;
                    a[x1][y1] = "\u2B55";
                    cnt -= 1;
                }
            }else {
                System.out.println("정확한 방향을 다시 입력해주세요.");
                direction1 = in.next();
            }
        }
    }
    void monsterplayermoving() {
        String direction2 = "";
        Dice2 d = new Dice2();
        d.DiceNum();
        int cnt = d.ran;
        while (true) {
            System.out.println("몬스터 플레이어 한 칸씩 이동하게 됩니다. 원하시는 방향을 입력해주세요 ex)동, 서, 남, 북");
            System.out.print("방향 입력 : ");
            direction2 = in.next();
            if(direction2.equals("동")) {
                if(y2 == 9) {
                    System.out.println("갈 곳이 없어요!");
                    continue;
                    
                } else if(a[x2][y2+1].equals("\uD83D\uDEAB")) {
                    System.out.println("금지 구역이에요!");
                    continue;
                } else {
                    a[x2][y2] = "\uD83D\uDFE3";
                    y2++;
                    a[x2][y2] = "\u26AB";
                    cnt -= 1;
                }
            } else if(direction2.equals("서")){
                if(y2 == 0) {
                    System.out.println("갈 곳이 없어요!");
                    continue;
                } else if(a[x2][y2-1].equals("\uD83D\uDEAB")) {
                    System.out.println("금지 구역이에요!");
                    continue;
                } else {
                    a[x2][y2] = "\uD83D\uDFE3";
                    y2--;
                    a[x2][y2] = "\u26AB";
                    cnt -= 1;
                }
            } else if(direction2.equals("남")) {
                if(x2 == 9) {
                    System.out.println("갈 곳이 없어요!");
                    continue;
                } else if(a[x2+1][y2].equals("\uD83D\uDEAB")) {
                    System.out.println("금지 구역이에요!");
                    continue;
                } else {
                    a[x2][y2] = "\uD83D\uDFE3";
                    x2++;
                    a[x2][y2] = "\u26AB";
                    cnt -= 1;
                }
            }else if(direction2.equals("북")) {
                if(x2 == 0) {
                    System.out.println("갈 곳이 없어요!");
                    continue;
                } else if(a[x2-1][y2].equals("\uD83D\uDEAB")) {
                    System.out.println("금지 구역이에요!");
                    continue;
                } else {
                    a[x2][y2] = "\uD83D\uDFE3";
                    x2--;
                    a[x2][y2] = "\u26AB";
                    cnt -= 1;
                }
            }else {
                System.out.println("정확한 방향을 다시 입력해주세요.");
                direction2 = in.next();
            }
        }
    }
}
public class Practice2 {
    public static void main(String[] args) {
        maingame a = new maingame();
        a.boardmaking();
        a.start();
        a.banmaking();
        while(true) {
            a.peopleplayermoving();
            a.monsterplayermoving();
        }
    }
}
class Dice2 {
    int ran;
    void DiceNum() {
        ran = (int) ((Math.random() * 6) + 1);
        if (ran == 1) {
            System.out.println("\u2680");
        }
        if (ran == 2) {
            System.out.println("\u2681");
        }
        if (ran == 3) {
            System.out.println("\u2682");
        }
        if (ran == 4) {
            System.out.println("\u2683");
        }
        if (ran == 5) {
            System.out.println("\u2684");
        }
        if (ran == 6) {
            System.out.println("\u2685");
        }
    }
}
