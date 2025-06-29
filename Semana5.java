// Clase que representa un nodo individual en la lista enlazada.
// Cada nodo contiene un valor (en este caso, el nombre de una asignatura)
// y una referencia al siguiente nodo en la secuencia.
public class Node{

public string Data { get; set; } // El dato almacenado en el nodo (nombre de la asignatura)
    public Node Next { get; set; }   // Referencia al siguiente nodo en la lista

    // Constructor para inicializar un nuevo nodo con un dato específico.
    public Node(string data)
    {
        Data = data;
        Next = null; // Por defecto, el siguiente nodo es nulo
    }
}

// Clase que representa la estructura de la lista enlazada.
// Contiene una referencia al primer nodo (Head) de la lista.
public class LinkedList
{
    public Node Head { get; private set; } // Referencia al primer nodo de la lista

    // Constructor para inicializar una lista enlazada vacía.
    public LinkedList()
    {
        Head = null; // Una lista nueva está vacía, por lo que Head es nulo
    }

    // Método para añadir un nuevo nodo al final de la lista.
    public void Add(string data)
    {
        Node newNode = new Node(data); // Crea un nuevo nodo con el dato proporcionado

        // Si la lista está vacía, el nuevo nodo se convierte en la cabeza de la lista.
        if (Head == null)
        {
            Head = newNode;
        }
        else
        {
            // Si la lista no está vacía, recorre la lista hasta encontrar el último nodo.
            Node current = Head;
            while (current.Next != null)
            {
                current = current.Next;
            }
            // Una vez en el último nodo, su propiedad Next apunta al nuevo nodo.
            current.Next = newNode;
        }
    }

    // Método para mostrar todos los elementos de la lista enlazada por pantalla.
    public void Display()
    {
        // Si la lista está vacía, imprime un mensaje.
        if (Head == null)
        {
            Console.WriteLine("La lista de asignaturas está vacía.");
            return;
        }

        Console.WriteLine("Asignaturas del curso (Lista Enlazada):");
        Node current = Head; // Empieza desde la cabeza de la lista.

        // Recorre la lista hasta que el nodo actual sea nulo (fin de la lista).
        while (current != null)
        {
            Console.WriteLine(current.Data); // Imprime el dato del nodo actual.
            current = current.Next;          // Avanza al siguiente nodo.
        }
    }
}

// Clase principal que contiene el método Main para ejecutar el programa.
public class ProgramaAsignaturasConNodos
{
    public static void Main(string[] args)
    {
        // Crear una instancia de nuestra clase LinkedList.
        LinkedList asignaturasLista = new LinkedList();

        // Añadir las asignaturas a la lista utilizando el método Add de nuestra LinkedList.
        asignaturasLista.Add("Matemáticas");
        asignaturasLista.Add("Física");
        asignaturasLista.Add("Química");
        asignaturasLista.Add("Historia");
        asignaturasLista.Add("Lengua");

        // Mostrar las asignaturas utilizando el método Display de nuestra LinkedList.
        asignaturasLista.Display();

        // Puedes descomentar la siguiente línea si necesitas que la consola
        // no se cierre inmediatamente después de la ejecución en algunos entornos.
        // Console.ReadKey();
    }
}
    }

