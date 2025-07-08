import java.util.*;
public class LibretaDeNotas {
    private HashMap<String, ArrayList<Double>> calificaciones;

    public LibretaDeNotas() {
        calificaciones = new HashMap<>();
    }

    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = scanner.nextInt();
        System.out.print("Ingrese la cantidad de notas por alumno: ");
        int cantidadNotas = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.print("Ingrese el nombre del alumno #" + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            ArrayList<Double> notas = new ArrayList<>();
            for (int j = 0; j < cantidadNotas; j++) {
                System.out.print("Ingrese la nota #" + (j + 1) + " de " + nombre + ": ");
                double nota = scanner.nextDouble();
                notas.add(nota);
            }
            scanner.nextLine(); // limpiar buffer
            calificaciones.put(nombre, notas);
        }
    }

    public void mostrarPromedios() {
        System.out.println("\n--- Promedios por alumno ---");
        for (Map.Entry<String, ArrayList<Double>> entry : calificaciones.entrySet()) {
            String alumno = entry.getKey();
            ArrayList<Double> notas = entry.getValue();
            double suma = 0;
            for (double nota : notas) {
                suma += nota;
            }
            double promedio = suma / notas.size();
            System.out.println(alumno + ": Promedio = " + promedio);
        }

    }
    public void mostrarNotaMaxima() {
        System.out.println("\n--- Nota Máxima por Alumno ---");
        for (Map.Entry<String, ArrayList<Double>> entry : calificaciones.entrySet()) {
            String alumno = entry.getKey();
            ArrayList<Double> notas = entry.getValue();

            double maxNota = Collections.max(notas);
            System.out.println(alumno + ": Nota Máxima = " + maxNota);
        }
    }

    public void mostrarNotaMinima() {
        System.out.println("\n--- Nota Mínima por Alumno ---");
        for (Map.Entry<String, ArrayList<Double>> entry : calificaciones.entrySet()) {
            String alumno = entry.getKey();
            ArrayList<Double> notas = entry.getValue();

            double minNota = Collections.min(notas);
            System.out.println(alumno + ": Nota Mínima = " + minNota);
        }
    }


    public static void main(String[] args) {
        LibretaDeNotas libreta = new LibretaDeNotas();
        libreta.ingresarDatos();
        //2libreta.mostrarPromedios();
        libreta.mostrarNotaMaxima();  // ← Nueva función
        libreta.mostrarNotaMinima();
    }
}