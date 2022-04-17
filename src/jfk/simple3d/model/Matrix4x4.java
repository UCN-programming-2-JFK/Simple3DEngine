package jfk.simple3d.model;

public class Matrix4x4 {

	public float[][] values = new float[4][4];
	
	
public Vector4 multiply(Vector4 vector) {
		
		Vector4 result = new Vector4();
			result.setX(values[0][0] * vector.values[0] + values[0][1] * vector.values[1] + values[0][2] * vector.values[2] + values[0][3] * vector.values[3]);	
			result.setY(values[1][0] * vector.values[0] + values[1][1] * vector.values[1] + values[1][2] * vector.values[2] + values[1][3] * vector.values[3]);
			result.setZ(values[2][0] * vector.values[0] + values[2][1] * vector.values[1] + values[2][2] * vector.values[2] + values[2][3] * vector.values[3]);
			result.setW(values[3][0] * vector.values[0] + values[3][1] * vector.values[1] + values[3][2] * vector.values[2] + values[3][3] * vector.values[3]);
		return result;
	}
}