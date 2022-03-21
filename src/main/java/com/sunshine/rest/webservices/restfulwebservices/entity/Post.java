package com.sunshine.rest.webservices.restfulwebservices.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_post")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
	@Id
	@SequenceGenerator(name = "post_sequence", sequenceName = "post_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_sequence")
	private Integer id;
	private String description;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

}
