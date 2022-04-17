package jfk.simple3d.model;

public class Vector4 {
	
	public float[] values = new float[4];
	
	public float getX() {return this.values[0];}
	public void setX(float x) {this.values[0] = x;}
	public float getY() {return this.values[1];}
	public void setY(float y) {this.values[1] = y;}
	public float getZ() {return this.values[2];}
	public void setZ(float z) {this.values[2] = z;}
	public float getW() {return this.values[3];}
	public void setW(float w) {this.values[3] = w;}
	
	public Vector4() { }
	
	public Vector4(float[] values) {
		this.values = values;
	}
	
	public Vector4(float x, float y, float z, float w) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
		this.setW(w);
	}
}