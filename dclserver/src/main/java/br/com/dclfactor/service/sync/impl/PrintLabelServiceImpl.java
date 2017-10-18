/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.service.sync.impl;

import br.com.dclfactor.models.alcatel.AlcLot;
import br.com.dclfactor.service.sync.PrintLabelService;
import br.com.dclfactor.utils.ZPLPrintUtil;
import br.com.dclfactor.utils.ZPLString;
import javax.print.PrintService;
import org.springframework.stereotype.Service;

/**
 *
 * @author LimaD01
 */
@Service("printLabelService")
public class PrintLabelServiceImpl implements PrintLabelService {

    @Override
    public void reprintLote(PrintService printer, AlcLot lote) {
        ZPLPrintUtil.print(printer, ZPLString.ZPLStringLote(lote));
    }

}
