package stock.exchange.example.model.dbo;

import com.sun.istack.internal.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 45)
    @NotNull
    private String name;

    @Column
    private String description;

    @Column
    @NotNull
    private Double currentPrice;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "stocks")
    private List<StockExchange> stockExchanges;
}

