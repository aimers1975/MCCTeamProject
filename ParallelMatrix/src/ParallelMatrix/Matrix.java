package ParallelMatrix;

import java.lang.StringBuilder;

public class Matrix {
	
	double[][] matrix;

	public Matrix(int rows, int columns, boolean zerod, int max) {
		matrix = new double[rows][columns];
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
	
	public boolean setRow(double[] inputRow, int rowID) {
		if(inputRow.length == matrix[0].length && rowID < matrix.length) {
		    matrix[rowID] = inputRow;
		    return true;
		} else {
			return false;
		}
	}
	
	public double getElem(int i, int j) {
		return matrix[i][j];
	}

	public boolean setElem(int i, int j, double value) {
		if(i < getNumRows() && j < getNumColumns()) {
			matrix[i][j] = value;
			return true;
		} else {
			return false;
		}
	}
	
	public double[] getRow(int row) {
		if(row < getNumRows()) 
		    return matrix[row];
		else
			return new double[0]; // need to fix this
	}

	public double[] getColumn(int col) {
		return matrix[col];
	}
	
	public int getNumRows() {
		return matrix.length;
	}
	
	public int getNumColumns() {
		return matrix[0].length;
	}
	
	//To do
	public boolean equals(Matrix compareM){
		return true;
	}
	
	public static boolean add(Matrix matrixA, Matrix matrixB, Matrix matrixResult) {
		if((matrixA.getNumRows() != matrixB.getNumRows()) || 
		   (matrixA.getNumColumns() != matrixB.getNumColumns()) ||
		   (matrixResult.getNumColumns() != matrixA.getNumColumns()) ||
		   (matrixResult.getNumRows() != matrixA.getNumRows())) {
			return false;
		}
		for(int i=0; i<matrixA.getNumRows(); i++) {
			for(int j=0; j<matrixA.getNumColumns(); j++) {
				matrixResult.setElem(i,j, (matrixA.getElem(i,j)+matrixB.getElem(i,j)));
			} 
		}
		return true;
	}
	

	
	public static boolean multiply(Matrix matrixA, Matrix matrixB, Matrix matrixResult) {
		if((matrixA.getNumRows() != matrixB.getNumColumns()) || 
				   ((matrixResult.getNumRows() != matrixA.getNumRows())&&
				     (matrixResult.getNumColumns() != matrixA.getNumRows()))) {
					return false;
		} else {
			
			for(int i=0; i<matrixA.getNumRows(); i++) {
				for(int j=0; j<matrixB.getNumColumns(); j++) {
					double value = 0;
					for(int inner=0; inner < matrixA.getNumColumns();inner++) {
						value = value + (matrixA.getElem(i, inner) * matrixB.getElem(inner, j));
					}
					matrixResult.setElem(i, j, value);
				}
			}
			return true;
		}
	}
	   //To do
	public double determinant() {
		return 0;
	}
	   //Todo
	public Matrix cofactor() {
        return new Matrix(1,1,true,0);
	}
	   //Todo
	public Matrix invert() {
		return new Matrix(1,1,true,0);
	}
	
	public static boolean solveLinearSystem(Matrix A, Matrix X, Matrix B) {
		// AX=B, so A^-1B = X...Take the inverse of A and solve for X
		return true;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<getNumRows(); i++) {
			for(int j=0; j<getNumColumns(); j++) {
				sb.append(matrix[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Matrix sampleMatrix = new Matrix(2,4,false,10);
		Matrix sampleMatrix2 = new Matrix(2,3,false,5);
		Matrix resultMatrix = new Matrix(2,4,true,0);
		sampleMatrix.toString();
		sampleMatrix2.toString();
		Matrix.add(sampleMatrix, sampleMatrix2, resultMatrix);
		resultMatrix.toString();
		System.out.println("Created matrix.");
	}
}