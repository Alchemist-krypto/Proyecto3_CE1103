package Clases;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML {

    public static void EscribeXML(String nombre, String ID, String direccion, String Condicion) {
        try {
            // Cargar el documento XML desde un archivo
            Document document = cargarDesdeArchivo("src\\XML\\registro.xml");

            // Check if the document is not null before proceeding
            if (document != null) {
                // Realizar modificaciones en el documento
                agregarLibro(document, ID, nombre, direccion, Condicion);

                // Imprimir el contenido del documento XML modificado
                imprimirDocumento(document);

                // Guardar el documento XML modificado
                guardarComoArchivo(document, "src\\XML\\registro.xml");

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
        
        Element CalificacionElement = document.createElement("Calificacion");
        CalificacionElement.appendChild(document.createTextNode("0"));
        empleadoElement.appendChild(CalificacionElement);

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
    
       public static String calificar(String ID,String Cal) {
    try {
        // Cargar el documento XML desde un archivo
        Document document = cargarDesdeArchivo("src\\XML\\registro.xml");

        // Verificar que el documento no sea nulo antes de continuar
        if (document != null) {
            // Buscar el elemento Empleado con el ID proporcionado
            NodeList empleados = document.getElementsByTagName("Empleado");
            for (int i = 0; i < empleados.getLength(); i++) {
                Node empleado = empleados.item(i);
                if (empleado.getNodeType() == Node.ELEMENT_NODE) {
                    Element empleadoElement = (Element) empleado;
                    String empleadoID = empleadoElement.getAttribute("ID");
                    if (empleadoID.equals(ID)) {
                        // Encontrado el empleado con el ID, obtener el nombre
                        String nombre = obtenerTextoDeElemento(empleadoElement, "Calificacion");

                        // Concatenar "1" al nombre
                        if (nombre != null) {
                            String nuevoNombre = Integer.toString(Integer.parseInt(nombre) + Integer.parseInt(Cal));

                            // Modificar el elemento nombre en el XML
                            NodeList nombreNodeList = empleadoElement.getElementsByTagName("Calificacion");
                            if (nombreNodeList.getLength() > 0) {
                                Node nombreNode = nombreNodeList.item(0);
                                nombreNode.setTextContent(nuevoNombre);
                                // Guardar el documento XML modificado
                                guardarComoArchivo(document, "src\\XML\\registro.xml");

                                System.out.println("Nombre modificado en el XML: " + nuevoNombre);
                            } else {
                                System.out.println("Elemento 'nombre' no encontrado para el ID: " + ID);
                            }

                            return nuevoNombre;
                        } else {
                            System.out.println("Nombre no encontrado para el ID: " + ID);
                        }
                    }
                }
            }
            System.out.println("Empleado no encontrado para el ID: " + ID);
        } else {
            System.out.println("Error cargando el documento XML.");
        }

    } catch (ParserConfigurationException | TransformerException e) {
        e.printStackTrace();
    }
    return null;


    }

    private static String obtenerTextoDeElemento(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            return node.getTextContent();
        } else {
            return null;
        }
    }
}
