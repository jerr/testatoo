package org.testatoo.core.component

import org.testatoo.core.component.field.ColorField
import org.testatoo.core.component.field.DateField
import org.testatoo.core.component.field.DateTimeField
import org.testatoo.core.component.field.EmailField
import org.testatoo.core.component.field.Field
import org.testatoo.core.component.field.MonthField
import org.testatoo.core.component.field.NumberField
import org.testatoo.core.component.field.PasswordField
import org.testatoo.core.component.field.PhoneField
import org.testatoo.core.component.field.RangeField
import org.testatoo.core.component.field.SearchField
import org.testatoo.core.component.field.TextField
import org.testatoo.core.component.field.TimeField
import org.testatoo.core.component.field.URLField
import org.testatoo.core.component.field.WeekField
import org.testatoo.core.internal.Identifiers

import static org.testatoo.core.Testatoo.$$

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
public class ComponentFactory {

    public static Button button(String text) {
        collectAll(Button).find { it.text() == text }
    }

    public static Radio radio(String label) {
        collectAll(Radio).find { it.label() == label }
    }

    public static CheckBox checkbox(String label) {
        collectAll(CheckBox).find { it.label() == label }
    }

    public static Dropdown dropdown(String label) {
        collectAll(Dropdown).find { it.label() == label }
    }

    public static PasswordField passwordField(String value) { field(value, PasswordField) }
    public static TextField textField(String value) { field(value, TextField) }
    public static SearchField searchField(String value) { field(value, SearchField) }
    public static EmailField emailField(String value) { field(value, EmailField) }
    public static URLField urlField(String value) { field(value, URLField) }
    public static NumberField numberField(String value) { field(value, NumberField) }
    public static RangeField rangeField(String value) { field(value, RangeField) }
    public static DateField dateField(String value) { field(value, DateField) }
    public static ColorField colorField(String value) { field(value, ColorField) }
    public static DateTimeField dateTimeField(String value) { field(value, DateTimeField) }
    public static MonthField monthField(String value) { field(value, MonthField) }
    public static PhoneField phoneField(String value) { field(value, PhoneField) }
    public static TimeField timeField(String value) { field(value, TimeField) }
    public static WeekField weekField(String value) { field(value, WeekField) }


    private static <T extends Field> T field(String value, Class<T> clazz) {
        collectAll(clazz).find { it.label() == value || it.placeholder() == value }
    }

    private static <T extends Component> List<T> collectAll(Class<T> clazz) {
        Identifiers.findSelectorsFor(clazz).collectMany {
            $$(it.value, it.key)
        }
    }
}
