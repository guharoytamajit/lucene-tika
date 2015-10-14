package luceneDemo;

import java.io.File;
import java.io.FileInputStream;

import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

public class TikaDemo {
	public static void main(String[] args) throws Exception {
		File file = new File("data/test.html.pdf");//

		// Instantiating tika facade class
		Tika tika = new Tika();

		// detecting the file type using detect method
		String filetype = tika.detect(file);
		System.out.println(filetype);

		// Parser method parameters
		Parser parser = new AutoDetectParser();
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		FileInputStream inputstream = new FileInputStream(file);
		ParseContext context = new ParseContext();

		parser.parse(inputstream, handler, metadata, context);
		System.out.println(handler.toString());

		// getting the list of all meta data elements
		String[] metadataNames = metadata.names();

		for (String name : metadataNames) {
			System.out.println(name + ": " + metadata.get(name));
		}
	}
}
