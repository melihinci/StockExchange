package stock.exchange.example.service.interfaces;

import org.springframework.stereotype.Component;
import stock.exchange.example.model.AddStockRequest;
import stock.exchange.example.model.dbo.StockExchange;

@Component
public interface StockExchangeService {
    StockExchange getByName(String name);

    Void addStockByName(String stockExchangeName, AddStockRequest request);

    Void removeStockByName(String stockExchangeName, String stockName);
}
