/**
 * Copyright (C) 2008 Ovea <dev@ovea.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.testatoo.experimental.dsl

import java.util.concurrent.TimeoutException

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 * @date 2013-05-01
 */
class Testatoo {

    // settings
    Evaluator evaluator = new LegacyEvaluator()

    // dsl

    Component $(String jQuery, long timeout = 2000) { new Component(evaluator: evaluator, id: new jQueryId(jQuery, timeout)) }

    void open(String uri) { evaluator.open(uri) }

    void assertThat(Block m) { run(m) }

    void on(Block m) { run(m) }

    void assertThat(Collection<Block> blocks) { run(Blocks.compose(blocks)) }

    void assertThat(Closure<?> c) {
        c()
        run(Blocks.compose(Blocks.pending()))
    }

    void waitUntil(Block m, long timeout = 5000) {
        try {
            Util.waitUntil timeout, 500, {
                println "waitUntil: ${m}"
                m.run()
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("${e.message} : ${m}")
        }
    }

    // attributes

    PlaceholderAttribute getPlaceholder() { new PlaceholderAttribute(evaluator) }

    LabelAttribute getLabel() { new LabelAttribute(evaluator) }

    TextAttribute getText() { new TextAttribute(evaluator) }

    // properties

    final VisibleProperty visible = new VisibleProperty(evaluator)
    final HiddenProperty hidden = new HiddenProperty(evaluator)
    final AvailableProperty available = new AvailableProperty(evaluator)
    final MissingProperty missing = new MissingProperty(evaluator)

    // utils

    private void run(Block block) {
        println block.toString()
        block.run()
    }

}
