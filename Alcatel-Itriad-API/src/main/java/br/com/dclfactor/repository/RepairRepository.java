/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repository;

import br.com.dclfactor.entity.alcatel.AlcRepair;
import br.com.dclfactor.entity.gbr.GbrLine;
import br.com.dclfactor.entity.gbr.GbrSerial;
import br.com.dclfactor.entity.gbr.GbrSku;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LimaD01
 */
public interface RepairRepository extends JpaRepository<AlcRepair, Integer> {

    List<AlcRepair> findByDtRepairIsNull();

    List<AlcRepair> findBySerialIDAndDtRepairIsNull(GbrSerial serial);

    AlcRepair findBySerialIDAndStatusIsNull(GbrSerial serial);

    List<AlcRepair> findBySerialID(GbrSerial serial);

    List<AlcRepair> findByDtEntryBetween(Date iniDate, Date finDate);

    List<AlcRepair> findByDtRepairBetween(Date inicialDate, Date finalDate);

    List<AlcRepair> findByDtEntryBetweenAndDtRepairIsNull(Date inicialDate,
            Date finalDate);

    List<AlcRepair> findByDtEntryBetweenAndStatusIn(Date inicialDate,
            Date finalDate, Collection<String> status);

    Number countByDtEntryAndLineAndSku(Date iniDate, GbrLine line, GbrSku sku);

    Number countByDtEntryBetweenAndLineAndSku(Date iniDate, Date finDate,
            GbrLine line, GbrSku sku);

}
