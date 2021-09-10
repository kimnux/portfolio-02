package com.kimnux.portfolio.model;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=2, max=30, message = "제목은 2자 이상 30자 이하 입니다! ")
    private String title;

    private String content;
    private Date reg_dt;
    private String writer;
}
