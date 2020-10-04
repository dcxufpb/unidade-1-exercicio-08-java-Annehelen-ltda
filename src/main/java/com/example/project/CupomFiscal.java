package com.example.project;

public class CupomFiscal {
	private static final String ENDLN = System.lineSeparator();
	private static boolean isEmpty(String str){
		if(str == null) return true;
		int spaceCount = str.length() - str.replace(".", "").length();
		return (spaceCount == str.length());
	}
	public static String dadosLojaObjeto(Loja loja) {
		// Implemente aqui
		String num = loja.getNumero() + "";
		if (isEmpty(loja.getNomeLoja())){
			throw new RuntimeException("O campo nome da loja é obrigatório");
		}
		if(isEmpty (loja.getLogradouro())){
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		}
		if(loja.getNumero() == 0){
			num = "s/n";
		}
		if(isEmpty(loja.getMunicipio())){
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}
		if (isEmpty(loja.getEstado())){
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		}
		if (isEmpty(loja.getCnpj())){
			throw new RuntimeException("O campo cnpj da loja é obrigatório");
		}
		if (isEmpty(loja.getInscricaoEstadual())){
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}
		String part2 = loja.getLogradouro()+ ", " + num;
		if (! isEmpty (loja.getComplemento())){
			part2 += " " + loja.getComplemento();
			}
		String part3 = "";
		if (! isEmpty (loja.getBairro())){
			part3 += loja.getBairro() + " - ";
		}
		part3 += loja.getMunicipio() +  " - " + loja.getEstado();
		
		String part4 = "";
		if (! isEmpty (loja.getCep())){
			part4 = "CEP:" + loja.getCep();
			}
		if (! isEmpty (loja.getTelefone())){
			if (! isEmpty (part4)){
				part4 += " ";
			}
			part4 += "Tel " + loja.getTelefone();
			}
		if (! isEmpty(part4)){
			part4 += ENDLN;
			}
		String part5 = "";
		if (! isEmpty (loja.getObservacao())){
			part5 += loja.getObservacao();
			}

		String output = loja.getNomeLoja() + ENDLN;
		output += part2 + ENDLN;
		output += part3 + ENDLN;
		output += part4;
		output += part5 + ENDLN;
		output += "CNPJ: " + loja.getCnpj() + ENDLN;
		output += "IE: " + loja.getInscricaoEstadual() +ENDLN;

		return output;
	}

}
