package entity.requete;

/**
 * Contiens toute les actions possible pour tout les services
 * TODO Démanteler en plusieurs sous enum par service avec controle du {@link ServiceDemander} : voir comment faire.
 * 
 * @author Aurélien Harlé
 * @version 1
 * @since 18/07/2017
 *
 */
public enum TypeAction {

	SELECT,
	INSERT,
	UPDATE,
	DELETE
	
}
