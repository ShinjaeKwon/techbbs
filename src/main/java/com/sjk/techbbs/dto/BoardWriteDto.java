package com.sjk.techbbs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardWriteDto {

	private String title;
	private String content;
	private String username;
	private String category;

}
