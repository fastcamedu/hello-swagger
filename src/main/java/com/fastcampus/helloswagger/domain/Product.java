package com.fastcampus.helloswagger.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data(staticConstructor = "of")
public class Product {
    @Schema(type = "Long", name = "id", description = "상품 ID")
    private final Long id;
    @Schema(type = "String", name = "name", description = "상품 이름")
    private final String name;
    @Schema(type = "BigDecimal", name = "price", description = "상품 가격")
    private final BigDecimal price;
}
