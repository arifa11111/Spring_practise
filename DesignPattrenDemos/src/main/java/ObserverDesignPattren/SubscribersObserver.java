package ObserverDesignPattren;

public class SubscribersObserver extends Observer {

    public SubscribersObserver(YouTubeChannel subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("Zemoso channel You got one subscriber " );
    }
}
