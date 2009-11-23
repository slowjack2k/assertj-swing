/*
 * Created on Dec 23, 2007
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2007-2009 the original author or authors.
 */
package org.fest.assertions;

import static org.fest.assertions.CommonFailures.*;
import static org.fest.assertions.NotNull.notNullFile;
import static org.fest.test.ExpectedFailure.expectAssertionError;
import org.fest.test.CodeToTest;
import org.junit.Test;

/**
 * Tests for <code>{@link FileAssert#doesNotSatisfy(Condition)}</code>.
 *
 * @author David DIDIER
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class FileAssert_doesNotSatisfy_Test extends FileAssert_TestCase
    implements GenericAssert_doesNotSatisfy_TestCase {

  @Test
  public void should_pass_if_condition_is_not_satisfied() {
    new FileAssert(null).doesNotSatisfy(notNullFile());
  }

  @Test
  public void should_throw_error_if_condition_is_null() {
    expectErrorIfConditionIsNull().on(new CodeToTest() {
      public void run() {
        new FileAssert(file).doesNotSatisfy(null);
      }
    });
  }

  @Test
  public void should_fail_if_condition_is_satisfied() {
    expectAssertionError("actual value:<c:\\f.txt> should not satisfy condition:<NotNull>").on(new CodeToTest() {
      public void run() {
        new FileAssert(file).doesNotSatisfy(notNullFile());
      }
    });
  }

  @Test
  public void should_fail_and_display_description_of_assertion_if_condition_is_satisfied() {
    String message = "[A Test] actual value:<c:\\f.txt> should not satisfy condition:<NotNull>";
    expectAssertionError(message).on(new CodeToTest() {
      public void run() {
        new FileAssert(file).as("A Test")
                            .doesNotSatisfy(notNullFile());
      }
    });
  }

  @Test
  public void should_fail_and_display_description_of_condition_if_condition_is_satisfied() {
    expectAssertionError("actual value:<c:\\f.txt> should not satisfy condition:<Not Null>").on(new CodeToTest() {
      public void run() {
        new FileAssert(file).doesNotSatisfy(notNullFile().as("Not Null"));
      }
    });
  }

  @Test
  public void should_fail_and_display_descriptions_of_assertion_and_condition_if_condition_is_satisfied() {
    expectAssertionError("[A Test] actual value:<c:\\f.txt> should not satisfy condition:<Not Null>").on(
      new CodeToTest() {
        public void run() {
          new FileAssert(file).as("A Test")
                              .doesNotSatisfy(notNullFile().as("Not Null"));
        }
      });
  }

  @Test
  public void should_fail_with_custom_message_if_condition_is_satisfied() {
    expectAssertionError("My custom message").on(new CodeToTest() {
      public void run() {
        new FileAssert(file).overridingErrorMessage("My custom message")
                            .doesNotSatisfy(notNullFile());
      }
    });
  }

  @Test
  public void should_fail_with_custom_message_ignoring_description_of_assertion_if_condition_is_satisfied() {
    expectAssertionError("My custom message").on(new CodeToTest() {
      public void run() {
        new FileAssert(file).as("A Test")
                            .overridingErrorMessage("My custom message")
                            .doesNotSatisfy(notNullFile());
      }
    });
  }

  @Test
  public void should_fail_with_custom_message_ignoring_description_of_condition_if_condition_is_satisfied() {
    expectAssertionError("My custom message").on(new CodeToTest() {
      public void run() {
        new FileAssert(file).overridingErrorMessage("My custom message")
                            .doesNotSatisfy(notNullFile().as("Not Null"));
      }
    });
  }
}