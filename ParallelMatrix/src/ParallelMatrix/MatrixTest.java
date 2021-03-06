package ParallelMatrix;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MatrixTest {
	
	Matrix testMatrix;
	Matrix testMatrix2;
	Matrix testMatrix3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testMatrix = new Matrix(4,4,false,10);
		testMatrix2 = new Matrix(4,4,false,5);
		testMatrix3 = new Matrix(3,4,false,5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRow() {
		double[] rowSample = {0,2,4,6};
		double[] temp = testMatrix.getRow(2);
		for(int i=0; i<temp.length; i++) {
			assert(temp[i] == rowSample[i]);
		}
	}
	@Test
	public void testGetColumn() {
		double[] colSample = {0,2,4,6};
		double[] temp = testMatrix.getRow(2);
		for(int i=0; i<temp.length; i++) {
			assert(temp[i] == colSample[i]);
		}
	}
	@Test
	public void testAdd() {
		Matrix matrixResult = new Matrix(4,4,true,0);
	    Matrix.add(testMatrix, testMatrix2, matrixResult);
	    String expected = "0.0 0.0 0.0 0.0 \n0.0 2.0 4.0 6.0 \n0.0 4.0 8.0 7.0 \n0.0 6.0 7.0 13.0 \n";
	    assertEquals(matrixResult.toString(),expected);
	}
	
	@Test
	public void testMultiply() {
		Matrix matrixResult = new Matrix(4,4,true,0);
		Matrix.multiply(testMatrix, testMatrix2, matrixResult);
		String expected = "0.0 0.0 0.0 0.0 \n0.0 14.0 13.0 17.0 \n0.0 28.0 26.0 34.0 \n0.0 42.0 39.0 51.0 \n";
		assertEquals(matrixResult.toString(),expected);
	}
	
	@Test
	public void testToString() {
		String expected = "0.0 0.0 0.0 0.0 \n0.0 1.0 2.0 3.0 \n0.0 2.0 4.0 6.0 \n0.0 3.0 6.0 9.0 \n";
		assertEquals(testMatrix.toString(), expected);
	}
	
	@Test
	public void testSetRow() {
		Matrix replaceRow = new Matrix(4,4,false,10);
		double[] row = {5,5,5,5};
		replaceRow.setRow(row, 3);
		String expected = "0.0 0.0 0.0 0.0 \n0.0 1.0 2.0 3.0 \n0.0 2.0 4.0 6.0 \n5.0 5.0 5.0 5.0 \n";
		assertEquals(expected,replaceRow.toString());
		
	}
	@Test
	public void testSetElem(){
		Matrix thisMatrix = new Matrix(4,4,true,0);
		for(int i=0;i<thisMatrix.getNumRows();i++) {
			for(int j=0; j<thisMatrix.getNumColumns();j++) {
				thisMatrix.setElem(i, j, ((i*j)%10));
			}
		}
		String expected = "0.0 0.0 0.0 0.0 \n0.0 1.0 2.0 3.0 \n0.0 2.0 4.0 6.0 \n0.0 3.0 6.0 9.0 \n";
		assertEquals(expected,thisMatrix.toString());
	}
	
	@Test
	public void testGetElem() {
		assert(testMatrix.getElem(2, 2)== 4);
	}
	
	@Test
	public void testGetNumRows() {
		Matrix newMat = new Matrix(7,3,true,0);
		assertEquals(newMat.getNumRows(),7);
	}
	
	@Test
	public void testIsSquare() {
		assert(testMatrix.isSquare());
	}
	
	@Test 
	public void testIsNotSquare() {
		assert(!testMatrix3.isSquare());
	}
	
	@Test
	public void testFlipOddEven() {
		assert(Matrix.flipOdd(2) == 1);
	}
	
	public void testFlipOddOdd() {
		assert(Matrix.flipOdd(3) == -1);
	}
	
	@Test
	public void testGetNumColumns() {
		Matrix newMat = new Matrix(7,3,true,0);
		assertEquals(newMat.getNumColumns(),3);
	}

}
