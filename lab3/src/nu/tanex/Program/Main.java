package nu.tanex.Program;

import nu.tanex.Waveforms.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SineWave sine = new SineWave(1, 10);
        CosineWave cos = new CosineWave(2, 10);
        Thread.sleep(1000);
        WaveformPlotter plotter = new WaveformPlotter(sine, cos);
    }
}
