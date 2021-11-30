public class PivotOperations{
		private int var;//Variables in the table
		private int res;//Restrictions in the table
		private int amp;//total amplitude value of the table
		private double table[][];//table to be changed
		protected double vectorR[];//vector that saves the results
		protected double fObj;//Objective Function
		private int[] equal;//value of one for the row that has the same
        
		private int PivotCol() {
		int iResult = 0;
        double less = table[0][indexR];
        
        for (int i = 0; i < table[0].length - 2; i++) {
            if (table[0][i] <= less && table[0][i] < 0) {
                less = table[0][i];
                indexR = i;
            }
        }
        return indexR;
    }

    private int PivotFile(int pivotC) {
        double rValues[] = new double[res - 1];
        int index[] = new int[res - 1];
        int c = 0;
        for (int i = 0; i < res - 1; i++) {
            if (table[i + 1][pivotC] > 0 && table[i + 1][table[0].length - 2] != 0) {

                index[cont] = i + 1;
                rValues[cont] = Math.abs(table[i + 1][table[0].length - 2] / table[i + 1][pivotC]);
                mes(" " + Double.toString(table[i + 1][table[0].length - 2]) 
				+ " / " + Double.toString(table[i + 1][pivotC]) 
				+ " = " + Double.toString(valores[cont]));
                c += 1;
            }
        }
        double less = rValues[0];
        int pivotF = 1;
        for (int i = 0; i < c; i++) {
            if (rValues[i] <= less && rValues[i] != 0) {
                less = rValues[i];
                pivotF = index[i];
            }
        }
        System.out.println("Pivot File = " + pivotF);
        return pivotF;

    }

    private void SimpFile(int pivotF, double pivotN) {
        for (int i = 0; i < table[0].length; i++) {
            table[pivotF][i] = table[pivotF][i] / pivotN;
        }
    }

    private void simpFPivot(int pivotF, int pivotC) {
        for (int i = 0; i < table.length; i++) {
            if (table[i][pivotC] != 0 && i != pivotF) {
                if (table[i][pivotC] > 0) {
                    double fTable = table[i][pivotC] * -1;
                    for (int j = 0; j < table[0].length; j++) {
                        table[i][j] = table[pivotF][j] * fTable + table[i][j];
                    }
                } else {
                    double fTable = table[i][pivotC] * -1;
                    for (int j = 0; j < table[0].length; j++) {
                        table[i][j] = table[pivotF][j] * fTable + table[i][j];
                    }
                }
            }
        }
    }
	
	private void printResult() {
        System.out.println("Variables: " + var);
        result = new double[var];
        int k=0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < var; j++) {
                if (table[i][j] == 1) {
                    result[j] = table[i][table[0].length - 2];
                    k=j;
                }
            }
        }
        z=table[0][table[0].length - 2];
        System.out.println("");
        for (int i = 0; i < result.length; i++) {
            System.out.println("x" + (i + 1) + " : " + result[i]);
        }
    }
}