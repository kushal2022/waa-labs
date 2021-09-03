/**
 * 
 */
package com.students.domain;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @author B.Pirasanth
 *
 */
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@DecimalMin(value = "100", message = "{Size.area.validation}")
	@DecimalMax("999")
 	private Integer area;

	@DecimalMin(value = "100", message = "{Size.prefix.validation}")
	@DecimalMax("999")
 	private Integer prefix;

	@DecimalMin(value = "1000", message = "{Size.number.validation}")
	@DecimalMax("9999")
 	private Integer number;
	

 
	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

 	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}
}
