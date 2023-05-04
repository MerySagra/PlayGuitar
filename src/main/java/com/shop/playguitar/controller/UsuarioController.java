package com.shop.playguitar.controller;

import com.shop.playguitar.modelo.bean.Producto;
import com.shop.playguitar.modelo.bean.Role;
import com.shop.playguitar.modelo.bean.Usuario;
import com.shop.playguitar.modelo.repository.ProductoRepository;
import com.shop.playguitar.modelo.repository.UsuarioRepository;
import com.shop.playguitar.modelo.service.RoleService;
import com.shop.playguitar.modelo.service.UsuarioService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class UsuarioController {

        @Autowired
        private UsuarioService usuarioService;

        @Autowired
        private UsuarioRepository usuarioRepository;

        @Autowired
        private RoleService roleService;

        //Listado de usuarios

        @GetMapping("/todos")
        public List<Usuario> findAllUsers(){
            return usuarioService.findAll();
        }

        //Añadir usuarios

        @PostMapping("/alta")
        public Usuario addUser(@RequestBody Usuario user) {
            return usuarioRepository.save(user);
        }

        //Usuario por id

        @GetMapping("/find/{id}")
        public Usuario verPorId(@PathVariable("id") int id){
            return usuarioService.findById(id);
        }

        //Editar usuarios

        @PutMapping("/editar/{id}")
        public Usuario editarUsuario(@PathVariable int id, @RequestBody Usuario usuarioActualizado){
            Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el id " + id));

            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApellidos(usuarioActualizado.getApellidos());

            return usuarioRepository.save(usuarioExistente);
        }

    }

