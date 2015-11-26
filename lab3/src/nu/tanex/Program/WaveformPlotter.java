/*
 * -------------------------
 * WaveformPlotter.java
 * -------------------------
 * (C) Copyright 2010, by Federico Pecora.
 * Parts based on code (C) David Gilbert (for Object Refinery Limited)
 *
 */
package nu.tanex.Program;

import java.awt.Color;

import java.util.Vector;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import nu.tanex.Waveforms.Waveform;

/**
 * A simple, self-updating waveform plotter.
 */
public class WaveformPlotter extends ApplicationFrame {

    private static final long serialVersionUID = 1L;

    /**
     * A vector containing the XYSeries to plot.
     */
    private Vector<XYSeries> mySeries = new Vector<XYSeries>();

    /**
     * Create an empty WaveformPlotter.  Waveforms can then be added asynchronously with the method
     * addWaveForm().
     */
    public WaveformPlotter() {
        super("Waveform Plotter");
    }

    public void addWaveform(Waveform wf) {
        this.mySeries.add(wf.getSeries());
        ChartPanel chartPanel = (ChartPanel) createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        this.displayPlotterWindow();
    }


    /**
     * Creates a new waveform plotter given the waveforms to plot.
     * @param waveforms The Waveforms to be plotted.
     */
    public WaveformPlotter(Waveform... waveforms ) {
        super("Waveform Plotter");
        for (Waveform wf : waveforms) this.mySeries.add(wf.getSeries());
        ChartPanel chartPanel = (ChartPanel) createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        this.displayPlotterWindow();
    }

    /**
     * Creates the chart.
     * @param dataset  The collection of XY series to plot.
     * @return A chart.
     */
    private JFreeChart createChart(XYSeriesCollection dataset) {

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Current Waveforms",  // title
                "Time",             // x-axis label
                "Value",   // y-axis label
                dataset,            // data
                true,               // create legend?
                true,               // generate tooltips?
                false               // generate URLs?
        );

        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYShapeRenderer r = new XYShapeRenderer();
        plot.setRenderer(r);

        return chart;

    }

    /**
     * Creates the collection of series to use as dataset.
     * @return A collection of series.
     */
    private XYSeriesCollection createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        for (XYSeries s : mySeries) {
            dataset.addSeries(s);
        }
        return dataset;
    }

    /**
     * Creates a panel for the chart.
     * @return A panel.
     */
    private JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        return panel;
    }


    /**
     * Open the GUI to show the plot. 
     */
    private void displayPlotterWindow() {
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
    }



}