package Producto.Repositorio;
import Producto.Modelo.Producto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryImpl  implements  ProductoRepository {
    private List<Producto> productos;

    public ProductoRepositoryImpl() throws IOException, ClassNotFoundException {
        productos = new ArrayList<>();
    }

    @Override
    public Producto findById(int id) {
        return productos.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Producto> findAll() throws IOException, ClassNotFoundException {
        productos = (List<Producto>) ObjectSerializer.readObjectFromFile("productos.ax");
        return productos;
    }

    @Override
    public void save(Producto producto) throws IOException {
        productos.add(producto);
        ObjectSerializer.writeObjectToFile(productos, "productos.ax");
    }

    @Override
    public void update(Producto producto) throws IOException {
        Producto oldProducto = findById(producto.getId());
        if (oldProducto != null) {
            productos.remove(oldProducto);
            productos.add(producto);
            ObjectSerializer.writeObjectToFile(productos, "productos.ax");
        }
    }

    @Override
    public void delete(Producto producto) throws IOException {
        productos.remove(producto);
        ObjectSerializer.writeObjectToFile(productos, "productos.ax");
    }
}