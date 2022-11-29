package Game;

import java.util.Random;
import java.util.Scanner;

public class Main_yuni {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		String[][] a = new String[10][10];
		int x1=0,y1=0;
		int x2=9, y2=9;
		//"\uD83D\uDFE3" 보라색 동그라미
		//"\uD83D\uDEAB"; 금지표시
		//"\u2B55" 빨간색 빈 동그라미""
		//"\u1F535" 파란색 동그라미 (몬스터)
	
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = "\uD83D\uDFE3";
				if(i == 0 && j ==0 ) {
					a[0][0] = "\u2B55";
				}
				else if(i==9 && j==9) {
					a[9][9] = "\u26AB";
				}
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			int k = rand.nextInt(9)+1;
			int l = rand.nextInt(9)+1;
			a[k][l] = "\uD83D\uDEAB";
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if(a[i][j].equals("0")) {
					a[i][j] = "\uD83D\uDFE3";
				}else if(a[i][j].equals("1")) {
					a[i][j] = "\uD83D\uDEAB";
				}else if(a[i][j].equals("2")) {
					a[i][j] = "\u2B55";
				}
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		 
		int r = 5;
		int cnt1 = 0;
		int cnt2 = 0;
		String direction1 = "";
		String direction2 = "";
		while(cnt1 < 3) {
			System.out.println("한 칸씩 이동하게 됩니다. 원하시는 방향을 입력해주세요 ex)동, 서, 남, 북");
			direction1 = in.next();
			cnt1++;
			if(direction1.equals("동")) {
				if(y1 == 9) {
					System.out.println("갈 곳이 없어요!");
					cnt1--;
					continue;
				}
				if(a[x1][y1+1] == "\uD83D\uDEAB") { // 금지
					System.out.println("금지 구역이에요!");
					cnt1--;
					continue;
				}
				a[x1][y1] = "\uD83D\uDFE3";
				y1++;
				a[x1][y1] = "\u2B55";
			} else if(direction1.equals("서")){
				if(y1 == 0) {
					System.out.println("갈 곳이 없어요!");
					cnt1--;
					continue;
				}
				if(a[x1][y1-1] == "\uD83D\uDEAB") {
					System.out.println("금지 구역이에요!");
					cnt1--;
					continue;
				}
				a[x1][y1] = "\uD83D\uDFE3";
				y1--;
				a[x1][y1] = "\u2B55";
			} else if(direction1.equals("남")) {
				if(x1 == 9) {
					System.out.println("갈 곳이 없어요!");
					cnt1--;
					continue;
				}
				if(a[x1+1][y1] == "\uD83D\uDEAB") {
					System.out.println("금지 구역이에요!");
					cnt1--;
					continue;
				}
				a[x1][y1] = "\uD83D\uDFE3";
				x1++;
				a[x1][y1] = "\u2B55";
			}else if(direction1.equals("북")) {
				if(x1 == 0) {
					System.out.println("갈 곳이 없어요!");
					cnt1--;
					continue;
				}
				if(a[x1-1][y1] == "\uD83D\uDEAB") {
					System.out.println("금지 구역이에요!");
					cnt1--;
					continue;
				}
				a[x1][y1] = "\uD83D\uDFE3";
				x1--;
				a[x1][y1] = "\u2B55";
			}else {
				System.out.println("정확한 방향을 다시 입력해주세요.");
				direction1 = in.next();
				cnt1--;
			}
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					System.out.print(a[i][j]);
				}
				System.out.println();
			}
			
		}
		while(cnt2 < 3) {
			System.out.println("한 칸씩 이동하게 됩니다. 원하시는 방향을 입력해주세요 ex)동, 서, 남, 북");
			direction2 = in.next();
			cnt2++;
			if(direction2.equals("동")) {
				if(y2 == 9) {
					System.out.println("갈 곳이 없어요!");
					cnt2--;
					continue;
				}
				if(a[x2][y2+1] == "\uD83D\uDEAB") {
					System.out.println("금지 구역이에요!");
					cnt2--;
					continue;
				}
				a[x2][y2] = "\uD83D\uDFE3";
				y2++;
				a[x2][y2] = "\u26AB";
			} else if(direction2.equals("서")){
				if(y2 == 0) {
					System.out.println("갈 곳이 없어요!");
					cnt2--;
					continue;
				}
				if(a[x2][y2-1] == "\uD83D\uDEAB") {
					System.out.println("금지 구역이에요!");
					cnt2--;
					continue;
				}
				a[x2][y2] = "\uD83D\uDFE3";
				y2--;
				a[x2][y2] = "\u26AB";
			} else if(direction2.equals("남")) {
				if(x2 == 9) {
					System.out.println("갈 곳이 없어요!");
					cnt2--;
					continue;
				}
				if(a[x2+1][y2] == "\uD83D\uDEAB") {
					System.out.println("금지 구역이에요!");
					cnt2--;
					continue;
				}
				a[x2][y2] = "\uD83D\uDFE3";
				x2++;
				a[x2][y2] = "\u26AB";
			}else if(direction2.equals("북")) {
				if(x2 == 0) {
					System.out.println("갈 곳이 없어요!");
					cnt2--;
					continue;
				}
				if(a[x2-1][y2] == "\uD83D\uDEAB") {
					System.out.println("금지 구역이에요!");
					cnt2--;
					continue;
				}
				a[x2][y2] = "\uD83D\uDFE3";
				x2--;
				a[x2][y2] = "\u26AB";
			}else {
				System.out.println("정확한 방향을 다시 입력해주세요.");
				direction2 = in.next();
				cnt2--;
			}
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					System.out.print(a[i][j]);
				}
				System.out.println();
			}
			
		}
		
	}

	

}
