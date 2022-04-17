package jfk.simple3d.model;

public class Matrix3x3 {

	public float[][] values = new float[3][3];
	
	public Vector3 multiply(Vector3 vector) {
		
		Vector3 result = new Vector3();
			result.setX(values[0][0] * vector.values[0] + values[0][1] * vector.values[1] + values[0][2] * vector.values[2]);	
			result.setY(values[1][0] * vector.values[0] + values[1][1] * vector.values[1] + values[1][2] * vector.values[2]);
			result.setZ(values[2][0] * vector.values[0] + values[2][1] * vector.values[1] + values[2][2] * vector.values[2]);
		return result;
	}
}