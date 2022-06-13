package com.sika.bartrainer.Drink;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Data;

@Entity
@Data
@Table(name = "cocktails")
public class Drink {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "glass")
  private String glass;

  @Column(name = "method")
  private String method;

  @Column(name = "ingredient1")
  private String ingredient1;

  @Column(name = "ingredient2")
  private String ingredient2;

  @Column(name = "ingredient3")
  private String ingredient3;

  @Column(name = "ingredient4")
  private String ingredient4;

  @Column(name = "ingredient5")
  private String ingredient5;

  @Column(name = "ingredient6")
  private String ingredient6;

  @Column(name = "topper")
  private String topper;

  @Column(name = "instruction1")
  private String instruction1;

  @Column(name = "instruction2")
  private String instruction2;

  @Column(name = "instruction3")
  private String instruction3;

  @Column(name = "instruction4")
  private String instruction4;

  @Column(name = "instruction5")
  private String instruction5;

  @Column(name = "instruction6")
  private String instruction6;

  @Column(name = "instruction7")
  private String instruction7;

  @Column(name = "garnish")
  private String garnish;

  @Column(name = "imageurl")
  private String imageurl;
}
