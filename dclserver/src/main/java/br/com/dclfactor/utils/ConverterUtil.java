package br.com.dclfactor.utils;

import java.io.File;
import java.util.List;

import br.com.dclfactor.models.QuantImeiByPost;
import br.com.dclfactor.models.alcatel.AlcHDT;
import java.io.Serializable;

public class ConverterUtil implements Serializable {

    public static QuantImeiByPost alcHdtToQuantImeiByPost(AlcHDT hdt) {
        return new QuantImeiByPost(hdt.getId(), hdt.getDiff());
    }

    public static AlcHDT fileToAlcHdt(String hdtName, File path) {
        List<String> lines = FileUtil.readFile(path);
        AlcHDT hdt = new AlcHDT();
        if (path.getName().endsWith(".imi") && !lines.isEmpty() && lines.size() > 26) {
            String begin = getValue(lines.get(25)) + getCurrentValue(lines.get(7));
            String current = getValue(lines.get(25)) + getCurrentValue(lines.get(4));
            String end = getValue(lines.get(25)) + getCurrentValue(lines.get(10));
            hdt.setId(hdtName);
            hdt.setBeginRange(begin);
            hdt.setCurrentRange(current);
            hdt.setEndRange(end);
            return hdt;
        }

        return new AlcHDT();
    }

    private static String getCurrentValue(String currentField) {
        long current = Long.parseLong(getValue(currentField));
        return String.format("%06d", current);
    }

    private static String getValue(String field) {
        return field.split(" = ")[1].trim();
    }

}
