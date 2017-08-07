package com.tom.patterns.decorator;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;

public class ExampleOfDecorator {

	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("test.zip");
			os = new GZIPOutputStream(os);
			writeSomeContentToOutputStream(os);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e)	{
			e.printStackTrace();
		}
	}

	private static void writeSomeContentToOutputStream(OutputStream os) throws IOException {
		String someContent = "This is some content";
		os = new BufferedOutputStream(os);
		os.write(someContent.getBytes(Charset.forName("UTF-8")));		
	}

}
