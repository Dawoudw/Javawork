package dev.wsd.collections;
import java.util.ArrayList;

import dev.wsd.entities.*;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public class UserCredentialCollection <T> extends ArrayList<UserCredential> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserCredentialCollection(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}