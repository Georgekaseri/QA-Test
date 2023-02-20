/*package com.diffblue.interview;

public class Q1 {
    
}*/
package com.diffblue.interview;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExampleClassTest {

    @Test
    void testGetLinesOfCode() throws IOException {
        File testFile = new File("src/test/resources/TestFile.java");
        ExampleClass exampleClass = new ExampleClass(testFile);
        List<CodeLine> codeLines = exampleClass.getLinesOfCode();
        assertEquals(3, codeLines.size());
        assertEquals("public class TestFile {", codeLines.get(0).getContents());
        assertEquals(1, codeLines.get(0).getLineNumber());
        assertEquals("    public void testMethod() {", codeLines.get(1).getContents());
        assertEquals(2, codeLines.get(1).getLineNumber());
        assertEquals("        System.out.println(\"Test Method\");", codeLines.get(2).getContents());
        assertEquals(3, codeLines.get(2).getLineNumber());
    }

    @Test
    void testGetFile() throws IOException {
        File testFile = new File("src/test/resources/TestFile.java");
        ExampleClass exampleClass = new ExampleClass(testFile);
        assertEquals(testFile, exampleClass.getFile());
    }

}
//In this test case, we have two test methods. The first one, testGetLinesOfCode, tests the getLinesOfCode method of the ExampleClass. We first create a File object representing a test file in the src/test/resources directory. We then create an ExampleClass object using this File. We call the getLinesOfCode method on the ExampleClass object, which should return a list of CodeLine objects. We then check that the size of the list is 3, and that the contents and line numbers of each CodeLine object are correct.
//The second test method, testGetFile, tests the getFile method of the ExampleClass. We create an ExampleClass object using a File object representing the test file, and we check that the getFile method of the ExampleClass object returns the same File object.
