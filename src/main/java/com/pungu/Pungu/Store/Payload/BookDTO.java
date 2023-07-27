package com.pungu.Pungu.Store.Payload;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDTO {
    private int id;
    private String name;
    private String genre;
    private String author;
    private double actual_price;
    private double discounted_price;
    private int off_percentage;
}
