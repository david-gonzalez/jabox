package org.jabox.webapp.borders;

import org.apache.wicket.markup.html.border.Border;
import org.jabox.webapp.panels.HeaderLinksPanel;

public class ServersBorder extends Border {
    private static final long serialVersionUID = -6762014978866138140L;

    private final HeaderLinksPanel headers;

    public ServersBorder() {
        this(1);
    }

    public ServersBorder(final int menuIndex) {
        super("border");
        headers = new HeaderLinksPanel();
        addToBorder(headers);
    }
}
