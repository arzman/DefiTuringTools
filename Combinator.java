package main;

import java.util.Arrays;

public class Combinator {

	private int k;
	private int n;

	private long numComb;
	private int[] indexes;

	private boolean bypass;

	private long total;

	public Combinator(int an, int ak, boolean aBypass) {

		k = ak;
		n = an;
		bypass = aBypass;

		numComb = 0;
		indexes = new int[k];
		if (!bypass) {
			total = cnk(n, k);
		}

	}

	public boolean hasNext() {
		return (numComb < total) || bypass;
	}

	public int[] next() {

		if (numComb == 0) {

			for (int i = 0; i < indexes.length; i++) {
				indexes[i] = i;
			}
		} else {
			int ic = -1;
			for (int i = k - 1; ic == -1 && i > -1; i--) {

				if (indexes[i] != n ) {
					ic = i;
				}

			}
			indexes[ic] = indexes[ic] + 1;
			for (int j = ic + 1; j < k; j++) {
				indexes[j] = indexes[ic] + 1;
			}

		}

		numComb = numComb + 1;

		return Arrays.copyOf(indexes, k);
	}

	public long getTotal() {
		return total;
	}

	private long cnk(int n, int k) {

		long res = 1;

		if (k != 0) {
			res = (n * cnk(n - 1, k - 1)) / k;
		}
		return res;
	}

}
