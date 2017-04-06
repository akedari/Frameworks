package edu.kedari;

import java.util.List;

public class Triangle implements Shape{
	
//	List<Point> points;
	Point pointA;
	Point pointB;
	Point pointC;
	
	

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

//	public List<Point> getPoints() {
//		return points;
//	}
//
//	public void setPoints(List<Point> points) {
//		this.points = points;
//	}


	@Override
	public void draw(){
		System.out.println("Triangle");
		
		System.out.println("PointA ("+ pointA.getX() + "," + pointA.getY() + ")");
		System.out.println("PointB ("+ pointB.getX() + "," + pointB.getY() + ")");
		System.out.println("PointC ("+ pointC.getX() + "," + pointC.getY() + ")");
		
		
//		for(Point point:points){
//			System.out.println("Point ("+ point.getX() + "," + point.getY() + ")");
//		}
		
	}
}
