package Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import java.util.ArrayList;
import java.util.List;
import com.carpopling.apirest.Person.Person;

public class XML {

    public static void EscribeXML(String nombre, String ID, String direccion, String Condicion) {
        try {
            // Cargar el documento XML desde un archivo
            Document document = cargarDesdeArchivo(
                    "apirest\\src\\main\\java\\XML\\registro.xml" //
            );

            // Check if the document is not null before proceeding
            if (document != null) {
                // Realizar modificaciones en el documento
                agregarLibro(document, ID, nombre, direccion, Condicion);

                // Imprimir el contenido del documento XML modificado
                imprimirDocumento(document);

                // Guardar el documento XML modificado
                guardarComoArchivo(document,
                        "apirest\\\\src\\\\main\\\\java\\\\XML\\\\registro.xml");

                System.out.println("Documento XML modificado exitosamente.");
            } else {
                System.out.println("Error cargando el documento XML.");
            }

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static List<Person> obtenerTodosLosEmpleados() {
        try {
            // Cargar el documento XML desde un archivo
            Document document = cargarDesdeArchivo("apirest\\\\src\\\\main\\\\java\\\\XML\\\\registro.xml");

            // Verificar que el documento no sea nulo antes de continuar
            if (document != null) {
                // Obtener la lista de empleados
                NodeList empleados = document.getElementsByTagName("Empleado");

                // Crear una lista para almacenar objetos Person
                List<Person> listaPersonas = new ArrayList<>();

                // Iterar sobre los empleados y agregarlos a la lista
                for (int i = 0; i < empleados.getLength(); i++) {
                    Node empleado = empleados.item(i);
                    if (empleado.getNodeType() == Node.ELEMENT_NODE) {
                        Element empleadoElement = (Element) empleado;
                        String id = obtenerTextoDeElemento(empleadoElement, "ID");
                        String nombre = obtenerTextoDeElemento(empleadoElement, "nombre");
                        String direccion = obtenerTextoDeElemento(empleadoElement, "direccion");
                        String condicion = obtenerTextoDeElemento(empleadoElement, "Condicion");

                        // Crear un objeto Person y agregarlo a la lista
                        Person person = new Person(Integer.parseInt(id), nombre, direccion, condicion);
                        listaPersonas.add(person);
                    }
                }

                // Devolver la lista de Person
                return listaPersonas;

            } else {
                System.out.println("Error cargando el documento XML.");
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return null;
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
        Element IDElement = document.createElement("ID");
        IDElement.appendChild(document.createTextNode(id));
        empleadoElement.appendChild(IDElement);

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

    public static String calificar(String ID, String Cal) {
        try {
            // Cargar el documento XML desde un archivo
            Document document = cargarDesdeArchivo("apirest\\\\src\\\\main\\\\java\\\\XML\\\\registro.xml");

            // Verificar que el documento no sea nulo antes de continuar
            if (document != null) {
                // Buscar el elemento Empleado con el ID proporcionado
                NodeList empleados = document.getElementsByTagName("Empleado");
                for (int i = 0; i < empleados.getLength(); i++) {
                    Node empleado = empleados.item(i);
                    if (empleado.getNodeType() == Node.ELEMENT_NODE) {
                        Element empleadoElement = (Element) empleado;
                        String empleadoID = obtenerTextoDeElemento(empleadoElement, "ID");

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
                                    guardarComoArchivo(document,
                                            "apirest\\\\src\\\\main\\\\java\\\\XML\\\\registro.xml");

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

    // ... (otras funciones de la clase)

    public static String obtenerTextoDeEtiqueta(String tagName) {
        try {
            // Cargar el documento XML desde un archivo
            Document document = cargarDesdeArchivo("apirest\\\\src\\\\main\\\\java\\\\XML\\\\registro.xml" + //
                    "");

            // Verificar que el documento no sea nulo antes de continuar
            if (document != null) {
                NodeList nodeList = document.getElementsByTagName(tagName);
                if (nodeList.getLength() > 0) {
                    Node node = nodeList.item(0);
                    return node.getTextContent();
                } else {
                    System.out.println("Etiqueta '" + tagName + "' no encontrada en el XML.");
                }
            } else {
                System.out.println("Error cargando el documento XML.");
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> obtenerCalificacionesOrdenadas() {
        try {
            // Cargar el documento XML desde un archivo
            Document document = cargarDesdeArchivo("apirest\\\\src\\\\main\\\\java\\\\XML\\\\registro.xml");

            // Verificar que el documento no sea nulo antes de continuar
            if (document != null) {
                // Obtener la lista de empleados
                NodeList empleados = document.getElementsByTagName("Empleado");

                // Crear una lista para almacenar objetos Empleado con Calificacion
                List<Empleado> listaEmpleados = new ArrayList<>();

                // Iterar sobre los empleados y agregarlos a la lista
                for (int i = 0; i < empleados.getLength(); i++) {
                    Node empleado = empleados.item(i);
                    if (empleado.getNodeType() == Node.ELEMENT_NODE) {
                        Element empleadoElement = (Element) empleado;
                        String calificacion = obtenerTextoDeElemento(empleadoElement, "Calificacion");

                        // Agregar la calificación a la lista
                        listaEmpleados.add(new Empleado(calificacion));
                    }
                }

                // Implementar Selection Sort para ordenar la lista de calificaciones en orden
                // descendente
                int n = listaEmpleados.size();
                for (int i = 0; i < n - 1; i++) {
                    int maxIndex = i;
                    for (int j = i + 1; j < n; j++) {
                        if (listaEmpleados.get(j).getCalificacion2()
                                .compareTo(listaEmpleados.get(maxIndex).getCalificacion2()) > 0) {
                            maxIndex = j;
                        }
                    }
                    // Intercambiar los elementos
                    Empleado temp = listaEmpleados.get(maxIndex);
                    listaEmpleados.set(maxIndex, listaEmpleados.get(i));
                    listaEmpleados.set(i, temp);
                }

                // Crear una lista para almacenar las calificaciones ordenadas
                List<String> calificacionesOrdenadas = new ArrayList<>();

                // Obtener las calificaciones ordenadas
                for (Empleado emp : listaEmpleados) {
                    calificacionesOrdenadas.add(emp.getCalificacion2());
                }
                Collections.sort(calificacionesOrdenadas, Collections.reverseOrder());
                // Devolver la lista de calificaciones ordenadas
                insertionSort(calificacionesOrdenadas);
                return calificacionesOrdenadas;

            } else {
                System.out.println("Error cargando el documento XML.");
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<String> obtenerCalificacionesConNombresOrdenados() {
        try {
            // Cargar el documento XML desde un archivo
            Document document = cargarDesdeArchivo("apirest\\\\src\\\\main\\\\java\\\\XML\\\\registro.xml");

            // Verificar que el documento no sea nulo antes de continuar
            if (document != null) {
                // Obtener la lista de empleados
                NodeList empleados = document.getElementsByTagName("Empleado");

                // Crear una lista para almacenar objetos Empleado con Calificacion y Nombre
                List<Empleado> listaEmpleados = new ArrayList<>();

                // Iterar sobre los empleados y agregarlos a la lista
                for (int i = 0; i < empleados.getLength(); i++) {
                    Node empleado = empleados.item(i);
                    if (empleado.getNodeType() == Node.ELEMENT_NODE) {
                        Element empleadoElement = (Element) empleado;
                        String nombre = obtenerTextoDeElemento(empleadoElement, "nombre");
                        String calificacion = obtenerTextoDeElemento(empleadoElement, "Calificacion");

                        // Agregar el nombre y la calificación a la lista
                        listaEmpleados.add(new Empleado(nombre, calificacion));
                    }
                }

                // Implementar Selection Sort para ordenar la lista de calificaciones en orden
                // descendente
                int n = listaEmpleados.size();
                for (int i = 0; i < n - 1; i++) {
                    int maxIndex = i;
                    for (int j = i + 1; j < n; j++) {
                        if (listaEmpleados.get(j).getCalificacion()
                                .compareTo(listaEmpleados.get(maxIndex).getCalificacion()) > 0) {
                            maxIndex = j;
                        }
                    }
                    // Intercambiar los elementos
                    Empleado temp = listaEmpleados.get(maxIndex);
                    listaEmpleados.set(maxIndex, listaEmpleados.get(i));
                    listaEmpleados.set(i, temp);
                }

                // Crear una lista para almacenar las calificaciones ordenadas con nombres
                List<String> calificacionesConNombresOrdenados = new ArrayList<>();

                // Obtener las calificaciones ordenadas con nombres
                for (Empleado emp : listaEmpleados) {
                    calificacionesConNombresOrdenados.add(emp.getNombre() + ": " + emp.getCalificacion());
                }

                return calificacionesConNombresOrdenados;

            } else {
                System.out.println("Error cargando el documento XML.");
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Crear una nueva lista para almacenar los números
    public static void insertionSort(List<String> calificacionesOrdenadas) {
        int n = calificacionesOrdenadas.size();

        // Crear una nueva lista para almacenar los números
        List<Double> numeros = new ArrayList<>();

        // Convertir la lista de cadenas a una lista de números
        for (String calificacion : calificacionesOrdenadas) {
            numeros.add(Double.parseDouble(calificacion));
        }

        for (int i = 1; i < n; ++i) {
            double key = numeros.get(i);
            int j = i - 1;

            // Mover los elementos de arr[0..i-1], que son menores que key,
            // a una posición adelante de su posición actual (orden de mayor a menor)
            while (j >= 0 && numeros.get(j) < key) {
                numeros.set(j + 1, numeros.get(j));
                j = j - 1;
            }
            numeros.set(j + 1, key);
        }

        // Asignar los elementos ordenados al ArrayList original
        for (int i = 0; i < n; ++i) {
            calificacionesOrdenadas.set(i, String.valueOf(numeros.get(i)));
        }
    }

    public static boolean existeIdEnXML(String id) {
        try {
            // Cargar el documento XML desde un archivo
            Document document = cargarDesdeArchivo("apirest\\\\src\\\\main\\\\java\\\\XML\\\\registro.xml");

            // Verificar que el documento no sea nulo antes de continuar
            if (document != null) {
                // Obtener la lista de empleados
                NodeList empleados = document.getElementsByTagName("Empleado");

                // Iterar sobre los empleados y verificar si el ID existe
                for (int i = 0; i < empleados.getLength(); i++) {
                    Node empleado = empleados.item(i);
                    if (empleado.getNodeType() == Node.ELEMENT_NODE) {
                        Element empleadoElement = (Element) empleado;
                        String empleadoId = obtenerTextoDeElemento(empleadoElement, "ID");

                        // Comparar el ID actual con el ID proporcionado
                        if (empleadoId.equals(id)) {
                            return true; // ID encontrado
                        }
                    }
                }

                // Si llegamos aquí, el ID no se encontró
                return false;

            } else {
                System.out.println("Error cargando el documento XML.");
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return false; // Si hay algún error, devolver falso
    }

    // Método para imprimir el array
    private static class Empleado {
        private String nombre;
        private String calificacion;
        private String calificacion2;

        public Empleado(String nombre, String calificacion) {
            this.nombre = nombre;
            this.calificacion = calificacion;
        }

        public Empleado(String calificacion2) {
            this.calificacion2 = calificacion2;
        }

        public String getNombre() {
            return nombre;
        }

        public String getCalificacion() {
            return calificacion;
        }

        public String getCalificacion2() {
            return calificacion2;
        }
    }

}