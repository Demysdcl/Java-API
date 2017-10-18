package br.com.dclfactor.utils;

import java.io.Serializable;

public class DclStringUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	public static String createFullSku(String sku, String ppb) {
		String[] splits = sku.split("-");
		StringBuilder fullSku = new StringBuilder();
		fullSku.append(splits[0]).append("-").append(splits[1]).append("-")
				.append(ppb);
		return fullSku.toString();
	}

	public static String getFamily(String sku) {
		String[] splits = sku.split("-");
		return splits[0];
	}
	
}
