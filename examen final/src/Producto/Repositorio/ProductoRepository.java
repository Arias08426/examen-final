package Producto.Repositorio;
import Producto.Modelo.Producto;
import java.io.IOException;
import java.util.List;

public interface ProductoRepository {
    Producto findById(int id);
    List<Producto> findAll() throws IOException, ClassNotFoundException;
    void save(Producto producto) throws IOException;
    void update(Producto producto) throws IOException;
    void delete(Producto producto) throws IOException;
}
