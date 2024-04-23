package chap14;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExam628 {

	public static void main(String[] args) throws IOException {
		Writer writer = new FileWriter("D:/temp/test9.txt");
		char[] array = {'a', 'b', 'c', 'd', 'e'};
		
		writer.write(array,1,3);
		writer.flush();
		writer.close();
	}

}
