package ObserverDesignPattren;

import java.util.ArrayList;
import java.util.List;
public class YouTubeChannel {
    private List<Observer> observers=new ArrayList<>();
    private boolean state;
    public static int totalSubscribers=256;
    public boolean getState(){
        return state;
    }
    public void setState(boolean state){
        this.state=state;
        notifyAllObservers();
    }
    public void attach(Observer observer){
        observers.add(observer);
    }
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
