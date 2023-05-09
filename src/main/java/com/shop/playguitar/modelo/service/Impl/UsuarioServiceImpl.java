package com.shop.playguitar.modelo.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.shop.playguitar.modelo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.shop.playguitar.modelo.bean.Direcciones;
import com.shop.playguitar.modelo.bean.Role;
import com.shop.playguitar.modelo.bean.Tarjeta;
import com.shop.playguitar.modelo.bean.Usuario;
import com.shop.playguitar.modelo.repository.RoleRepository;
import com.shop.playguitar.modelo.repository.UsuarioRepository;



@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository urepo;
	
	@Autowired
	private RoleRepository rrepo;

	@Override
	public List<Usuario> findAll() {
	
		return urepo.findAll();
	}

	@Override
	public Usuario findById(int idUsuario) {
		return urepo.findById(idUsuario).orElse(null);
	}

	@Override
	public Usuario findByEmail(String email) {
			return urepo.findByEmail(email);
	}

	@Override
	public Usuario findByIdWithAddress(int idUsuario){
		return urepo.findByIdWithAddress(idUsuario);
	}

	@Override
	public int altaUsuario(Usuario usuario) {
		int filas=0;
		try {
			
			urepo.save(usuario);
			filas = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarUsuario(int idUsuario) {
		int filas=0;
		try {
			urepo.deleteById(idUsuario);
			filas = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarUsuario(Usuario usuario) {
		int filas=0;
		if(findById(usuario.getIdUsuario()) != null) {
			urepo.save(usuario);
			filas=1;
		}
		return filas;
	}
	/*
	@Override
	public List<Tarjeta> addTarjetaUsuario(Usuario usuario, Tarjeta tarjeta) {
		List<Tarjeta> tarjetas = usuario.getTarjetas();
	    tarjetas.add(tarjeta);
	    usuario.setTarjetas(tarjetas);
		//session.saveOrUpdate(usuario);
		return tarjetas;
	    
	}

	@Override
	public List<Tarjeta> removeTarjetaUsuario(Usuario usuario, Tarjeta tarjeta) {
		List<Tarjeta> tarjetas = usuario.getTarjetas();
	    tarjetas.remove(tarjeta);
	    usuario.setTarjetas(tarjetas);
	    //session.update(usuario);
	    return tarjetas;
	
	}

	@Override
	public List<Direcciones> addDireccioneUsuario(Usuario usuario, Direcciones direccione) {
		List<Direcciones> direcciones = usuario.getDirecciones();
		direcciones.add(direccione);
		usuario.setDirecciones(direcciones);
		return direcciones;
	}

	@Override
	public List<Direcciones> removeDireccioneUsuario(Usuario usuario, Direcciones direccione) {
		List<Direcciones> direcciones = usuario.getDirecciones();
	    direcciones.remove(direccione);
	    usuario.setDirecciones(direcciones);
	    //session.update(usuario);
	    return direcciones;
	}
	*/
	
	//método que modifica el rol del usuario (Solo si eres admin)
	/*
	@Override
	public int modificarRol(Usuario usuario) {
		
		Usuario u1 = urepo.verUsuario()
		
		
		
	        int modifica = 0;
	        if(u1 != null) {
	        	Role role = new Role();
	        	role.setIdRol(2);
	        	role.setNombre("rol_admin");
	        	u1.setRole(role);
	        	
	            urepo.save(u1);
	            modifica = 1;
	        }
	        return modifica;
		
	}
*/
	/*
	@Override
	public int modificarRol(Usuario usuario) {
	    int modifica = 0;
	    Optional<Usuario> optionalU1 = urepo.findById(usuario.getIdUsuario());
	    if (optionalU1.isPresent()) {
	        Usuario u1 = optionalU1.get();
	        Role role = new Role();
	        role.setIdRol(2);
	        role.setNombre("rol_admin");
	        u1.setRole(role);
	        urepo.save(u1);
	        modifica = 1;
	    }
	    return modifica;
	}
	*/
	
	@Override
	public int modificarRol(Usuario usuario) {
	    int filas=0;
	    
	    urepo.save(usuario);
	    return filas;
	}





	

	
	
	/*
	@Override
	public Usuario findById(String nombre) {
		return urepo.findByNombre(nombre);
	}
	
	@Override
	public boolean registro(Usuario usuario) {
		if (findById(usuario.getNombre()) == null) {
				urepo.save(usuario);
				return true;
		}
		return false;
	}
	
	@Override
	public Usuario mostrarUsuario(String nombre) {
		
		return urepo.findByNombre(nombre);
	}
*/
}
