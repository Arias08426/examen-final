package Producto.Repositorio;

import Producto.Modelo.Producto;
import Producto.Repositorio.ProductoRepository;
import Producto.Repositorio.ProductoRepositoryImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PrincipalProducto {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opcion = "1";
        ProductoRepository repo = new ProductoRepositoryImpl();
        do {
            Scanner s = new Scanner(System.in);
            System.out.print("Menu \n 1. Agregar  \n 2. Listar \n 3. Editar " +
                    "\n 4. Eliminar  \n 5. Salir \n =>");
            opcion = s.next();
            switch (opcion) {
                case "1": {
                    System.out.println("Id producto: ");
                    Integer id = s.nextInt();
                    System.out.println("Nombre producto: ");
                    String nombre = s.next();
                    System.out.println("categoria: ");
                    String categ = s.next();
                    System.out.println("cantidad: ");
                    double cant = s.nextDouble();
                    repo.save(new Producto(id, nombre, categ, cant));
                    break;
                }
                case "2": {
                    List<Producto> productos = repo.findAll();
                    productos.forEach(System.out::println);
                    break;
                }
                case "3": {
                    System.out.println("===== editar ====");
                    System.out.print("id  producto: ");
                    Integer idp = s.nextInt();
                    System.out.print("ingrese nombre: ");
                    String nombre = s.next();
                    System.out.print("ingrese categoria: ");
                    String categ = s.next();
                    System.out.print("ingrese cantidad: ");
                    double cant = s.nextDouble();
                    Producto beaActualizar = new Producto(idp, nombre, categ, cant);
                    repo.update(beaActualizar);
                    break;
                }
                case "4": {
                    System.out.println("===== eliminar ======");
                    System.out.print("ingrese id del registro: ");
                    Integer id = s.nextInt();
                    repo.delete(repo.findById(id));
                    repo.findAll().forEach(System.out::println);
                    break;
                }
                case "5": {
                    opcion = "5";
                    break;
                }
            }
        } while (opcion != "5");
    }
}