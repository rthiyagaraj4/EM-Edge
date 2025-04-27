/**
 * 
 */
package eIPAD.chartsummary.common.dao;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.WidgetOrderResponse;

/**
 * @author SaraswathiR
 *
 */
public interface WidgetOrderDAO {
	WidgetOrderResponse getUserWidgetOrder(PatContext patientContext);
	WidgetOrderResponse getDefaultWidgetOrder(PatContext patientContext);
}
