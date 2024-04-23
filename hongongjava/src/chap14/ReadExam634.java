package chap14;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExam634 {

	public static void main(String[] args) throws IOException {
		Reader reader = new FileReader("D:/temp/test9.txt");
		
		char[]buffer = new char[5];
		
		int readCharNum = reader.read(buffer,2,3);
		System.out.println(readCharNum);
		if(readCharNum != -1)
		{
			for(int i=2; i<buffer.length;i++)
			{System.out.println(buffer[i]);}
		}
		
		reader.close();
	}

}
