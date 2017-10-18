package br.com.dclfactor.models.alcatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.dclfactor.models.BaseEntity;
import br.com.dclfactor.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "ALC_PPB_MONTH", schema = "db_accessadmin")
@NoArgsConstructor
@Entity
public class AlcPPBMonth extends BaseEntity<Long> {

	private static final long serialVersionUID = -3989511709097818264L;

	@Id
	@GeneratedValue
	@Column(name = "ID_PPB_MONTH")
	private Long id;

	@NotNull(message="Informe o  Mês!")
	@Min(value=1,  message="O Valor Deve Ser Maior que 0")
	@Max(value=12,  message="O Valor Deve Ser Menor que 12")
	@Column(name = "PPB_MONTH", length = 2)
	private Integer month;

	@NotNull(message="Informe o  Ano!")
	@Column(name = "PPB_YEAR", length = 5)
	private Integer year;

	@NotEmpty(message="Informe o SKU com PPB")
	@Column(name = "FULL_SKU", length = 30)
	private String fullSku;

	@Column(name = "QTY")
	@NotNull(message="Informe a Quantidade")
	private Long quantity;
	
	public String getStringMonth(){
		return DateUtil.getStringMonth(month);
	}

	@Override
	public String getDescription() {
	
		return fullSku +" "+ quantity;
	}
}
