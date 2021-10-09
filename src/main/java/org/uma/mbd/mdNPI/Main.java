package org.uma.mbd.mdNPI;

import org.uma.mbd.mdNPI.npi.NPI;


public class Main {
	public static void main(String [] args) {
		// 5 + (6 - 2) * 3;
		// NPI 5 6 2 - 3 * +
		NPI cpi = new NPI();
		cpi.entra(5);
		System.out.println(cpi);
		cpi.entra(6);
		System.out.println(cpi);
		cpi.entra(2);
		System.out.println(cpi);
		cpi.resta();
		System.out.println(cpi);
		cpi.entra(3);
		System.out.println(cpi);
		cpi.multiplica();
		System.out.println(cpi);
		cpi.suma();
		System.out.println(cpi);
		System.out.println("Resultado " + cpi.getResultado());
 	}
}
