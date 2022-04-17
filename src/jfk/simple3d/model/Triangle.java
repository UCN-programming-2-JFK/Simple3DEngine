package jfk.simple3d.model;

public class Triangle {

	public Vertex[] vertices = new Vertex[3];

	public Triangle(Vertex v1, Vertex v2, Vertex v3) {
		this.vertices[0] = v1;
		this.vertices[1] = v2;
		this.vertices[2] = v3;
	}
	
	public Triangle() {
		this.vertices[0] = new Vertex();
		this.vertices[1] = new Vertex();
		this.vertices[2] = new Vertex();
	}
}