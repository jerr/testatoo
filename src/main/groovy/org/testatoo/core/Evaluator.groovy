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
package org.testatoo.core

import org.testatoo.core.input.Key
import org.testatoo.core.input.MouseModifiers

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
interface Evaluator {
    abstract <T> T getImplementation(Class<T> type)

    abstract void open(String url)

    abstract void runScript(String script)

    abstract void registerScripts(String... scripts)

    abstract String eval(String id, String expression)

    abstract boolean check(String id, String expression)

    abstract void trigger(String id, String event)

    abstract String getTitle()

    abstract String getPageSource()

    abstract String getUrl()

    abstract Set<String> getWindowIds()

    abstract void closeWindow(String id)

    abstract void switchToWindow(String id)

    abstract void to(String url)

    abstract void back()

    abstract void forward()

    abstract void refresh()

    abstract <T> T getJson(String query)

    abstract List<MetaInfo> metaInfo(String query)

    abstract void type(Collection<?> keys)

    abstract void press(Key key)

    abstract void release(Key key)

    abstract void click(String id, Collection<MouseModifiers> click, Collection<?> keys)

    abstract void click(String id, Collection<MouseModifiers> click)

    abstract void click(String id)

    abstract void mouseOver(String id)

    abstract void dragAndDrop(String originId, String targetId)
}
