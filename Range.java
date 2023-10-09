import java.util.Random;

class Range{
    private final int start;
    private final int stop;
    public Range(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }
    public int getRand(){
        return start + new Random().nextInt(this.stop-this.start+1);
    }
}