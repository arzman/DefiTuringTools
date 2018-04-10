package main;

import java.util.Arrays;

public class PermutatorRep {

	private int k;
	private int n;

	private long numPerm;
	private int[] indexes;

	private long total;

	public PermutatorRep(int an, int ak) {

		k = ak;
		n = an;

		numPerm = 0;
		indexes = new int[k];

		total = (long) Math.pow(n, k);

	}

	public boolean hasNext() {
		return numPerm < total;
	}

	public int[] next() {

		if (numPerm == 0) {

			for (int i = 0; i < indexes.length; i++) {
				indexes[i] = 0;
			}
		} else {
			int ic = -1;

			for (int i = k - 1; ic == -1 && i > -1; i--) {

				if (indexes[i] != n - 1) {
					ic = i;
				}

			}
			indexes[ic] = indexes[ic] + 1;
			for (int j = ic + 1; j < k; j++) {
				indexes[j] = 0;
			}
		}

		numPerm = numPerm + 1;

		return Arrays.copyOf(indexes, k);
	}

	public long getTotal() {
		return total;
	}

}
