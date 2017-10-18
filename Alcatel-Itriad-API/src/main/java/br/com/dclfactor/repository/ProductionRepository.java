/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.repository;

import br.com.dclfactor.entity.alcatel.AlcListProduction;
import br.com.dclfactor.repository.vo.CountProductionVO;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author LimaD01
 */
public interface ProductionRepository extends JpaRepository<AlcListProduction, Long>{
    
    List<AlcListProduction> findByLote(String lote);
    
    List<AlcListProduction> findByPackString(String packString);

    List<AlcListProduction> findByPackStringIn(Collection<String> groupBoxes);
    
    @Query("SELECT new br.com.dclfactor.repository.vo.CountProductionVO"
            + "(a.family, s.qtyBox, count(a.id)) "
            + "FROM AlcListProduction a "
            + "INNER JOIN a.op o "
            + "INNER JOIN o.sku s "
            + "WHERE a.dtPallet between ?1 and ?2 "
            + "GROUP BY a.family, s.qtyBox")
    List<CountProductionVO> countPrtoductionPerFamily(Date iniDate, Date finDate);
    

}
