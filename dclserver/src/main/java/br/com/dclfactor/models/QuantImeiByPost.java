package br.com.dclfactor.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
public class QuantImeiByPost implements Serializable,
        Comparable<QuantImeiByPost> {

    private static final long serialVersionUID = 4846585581451942713L;

    @Getter
    @Setter
    private String postName;

    @Getter
    @Setter
    private Long total;

    public boolean isFinishing() {
        return total < 801;
    }

    public String getTime() {
        long time = total / 450 * 60;
        if (time > 60) {
            long hora = time / 60;
            if (hora == 1) {
                return hora + " (hora)";
            }
            return hora + " (horas)";
        }
        return time + " (min)";
    }

    public String getProduct() {
        long single = total / 2;
        long dual = total / 4;
        return "Sg: " + single + "  <->   Dl: " + dual;
    }

    public String getStatus() {
        if (total == 0) {
            return "N�O ENCONTRADO";
        } else if (total < 801) {
            return "FINALIZANDO";
        } else if (total < 1600) {
            return "REQUER ATEN��O";
        } else {
            return "SUFICIENTE";
        }

    }

    public String getRowStyle() {
        String status = getStatus();
        switch (status) {
            case "N�O ENCONTRADO":
                return "text-align: center; background-color: #FFD700;";
            case "REQUER ATEN��O":
                return "text-align: center; background-color: #FFFF00;";
            case "FINALIZANDO":
                return "text-align: center; background-color: #EF0000; color: #FFFFE0;";
            default:
                return "text-align: center;";

        }

    }

    public String getIcon() {
        if (total == 0) {
            return "power";
        } else if (total < 801) {
            return "finishing";
        } else if (total < 1600) {
            return "alert";
        } else {
            return "accept";
        }

    }

    @Override
    public int compareTo(QuantImeiByPost o) {
        if (o == null || o.getTotal() == null || o.getPostName() == null) {
            return 1;
        }
        return total.compareTo(o.total);
    }

}
