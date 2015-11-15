package events;

/**
 * Created by ir2pid on 21/10/15.
 */
public class OnSpeechEvent {

    String text;

    public OnSpeechEvent(String s) {
        this.text = s;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
