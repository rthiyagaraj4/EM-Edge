/**
 * 
 */
package eIPAD.chartsummary.common.bc;

import eIPAD.chartsummary.common.dao.WidgetOrderDAO;
import eIPAD.chartsummary.common.daoimpl.WidgetOrderDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.WidgetOrderResponse;

/**
 * @author SaraswathiR
 *
 */
public class WidgetOrderBC {
	public WidgetOrderResponse getUserWidgetOrder(PatContext patientContext) {
		WidgetOrderResponse resp;
		WidgetOrderDAO dao = new WidgetOrderDAOImpl();
		resp = dao.getUserWidgetOrder(patientContext);
		return resp;
	}
	
	public WidgetOrderResponse getDefaultWidgetOrder(PatContext patientContext){
		WidgetOrderResponse resp;
		WidgetOrderDAO dao = new WidgetOrderDAOImpl();
		resp = dao.getDefaultWidgetOrder(patientContext);
		return resp;
	}
}
