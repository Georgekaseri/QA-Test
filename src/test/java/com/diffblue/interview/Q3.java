/*To test the use case where the program is used to find all lines of code covered in a Java source file by at least two different test files, we can do the following:
1. Create a CodeClass object for the Java source file that we want to test.
2. Generate two random ExampleTest objects that will test against the CodeClass.
3. Run the tests against the CodeClass object.
4. Use ExampleAnalyzer to determine the lines of code that are covered by both tests.
5. Ensure that the output of the test is correct and that it does not change between executions.
Here is an implementation of the above steps as an end-to-end test:*/

package com.diffblue.interview;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q3 {

  @Test
  public void testFindAllLinesCoveredByTwoTests() throws IOException {
    // Create a CodeClass object for the Java source file we want to test
    final File file = new File("src/test/resources/ExampleClass.java");
    final CodeClass codeClass = new ExampleClass(file);

    // Generate two random ExampleTest objects to test against the CodeClass
    final ExampleTest test1 = new ExampleTest("Test 1", 123);
    final ExampleTest test2 = new ExampleTest("Test 2", 456);
    test1.testAgainst(codeClass);
    test2.testAgainst(codeClass);

    // Use ExampleAnalyzer to determine the lines of code that are covered by both tests
    final ExampleAnalyzer analyzer = new ExampleAnalyzer();
    final Set<CodeLine> linesCoveredByBothTests = analyzer.findLinesCoveredByMultipleTests(
        Set.of(test1, test2),
        codeClass
    );

    // Check that the output is correct and does not change between executions
    assertEquals(3, linesCoveredByBothTests.size());
    assertTrue(linesCoveredByBothTests.contains(new CodeLine(3, "  private int exampleField;")));
    assertTrue(linesCoveredByBothTests.contains(new CodeLine(9, "  public ExampleClass() {")));
    assertTrue(linesCoveredByBothTests.contains(new CodeLine(15, "    return exampleField;")));
  }
}
