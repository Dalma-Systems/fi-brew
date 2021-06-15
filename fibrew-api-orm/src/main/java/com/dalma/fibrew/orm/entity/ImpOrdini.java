package com.dalma.fibrew.orm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;


/**
 * The persistent class for the IMP_ORDINI database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="IMP_ORDINI")
@NamedQuery(name="ImpOrdini.findAll", query="SELECT i FROM ImpOrdini i")
public class ImpOrdini implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORD_ORDINE")
	private Long ordOrdine; // id auto increment

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ORD_DATE")
	private Calendar ordDate; // work order scheduling date in format yyyy-MM-dd

	@Column(name="ORD_ERRORE")
	private String ordErrore; // error inserted by Modula if anything goes wrong

	@Column(name="ORD_OF")
	private BigDecimal ordOf; // work order erp id

	@Column(name="ORD_STATUS")
	private String ordStatus; // Modula's import status

	@Column(name="ORD_TIME")
	private String ordTime; // work order scheduling time in format HH:mm 
}
