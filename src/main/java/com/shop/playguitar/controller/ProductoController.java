package com.shop.playguitar.controller;

    import java.math.BigDecimal;
    import java.util.List;

    import com.shop.playguitar.modelo.service.ProductoService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.CrossOrigin;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.ResponseBody;
    import org.springframework.web.bind.annotation.RestController;
    import com.shop.playguitar.modelo.bean.Producto;
    import com.shop.playguitar.modelo.repository.UsuarioRepository;

    @CrossOrigin(origins="*")
    @RestController
    @RequestMapping("/rest")
    public class ProductoController {

            @Autowired
            private ProductoService productoService;

            @Autowired
            private UsuarioRepository usuarioRepository;

        /**
         *
         * @param id
         * @return Devuelte el precio de un producto a través de su id
         */

            @GetMapping("/producto/{id}/precio")
            public @ResponseBody
            BigDecimal damePrecioById(@PathVariable("id") double id) {
                //Producto producto = productoRepository.findById((int) id);
                Producto producto = productoService.findById((int) id);
                if (producto != null) {
                    return producto.getPrecio();        }
                return null;    }

        /**
         *
         * @return Devuelve todos los productos
         */

            @GetMapping("/todos")
            public List<Producto> obtenerTodosProductos(){
                return productoService.findAll();
            }

        /**
         *
         * @param nombre
         * @return Devuelve los productos por su nombre.
         */

            @GetMapping("/porNombre/{nombre}")
            public List<Producto> obtenerProductoPorNombre(@PathVariable("nombre") String nombre){
                return productoService.findByName(nombre);
            }

        /**
         *
         * @param id
         * @return Devuelve un producto por su id
         */

            @GetMapping("/porId/{id}")
            public Producto obtenerProductoPorId(@PathVariable("id") int id){
                return productoService.findById(id);
            }

        }

