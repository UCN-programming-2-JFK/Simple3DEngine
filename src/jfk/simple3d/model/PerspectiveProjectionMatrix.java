package jfk.simple3d.model;

public class PerspectiveProjectionMatrix extends Matrix4x4 {

	float fieldOfView, aspectRatio, zNear, zFar;

	public PerspectiveProjectionMatrix(float fieldOfView, float aspectRatio, float zNear, float zFar) {
		this.setFieldOfView(fieldOfView);
		this.setAspecteRatio(aspectRatio);
		this.setzNear(zNear);
		this.setzFar(zFar);
	}

	public float getFieldOfView() {
		return fieldOfView;
	}

	public void setFieldOfView(float fieldOfView) {
		this.fieldOfView = fieldOfView;
		recalculate();
	}

	public float getAspectRatio() {
		return aspectRatio;
	}

	public void setAspecteRatio(float aspectRatio) {
		this.aspectRatio = aspectRatio;
		recalculate();
	}

	public float getzNear() {
		return zNear;
	}

	public void setzNear(float zNear) {
		this.zNear = zNear;
		recalculate();
	}

	public float getzFar() {
		return zFar;
	}

	public void setzFar(float zFar) {
		this.zFar = zFar;
		recalculate(); 
	}

	private void recalculate() {
		float centerFieldOfView = (float) (1 / Math.tan(getFieldOfView() / 2));
		float depth = getzFar() - getzNear();
		values[0][0] = getAspectRatio() * centerFieldOfView;
		values[1][1] = centerFieldOfView;
		if(depth != 0) {
			values[1][1] = getzFar() / depth;
			values[1][1] = (-getzFar() * getzNear()) / depth;
		}
		values[3][2] = 1;
	}
}
