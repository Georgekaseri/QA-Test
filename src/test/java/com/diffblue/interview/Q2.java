
package com.diffblue.interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExampleAnalyzerTest {

    private ExampleAnalyzer exampleAnalyzer;

    @BeforeEach
    void setUp() throws IOException {
        File testFile = new File("src/test/resources/TestFile.java");
        ExampleClass exampleClass = new ExampleClass(testFile);
        exampleAnalyzer = new ExampleAnalyzer(exampleClass);
    }

    @Test
    void testRunTest() {
        CodeTest test = new ExampleTest(1);
        Set<CodeLine> coveredLines = exampleAnalyzer.runTest(test);
        assertEquals(2, coveredLines.size());
        assertTrue(coveredLines.contains(new ExampleLine(2, "    public void testMethod() {")));
        assertTrue(coveredLines.contains(new ExampleLine(3, "        System.out.println(\"Test Method\");")));
    }

    @Test
    void testRunTestSuite() {
        Set<CodeTest> testSuite = new HashSet<>();
        testSuite.add(new ExampleTest(1));
        testSuite.add(new ExampleTest(2));
        exampleAnalyzer.runTestSuite(testSuite);
    }
}
       
