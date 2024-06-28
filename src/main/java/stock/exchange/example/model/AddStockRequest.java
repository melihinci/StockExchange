package stock.exchange.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class AddStockRequest implements Serializable {

    private String name;

    private String description;

    private Double currentPrice;

    private String  stockExchangeName;
}
