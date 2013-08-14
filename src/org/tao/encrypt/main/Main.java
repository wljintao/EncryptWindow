package org.tao.encrypt.main;

import org.tao.encrypt.window.EncryptWindow;

public class Main {
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			EncryptWindow window = new EncryptWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
