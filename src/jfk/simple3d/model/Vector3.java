package jfk.simple3d.model;

public class Vector3 {
	
	public float[] values = new float[3];
	
	public float getX() {return this.values[0];}
	public void setX(float x) {this.values[0] = x;}
	public float getY() {return this.values[1];}
	public void setY(float y) {this.values[1] = y;}
	public float getZ() {return this.values[2];}
	public void setZ(float z) {this.values[2] = z;}

	public Vector3() { }
	
	public Vector3(float[] values) {
		this.values = values;
	}
	
	public Vector3(float x, float y, float z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}
}