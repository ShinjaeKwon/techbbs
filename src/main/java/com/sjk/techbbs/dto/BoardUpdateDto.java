package com.sjk.techbbs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardUpdateDto {

	private Long boardId;
	private String title;
	private String content;
	private String category;

}
