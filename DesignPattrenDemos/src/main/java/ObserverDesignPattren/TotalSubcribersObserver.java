package ObserverDesignPattren;

public class TotalSubcribersObserver extends Observer {

    public TotalSubcribersObserver(YouTubeChannel subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        YouTubeChannel.totalSubscribers=  YouTubeChannel.totalSubscribers+ 1;
        System.out.println("Total Subscribers : " + YouTubeChannel.totalSubscribers);
    }
}
