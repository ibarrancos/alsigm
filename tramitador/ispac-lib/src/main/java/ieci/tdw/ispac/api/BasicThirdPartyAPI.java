package ieci.tdw.ispac.api;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispaclib.thirdparty.IElectronicAddressAdapter;
import ieci.tdw.ispac.ispaclib.thirdparty.IPostalAddressAdapter;
import ieci.tdw.ispac.ispaclib.thirdparty.IThirdPartyAdapter;

public abstract class BasicThirdPartyAPI implements IThirdPartyAPI {

	/**
	 * Obtiene una lista de terceros en funci�n del c�digos de identificaci�n.
	 * @param code C�digo de identificaci�n del tercero
	 * @return Terceros que cumplen la condici�n.
	 * @exception ISPACException si ocurre alg�n error.
	 */
	public IThirdPartyAdapter [] lookup(String code) throws ISPACException {
		return lookup(code, true);
	}

	/**
	 * Obtiene una lista de terceros en funci�n del c�digos de identificaci�n. 
	 * @param code C�digo de identificaci�n del tercero
	 * @param onlyDefaultValues Indica si se cargan solamente las direcciones asociadas por defecto
	 * @return lista de terceros asociados con un c�digo de identificaci�n, 
	 * cargando las direcciones (postal y telem�tica) por defecto si as� se indica. 
	 * @throws ISPACException
	 */
	public IThirdPartyAdapter[] lookup(String code, boolean onlyDefaultValues) throws ISPACException {
		return new IThirdPartyAdapter[0];
	}
	
	/**
	 * Obtiene una lista de terceros en funci�n del nombre y dos apellidos.
	 * @param name nombre del tercero
	 * @param surnam1 primer apellido del tercero
	 * @param surname2 segundo apellido del tercero
	 * @return Terceros que cumple la condici�n.
	 * @exception ISPACException si ocurre alg�n error.
	 */
	public IThirdPartyAdapter [] lookup(String name, String surname1, String surname2) 
			throws ISPACException {
		return lookup(name, surname1, surname2, true);
	}

	/**
	 * Obtiene una lista de terceros en funci�n del nombre y dos apellidos.
	 * @param name nombre del tercero
	 * @param surnam1 primer apellido del tercero
	 * @param surname2 segundo apellido del tercero
	 * @param onlyDefaultValues Indica si se cargan solamente las direcciones asociadas por defecto
	 * @return Terceros que cumple la condici�n.
	 * @exception ISPACException si ocurre alg�n error.
	 */
	public IThirdPartyAdapter [] lookup(String name, String surname1, String surname2, 
			boolean onlyDefaultValues) throws ISPACException {
		return new IThirdPartyAdapter[0];
	}

	/**
	 * Obtiene un tercero a partir de su identificador interno.
	 * @param id Identificador interno del tercero.
	 * @return Informaci�n del tercero.
	 * @exception ISPACException si ocurre alg�n error.
	 */
	public IThirdPartyAdapter lookupById(String id) throws ISPACException {
		return lookupById(id, true);
	}
	
	/**
	 * Obtiene un tercero a partir de su identificador.
	 * @param id identificador del tercero
	 * @param onlyDefaultValues Indica si se cargan las direcciones asociadas por defecto
	 * @return Informaci�n del tercero con sus direcciones por defecto si as� se indica 
	 * @throws ISPACException
	 */
	public IThirdPartyAdapter lookupById(String id, boolean onlyDefaultValues) throws ISPACException {
		return null;
	}
	
	/**
	 * Obtiene un tercero a partir de su identificador interno y los identificadores de sus direcciones.
	 * @param id Identificador interno del tercero.
	 * @param postalAddressId Identificador de la direcci�n postal.
	 * @param electronicAddressId Identificador de la direcci�n electr�nica.
	 * @return Informaci�n del tercero.
	 * @exception ISPACException si ocurre alg�n error.
	 */
	public IThirdPartyAdapter lookupById(String id, String postalAddressId, String electronicAddressId) 
			throws ISPACException {
		return null;
	}

	
    /**
     * Obtiene una colecci�n de todas las direcciones postales para un tercero
     * @param id identificador de tercero
     * @return lista de direcciones de postales relacionadas con un tercero
     * @throws Exception
     */
    public IPostalAddressAdapter [] lookupPostalAddresses(String id) throws ISPACException {
    	return new IPostalAddressAdapter[0];
    }
    
    /**
     * Obtiene la direcci�n postal por defecto para un tercero
     * @param id identificador de tercero
     * @return direcci�n postal por defecto
     * @throws ISPACException
     */
    public IPostalAddressAdapter lookupDefaultPostalAddress(String id) throws ISPACException {
    	return null;
    }
    
    /**
     * Obtiene una colecci�n de todas las direcciones electr�nicas para un tercero
     * @param id identificador de tercero
     * @return colecci�n de direcciones electr�nicas
     * @throws ISPACException
     */
    public IElectronicAddressAdapter [] lookupElectronicAddresses(String id) throws ISPACException {
    	return new IElectronicAddressAdapter[0];
    }

    /**
     * Obtiene la direcci�n electr�nica por defecto para un tercero
     * @param id identificador de tercero
     * @return direcci�n electr�nica
     * @throws ISPACException
     */
    public IElectronicAddressAdapter lookupDefaultElectronicAddress(String id) throws ISPACException {
    	return null;
    }

	/**
	 * Obtiene una direcci�n postal seg�n su identificador
	 * @param addressId identificador de direcci�n postal
	 * @return direcci�n postal
	 * @throws ISPACException
	 */
	public IPostalAddressAdapter getPostalAddress(String addressId) throws ISPACException {
		return null;
	}

	/**
	 * Obtiene una direcci�n electr�nica seg�n su identificador
	 * @param addressId identificador de direcci�n electr�nica
	 * @return direcci�n electr�nica
	 * @throws ISPACException
	 */
	public IElectronicAddressAdapter getElectronicAddress(String addressId) throws ISPACException {
		return null;
	}

}