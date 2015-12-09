package org.testatoo.bundle.html5.components.heading

import org.testatoo.core.ByCss
import org.testatoo.core.component.Heading

import static org.testatoo.bundle.html5.components.helper.TextHelper.getText

/**
 * @author David Avenante (d.avenante@gmail.com)
 */

@ByCss('h3')
class H3 extends Heading {

    @Override
    String getText() {
        getText(this);
    }
}
