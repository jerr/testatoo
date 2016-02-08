/**
 * Copyright (C) 2016 Ovea (dev@ovea.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.testatoo.bundle.html5.component.input

import org.testatoo.core.ByCss
import org.testatoo.core.component.field.DateField

import static org.testatoo.bundle.html5.helper.RangeHelper.*
import static org.testatoo.core.Testatoo.getConfig

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@ByCss('input[type=date]')
class InputTypeDate extends DateField implements Input {

    @Override
    void setValue(String value) {
        config.evaluator.runScript("\$('#${id}').val('" + value + "')")
    }

    @Override
    Object getMinimum() {
        getMinimun(this)
    }

    @Override
    Object getMaximum() {
        getMaximum(this)
    }

    @Override
    Object getStep() {
        getStep(this)
    }

    @Override
    boolean isInRange() {
        isInRange(this)
    }

    @Override
    boolean isOutOfRange() {
        isOutOfRange(this)
    }
}
