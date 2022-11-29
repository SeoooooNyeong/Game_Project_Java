package Game;

import java.util.*;
public class Practice {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		String[][] a = new String[10][10];
		int x=0,y=0;
		//"\uD83D\uDFE3" 보라색 동그라미
		//"\uD83D\uDEAB"; 금지표시
		//"\u2B55" 빨간색 빈 동그라미""
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = "0";
				if(i == 0 && j ==0 ) {
					a[0][0] = "2";
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			int k = rand.nextInt(9)+1;
			int l = rand.nextInt(9)+1;
			a[k][l] = "1";
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
		int cnt = 0;
		String direction = "";
		while(cnt < 30) {
			System.out.println("한 칸씩 이동하게 됩니다. 원하시는 방향을 입력해주세요 ex)동, 서, 남, 북");
			direction = in.next();
			cnt++;
			if(direction.equals("동")) {
				if(y == 9) {
					System.out.println("갈 곳이 없어요!");
					cnt--;
					continue;
				}
				if(a[x][y+1] == "\uD83D\uDEAB") {
					System.out.println("금지 구역이에요!");
					cnt--;
					continue;
				}
				a[x][y] = "0";
				y++;
				a[x][y] = "2";
			} else if(direction.equals("서")){
				if(y == 0) {
					System.out.println("갈 곳이 없어요!");
					cnt--;
					continue;
				}
				if(a[x][y-1] == "\uD83D\uDEAB") {
					System.out.println("금지 구역이에요!");
					cnt--;
					continue;
				}
				a[x][y] = "0";
				y--;
				a[x][y] = "2";
			} else if(direction.equals("남")) {
				if(x == 9) {
					System.out.println("갈 곳이 없어요!");
					cnt--;
					continue;
				}
				if(a[x+1][y] == "\uD83D\uDEAB") {
					System.out.println("금지 구역이에요!");
					cnt--;
					continue;
				}
				a[x][y] = "0";
				x++;
				a[x][y] = "2";
			}else if(direction.equals("북")) {
				if(x == 0) {
					System.out.println("갈 곳이 없어요!");
					cnt--;
					continue;
				}
				if(a[x-1][y] == "\uD83D\uDEAB") {
					System.out.println("금지 구역이에요!");
					cnt--;
					continue;
				}
				a[x][y] = "0";
				x--;
				a[x][y] = "2";
			}else {
				System.out.println("정확한 방향을 다시 입력해주세요.");
				direction = in.next();
				cnt--;
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
		}
	}

}
