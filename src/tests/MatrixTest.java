package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import jfk.simple3d.model.*;

class MatrixTest {

	@Test
	void matrix3IdentityMatrixMultiplication() {
		
		//Arrange
		Matrix3x3 identityMatrix = new Matrix3x3();
		identityMatrix.values[0][0] = 1;
		identityMatrix.values[1][0] = 0;
		identityMatrix.values[2][0] = 0;
		identityMatrix.values[0][1] = 0;
		identityMatrix.values[1][1] = 1;
		identityMatrix.values[2][1] = 0;
		identityMatrix.values[0][2] = 0;
		identityMatrix.values[1][2] = 0;
		identityMatrix.values[2][2] = 1;
		
		Vector3 vector = new Vector3(1, 2, 3);
		
		//Act
		Vector3 result = identityMatrix.multiply(vector);
		
		//Assert
		assertEquals(vector.getX(), result.getX() ,"X value was corrupted in identity matrix multiplication");
		assertEquals(vector.getY(), result.getY(), "Y value was corrupted in identity matrix multiplication");
		assertEquals(vector.getZ(), result.getZ(), "Z value was corrupted in identity matrix multiplication");
	}
	
	
	@Test
	void matrix3Multiplication() {
		
		//Arrange
		Matrix3x3 identityMatrix = new Matrix3x3();
		identityMatrix.values[0][0] = -1;
		identityMatrix.values[1][0] = 2;
		identityMatrix.values[2][0] = 3;
		identityMatrix.values[0][1] = 0;
		identityMatrix.values[1][1] = 0;
		identityMatrix.values[2][1] = 0;
		identityMatrix.values[0][2] = 4;
		identityMatrix.values[1][2] = 2;
		identityMatrix.values[2][2] = 1;
		
		Vector3 vector = new Vector3(1, 2, -3);
		
		//Act
		Vector3 result = identityMatrix.multiply(vector);
		
		//Assert
		assertEquals(-13, result.getX() ,"X value was corrupted in identity matrix multiplication");
		assertEquals(-4, result.getY(), "Y value was corrupted in identity matrix multiplication");
		assertEquals(0, result.getZ(), "Z value was corrupted in identity matrix multiplication");
	}
	
	@Test
	void matrix4IdentityMatrixMultiplication() {
		
		//Arrange
		Matrix4x4 identityMatrix = new Matrix4x4();
		identityMatrix.values[0][0] = 1;
		identityMatrix.values[1][0] = 0;
		identityMatrix.values[2][0] = 0;
		identityMatrix.values[3][0] = 0;

		identityMatrix.values[0][1] = 0;
		identityMatrix.values[1][1] = 1;
		identityMatrix.values[2][1] = 0;
		identityMatrix.values[3][1] = 0;

		identityMatrix.values[0][2] = 0;
		identityMatrix.values[1][2] = 0;
		identityMatrix.values[2][2] = 1;
		identityMatrix.values[3][2] = 0;

		identityMatrix.values[0][3] = 0;
		identityMatrix.values[1][3] = 0;
		identityMatrix.values[2][3] = 0;
		identityMatrix.values[3][3] = 1;

		Vector4 vector = new Vector4(111.8f, -3, 3, 8);
		
		//Act
		Vector4 result = identityMatrix.multiply(vector);
		
		//Assert
		assertEquals(vector.getX(), result.getX() ,"X value was corrupted in identity matrix multiplication");
		assertEquals(vector.getY(), result.getY(), "Y value was corrupted in identity matrix multiplication");
		assertEquals(vector.getZ(), result.getZ(), "Z value was corrupted in identity matrix multiplication");
		assertEquals(vector.getW(), result.getW(), "W value was corrupted in identity matrix multiplication");
	}
	
	
	@Test
	void matrix4Multiplication() {
		
		//Arrange
		Matrix3x3 identityMatrix = new Matrix3x3();
		identityMatrix.values[0][0] = -1;
		identityMatrix.values[1][0] = 2;
		identityMatrix.values[2][0] = 3;
		identityMatrix.values[0][1] = 0;
		identityMatrix.values[1][1] = 0;
		identityMatrix.values[2][1] = 0;
		identityMatrix.values[0][2] = 4;
		identityMatrix.values[1][2] = 2;
		identityMatrix.values[2][2] = 1;
		
		Vector3 vector = new Vector3(1, 2, -3);
		
		//Act
		Vector3 result = identityMatrix.multiply(vector);
		
		//Assert
		assertEquals(-13, result.getX() ,"X value was corrupted in identity matrix multiplication");
		assertEquals(-4, result.getY(), "Y value was corrupted in identity matrix multiplication");
		assertEquals(0, result.getZ(), "Z value was corrupted in identity matrix multiplication");
	}
	
}