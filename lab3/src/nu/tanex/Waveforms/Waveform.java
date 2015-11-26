package nu.tanex.Waveforms;

import org.jfree.data.xy.XYSeries;

import java.util.Calendar;

public abstract class Waveform extends Thread {

    private double period;
    private double samplingFrequency;
    private XYSeries series;

    public Waveform(double period, double samplingFrequency){
        series = new XYSeries(period);
        this.period = period;
        this.samplingFrequency = samplingFrequency;
        start();
    }

    protected abstract double getValue(double t);

    public void emit(){
        double t = Calendar.getInstance().getTimeInMillis() / 1000;
        series.add(t, getValue(t));
    }

    public XYSeries getSeries() { return series; }

    @Override
    public void run() {
        try {
            while(true) {
                emit();
                    sleep(1000 / (long) samplingFrequency);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
