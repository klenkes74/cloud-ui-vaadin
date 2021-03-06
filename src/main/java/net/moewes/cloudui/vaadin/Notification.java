package net.moewes.cloudui.vaadin;

import java.util.Locale;

import lombok.Getter;
import lombok.Setter;
import net.moewes.cloudui.UiComponent;

/**
 * Java wrapper for Vaadin web component vaadin-notification
 */
@Getter
@Setter
public class Notification extends UiComponent {

    private String text;
    private Integer duration = 2000;
    private Position position = Position.BOTTOM_START;
    private boolean isOpen = false;

    /**
     * default constructor
     */
    public Notification() {
        super("cloudui-notification-wrapper");
    }

    public Notification(String text) {
        this();
        setText(text);
    }

    /**
     * constructor
     *
     * @param text     text to display
     * @param duration time in ms the message is shown
     */
    public Notification(String text, int duration) {
        this();
        setText(text);
        setDuration(duration);
    }

    /**
     * constructor
     *
     * @param text     text to display
     * @param duration time in ms the message is shown
     * @param position where the message is shown
     */
    public Notification(String text, int duration, Position position) {
        this();
        setText(text);
        setDuration(duration);
        setPosition(position);
    }

    /* // not supported yet
    public Notification(UiComponent... components) {
        this();
        // FIXME
    }
    */

    /**
     * opens the notification
     */
    public void open() {

        if (text != null) {
            getElement().setAttribute("text", text);
        } else {
            throw new IllegalStateException("No Content for notification");
            // TODO Template variant
        }
        if (duration != null) {
            getElement().setAttribute("duration", duration.toString());
        }
        if (position != null) {
            String value = position.name();
            value = value.replace("_", "-");
            value = value.toLowerCase(Locale.US);
            getElement().setAttribute("position", value);
        }
        getElement().setAttribute("isOpen", "true");
    }

    /**
     * possible value for attribute position
     */
    public enum Position {BOTTOM_CENTER, BOTTOM_END, BOTTOM_START, BOTTOM_STRETCH, MIDDLE, TOP_CENTER, TOP_END, TOP_START, TOP_STRETCH}
}
