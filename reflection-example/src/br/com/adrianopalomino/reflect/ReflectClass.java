package br.com.adrianopalomino.reflect;

/**
 * @author adrianopalomino
 *
 */
public class ReflectClass {

	private int attributeOne;

	// this private method will be invoked by another class
	private void setAttributeOne(int attributeOne) {
		this.attributeOne = attributeOne;
	}

	@Override
	public String toString() {
		return "ReflectClass [attributeOne=" + attributeOne + "]";
	}

}
