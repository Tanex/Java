package nu.tanex.Waveforms;

public final class SineWave extends Waveform{

    public SineWave(double period, double samplingFrequency){
        super(period, samplingFrequency);
    }

    @Override
    protected double getValue(double t) {
        return Math.sin(t);
    }
}
