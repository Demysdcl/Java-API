/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.sync;

import br.com.dclfactor.models.alcatel.AlcLot;
import javax.print.PrintService;

/**
 *
 * @author LimaD01
 */
public interface PrintLabelService {

    void reprintLote(PrintService printer, AlcLot lote);
}
