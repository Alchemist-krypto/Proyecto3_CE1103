import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML {

    public static void EscribeXML(String nombre, String ID, String direccion, String Condicion) {
        try {
            // Cargar el documento XML desde un archivo
            Document document = cargarDesdeArchivo("registro.xml");

            // Check if the document is not null before proceeding
            if (document != null) {
                // Realizar modificaciones en el documento
                agregarLibro(document, ID, nombre, direccion, Condicion);

                // Imprimir el contenido del documento XML modificado
                imprimirDocumento(document);

                // Guardar el documento XML modificado
                guardarComoArchivo(document, "registro.xml");

                System.out.println("Documento XML modificado exitosamente.");
            } else {
                System.out.println("Error cargando el documento XML.");
            }

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static Document cargarDesdeArchivo(String filePath) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            return builder.parse(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void agregarLibro(Document document, String id, String nombre, String direccion, String Condicion) {
        Element rootElement = document.getDocumentElement();

        // Crear un nuevo elemento Empleado
        Element empleadoElement = document.createElement("Empleado");
        rootElement.appendChild(empleadoElement);

        // Configurar el atributo 'ID'
        empleadoElement.setAttribute("ID", id);

        // Crear elementos secundarios
        Element nombreElement = document.createElement("nombre");
        nombreElement.appendChild(document.createTextNode(nombre));
        empleadoElement.appendChild(nombreElement);

        Element direccionElement = document.createElement("direccion");
        direccionElement.appendChild(document.createTextNode(direccion));
        empleadoElement.appendChild(direccionElement);

        Element CondicionElement = document.createElement("Condicion");
        CondicionElement.appendChild(document.createTextNode(Condicion));
        empleadoElement.appendChild(CondicionElement);

        // Agregar un salto de línea al final del elemento Empleado
        empleadoElement.appendChild(document.createTextNode("\n"));
    }

    private static void imprimirDocumento(Document document) {
        // Imprimir el contenido del documento XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
            System.out.println(); // Agregar una línea en blanco para mayor claridad
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void guardarComoArchivo(Document document, String filePath) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(filePath);
        transformer.transform(source, result);
    }
}
