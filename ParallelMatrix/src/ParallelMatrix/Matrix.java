package ParallelMatrix;

public class Matrix {
	
	int[][] matrix;

	public Matrix(int rows, int columns, boolean zerod, int max) {
		matrix = new int[rows][columns];
		for (int row=0; row<rows; row++) {
			for (int column=0; column < columns; column++) {
				if(zerod) {
					this.matrix[row][column] = 0;
				} else {
					this.matrix[row][column] = (row*column)% max;
				}
			}
		}
		
	}

	public int[] getRow(int row) {
		return matrix[row];
	}

	public int[] getColumn(int col) {
		return matrix[col];
	}
	
	public static void main(String[] args) {
		Matrix sampleMatrix = new Matrix(4,4,false,10);
		sampleMatrix.getRow(2);
		System.out.println("Created matrix.");
	}
}