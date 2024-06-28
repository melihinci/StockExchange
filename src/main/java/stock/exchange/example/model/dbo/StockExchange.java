package stock.exchange.example.model.dbo;

import com.sun.istack.internal.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
public class StockExchange {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 45)
    @NotNull
    private String name;

    @Column
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "stockExchanges")
    private List<Stock> stocks;

    public boolean isLiveInMarket() {
        return stocks != null ? stocks.size() > 4 : false;
    }

    @Getter(AccessLevel.NONE)
    private boolean liveInMarket;


}

