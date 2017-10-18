package br.com.dclfactor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dclfactor.entity.alcatel.AlcDefect;

public interface DefectRepository extends JpaRepository<AlcDefect, String> {
	
	
	
}
