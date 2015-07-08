public class Determinant{
//A method for calculating the determinant of a square matrix
	int[][] matrix;

	public Determinant(){
		//Constructor
	}

	public static int Multiply(int[][] matrix){
		return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
	}

	public static String MatrixToString(int[][] matrix){
		String x = "";
		for (int i=0; i<matrix[0].length; i++){
			for (int j=0; j<matrix[i].length; j++){
				x = x + matrix[j][i] + "  ";
			}
			x = x + "\n";
		}
		return x;
	}

	public static int Det3x3(int[][] matrix){
		int[][] aminor = {{matrix[1][1], matrix[1][2]},
						  {matrix[2][1], matrix[2][2]}
						};
		int[][] bminor = {{matrix[0][1], matrix[0][2]},
						  {matrix[2][1], matrix[2][2]}
						};
		int[][] cminor = {{matrix[0][1], matrix[0][2]},
						  {matrix[1][1], matrix[1][2]}
						};
		return matrix[0][0] * Multiply(aminor) - matrix[1][0] * Multiply(bminor) + matrix[2][0] * Multiply(cminor);
	}

	public static int Det4x4(int[][] matrix){
		int det = 0;
		int[] vals = new int[matrix[0].length];
		int[] multiplier = new int[matrix[0].length];

		for (int i=0; i<matrix[0].length; i++){
			multiplier[i] = matrix[i][0];
			vals[i] = multiplier[i] * Det3x3(Expand(i,matrix));
		}
		for (int k=0; k<vals.length; k++){
			if (k%2 != 0){
				det = det - vals[k];
			}
			else {
				det = det + vals[k];
			}
		}
		return det;
	}

	public static int DetNxN(int[][] matrix){
		int det = 0;
		int level = 0;
		int size = matrix[0].length;
		int[] vals = new int[size];
		int[][] multiplier = new int[size][size-3];

		for (int i=0; i<size; i++){
			while (size > 3){
				int x = DetNxN(Expand(i,matrix));
				vals[i] = x * matrix[i][0];
				break;
			}
		}
		if (size==3){
			det = Det3x3(matrix);
		}
		for (int j=0; j<vals.length; j++){
			if (j%2 != 0){
				det = det - vals[j];
			}
			else {
				det = det + vals[j];
			}
		}
		return det;
	}

	public static int[][] Expand(int column, int[][] matrix){
		int row = 0;
		int col = 0;
		int size = matrix[0].length - 1;
		int[][] expanded = new int[size][size];
		for (int i=0; i<matrix[0].length; i++){
			if (i!=column){
				for (int j=1; j<matrix[0].length; j++){
					expanded[col][row] = matrix[i][j];
					row++;
				}
				col++;
			}
			row = 0;
		}
		return expanded;
	}

	public static String Iterator(int[] arr){
		String mults = "";
			for (int j=0; j<arr.length; j++){
				mults = mults + arr[j] + " ";
			}
		return mults;
	}

	public static void main(String[] args){

		int[][] x = {{7,5,12,16,6,8},
					 {3,1,0,79,9,0},
					 {2,9,12,7,1,14},
					 {5,4,8,11,3,6},
					 {1,4,9,0,12,2},
					 {5,2,0,19,6,3}
					};

		System.out.println(MatrixToString(x));


		int size = x[0].length;

		if (size == 2){
			System.out.println(Multiply(x));
			System.exit(0);
		}
		if (size == 3){
			System.out.println(Det3x3(x));
			System.exit(0);
		}
		if (size == 4){
			System.out.println(Det4x4(x));
			System.exit(0);
		}
		System.out.println(DetNxN(x));
	}
}