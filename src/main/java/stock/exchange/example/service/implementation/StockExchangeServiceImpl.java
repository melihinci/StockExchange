package stock.exchange.example.service.implementation;

import stock.exchange.example.model.AddStockRequest;
import stock.exchange.example.model.dbo.StockExchange;
import stock.exchange.example.service.interfaces.StockExchangeService;

public class StockExchangeServiceImpl implements StockExchangeService {
    public StockExchange getByName(String name) {
        return null;
    }

    @Override
    public Void addStockByName(String stockExchangeName, AddStockRequest request) {
        return null;
    }

    @Override
    public Void removeStockByName(String stockExchangeName, String stockName) {
        return null;
    }

}
