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
			values[2][2] = getzFar() / depth;
			values[3][3] = (-getzFar() * getzNear()) / depth;
		}
		values[3][2] = 1;
	}
	
	public void project(Vector3 originalVector, Vector3 projectedVector) {
		
		System.out.println("Original vertex: " + originalVector);
		System.out.println("Projected vertex: " + projectedVector);
		
		projectedVector.setX(values[0][0] * originalVector.values[0] + values[0][1] * originalVector.values[1] + values[0][2] * originalVector.values[2] );	
		projectedVector.setY(values[1][0] * originalVector.values[0] + values[1][1] * originalVector.values[1] + values[1][2] * originalVector.values[2] );
		projectedVector.setZ(values[2][0] * originalVector.values[0] + values[2][1] * originalVector.values[1] + values[2][2] * originalVector.values[2] );
		float w = values[3][0] * originalVector.values[0] + values[3][1] * originalVector.values[1] + values[3][2] * originalVector.values[2];
		if(w != 0) {
			projectedVector.setX(projectedVector.getX() / w);
			projectedVector.setY(projectedVector.getY() / w);
			projectedVector.setZ(projectedVector.getZ() / w);
		}
	}
	
	public void project(Triangle originalTriangle, Triangle projectedTriangle) {
		for(Vector3 vector : originalTriangle.vertices) {
			project(originalTriangle.vertices[0], projectedTriangle.vertices[0]);
			project(originalTriangle.vertices[1], projectedTriangle.vertices[1]);
			project(originalTriangle.vertices[2], projectedTriangle.vertices[2]);
		}
		
	}
	
}
