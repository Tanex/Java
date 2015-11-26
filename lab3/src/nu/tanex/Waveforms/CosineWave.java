package nu.tanex.Waveforms;

public final class CosineWave extends Waveform{

    public CosineWave(double period, double samplingFrequency){
        super(period, samplingFrequency);
    }

    @Override
    protected double getValue(double t) {
        return Math.cos(t);
    }
}