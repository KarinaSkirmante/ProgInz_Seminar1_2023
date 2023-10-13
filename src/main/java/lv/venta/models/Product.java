package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Table(name = "product_table")//DB pusē izveidosies tabula
@Entity
public class Product {

	@Column(name = "Id")//DB puse būs kolonna "id" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Title")//DB puse būs kolonna title
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
	@Size(min = 3, max = 30, message = "Jabūt vismaz 3 un ne vairāk kā 30 simboliem")
	private String title;
	
	@Column(name = "Price")//DB puse bus kolonna price
	@Min(value = 0)
	@Max(value = 10000)
	private float price;
	
	@Column(name = "Description")
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+")
	@Size(min = 3, max = 100)
	private String description;
	
	@Column(name = "Quantity")
	@Min(value = 0)
	@Max(value = 1000)
	private int quantity;
	

	
	public int getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title!=null && title.matches("[A-Z]{1}[a-z]+"))
			this.title = title;
		else
			this.title="";
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if(price>0)
			this.price = price;
		else
			this.price = 0;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(description!=null && description.matches("[A-Z]{1}[a-z]+"))
			this.description = description;
		else
			this.description = "";
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity > 0)
			this.quantity = quantity;
		else
			this.quantity = 0;
	}

	public Product(String title, float price, String description, int quantity) {
	setTitle(title);
	setDescription(description);
	setPrice(price);
	setQuantity(quantity);
	}

	public Product() {
		setDescription("");
		setTitle("");
		setPrice(0);
		setQuantity(0);
	}

}
