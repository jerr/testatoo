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

import org.junit.BeforeClass
import org.junit.ClassRule
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.testatoo.WebDriverConfig
import org.testatoo.bundle.html5.component.list.Select

import static org.junit.Assert.fail
import static org.testatoo.core.Testatoo.$
import static org.testatoo.core.Testatoo.getBrowser

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@Ignore
@RunWith(JUnit4)
class MatcherTest {

    @ClassRule
    public WebDriverConfig driver = new WebDriverConfig()

    @BeforeClass
    public static void before() {
        browser.open 'http://localhost:8080/error.html'
    }

    @Test
    public void equals_to_matcher_on_list_items() {
        Select dropDown = $('#elements') as Select
        try {
            dropDown.should { have items.equalsTo('Val1') }
            fail()
        } catch (ComponentException e) {
            assert e.message == "Expected Items '[Val1]' but was '[Helium, Boron, Polonium, Calcium, Radium]'"
        }

        try {
            dropDown.should { have items.equalsTo(['Val1', 'Val2']) }
            fail()
        } catch (ComponentException e) {
            assert e.message == "Expected Items '[Val1, Val2]' but was '[Helium, Boron, Polonium, Calcium, Radium]'"
        }
    }

    @Test
    public void equals_to_matcher() {
        Select dropDown = $('#elements') as Select
        try {
            dropDown.items[0].should { have value.equalsTo('Val_1') }
            fail()
        } catch (ComponentException e) {
            assert e.message == "Expected Value 'Val_1' but was 'Helium'"
        }

        try {
            dropDown.items[0].should { have value.equalsTo('Val_1', 'val_2') }
            fail()
        } catch (ComponentException e) {
            assert e.message == "Expected one of Value '[Val_1, val_2]' but was 'Helium'"
        }
    }

    @Test
    public void containing_matcher() {
        Select dropDown = $('#elements') as Select
        try {
            dropDown.should { have items.containing('Val_1') }
            fail()
        } catch (ComponentException e) {
            assert e.message == "Expected Items containing 'Val_1' but was '[Helium, Boron, Polonium, Calcium, Radium]'"
        }

        try {
            dropDown.should { have items.containing('Val_1', 'Val_2') }
            fail()
        } catch (ComponentException e) {
            assert e.message == "Expected one of Items containing '[Val_1, Val_2]' but was '[Helium, Boron, Polonium, Calcium, Radium]'"
        }
    }
}
