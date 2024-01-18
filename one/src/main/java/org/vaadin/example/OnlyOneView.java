package org.vaadin.example;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
public class OnlyOneView extends VerticalLayout {

    public OnlyOneView() {
        add(new H1("Only in One"));
    }
}
