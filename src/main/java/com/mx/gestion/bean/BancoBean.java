/*
   Copyright 2009-2021 PrimeTek.

   Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

   Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.mx.gestion.bean;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;
import org.primefaces.omega.domain.Customer;
import org.primefaces.omega.domain.Product;
import org.primefaces.omega.service.CustomerService;
import org.primefaces.omega.service.OrderService;
import org.primefaces.omega.service.ProductService;

import com.mx.gestion.manager.BancoManager;
import com.mx.gestion.manager.IBancoManager;
import com.mx.gestion.model.Bancos;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class BancoBean implements Serializable {

	private List<Bancos> listaBancos;

    @PostConstruct
    public void init() {
    	listaBancos = new ArrayList<Bancos>();
    	IBancoManager bancoManager = new BancoManager();
    	listaBancos = bancoManager.getBanco();
    }

	public List<Bancos> getListaBancos() {
		return listaBancos;
	}

	public void setListaBancos(List<Bancos> listaBancos) {
		this.listaBancos = listaBancos;
	}

    

}
