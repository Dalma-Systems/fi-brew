package com.dalma.fibrew.orm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the IMP_ORDINI_RIGHE database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="IMP_ORDINI_RIGHE")
@NamedQuery(name="ImpOrdiniRighe.findAll", query="SELECT i FROM ImpOrdiniRighe i")
public class ImpOrdiniRighe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RIG_ORDINE")
	private Long rigOrdine; // id to connect with IMP_ORDINI

	@Column(name="RIG_ARTICOLO")
	private String rigArticolo; // material ERP id

	@Column(name="RIG_ERRORE")
	private String rigErrore; // error inserted by Modula if anything goes wrong

	@Column(name="RIG_HOSTCAUS")
	private String rigHostcaus; // work station ERP id

	@Column(name="RIG_OF")
	private BigDecimal rigOf; // work order erp id

	@Column(name="RIG_QTAR")
	private BigDecimal rigQtar; // material's quantity

	@Column(name="RIG_STATUS")
	private String rigStatus; // Modula's import status

	@Column(name="RIG_SUB1")
	private String rigSub1; // material's batch
}
