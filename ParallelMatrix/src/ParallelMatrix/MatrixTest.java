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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testMatrix = new Matrix(4,4,false,10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRows() {
		int[] rowSample = {0,2,4,6};
		int[] temp = testMatrix.getRow(2);
		for(int i=0; i<temp.length; i++) {
			assert(temp[i] == rowSample[i]);
		}
	}
	@Test
	public void testGetColumn() {
		int[] colSample = {0,2,4,6};
		int[] temp = testMatrix.getRow(2);
		for(int i=0; i<temp.length; i++) {
			assert(temp[i] == colSample[i]);
		}
	}

}
