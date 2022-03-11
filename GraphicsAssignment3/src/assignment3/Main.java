package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) {

		Main m1 = new Main();
		
		System.out.println("Hello, please enter the Name of the file containing the datalines.");
		Scanner commandIn = new Scanner(System.in);
		String filename = commandIn.nextLine();
		System.out.println(filename + " ");
		// File IO goes here
		try {
		File abc = new File(filename);
		Scanner file = new Scanner(abc);
		while (file.hasNext()) {
			System.out.print(" " + file.nextLine());
		}
		file.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("The filename could not be found, please try again.");
		}
		
		// Array of lines arranged like -> (x1, y1) (x2, y2)
		float[][] datalines = new float[3][3];
		
		//int num = m1.Inputlines(filename, datalines);
		
		// Displays image
		//m1.Displaypixels(datalines, num);
		
		//start of main loop
		
		boolean loop = true;
		while (loop) {
			System.out.println("What operation would you like to perform on the image? ");
			System.out.println("(t) - Basic Translate (s) - Basic Scale (r) - Basic Rotate");
			System.out.println("(gs) - General Scale (gr) - General Rotate (q) - Quit (h) - Help");
			System.out.print("(o) - Output data lines into a new file");
			System.out.println();
	
			String com = commandIn.next();
			
			if (com.equals("t")) {
				//Basic Translate
				System.out.println("Please enter the x and y displacement values.");
				float tx = commandIn.nextFloat();
				float ty = commandIn.nextFloat();
				
				m1.BasicTranslate(tx, ty);
				float[][] transMatrix = new float[3][3];
				//m1.ApplyTransformation(transMatrix, datalines);
				
				//m1.Displaypixels(datalines, num);
				
			} else if (com.equals("s")) {
				//Basic Scale
				System.out.println("Please enter the x and y scaling factors");
				float sx = commandIn.nextFloat();
				float sy = commandIn.nextFloat();
				
				m1.BasicScale(sx, sy);
				float[][] scaleMatrix = new float[3][3];
				//m1.ApplyTransformation(scaleMatrix, datalines);
				
				//m1.Displaypixels(datalines, num);
				
			} else if (com.equals("r")) {
				//Baisc Rotate
				System.out.println("Please enter the angle to rotate");
				float angle = commandIn.nextFloat();
				
				m1.BasicRotate(angle);
				float[][] rotateMatrix = new float[3][3];
				//m1.ApplyTransformation(rotateMatrix, datalines);
				
				//m1.Displaypixels(datalines, num);
				
			} else if (com.equals("gs")) {
				//General Scale
				System.out.println("Please enter the x and y scaling factors, followed by the center of scale");
				float Sx = commandIn.nextFloat();
				float Sy = commandIn.nextFloat();
				float Cx = commandIn.nextFloat();
				float Cy = commandIn.nextFloat();
				
				m1.Scale(Sx, Sy, Cx, Cy);
				float[][] genScaleMatrix = new float[3][3];
				//m1.ApplyTransformation(genScaleMatrix, datalines);
				
				//m1.Displaypixels(datalines, num);
				
			} else if (com.equals("gr")) {
				//General Rotate
				System.out.println("Please enter the angle of rotation (clockwise) and the center of rotation");
				float genAngle = commandIn.nextFloat();
				float Cx = commandIn.nextFloat();
				float Cy = commandIn.nextFloat();
				
				m1.Rotate(genAngle, Cx, Cy);
				float[][] genRotateMatrix = new float[3][3];
				//m1.ApplyTransformation(genRotateMatrix, datalines);
				
				//m1.Displaypixels(datalines, num);
				
			} else if (com.equals("o")) {
				//Outputlines
				  System.out.println("Please enter the name of the file you would like to send the datalines to.");
				  String outputName = commandIn.nextLine();
				//m1.Outputlines(num, num);
				
			} else if (com.equals("q")) {
				loop = false;
			}// if-else
			
		}// while
		
	     /* Test for size of datalines
		for (int i = 0; i < datalines.length; i++) {
			for (int j = 0; j < datalines.length; j++) {
				datalines[i][j] = j;
				System.out.print(datalines[i][j] + " ");
			}
			System.out.println();
		}*/
		
		System.exit(0);
	}
	
	private int Inputlines (String filename, float[][] datalines) {
		
		//count used to mark new lines
		int count = 0;
		
		//need filename
		Scanner file = new Scanner("");
		
		//loops through file
		while (file.hasNext()) {
			//4 coordinates is a line
			if (count % 4 == 0) {
				//num++;
			}// if
			
		}// while
		
		//placeholder
		int num = 0;
		
		// The number of datalines reaed
		return num;
	}
	
	private void ApplyTransformation (float[][] matrix, float[][] datalines) {
		
		//applies the transformation matrix to datalines, which contains the original positions to be changed
	}
	
	private void Displaypixels (float[][] datalines, float num) {
		
		//bresenham's goes here
		
	}
	
	private void Outputlines (float datalines, float num, String filename) {
		
		//Sends the lines contained within datalines to another file.
		
	}
	
	private void BasicTranslate (float tx, float ty) {
		
		//Transformation matrix
		float[][] transMatrix = new float[3][3];
		transMatrix[0][0] = 1;
		transMatrix[0][1] = 0;
		transMatrix[0][2] = 0;
		transMatrix[1][0] = 0;
		transMatrix[1][1] = 1;
		transMatrix[1][2] = 0;
		transMatrix[2][0] = tx;
		transMatrix[2][2] = ty;
		transMatrix[2][2] = 1;
		
		
		
	}
	
	private void BasicScale (float sx, float sy) {
		
		//Transformation matrix
		float[][] scaleMatrix = new float[3][3];
		scaleMatrix[0][0] = sx;
		scaleMatrix[0][1] = 0;
		scaleMatrix[0][2] = 0;
		scaleMatrix[1][0] = 0;
		scaleMatrix[1][1] = sy;
		scaleMatrix[1][2] = 0;
		scaleMatrix[2][0] = 0;
		scaleMatrix[2][2] = 0;
		scaleMatrix[2][2] = 1;
		
	}
	
	private void BasicRotate (double angle) {
		
		//Transformation matrix
		double[][] rotaMatrix = new double[3][3];
		rotaMatrix[0][0] = Math.cos(angle);
		rotaMatrix[0][1] = -Math.sin(angle);
		rotaMatrix[0][2] = 0;
		rotaMatrix[1][0] = Math.sin(angle);
		rotaMatrix[1][1] = Math.cos(angle);
		rotaMatrix[1][2] = 0;
		rotaMatrix[2][0] = 0;
		rotaMatrix[2][2] = 0;
		rotaMatrix[2][2] = 1;
	}
	
	private void Scale (float sx, float sy, float cx, float cy) {
		
	}
	
	private void Rotate (float angle, float cx, float cy) {
		
	}
	
	
	

}

