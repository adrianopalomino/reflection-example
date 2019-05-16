package br.com.adrianopalomino.reflect;

/**
 * @author adrianopalomino
 *
 */
public class ReflectClass {

	private int attributeOne;

	public int getAttributeOne() {
		return attributeOne;
	}

	// this private method will be invoked by another class
	private void setAttributeOne(int attributeOne) {
		this.attributeOne = attributeOne;
	}

}
