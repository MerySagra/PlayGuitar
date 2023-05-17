package com.shop.playguitar;

import com.shop.playguitar.controller.ProductoController;
import com.shop.playguitar.controller.UsuarioController;
import com.shop.playguitar.modelo.bean.Direcciones;
import com.shop.playguitar.modelo.bean.Producto;
import com.shop.playguitar.modelo.bean.Usuario;
import com.shop.playguitar.modelo.repository.UsuarioRepository;
import com.shop.playguitar.modelo.service.ProductoService;
import com.shop.playguitar.modelo.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ShopApplicationTests {

	@Test
	void contextLoads() {
	}

	@Mock
	private ProductoService productoService;

	@Mock
	private UsuarioService usuarioService;

	@Mock
	private UsuarioRepository usuarioRepository;

	@InjectMocks
	private UsuarioController usuarioController;

	@InjectMocks
	private ProductoController productoController;

	/**
	 * Test unitarios de los endpoints.
	 */

	@Test
	public void testDamePrecioById_ProductoExists_ReturnsPrecio() {

		// Arrange
		int id = 1;
		Producto producto = new Producto();
		producto.setIdProducto(id);
		producto.setPrecio(BigDecimal.valueOf(10.0));

		// When
		when(productoService.findById(id)).thenReturn(producto);

		BigDecimal result = productoController.damePrecioById(id);

		// Assert
		assertEquals(BigDecimal.valueOf(10.0), result);
	}

	@Test
	public void testDamePrecioById_ProductoDoesNotExist_ReturnsNull() {
		// Arrange
		int id = 1;

		// 	When
		when(productoService.findById(id)).thenReturn(null);

		BigDecimal result = productoController.damePrecioById(id);

		// Assert
		assertEquals(null, result);
	}

	@Test
	public void testObtenerTodosProductos() {
		// Arrange
		List<Producto> productos = Arrays.asList(new Producto(), new Producto());
		when(productoService.findAll()).thenReturn(productos);

		// Act
		List<Producto> result = productoController.obtenerTodosProductos();

		// Assert
		assertEquals(productos, result);
	}


	@Test
	public void testObtenerProductoPorNombre() {
		// Arrange
		String nombre = "producto";
		List<Producto> productos = Arrays.asList(new Producto(), new Producto());

		// When
		when(productoService.findByName(nombre)).thenReturn(productos);

		List<Producto> result = productoController.obtenerProductoPorNombre(nombre);

		// Assert
		assertEquals(productos, result);
	}

	@Test
	public void testObtenerProductoPorId() {
		// Arrange
		int id = 1;
		Producto producto = new Producto();
		producto.setIdProducto(id);

		// When
		when(productoService.findById(id)).thenReturn(producto);

		Producto result = productoController.obtenerProductoPorId(id);

		// Assert
		assertEquals(producto, result);
	}

	@Test
	public void testFindAllUsers() {
		// Arrange
		List<Usuario> usuarios = Arrays.asList(new Usuario(), new Usuario());

		// When
		when(usuarioService.findAll()).thenReturn(usuarios);

		List<Usuario> result = usuarioController.findAllUsers();

		// Assert
		assertEquals(usuarios, result);
	}

	@Test
	public void testAddUser_ReturnsSavedUsuario() {
		// Arrange
		Usuario user = new Usuario();

		// When
		when(usuarioRepository.save(user)).thenReturn(user);

		Usuario result = usuarioController.addUser(user);

		// Assert
		assertEquals(user, result);
	}
	@Test
	public void testVerPorId_ExistingId_ReturnsUsuario() {
		// Arrange
		int id = 1;
		Usuario usuario = new Usuario();

		// When
		when(usuarioService.findById(id)).thenReturn(usuario);

		Usuario result = usuarioController.verPorId(id);

		// Assert
		assertEquals(usuario, result);
	}

	@Test
	public void testEditarUsuario_ExistingId_ReturnsUpdatedUsuario() {
		// Arrange
		int id = 1;
		Usuario usuarioExistente = new Usuario();
		Usuario usuarioActualizado = new Usuario();
		List<Direcciones> nuevaDireccion = new ArrayList<Direcciones>();
		Direcciones d1 = new Direcciones();
		d1.setCalle("Nueva Calle");
		nuevaDireccion.add(d1);
		usuarioActualizado.setNombre("Nuevo Nombre");
		usuarioActualizado.setApellidos("Nuevos Apellidos");
		usuarioActualizado.setDirecciones(nuevaDireccion);

		// When
		when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuarioExistente));
		when(usuarioRepository.save(usuarioExistente)).thenReturn(usuarioExistente);

		Usuario result = usuarioController.editarUsuario(id, usuarioActualizado);

		// Assert
		assertEquals(usuarioExistente, result);
		assertEquals("Nuevo Nombre", usuarioExistente.getNombre());
		assertEquals("Nuevos Apellidos", usuarioExistente.getApellidos());
		assertEquals(Arrays.asList(d1), usuarioExistente.getDirecciones());
	}

	@Test
	public void testVerPorEmail() {
		// Arrange
		String email = "test@example.com";
		Usuario usuario = new Usuario();

		// When
		when(usuarioService.findByEmail(email)).thenReturn(usuario);

		Usuario result = usuarioController.verPorEmail(email);

		// Assert
		assertEquals(usuario, result);
	}

	@Test
	public void testVerConDirecciones() {
		// Arrange
		int id = 1;
		Usuario usuario = new Usuario();

		// When
		when(usuarioService.findByIdWithAddress(id)).thenReturn(usuario);

		Usuario result = usuarioController.verConDirecciones(id);

		// Assert
		assertEquals(usuario, result);
	}
}
