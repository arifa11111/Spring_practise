package ObserverDesignPattren;

public class SubscribeAccount extends Observer {

    public SubscribeAccount(YouTubeChannel subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    public void getAccount(String AccountHolder){
        System.out.print(AccountHolder);
    }
    @Override
    public void update() {
        System.out.println(", You are succesfully subscribed to Zemoso channel");
    }
}
