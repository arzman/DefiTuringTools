package main;

import java.util.Arrays;

public class Permutator {

	private int k;
	private int n;

	private long numPerm;
	private int[] indexes;

	private long total;

	public Permutator(int an, int ak) {

		k = ak;
		n = an;

		numPerm = 0;
		indexes = new int[k];

		total = 1;

		for (int i = 0; i < k; i++) {
			total = total * (an - i);
		}

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

			boolean isOk = true;

			while (!isOk) {
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
				
				for(int i=0;isOk && i<indexes.length-1;i++){
					for(int j=i+1;isOk && j<indexes.length;j++){
						isOk = indexes[i]!=indexes[j];
					}
				}

			}
		}

		numPerm = numPerm + 1;

		return Arrays.copyOf(indexes, k);
	}

	public long getTotal() {
		return total;
	}

}
