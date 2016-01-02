package events;

/**
 * Created by ir2pid on 16/11/15.
 */
public class OnPrintEvent {

    String data;

    public OnPrintEvent(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
