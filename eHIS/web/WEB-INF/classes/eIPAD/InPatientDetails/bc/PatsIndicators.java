/**
 * 
 */
package eIPAD.InPatientDetails.bc;

import java.util.ArrayList;

public class PatsIndicators {

	public String patId;

	public  ArrayList<Inds> typesOfIndicator=new ArrayList<Inds>();
	public String normalOrAbmormal;
	/**
	 * 
	 */
	
	/**
	 * @return the typesOfIndicator
	 */
	public ArrayList<Inds> getTypesOfIndicator() {
		return typesOfIndicator;
	}
	/**
	 * @param typesOfIndicator the typesOfIndicator to set
	 */
	public void setTypesOfIndicator(Inds TypeInd) {
		
		this.typesOfIndicator.add(TypeInd);
		
	}
	/**
	 * @return the patId
	 */
	public String getPatId() {
		return patId;
	}
	/**
	 * @param patId the patId to set
	 */
	public void setPatId(String patId) {
		this.patId = patId;
	}
	/**


	/**
	 * @return the indicatorAvaliable
	 */
	
	/**
	 * @param indicatorAvaliable the indicatorAvaliable to set
	 */

	
	
	
}
