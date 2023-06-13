package Producto.Modelo;
import java.io.Serializable;

public class Producto implements Serializable {
        public Integer Id;
        private String nombreProducto;
        private String categoria;
        private double cantidad;

        public Producto(Integer id, String nombreProducto, String categoria, double cantidad) {
            Id = id;
            this.nombreProducto = nombreProducto;
            this.categoria = categoria;
            this.cantidad = cantidad;
        }

        public Integer getId() {
            return Id;
        }

        public void setId(Integer id) {
            Id = id;
        }

        public String getNombreProducto() {
            return nombreProducto;
        }

        public void setNombreProducto(String nombreProducto) {
            this.nombreProducto = nombreProducto;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public double getCantidad() {
            return cantidad;
        }

        public void setCantidad(double cantidad) {
            this.cantidad = cantidad;
        }

        @Override
        public String toString() {
            return "Producto ->" +
                    "Id=" + Id +
                    ", nombreProducto='" + nombreProducto + '\'' +
                    ", categoria='" + categoria + '\'' +
                    ", cantidad=" + cantidad ;
        }
    }

