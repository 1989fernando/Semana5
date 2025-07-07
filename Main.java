// Clase para representar un nodo de la lista enlazada*/
class Nodo {
    int dato;
    Nodo siguiente;
    
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// Clase Lista Enlazada
class ListaEnlazada {
    private Nodo cabeza;
    
    public ListaEnlazada() {
        cabeza = null;
    }
    
    // Método para agregar elementos al final de la lista
    public void agregar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }
    
    /**
     * Método de búsqueda que retorna el número de veces que se encuentra 
     * el dato dentro de la lista enlazada.
     * 
     * @param valor El valor que se desea buscar en la lista
     * @return El número de veces que aparece el valor en la lista
     */
    public int buscar(int valor) {
        int contador = 0;
        Nodo actual = cabeza;
        
        // Recorrer toda la lista enlazada
        while (actual != null) {
            if (actual.dato == valor) {
                contador++;
            }
            actual = actual.siguiente;
        }
        
        // Mostrar resultado según las especificaciones
        if (contador == 0) {
            System.out.println("El dato '" + valor + "' no fue encontrado.");
        } else {
            System.out.println("El dato '" + valor + "' se encontró " + contador + " vez(es) en la lista.");
        }
        
        return contador;
    }
    
    // Método auxiliar para mostrar toda la lista
    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        
        System.out.print("Lista: ");
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }
    
    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }
    
    // Método para obtener el tamaño de la lista
    public int obtenerTamaño() {
        int tamaño = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            tamaño++;
            actual = actual.siguiente;
        }
        return tamaño;
    }
    
    // Método para eliminar la primera ocurrencia de un valor
    public boolean eliminar(int valor) {
        if (cabeza == null) {
            return false;
        }
        
        // Si el elemento a eliminar es el primero
        if (cabeza.dato == valor) {
            cabeza = cabeza.siguiente;
            return true;
        }
        
        // Buscar el elemento en el resto de la lista
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato == valor) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        
        return false;
    }
}

// Clase principal para probar la implementación
public class Main {
    public static void main(String[] args) {
        System.out.println("=== LISTA ENLAZADA EN JAVA ===");
        System.out.println("Implementación del método de búsqueda\n");
        
        // Crear una lista enlazada
        ListaEnlazada lista = new ListaEnlazada();
        
        // Agregar elementos de prueba
        System.out.println("Agregando elementos a la lista...");
        lista.agregar(5);
        lista.agregar(10);
        lista.agregar(5);
        lista.agregar(15);
        lista.agregar(5);
        lista.agregar(20);
        lista.agregar(10);
        
        // Mostrar la lista
        lista.mostrarLista();
        System.out.println("Tamaño de la lista: " + lista.obtenerTamaño());
        
        System.out.println("\n--- PRUEBAS DEL MÉTODO BUSCAR ---");
        
        // Caso 1: Buscar un valor que existe múltiples veces
        System.out.println("\n1. Buscando el valor 5:");
        int resultado1 = lista.buscar(5);
        
        // Caso 2: Buscar un valor que existe pocas veces
        System.out.println("\n2. Buscando el valor 10:");
        int resultado2 = lista.buscar(10);
        
        // Caso 3: Buscar un valor que existe una sola vez
        System.out.println("\n3. Buscando el valor 15:");
        int resultado3 = lista.buscar(15);
        
        // Caso 4: Buscar un valor que no existe
        System.out.println("\n4. Buscando el valor 25:");
        int resultado4 = lista.buscar(25);
        
        // Caso 5: Buscar en lista vacía
        System.out.println("\n5. Probando con lista vacía:");
        ListaEnlazada listaVacia = new ListaEnlazada();
        listaVacia.mostrarLista();
        int resultado5 = listaVacia.buscar(10);
        
        // Resumen de resultados
        System.out.println("\n--- RESUMEN DE RESULTADOS ---");
        System.out.println("Valor 5: " + resultado1 + " ocurrencias");
        System.out.println("Valor 10: " + resultado2 + " ocurrencias");
        System.out.println("Valor 15: " + resultado3 + " ocurrencias");
        System.out.println("Valor 25: " + resultado4 + " ocurrencias");
        System.out.println("Valor 10 (lista vacía): " + resultado5 + " ocurrencias");
        
        // Ejemplo adicional: Modificar la lista y buscar nuevamente
        System.out.println("\n--- PRUEBA ADICIONAL ---");
        System.out.println("Eliminando una ocurrencia del valor 5...");
        lista.eliminar(5);
        lista.mostrarLista();
        System.out.println("Buscando el valor 5 después de eliminar:");
        lista.buscar(5);
    }
}

