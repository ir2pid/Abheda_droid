package events;

/**
 * Created by ir2pid on 16/11/15.
 */
public class OnPrintEvent {

    String text;

    public OnPrintEvent(String s) {
        this.text = s;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
