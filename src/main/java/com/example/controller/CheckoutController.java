// src/main/java/com/example/controller/CheckoutController.java

package com.example.controller;

import com.example.model.Transaction;
import com.example.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Controller
public class CheckoutController {

    private final TransactionRepository transactionRepository;

    @Autowired
    public CheckoutController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/checkout")
    public String checkout() {
        // Simulasi transaksi
        Long userId = 1L; // Ganti dengan pengguna yang sesungguhnya
        BigDecimal totalAmount = new BigDecimal("100.00"); // Ganti dengan jumlah yang sesuai dengan transaksi
        LocalDateTime transactionDate = LocalDateTime.now();

        // Simpan transaksi ke database
        Transaction transaction = new Transaction();
        transaction.setUserId(userId);
        transaction.setTotalAmount(totalAmount);
        transaction.setTransactionDate(transactionDate);

        transactionRepository.save(transaction);

        // Redirect atau return ke halaman checkout sukses
        return "checkout";
    }
}
