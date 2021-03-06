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
package org.testatoo.bundle.html5.helper

import org.testatoo.core.ComponentException
import org.testatoo.core.component.Component

import static org.testatoo.core.Testatoo.config

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class CheckHelper {
    static boolean checked(Component c) {
        config.evaluator.check(c.id(), "it.is(':checked')")
    }

    static void check(Component c) {
        if(!c.enabled())
            throw new ComponentException("${c.class.simpleName} ${c} is disabled and cannot be checked")
        if (!c.checked())
            c.click()
        else
            throw new ComponentException("${c.class.simpleName} ${c} is already checked and cannot be checked")
    }

    static void uncheck(Component c) {
        if(!c.enabled())
            throw new ComponentException("${c.class.simpleName} ${c} is disabled and cannot be unchecked")
        if (c.checked())
            c.click()
        else
            throw new ComponentException("${c.class.simpleName} ${c} is already unchecked and cannot be unchecked")
    }
}
