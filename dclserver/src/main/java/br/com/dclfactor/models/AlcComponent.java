package br.com.dclfactor.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlcComponent extends BaseEntity<String>{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String description;
	
}
