/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.models;

import br.com.dclfactor.models.alcatel.AlcListProduction;
import br.com.dclfactor.service.response.LotResponse;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LimaD01
 */
public class ListProdResponse implements Serializable {

    @Getter
    @Setter
    private boolean finishedPO;

    @Getter
    @Setter
    private boolean finishedLot;

    @Getter
    @Setter
    private boolean validBox;

    @Getter
    @Setter
    private boolean proccessed;

    @Getter
    @Setter
    private LotResponse response;

    

    public ListProdResponse(boolean finishedPO, boolean finishedLot, boolean validBox, boolean proccessed, AlcListProduction prod) {
        this.finishedPO = finishedPO;
        this.finishedLot = finishedLot;
        this.validBox = validBox;
        this.proccessed = proccessed;
        this.response = new LotResponse(prod.getLote());
    }

    public static ListProdResponse create(boolean finishedPO, boolean finishedLot,
            boolean validBox, boolean proccessed, AlcListProduction prod) {
        ListProdResponse response = new ListProdResponse(finishedPO, finishedLot, validBox, proccessed, prod);
        return response;
    }

    public String getMsg() {
        if (finishedPO && finishedLot) {
            return ("Ordem de Produção Finalizada!");
        } else if (finishedLot) {
            return ("Lote de Produção Finalizado!");
        } else if (!validBox) {
            return ("Box Não Encontrada no Sistema!");
        } else if (proccessed) {
            return ("Box Já Foi Incluída no Lote " + response.getLote());
        }
        return ("Box Incluída com sucesso !");
    }

}
