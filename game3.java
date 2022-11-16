//3판 플레이, 점수 추가 시스템, 현재 마신 물 출력

import java.util.*;
public class game2 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner Scan = new Scanner(System.in);
        String nextment;
        int player1length = 999;
        int player1height = 999;
        int player2length = 999;
        int player2height = 999;
        String[][] box = new String[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                box[i][j] = "?";
            }
        }
        int poisonlength = rand.nextInt(9) + 1;
        int poisonheight = rand.nextInt(9) + 1;
        System.out.print("게임시작");
        System.out.println(poisonlength + " " + poisonheight);
        nextment = Scan.nextLine();
        out : while (true) {
            int player1cnt = 0;
            out1 : for (int i = 0; i < 5; i++) {
                player1cnt += 1;
                if (player1cnt == 1) {
                    for (int l = 0; l < 9; l++) {
                        for (int k = 0; k < 9; k++) {
                            System.out.print(box[l][k] + " ");
                        }
                        System.out.println();
                    }
                    System.out.print("player1 마실 물 위치 선택 : ");

                    player1length = Scan.nextInt();
                    player1height = Scan.nextInt();
                    if (player1length == poisonlength && player1height == poisonheight) {
                        System.out.println("player1이 독을 마셨습니다. ㅠㅠ");
                        System.out.println("player2 승!");
                        break out;
                    }
                    while (player1length > 9 || player1length < 1 || player1height > 9 || player1height < 1 || box[player1length-1][player1height-1].equals("물")) {
                        if (player1length > 9 || player1length < 1 || player1height > 9 || player1height < 1) {
                            System.out.println("범위를 벗어났습니다. \n다시 입력해주세요!");
                        } else {
                            System.out.println("빈병이에요,, \n다시 입력해주세요.");
                        }
                        nextment = Scan.nextLine();
                        for (int l = 0; l < 9; l++) {
                            for (int k = 0; k < 9; k++) {
                                System.out.print(box[l][k] + " ");
                            }
                            System.out.println();
                        }
                        System.out.print("player1 마실 물 위치 선택 : ");
                        player1length = Scan.nextInt();
                        player1height = Scan.nextInt();
                    }
                } else {
                    box[player1length-1][player1height-1] = "물";
                    System.out.println("물을 마셨어요!");
                    nextment = Scan.nextLine();
                    nextment = Scan.nextLine();
                    for (int l = 0; l < 9; l++) {
                        for (int k = 0; k < 9; k++) {
                            System.out.print(box[l][k] + " ");
                        }
                        System.out.println();
                    }
                    System.out.print("player1 마실 물 위치 선택 : ");
                    player1length = Scan.nextInt();
                    player1height = Scan.nextInt();
                    if (player1length == poisonlength && player1height == poisonheight) {
                        System.out.println("player1이 독을 마셨습니다. ㅠㅠ");
                        System.out.println("player2 승!");
                        break out;
                    } else if (player1length == 99 && player1height == 99) {
                        break out1;
                    }
                    while (player1length > 9 || player1length < 1 || player1height > 9 || player1height < 1 || box[player1length-1][player1height-1].equals("물")) {
                        if (player1length > 9 || player1length < 1 || player1height > 9 || player1height < 1) {
                            System.out.println("범위를 벗어났습니다. \n다시 입력해주세요!");
                        } else {
                            System.out.println("빈병이에요,, \n다시 입력해주세요.");
                        }
                        nextment = Scan.nextLine();
                        for (int l = 0; l < 9; l++) {
                            for (int k = 0; k < 9; k++) {
                                System.out.print(box[l][k] + " ");
                            }
                            System.out.println();
                        }
                        System.out.print("player1 마실 물 위치 선택 : ");
                        player1length = Scan.nextInt();
                        player1height = Scan.nextInt();
                    }
                }
            }
            nextment = Scan.nextLine();
            box[player1length-1][player1height-1] = "물";
            System.out.println("player1은 독을 마시지 않았네요!");
            nextment = Scan.nextLine();
            nextment = Scan.nextLine();









            System.out.println("player2가 마실 차례");
            int player2cnt = 0;
            out2 : for (int i = 0; i < 5; i++) {
                player2cnt += 1;
                if (player2cnt == 1) {
                    for (int l = 0; l < 9; l++) {
                        for (int k = 0; k < 9; k++) {
                            System.out.print(box[l][k] + " ");
                        }
                        System.out.println();
                    }
                    System.out.print("player2 마실 물 위치 선택 : ");

                    player2length = Scan.nextInt();
                    player2height = Scan.nextInt();
                    if (player2length == poisonlength && player2height == poisonheight) {
                        System.out.println("player2이 독을 마셨습니다. ㅠㅠ");
                        System.out.println("player1 승!");
                        break out;
                    }
                    while (player2length > 9 || player2length < 1 || player2height > 9 || player2height < 1 || box[player2length-1][player2height-1].equals("물")) {
                        if (player2length > 9 || player2length < 1 || player2height > 9 || player2height < 1) {
                            System.out.println("범위를 벗어났습니다. \n다시 입력해주세요!");
                        } else {
                            System.out.println("빈병이에요,, \n다시 입력해주세요.");
                        }
                        nextment = Scan.nextLine();
                        for (int l = 0; l < 9; l++) {
                            for (int k = 0; k < 9; k++) {
                                System.out.print(box[l][k] + " ");
                            }
                            System.out.println();
                        }
                        System.out.print("player2 마실 물 위치 선택 : ");
                        player2length = Scan.nextInt();
                        player2height = Scan.nextInt();
                    }
                } else {
                    box[player2length-1][player2height-1] = "물";
                    System.out.println("물을 마셨어요!");
                    nextment = Scan.nextLine();
                    nextment = Scan.nextLine();
                    for (int l = 0; l < 9; l++) {
                        for (int k = 0; k < 9; k++) {
                            System.out.print(box[l][k] + " ");
                        }
                        System.out.println();
                    }
                    System.out.print("player2 마실 물 위치 선택 : ");
                    player2length = Scan.nextInt();
                    player2height = Scan.nextInt();
                    if (player2length == poisonlength && player2height == poisonheight) {
                        System.out.println("player2이 독을 마셨습니다. ㅠㅠ");
                        System.out.println("player1 승!");
                        break out;
                    } else if (player2length == 99 && player2height == 99) {
                        break out2;
                    }
                    while (player2length > 9 || player2length < 1 || player2height > 9 || player2height < 1 || box[player2length-1][player2height-1].equals("물")) {
                        if (player2length > 9 || player2length < 1 || player2height > 9 || player2height < 1) {
                            System.out.println("범위를 벗어났습니다. \n다시 입력해주세요!");
                        } else {
                            System.out.println("빈병이에요,, \n다시 입력해주세요.");
                        }
                        nextment = Scan.nextLine();
                        for (int l = 0; l < 9; l++) {
                            for (int k = 0; k < 9; k++) {
                                System.out.print(box[l][k] + " ");
                            }
                            System.out.println();
                        }
                        System.out.print("player2 마실 물 위치 선택 : ");
                        player2length = Scan.nextInt();
                        player2height = Scan.nextInt();
                    }
                }
            }
            nextment = Scan.nextLine();
            box[player2length-1][player2height-1] = "물";
            System.out.println("player2는 독을 마시지 않았네요!");
            nextment = Scan.nextLine();
            nextment = Scan.nextLine();
        }
    }
}
