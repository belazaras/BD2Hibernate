package model;

public class CategoriaInvitado extends Categoria {

	/**Construcotres**/
	public CategoriaInvitado(){
		this.limiteReproducciones=10;
	}
	
	public CategoriaInvitado(int limite){
		this.limiteReproducciones=limite;
	}
	
	/**M�todos**/
	@Override
	public int limiteDeReproducciones() {
		
		return this.limiteReproducciones;
	}

}
