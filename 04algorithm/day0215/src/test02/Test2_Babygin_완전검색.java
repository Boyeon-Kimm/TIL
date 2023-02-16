package test02;

import java.util.Arrays;

public class Test2_Babygin_완전검색 {
	public static void main(String[] args) {
		int[] cards = {1, 1, 2, 2, 3, 3};
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(i != j) {
					for(int k=0; k<6; k++) {
						if(k != i && k != j) {
							for(int l=0; l<6; l++) {
								if(l != i && l != j && l != k) {
									for(int m=0; m<6; m++) {
										if(m != i && m != j && m != k && m != l) {
											for(int n=0; n<6; n++) {
												if(n != i && n != j && n != k && n != l && n != m) {
													if(tripletOrRun(cards[i], cards[j], cards[k]) && tripletOrRun(cards[l], cards[m], cards[n])) {
														System.out.println("babygin!");
														return;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private static boolean tripletOrRun(int i, int j, int k) {
		return (i == j && j == k )||(j == i + 1 && k == i+2);
	}
}
