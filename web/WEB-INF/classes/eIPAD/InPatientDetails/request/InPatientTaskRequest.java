/**
 * 
 */
package eIPAD.InPatientDetails.request;

import eIPAD.chartsummary.common.request.GenericRequest;

/**
 * @author saraswathir
 *
 */
public class InPatientTaskRequest extends GenericRequest{
	private String clientIpAddress;

	/**
	 * @return the clientIpAddress
	 */
	public String getClientIpAddress() {
		return clientIpAddress;
	}

	/**
	 * @param clientIpAddress the clientIpAddress to set
	 */
	public void setClientIpAddress(String clientIpAddress) {
		this.clientIpAddress = clientIpAddress;
	}
}
