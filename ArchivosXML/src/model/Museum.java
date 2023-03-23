package model;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class Museum {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation dom = builder.getDOMImplementation();
			
			Document document = dom.createDocument(null, "artwork", null);
			document.setXmlVersion("1.0");
			
			Element works = document.createElement("works");
			
			Element artwork1 = document.createElement("work");
			artwork1.setAttribute("id", "1");
			artwork1.setAttribute("type", "pintura");
			
			Element artwork2 = document.createElement("work");
			artwork2.setAttribute("id", "2");
			artwork2.setAttribute("type", "escultura");
			
			Element name = document.createElement("name");
			Text name1 = document.createTextNode(" La mona Liza ");
			name.appendChild(name1);
			
			Element nameA = document.createElement("name");
			Text name2 = document.createTextNode(" Torzo de mujer ");
			nameA.appendChild(name2);
			
			Element type = document.createElement("type");
			Text type1 = document.createTextNode(" pintura ");
			type.appendChild(type1);
			
			Element typeA = document.createElement("type");
			Text type2 = document.createTextNode(" Escultura ");
			typeA.appendChild(type2);
			
			Element value = document.createElement("value");
			Text value1 = document.createTextNode(" 50000 USD ");
			value.appendChild(value1);
			
			Element valueA = document.createElement("value");
			Text value2 = document.createTextNode(" 30000 USD ");
			valueA.appendChild(value2);
			
			
			Element author = document.createElement("autor");
			Element authorName = document.createElement("name");
			Text Text1 = document.createTextNode(" Leonardo ");
			authorName.appendChild(Text1);
			
			Element authorA = document.createElement("autor");
			Element authorNameA = document.createElement("name");
			Text Text2 = document.createTextNode(" Fernando ");
			authorNameA.appendChild(Text2);
			
			
			Element authorLastName = document.createElement("lastname");
			Text authorLastNameText = document.createTextNode(" Da vinci ");
			authorLastName.appendChild(authorLastNameText);
			
			Element authorLastName1 = document.createElement("lastname");
			Text LastNameText = document.createTextNode(" Botero ");
			authorLastName1.appendChild(LastNameText);
			
			
			artwork1.appendChild(name);
			artwork1.appendChild(type);
			artwork1.appendChild(value);
			artwork1.appendChild(author);
			
			artwork2.appendChild(nameA);
			artwork2.appendChild(typeA);
			artwork2.appendChild(valueA);
			artwork2.appendChild(authorA);
			
			author.appendChild(authorName);
			author.appendChild(authorLastName);
			
			authorA.appendChild(authorNameA);
			authorA.appendChild(authorLastName1);
			
			works.appendChild(artwork1);
			works.appendChild(artwork2);
			
			document.getDocumentElement().appendChild(works);
			
			Source source = new DOMSource(document);
			Result result = new StreamResult(new File("src/resources/artwork.xml"));
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			
			System.out.println("Archivo de Artwork XML creado");
			
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}
}