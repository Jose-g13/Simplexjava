 public class CreatTable {
    
    private int var;//Variables in the table
    private int res;//Restrictions in the table
    private int amp;//total amplitude value of the table
    private double table[][];//table to be changed
    protected double vectorR[];//vector that saves the results
    protected double fObj;//Objective Function
	private int[] equal;//value of one for the row that has the same

    public Table(Simplex simplex) {
        res = simplex.res.size();
        equal = new int[res];
        var = maximoNumSubindices(simplex);
        amp = var + addValues(simplex) + 1;
        table = new double[res][amp];
        
        int k = var;
        for (int i = 0; i < res; i++) {

            for (int ii = 0; ii < var; ii++) {
                try {
                    table[i][ii] = simplex.res.get(i).sub[ii];
                } catch (Exception ex) {
                    table[i][ii] = 0;
                }
            }

            if (simplex.res.get(i).valorZ != 1){
                if (vSign(simplex.res.get(i).dEqual) == 1){
                    table[i][k] = 1;
                    if (simplex.res.get(i).dEqual == 0){
                        table[0][k] = M;
                        equal[i] = 1;
                    }
                    k += 1;
                }
                if (vSign(simplex.res.get(i).dEqual) == 2){
                    table[i][k] = -1;
                    table[i][k + 1] = 1;
                    k += 2;
                }
            }

            table[i][amp - 2] = simplex.res.get(i).result;

            table[i][amp - 1] = simplex.res.get(i).z;
        }
    }