package stock.exchange.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import stock.exchange.example.model.AddStockRequest;
import stock.exchange.example.model.dbo.StockExchange;
import stock.exchange.example.service.interfaces.StockExchangeService;

@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class StockExchangeController {

    @Autowired
    StockExchangeService stockExchangeService;

    private static Logger logger = LoggerFactory.getLogger(StockExchangeController.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception ex) {
        logger.error("ERROR:",ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("StockExchangeController got an error-> "+ ex.getMessage());
    }

    @GetMapping(path = "/stock-exchange/{name}")
    public ResponseEntity<StockExchange> getStockExchange(@PathVariable String name) {
        return ResponseEntity.ok(stockExchangeService.getByName(name));
    }
    @PostMapping(path = "/stock-exchange/add-stock")
    public ResponseEntity<Void> addStocktoStockExchange(@RequestParam(name = "stockExchangeName")   String stockExchangeName, @RequestBody AddStockRequest request) {
        return ResponseEntity.ok(stockExchangeService.addStockByName(stockExchangeName,request));
    }

    @DeleteMapping(path = "/stock-exchange/remove-stock")
    public ResponseEntity<Void> removeStockFromStockExchange(@RequestParam(name = "stockExchangeName")   String stockExchangeName, @RequestParam(name = "stockName")   String stockName){
        return ResponseEntity.ok(stockExchangeService.removeStockByName(stockExchangeName,stockName));
    }
}