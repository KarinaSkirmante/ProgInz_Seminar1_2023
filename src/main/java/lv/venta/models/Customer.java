package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "customer_table")//DB pusē izveidosies tabula
@Entity
public class Customer {
	@Column(name = "Idc")//DB puse būs kolonna "id" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idc;
	
	@Column(name = "Name")//DB puse būs kolonna title
	private String name;
	
	@Column(name = "Surname")//DB puse būs kolonna title
	private String surname;
	
	@OneToMany(mappedBy = "customer")//sasaistam ar mainīgo no otras puses
	private Collection<Product> allProducts;
	
}
