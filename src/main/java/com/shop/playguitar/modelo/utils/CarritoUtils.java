package com.shop.playguitar.modelo.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.shop.playguitar.modelo.bean.Producto;

@Component
public class
CarritoUtils {
	

	public Map<Producto, Integer> crearComprobarCarrito(HttpSession misesion, Model model) {
			
			Map<Producto, Integer> carrito = null;
			if (misesion.getAttribute("carrito") == null) {		 
				 carrito = new HashMap<Producto, Integer>();
				misesion.setAttribute("carrito",carrito);
			}else {
				 carrito = (Map<Producto, Integer>) misesion.getAttribute("carrito");
			}
			
			model.addAttribute("carrito", carrito);
			
			return carrito;
		}
}
