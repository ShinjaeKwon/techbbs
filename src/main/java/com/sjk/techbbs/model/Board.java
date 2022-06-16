package com.sjk.techbbs.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sjk.techbbs.dto.BoardDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String title;

	@Lob
	private String content;

	private int hit;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"board"})
	private List<Reply> replies;

	@Enumerated(EnumType.STRING)
	private Category category;

	@CreationTimestamp
	private Timestamp createDate;

	public Board(BoardDto boardDto, User user) {
		this.title = boardDto.getTitle();
		this.content = boardDto.getContent();
		this.user = user;
		this.category = Category.findByCategoryName(boardDto.getCategory());
	}
}
