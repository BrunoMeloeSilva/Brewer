package bms.brewer.dto;

public class FotoDTO {
	
	private String nome;
	private String contentType;
	
	
	public FotoDTO(String nome, String contentType) {
		this.nome = nome;
		this.contentType = contentType;
	}


	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}


	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	
	
	
}
