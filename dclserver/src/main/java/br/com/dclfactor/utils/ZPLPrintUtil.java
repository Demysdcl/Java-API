/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.utils;

import java.awt.print.PrinterJob;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.SimpleDoc;
import lombok.Getter;

/**
 *
 * @author LimaD01
 */
public class ZPLPrintUtil implements Serializable {

    private static final long serialVersionUID = -5712120993072692610L;

    @Getter
    private static String msg;

    public static PrintService selectPrinterByLine(String lineName) {
        PrintService[] printers = PrinterJob.lookupPrintServices();

        for (PrintService service : printers) {
            List<String> posts = selectPrinterName(lineName.toUpperCase());
            for (String name : posts) {
                if (service.getName().toUpperCase().contains(name)) {
                    return service;
                }
            }
        }
        return null;
    }

    private static List<String> selectPrinterName(String lineName) {
        String[] splits = lineName.split(" ");
        int value = Integer.parseInt(splits[1]);
        List<String> posts = new ArrayList<>();
        posts.add("COLETIVA" + String.format("%02d", value));
        posts.add("COLETIVA" + String.format("%02d", value + 1));
        return posts;
    }

    public static void print(PrintService printer, String zpl) {
        if (printer != null) {
            byte[] by = zpl.getBytes();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(by, flavor, null);
            try {
                printer.createPrintJob().print(doc, null);
            } catch (PrintException e) {
            }
        } else {
            msg = "Impressora não encontrado ou Nenhuma impressora cadastrada para está linha!";
        }

    }

}
