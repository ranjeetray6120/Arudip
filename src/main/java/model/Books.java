package model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Books {
	int bool_id;
	String tital;
	String author;
	double price;
	public Books(String tital,String aurhor, double price) {
		this.tital = tital;
		this.author = aurhor;
		this.price = price;
	}
}
