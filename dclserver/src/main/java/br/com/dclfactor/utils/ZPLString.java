/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.utils;

import br.com.dclfactor.models.alcatel.AlcLot;
import br.com.dclfactor.models.alcatel.AlcOrder;
import br.com.dclfactor.models.gbr.GbrSku;
import java.io.Serializable;

/**
 *
 * @author LimaD01
 */
public class ZPLString implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String ZPLStringLote(AlcLot lote) {
        AlcOrder order = lote.getOp();
        GbrSku sku = order.getSku();
        int qty = lote.getQtyProd() * sku.getQtdProdutoColetivo();
        return "^XA" + "^MMT" + "^PW886" + "^LL2126" + "^LS0"
                + "^FT164,2046^A0B,100,98^FH\\^FDORDEM DE PRODUCAO:^FS"
                + "^FT164,1044^A0B,100,98^FH\\^FD"
                + order.getId()
                + "^FS"
                + "^BY108,108^FT178,239^BXB,9,200,0,0,1,~"
                + "^FH\\^FD"
                + order.getId()
                + "^FS"
                + "^FT330,2046^A0B,100,98^FH\\^FDLOTE:^FS"
                + "^FT330,1044^A0B,100,98^FH\\^FD"
                + lote.getId()
                + "^FS"
                + "^BY108,108^FT347,233^BXB,9,200,0,0,1,~"
                + "^FH\\^FD"
                + lote.getId()
                + "^FS"
                + "^FT486,2046^A0B,100,98^FH\\^FDLINHA PRODUTIVA:^FS"
                + "^FT486,1044^A0B,100,98^FH\\^FD"
                + order.getLine().getDescription()
                + "^FS"
                + "^FT654,2046^A0B,100,98^FH\\^FDSKU:^FS"
                + "^FT654,1044^A0B,100,91^FH\\^FD"
                + order.getFullSku()
                + "^FS"
                + "^FT824,2046^A0B,100,98^FH\\^FDQUANTIDADE:^FS"
                + "^FT824,1044^A0B,100,98^FH\\^FD"
                + qty
                + "^FS"
                + "^FO364,20^GB172,2067,12^FS"
                + "^FO696,22^GB172,2067,12^FS"
                + "^FO201,20^GB172,2067,12^FS"
                + "^FO37,21^GB832,2070,12^FS"
                + "^FO39,1066^GB821,0,11^FS"
                + "^PQ1,0,1,Y^XZ";

    }

}
