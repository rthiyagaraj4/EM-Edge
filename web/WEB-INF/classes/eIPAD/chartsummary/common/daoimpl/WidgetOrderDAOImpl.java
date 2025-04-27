/**
 * 
 */
package eIPAD.chartsummary.common.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eIPAD.chartsummary.common.constants.WidgetItems;
import eIPAD.chartsummary.common.dao.WidgetOrderDAO;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.common.response.WidgetOrderResponse;

/**
 * @author SaraswathiR
 *
 */
public class WidgetOrderDAOImpl extends GenericDAOImpl implements WidgetOrderDAO  {

	public WidgetOrderResponse getDefaultWidgetOrder(PatContext patientContext) {
		ErrorInfo errorInfo;
		String locale = "en";
		errorInfo = new ErrorInfo();
		errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
		WidgetOrderResponse response = new WidgetOrderResponse();
		ArrayList<WidgetItems> activeWidgets = returnDefaultWidgetOrder();
		ArrayList<WidgetItems> inactiveWidgets = new ArrayList<WidgetItems>();
		response.getErrorsList().add(errorInfo);
		response.setActiveWidgets(activeWidgets);
		response.setInactiveWidgets(inactiveWidgets);
		return response;
	}
	
	public WidgetOrderResponse getUserWidgetOrder(PatContext patientContext) {
		WidgetOrderResponse response = new WidgetOrderResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		ArrayList<WidgetItems> activeWidgets = new ArrayList<WidgetItems>();
		ArrayList<WidgetItems> inactiveWidgets = new ArrayList<WidgetItems>();
		response.setActiveWidgets(activeWidgets);
		response.setInactiveWidgets(inactiveWidgets);
		
		if(patientContext!=null && patientContext.getLoggedInUser()!=null){
			String login_user = patientContext.getLoggedInUser();
			locale = patientContext.getLocale();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String widgetOrderQuery = "select widget_id , widget_order from CA_MOBILE_WIDGET_ORDER where appl_user_id = ? order by widget_order";
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					
					pstmt=con.prepareStatement(widgetOrderQuery.toString());
					pstmt.setString(1, login_user);
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						int widget_order;
						String widget_id; 
						while(rs.next())
						{
							widget_id = rs.getString("widget_id")==null?"":rs.getString("widget_id");
							widget_order = rs.getInt("widget_order");
							if(widget_order==-1){
								if(getCorrespondingWidgetItem(widget_id)!=null){
									inactiveWidgets.add(getCorrespondingWidgetItem(widget_id));
								}
							}else{
								if(getCorrespondingWidgetItem(widget_id)!=null){
									activeWidgets.add(getCorrespondingWidgetItem(widget_id));
								}
							}
						}
						if(activeWidgets.size()+inactiveWidgets.size() == 0){
							activeWidgets = returnDefaultWidgetOrder();
						}
						else if((activeWidgets.size()+inactiveWidgets.size())!= WidgetItems.values().length){
							
							WidgetItems enumItems[] = WidgetItems.values();
							for(int x=0;x<enumItems.length;x++){
								if(!activeWidgets.contains(enumItems[x]) && !inactiveWidgets.contains(enumItems[x])){
									//could be a newly added widget for which user preference is not found  
									activeWidgets.add(enumItems[x]);
								}
							}
							
							//activeWidgets = returnDefaultWidgetOrder();
							//inactiveWidgets.clear();
						}
						response.setActiveWidgets(activeWidgets);
						response.setInactiveWidgets(inactiveWidgets);
					}
				}
			}catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
				
			}
			
		}
		return response;
	}
	
	private WidgetItems getCorrespondingWidgetItem(String widget_id){
		if(widget_id.equals(WidgetItems.VITALS.getWidgetId())){
			return WidgetItems.VITALS;
		}
		else if(widget_id.equals(WidgetItems.ALLERGY.getWidgetId())){
			return WidgetItems.ALLERGY;
		}
		else if(widget_id.equals(WidgetItems.PROCEDURE.getWidgetId())){
			return WidgetItems.PROCEDURE;
		}
		else if(widget_id.equals(WidgetItems.PROBLEMS.getWidgetId())){
			return WidgetItems.PROBLEMS;
		}
		else if(widget_id.equals(WidgetItems.NOTES.getWidgetId())){
			return WidgetItems.NOTES;
		}
		else if(widget_id.equals(WidgetItems.RESULTS.getWidgetId())){
			return WidgetItems.RESULTS;
		}
		else if(widget_id.equals(WidgetItems.PENDINGORDERS.getWidgetId())){
			return WidgetItems.PENDINGORDERS;
		}
		else if(widget_id.equals(WidgetItems.MEDICATIONS.getWidgetId())){
			return WidgetItems.MEDICATIONS;
		}
		else{
			return null;
		}
	}
	private ArrayList<WidgetItems> returnDefaultWidgetOrder(){
		ArrayList<WidgetItems> activeWidgets = new ArrayList<WidgetItems>();
		activeWidgets.add(WidgetItems.VITALS);
		activeWidgets.add(WidgetItems.ALLERGY);
		activeWidgets.add(WidgetItems.PROCEDURE);
		activeWidgets.add(WidgetItems.PROBLEMS);
		activeWidgets.add(WidgetItems.NOTES);
		activeWidgets.add(WidgetItems.RESULTS);
		activeWidgets.add(WidgetItems.PENDINGORDERS);
		activeWidgets.add(WidgetItems.MEDICATIONS);
		return activeWidgets;
	}

}
