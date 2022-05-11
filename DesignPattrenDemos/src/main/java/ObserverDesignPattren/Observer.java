package ObserverDesignPattren;

public abstract class Observer {
    protected YouTubeChannel subject;
    public abstract void update();
}
