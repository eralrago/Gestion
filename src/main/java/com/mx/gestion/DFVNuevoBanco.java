package com.mx.gestion;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
//import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named("dfvNuevoBanco")
@RequestScoped
public class DFVNuevoBanco {
	public void viewProducts() {
		Map<String, Object> options = new HashMap<>();
		options.put("resizable", false);
		PrimeFaces.current().dialog().openDynamic("dialogs/nuevoBanco", options, null);
	}
	
	
}
