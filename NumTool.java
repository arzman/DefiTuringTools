package main;

import java.util.ArrayList;
import java.util.Collections;

public class NumTool {

	public static boolean isPrime(long num) {

		boolean res;

		if (num == 1) {
			res = false;
		} else {

			if (num == 2) {
				res = true;
			} else {

				if (num % 2 == 0) {
					res = false;
				} else {

					long div = 3;
					boolean stop = false;
					res = true;
					while (!stop && div * div <= num) {

						if (num % div == 0) {
							stop = true;
							res = false;
						}
						div = div + 1;

					}

				}
			}

		}
		return res;

	}

	public static ArrayList<Long> divPropre(long num) {

		ArrayList<Long> tmp = new ArrayList<>();
		if (num != 1) {
			tmp.add(1L);
		}

		for (long div = 2; div * div < num; div++) {

			if (num % div == 0) {
				tmp.add(div);
				tmp.add(num / div);
			}
		}

		return tmp;

	}

	public static ArrayList<Long> primeFactor(long num) {

		ArrayList<Long> tmp = new ArrayList<>();

		if (isPrime(num)) {
			tmp.add(num);
		} else {

			if (num % 2 == 0) {
				tmp.addAll(primeFactor(num / 2));

				if (!tmp.contains(2L)) {
					tmp.add(2L);
				}

			} else {
				boolean stop = false;
				long div = 3;

				while (!stop) {
					if (num % div == 0 && NumTool.isPrime(div)) {

						tmp.addAll(primeFactor(num / div));

						if (!tmp.contains(div)) {
							tmp.add(div);
						}
						stop = true;

					} else {
						div = div + 2;
					}
				}

			}

		}

		return tmp;
	}

	public static long pgcd(long n, long m) {

		long res;

		long a = n;
		long b = m;

		while (b != 0) {

			res = a;
			a = b;
			b = res % b;

		}

		res = a;

		return res;

	}

	public static long euler(long n) {

		long phi = 1;
		if (n != 1 && n != 2) {
			ArrayList<Long> factor = primeFactorAll(n);
			Collections.sort(factor);

			long prev = factor.get(0);
			long k = 0;
			for (long div : factor) {

				if (div == prev) {
					k = k + 1;
				} else {

					phi = phi * (prev - 1) * ((long) Math.pow(prev, k - 1));
					k = 1;
				}

				prev = div;

			}
			phi = phi * (prev - 1) * ((long) Math.pow(prev, k - 1));
		}

		return phi;

	}

	public static ArrayList<Long> primeFactorAll(long num) {

		ArrayList<Long> tmp = new ArrayList<>();

		if (isPrime(num)) {
			tmp.add(num);
		} else {

			if (num % 2 == 0) {
				tmp.addAll(primeFactorAll(num / 2));

				tmp.add(2L);

			} else {
				boolean stop = false;
				long div = 3;

				while (!stop) {
					if (num % div == 0 && NumTool.isPrime(div)) {

						tmp.addAll(primeFactorAll(num / div));

						tmp.add(div);
						stop = true;

					} else {
						div = div + 2;
					}
				}

			}

		}

		return tmp;
	}

	public static long get2Triangulaire(long num) {
		return num * (num + 1);
	}

	public static long getTriangulaire(long num) {
		return get2Triangulaire(num) / 2;
	}

	public static boolean isTriangulaire(long num) {

		boolean res = false;

		for (long i = (long) (Math.sqrt(2 * num) - 1); i * i < 2 * num; i++) {

			if (i * (i + 1) == 2 * num) {
				res = true;
				break;
			}

		}

		return res;
	}

	public static long get2Pentagonal(long num) {
		return num * (3 * num - 1);
	}

	public static long getPentagonal(long num) {
		return get2Pentagonal(num) / 2;
	}

	public static boolean isPentagonal(long num) {

		boolean res = false;
		if (num == 1) {
			res = true;
		} else {
			for (long i = (long) Math.sqrt(2 * num / 3); i * i < num; i++) {

				if (i * (3 * i - 1) == 2 * num) {
					res = true;
					break;
				}

			}
		}

		return res;
	}

	public static long getHexagonal(long num) {
		return num * (2 * num - 1);
	}

	public static boolean isHexagonal(long num) {

		boolean res = false;

		if (num == 1) {
			res = true;
		} else {

			for (long i = (long) Math.sqrt(num / 2); i * i < num; i++) {

				if (i * (2 * i - 1) == num) {
					res = true;
					break;
				}

			}
		}

		return res;
	}

	public static boolean isPandigital(long num) {

		boolean res = true;
		String tmp = String.valueOf(num);

		for (int i = 1; res && i <= tmp.length(); i++) {

			res = tmp.contains(String.valueOf(i));
		}

		return res;
	}

	public static long racCube(long num) {

		long res = -1;
		long deb = (long) Math.exp(Math.log(num) / 3) - 1;
		for (long i = deb; i * i * i <= num; i++) {

			if (i * i * i == num) {
				res = i;
			}
		}

		return res;

	}
	
	public static long sumChiffreExp(long num, int exp){
		
		long res = 0;
		long tmp = num;
		
		while(tmp!=0){
			
			res = +res +  (long)( Math.pow(tmp%10, exp));
			tmp = tmp/10;
		}
		
		
		return res;
	}
	


}
