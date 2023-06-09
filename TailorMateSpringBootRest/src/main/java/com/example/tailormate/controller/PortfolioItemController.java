package com.example.tailormate.controller;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.PortfolioItem;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.PortfolioItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/portfolioItems")
public class PortfolioItemController {

    private final PortfolioItemService portfolioItemService;

    @Autowired
    public PortfolioItemController(PortfolioItemService portfolioItemService) {
        this.portfolioItemService = portfolioItemService;
    }

    @GetMapping
    public ResponseEntity<List<PortfolioItem>> getAllPortfolioItems() {
        List<PortfolioItem> portfolioItems = portfolioItemService.getAllPortfolioItems();
        return new ResponseEntity<>(portfolioItems, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioItem> getPortfolioItemById(@PathVariable("id") int id) {
        PortfolioItem portfolioItem = portfolioItemService.getPortfolioItemById(id);
        if (portfolioItem != null) {
            return new ResponseEntity<>(portfolioItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PortfolioItem> createPortfolioItem(@RequestBody PortfolioItem portfolioItem) {
        PortfolioItem savedPortfolioItem = portfolioItemService.savePortfolioItem(portfolioItem);
        return new ResponseEntity<>(savedPortfolioItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioItem> updatePortfolioItem(@PathVariable("id") int id, @RequestBody PortfolioItem portfolioItem) {
        PortfolioItem existingPortfolioItem = portfolioItemService.getPortfolioItemById(id);
        if (existingPortfolioItem != null) {
            portfolioItem.setPortfolioItemId(id);
            PortfolioItem updatedPortfolioItem = portfolioItemService.updatePortfolioItem(portfolioItem);
            return new ResponseEntity<>(updatedPortfolioItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolioItem(@PathVariable("id") int id) {
        PortfolioItem existingPortfolioItem = portfolioItemService.getPortfolioItemById(id);
        if (existingPortfolioItem != null) {
            portfolioItemService.deletePortfolioItem(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
