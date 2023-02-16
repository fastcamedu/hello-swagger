package com.fastcampus.helloswagger.controller;

import com.fastcampus.helloswagger.domain.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping(value = "/products")
    @Operation(summary = "상품 목록 요청", description = "상품 전체 목록을 조회합니다.", tags = { "Product Controller" })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            schema = @Schema(
                                    implementation = Product.class
                            )
                    )
            ),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(value = "/product")
    @Operation(summary = "상품 정보 요청", description = "단일 상품을 조회합니다.", tags = { "Product Controller" })
    public ResponseEntity<Product> get(
            @Parameter(name = "productId", description = "조회할 상품 아이디", required = true) @RequestParam(value = "productId") Long productId) {
        Product product = Product.of(1000L, "테스트 상품", BigDecimal.valueOf(2000));
        return ResponseEntity.ok(product);
    }

    @PostMapping(value = "/products")
    @Operation(summary = "상품 생성 요청", description = "상품을 생성합니다.", tags = { "Product Controller" })
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(product);
    }

    @PutMapping(value = "/products")
    @Operation(summary = "상품 수정 요청", description = "상품 정보를 수정합니다.", tags = { "Product Controller" })
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return ResponseEntity.ok(product);
    }

    @DeleteMapping(value = "/products/{productId}")
    @Operation(
            summary = "상품 삭제 요청",
            description = "선택한 상품을 삭제합니다.",
            tags = { "Product Controller" }
    )
    public ResponseEntity<Long> delete(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(productId);
    }
}
