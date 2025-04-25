import java.util.Scanner;

public class InventarioZapatos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Variables del producto
        String nombreProducto;
        int cantidadInicial;
        int unidadesVendidas;
        int stockActual;

        // Ingreso de información del producto
        System.out.println("Ingrese el nombre del producto:");
        nombreProducto = entrada.nextLine();

        System.out.println("Ingrese la cantidad inicial en inventario:");
        cantidadInicial = entrada.nextInt();

        System.out.println("Ingrese la cantidad de unidades vendidas:");
        unidadesVendidas = entrada.nextInt();

        // Cálculo de stock actual
        stockActual = cantidadInicial - unidadesVendidas;

        // Validación de disponibilidad
        if (stockActual >= 0) {
            System.out.println("Stock disponible después de la venta: " + stockActual);
        } else {
            System.out.println("¡No hay suficiente stock para realizar esta venta!");
            stockActual = 0;
        }

        // Duplicar inventario si se ha vendido todo
        if (stockActual == 0 && unidadesVendidas > 0) {
            cantidadInicial = unidadesVendidas * 2;
            stockActual = cantidadInicial;
            System.out.println("El producto se vendió completamente. Inventario duplicado.");
        }

        // Mostrar información actualizada del inventario
        System.out.println("\n--- Información del producto ---");
        System.out.println("Producto: " + nombreProducto);
        System.out.println("Inventario actual: " + stockActual);

        entrada.close();
    }
}
