package com.sjk.techbbs.model;

import java.util.Arrays;

public enum Category {
	OS("운영체제"),
	NETWORK("네트워크"),
	ALGORITHM("알고리즘"),
	DATABASE("데이터베이스"),
	DESIGN_PATTERN("디자인패턴"), DATA_CONSTRUCTOR("자료구조"), JAVA("자바"), SPRING("스프링"), JPA("JPA");

	private final String subject;

	Category(String subject) {
		this.subject = subject;
	}

	public static Category findByCategoryName(String category) {
		return Arrays.stream(Category.values())
			.findFirst()
			.filter(s -> s.subject.equals(category))
			.orElseThrow(() -> new IllegalArgumentException("카테고리를 찾을 수 없습니다."));
	}

	public String getSubject() {
		return subject;
	}

}
