package br.com.dclfactor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dclfactor.entity.alcatel.AlcDefect;
import br.com.dclfactor.repository.DefectRepository;
import lombok.Getter;

@Service
public class DefectService extends GenericAbstractService<AlcDefect, String> {
	
	@Getter
	@Autowired
	private DefectRepository repository;	
	
}
