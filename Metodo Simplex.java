Import java.io.*;
class tabla {
      public static void main(String[] throws IOException){
          BufferedReader leer = new BufferedReader
                      (new InputStreamReader(System.in));

                   int i, j;
        int variables; // Declare problem variables
        int restrictions; // Declare problem restrictions
        int array; // Declare content of the array
        int ar [][]; // Declare array
        
        // Asking for variables and restrictions
        System.out.print("Enter the variables: ");
        variables = Integer.parseInt(leer.readLine());
	System.out.print("Enter the restrictions: ");
	restrictions = Integer.parseInt(leer.readLine());
	
        // Creating the array
        ar = new int[variables+1][restrictions+variables+1];
        
        for(i=0; i<(variables+1); i++){
			for(j=0; j<(restrictions+variables+1); j++){
				System.out.print("Creating matrix... ["+i+"]["+j+"]: ");
				array = Integer.parseInt(leer.readLine());
				ar[i][j]= array;
			}
		}
            

      }
}