package ObserverDesignPattren;
public class ObserverPatternDemo {
        public static void main(String[] args) {
            YouTubeChannel subject = new YouTubeChannel();
            SubscribeAccount user=new SubscribeAccount(subject);
            new SubscribersObserver(subject);
            new TotalSubcribersObserver(subject);
            System.out.println("==========================");
            user.getAccount("Arifa");
            subject.setState(true);
            System.out.println("==========================");
            user.getAccount("Asha");
            subject.setState(true);

        }
}
