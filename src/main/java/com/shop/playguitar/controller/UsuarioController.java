package com.shop.playguitar.controller;

import com.shop.playguitar.modelo.bean.Usuario;
import com.shop.playguitar.modelo.repository.UsuarioRepository;
import com.shop.playguitar.modelo.service.UsuarioService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class UsuarioController {

        @Autowired
        private UsuarioService usuarioService;

        @Autowired
        private UsuarioRepository usuarioRepository;

    /**
     *
     * @return Devuelve todos los usuarios existentes.
     */

        @GetMapping("/todos")
        public List<Usuario> findAllUsers(){
            return usuarioService.findAll();
        }

    /**
     *
     * @param user
     * @return Da de alta un nuevo usuario
     */

        @PostMapping("/alta")
        public Usuario addUser(@RequestBody Usuario user) {
            return usuarioRepository.save(user);
        }

    /**
     *
     * @param id
     * @return Encuentra al usuario del ID deseado.
     */

        @GetMapping("/find/{id}")
        public Usuario verPorId(@PathVariable("id") int id){
            return usuarioService.findById(id);
        }

    /**
     *
     * @param id
     * @param usuarioActualizado
     * @return Edita la información de un usuario existente.
     */

        @PutMapping("/editar/{id}")
        public Usuario editarUsuario(@PathVariable int id, @RequestBody Usuario usuarioActualizado){
            Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el id " + id));

            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApellidos(usuarioActualizado.getApellidos());
            usuarioExistente.setDirecciones(usuarioActualizado.getDirecciones());

            return usuarioRepository.save(usuarioExistente);
        }

    /**
     *
     * @param email
     * @return Encuentra al usuario a través de su mail.
     */

        @GetMapping("/findByEmail/{email}")
        public Usuario verPorEmail(@PathVariable("email") String email){
        return usuarioService.findByEmail(email);
        }

    /**
     *
     * @param id
     * @return Encuentra al usuario del ID deseado con su dirección.
     */

        @GetMapping("/users-addresses/{id}")
                public Usuario verConDirecciones(@PathVariable("id") int id){
                return usuarioService.findByIdWithAddress(id);
                }

        }

