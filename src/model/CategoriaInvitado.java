package model;

public class CategoriaInvitado extends Categoria {

	/**Construcotres**/
	public CategoriaInvitado(){
		this.limiteReproducciones=10;
	}
	
	public CategoriaInvitado(int limite){
		this.limiteReproducciones=limite;
	}
	
	/**Métodos**/
	@Override
	public int limiteDeReproducciones() {
		
		return this.limiteReproducciones;
	}

}
