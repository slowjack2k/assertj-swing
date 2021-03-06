/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2015 the original author or authors.
 */
package org.assertj.swing.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Tests for {@link PatternTextMatcher#formattedValues()}.
 * 
 * @author Alex Ruiz
 */
public class PatternTextMatcher_formattedValues_Test {
  @Test
  public void should_Return_Single_Pattern_As_Formatted_Value_If_Matcher_Has_Only_One_Pattern() {
    PatternTextMatcher matcher = new PatternTextMatcher(Pattern.compile("one"));
    assertThat(matcher.formattedValues()).isEqualTo("'one'");
  }

  @Test
  public void should_Return_Array_Of_Patterns_As_Formatted_Value_If_Matcher_Has_More_Than_One_Pattern() {
    PatternTextMatcher matcher = new PatternTextMatcher(Pattern.compile("one"), Pattern.compile("two"));
    assertThat(matcher.formattedValues()).isEqualTo("[\"one\", \"two\"]");
  }
}
