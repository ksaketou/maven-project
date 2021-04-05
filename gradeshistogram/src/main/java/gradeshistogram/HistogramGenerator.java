package gradeshistogram;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * This class reads a text file containing some grades and transfers them into
 * an integer array. Then, it presents those grades in a histogram form using
 * JFreeChart library.
 * 
 */
public class HistogramGenerator {

	/**
	 * This function reads the file with the grades and returns an array of integers
	 * containing the grades from the file.
	 * 
	 * @return array of grades
	 */
	public int[] read_grades(String file) {

		ArrayList<Integer> gradeslist = new ArrayList<Integer>();
		try {
			File f = new File(file);
			Scanner reader = new Scanner(f);

			while (reader.hasNextLine()) {
				gradeslist.add(Integer.parseInt(reader.nextLine())); // add the grade to the list
			}

			reader.close();

		} catch (FileNotFoundException e) { // throw exception if an error occures
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		int[] array = new int[gradeslist.size()]; // the array with the grades
		for (int i = 0; i < gradeslist.size(); i++) {
			array[i] = gradeslist.get(i);
		}
		return array;
	}

	/**
	 * This function calculates the frequency of a specific grade from an integer
	 * array of many different grades.
	 * 
	 * @param values the array with the grades
	 * @param grade  the grade of which the frequency we have to calculate
	 * 
	 * @return the frequency of the input grade
	 */
	public int calculate_frequency(int[] values, int grade) {

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == grade) {
				count++;
			}
		}
		return count;
	}

	/***
	 * Receives a single dimension Integer array with the input grades. 
	 * From this array the dataset that will be used for the visualization 
	 * is generated. Finally, the chart is created and then presented in
	 * the screen.
	 * 
	 * @param dataValues Single dimension integer array of grades
	 */
	public void generateChart(int[] dataValues) {

		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset.
		 */
		XYSeries data = new XYSeries("grades");

		/*
		 * Generate the XYSeries data object from the input 
		 * Integer array of grades. (x, y) = (grade, frequency)
		 */
		HistogramGenerator h = new HistogramGenerator();
		for (int i = 0; i < dataValues.length; i++) {
			data.add(dataValues[i], h.calculate_frequency(dataValues, dataValues[i]));
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grades Histogram", "Grades", "Frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);
		
		
		//add chart customizations (line thickness)
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.BLUE);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));
		plot.setRenderer(renderer);

		/*
		 * Initialize a frame for visualizing the chart and attach the previously
		 * created chart.
		 */
		ChartFrame frame = new ChartFrame("Grades Histogram", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		HistogramGenerator hg = new HistogramGenerator();
		int data[] = hg.read_grades(args[0]);
		hg.generateChart(data);
	}
}
