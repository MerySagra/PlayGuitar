package com.shop.playguitar.controller;

    import java.math.BigDecimal;
    import java.util.List;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.CrossOrigin;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.ResponseBody;
    import org.springframework.web.bind.annotation.RestController;
    import com.shop.playguitar.modelo.bean.Producto;
    import com.shop.playguitar.modelo.repository.ProductoRepository;
    import com.shop.playguitar.modelo.repository.UsuarioRepository;

    @CrossOrigin(origins="*")
    @RestController
    @RequestMapping("/rest")
    public class ProductoController {

            @Autowired
            private ProductoRepository productoRepository;

            @Autowired
            private UsuarioRepository usuarioRepository;

            //Precio de un producto solicitado
            @GetMapping("/producto/{id}/precio")
            public @ResponseBody
            BigDecimal damePrecioById(@PathVariable("id") double id) {
                //Producto producto = productoRepository.findById((int) id);
                Producto producto = productoRepository.findById((int) id).orElse(null);
                if (producto != null) {
                    return producto.getPrecio();        }
                return null;    }

            //Listado de productos

            @GetMapping("/todos")
            public List<Producto> obtenerTodosProductos(){
                return productoRepository.findAll();
            }

            @GetMapping("/porNombre/{nombre}")
            public List<Producto> obtenerProductoPorNombre(@PathVariable("nombre") String nombre){
                return productoRepository.buscarPorNombre(nombre);
            }

        }

