import java.util.Scanner;

public class parcial {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String nombreProducto = "";
        int cantidadInicial = 0;
        int stockActual = 0;
        boolean productoRegistrado = false;

        int opcion;

        do {
            System.out.println("\n--- MENÚ DE INVENTARIO ---");
            System.out.println("1. Ingresar información del producto");
            System.out.println("2. Registrar venta");
            System.out.println("3. Duplicar inventario si está agotado");
            System.out.println("4. Mostrar información del inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    entrada.nextLine(); // limpiar buffer
                    System.out.print("Ingrese el nombre del producto: ");
                    nombreProducto = entrada.nextLine();

                    System.out.print("Ingrese la cantidad inicial en inventario: ");
                    cantidadInicial = entrada.nextInt();

                    stockActual = cantidadInicial;
                    productoRegistrado = true;
                    System.out.println("Producto registrado correctamente.");
                    break;

                case 2:
                    if (!productoRegistrado) {
                        System.out.println("Primero debe registrar un producto.");
                        break;
                    }

                    System.out.print("Ingrese la cantidad vendida: ");
                    int vendidos = entrada.nextInt();

                    if (vendidos <= stockActual) {
                        stockActual -= vendidos;
                        System.out.println("Venta registrada. Stock actualizado.");
                    } else {
                        System.out.println("No hay suficiente stock para esta venta.");
                    }
                    break;

                case 3:
                    if (!productoRegistrado) {
                        System.out.println("Primero debe registrar un producto.");
                        break;
                    }

                    if (stockActual == 0) {
                        cantidadInicial *= 2;
                        stockActual = cantidadInicial;
                        System.out.println("Inventario duplicado porque estaba agotado.");
                    } else {
                        System.out.println("El inventario aún no está agotado. No se puede duplicar.");
                    }
                    break;

                case 4:
                    if (!productoRegistrado) {
                        System.out.println("Primero debe registrar un producto.");
                        break;
                    }

                    System.out.println("\n--- Información del producto ---");
                    System.out.println("Producto: " + nombreProducto);
                    System.out.println("Inventario inicial: " + cantidadInicial);
                    System.out.println("Stock actual: " + stockActual);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 5);

        entrada.close();
    }
}

