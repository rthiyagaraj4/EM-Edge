package eXH;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import webbeans.eCommon.*;

public class NotificationBean
{
	public static Map<String, Map<String, String>> searchCriteria(String locale)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		Map<String, String> recipientTypes = new LinkedHashMap<String, String>();
		Map<String, String> contactTypes = new LinkedHashMap<String, String>();
		Map<String, String> contactModes = new LinkedHashMap<String, String>();
		Map<String, String> emContactModes = new LinkedHashMap<String, String>();
		Map<String, Map<String, String>> listValues = new HashMap<String, Map<String, String>>();

		String messageTypesQry = "SELECT DISTINCT a.message_type code, a.description description FROM xh_message_type a, xh_event_type b, xm_eve_ntfy_rcp_gen_lang_vw c WHERE a.message_type = b.message_type AND b.event_type = c.event_type ORDER BY a.description";
		String eventTypesQry = "SELECT DISTINCT a.event_type code, a.event_type || '-' || a.event_name description FROM xh_event_type a, xm_eve_ntfy_rcp_gen_lang_vw b WHERE a.event_type = b.event_type ORDER BY a.event_type";
		String masterCodesQry = "SELECT short_desc, type_class, type_code FROM xm_notification_type_lang_vw WHERE language_id = 'en' AND eff_status = 'E' ORDER BY short_desc";
		String facilityQry = "SELECT a.facility_id code, a.facility_name description FROM sm_facility_param_lang_vw a, sm_modules_facility_vw b WHERE a.facility_id = b.facility_id AND b.module_id = 'XH' AND a.language_id = '" + locale + "' ORDER BY a.facility_name";

		try
		{
			recipientTypes.put("", "Select");
			contactTypes.put("", "Select");
			contactModes.put("", "Select");
			emContactModes.put("", "Select");

			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(masterCodesQry);
			resultSet = pstmt.executeQuery();
			while(resultSet.next())
			{
				String typeClass = resultSet.getString("type_class");
				String typeCode = resultSet.getString("type_code");
				String shortDesc = resultSet.getString("short_desc");

				if("RECIPIENT_TYPE".equals(typeClass)) {
					recipientTypes.put(typeCode, shortDesc);
				}
				else if("CONTACT_TYPE".equals(typeClass)) {
					contactTypes.put(typeCode, shortDesc);
				}
				else if("COMMUNICATION_MODE".equals(typeClass)) {
					contactModes.put(typeCode, shortDesc);
				}
				else if("EM_MODULE_CONTACT_MODE".equals(typeClass)) {
					emContactModes.put(typeCode, shortDesc);
				}
			}

			DAOUtil daoUtil = DAOUtil.getInstance();

			listValues.put("messageTypes", daoUtil.getValuesMap(dbConn, messageTypesQry));
			listValues.put("eventTypes", daoUtil.getValuesMap(dbConn, eventTypesQry));
			listValues.put("languages", daoUtil.getSMLanguages(dbConn));
			listValues.put("facilities", daoUtil.getValuesMap(dbConn, facilityQry));
			listValues.put("recipientTypes", recipientTypes);
			listValues.put("contactTypes", contactTypes);
			listValues.put("contactModes", contactModes);
			listValues.put("emContactModes", emContactModes);
			listValues.put("msgStatus", getMessageStatus());
			listValues.put("notificationTypes", getNotificationTypes());
		}
		catch (Exception exp)
		{
			System.out.println("(NotificationBean:searchCriteria) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}
		return listValues;
	}

	public static Map<String, String> getMessageStatus()
	{
		Map<String, String> messageStatus = new LinkedHashMap<String, String>();
		
		messageStatus.put("", "Select");
		messageStatus.put("S", "Success");
		messageStatus.put("E", "Error");
		messageStatus.put("P", "Pending");
		
		return messageStatus;
	}
	
	public static Map<String, String> getNotificationTypes()
	{
		Map<String, String> notificationTypes = new LinkedHashMap<String, String>();
		
		notificationTypes.put("", "Select");
		notificationTypes.put("O", "Online");
		notificationTypes.put("R", "Reminder");
		
		return notificationTypes;
	}
	
	public static Map<String, String> getReminderServiceTypes(String locale)
	{
		String query = "SELECT DISTINCT reminder_service_id code, REMINDER_SERVICE_NAME description FROM xm_reminder_service_lang_vw WHERE language_id = '"+locale+"'";
		Map<String, String> serviceTypes = null;

		try
		{
			serviceTypes = DAOUtil.getInstance().getValuesMap(null, query);
		}
		catch (Exception exp)
		{
			System.out.println("(NotificationBean:getReminderServiceTypes) Exception - " + exp.getMessage());
			System.out.println("(NotificationBean:getReminderServiceTypes) Query - " + query);
			exp.printStackTrace(System.err);
		}

		if(serviceTypes == null) serviceTypes = Collections.emptyMap();
		return serviceTypes;
	}

	public static List<List<Map<String, String>>> getDynamicFields(HttpServletRequest request, String locale)
	{
		return getDynamicFields(XHUtil.getRequestParams(request), locale);
	}

	public static List<List<Map<String, String>>> getDynamicFields(Map<String, String> requestParams, String locale)
	{
		List<List<Map<String, String>>> dynamicFields = new ArrayList<List<Map<String, String>>>();

		String dynamicFieldsQry = "SELECT trx_no, param_id paramID, param_name paramLabel, param_num_value, param_date_value, param_char_value paramCurrentValue, data_type paramDataType, range_requred_yn, schedule_cmd, lookup_query, code_desc_field_required_yn, system_defined_parameter_yn, field_display_type, fileld_lov, filed_co_ordinate, param_comparision_operator, param_logical_operator, criteria_type FROM xm_eve_ntfy_crt_param_lang_vw WHERE (filed_co_ordinate IS NULL OR filed_co_ordinate <> '0,0')"
									+ " AND event_type = '" + requestParams.get("eventType") 
									+ "' AND receipient_type ='" + requestParams.get("recipientType") 
									+ "' AND receipient_dependency = '" + requestParams.get("recipientDependancy") 
									+ "' AND contact_type = '" + requestParams.get("contactType") 
									+ "' AND contact_mode = '" + requestParams.get("contactMode")
									+ "' AND language_id = '" + locale + "'";

		try
		{
			DAOUtil daoUtil = DAOUtil.getInstance();
			System.out.println("dynamicFieldsQry "+dynamicFieldsQry);
			List<Map<String, String>> tempDynamicFields = daoUtil.getQueryResult(dynamicFieldsQry, null);

			List<Map<String, String>> commandDynamicFields = new ArrayList<Map<String, String>>();
			List<Map<String, String>> conditionDynamicFields = new ArrayList<Map<String, String>>();

			for(Map<String, String> currentParamDtls : tempDynamicFields)
			{
				String criteria = currentParamDtls.get("CRITERIA_TYPE");
				if("COMMAND".equals(criteria)) {
					commandDynamicFields.add(currentParamDtls);
				}
				else if("CONDITION".equals(criteria)) {
					conditionDynamicFields.add(currentParamDtls);
				}
			}
			dynamicFields.add(commandDynamicFields);
			dynamicFields.add(conditionDynamicFields);
		}
		catch (Exception exp)
		{
			System.out.println("(NotificationBean:getDynamicFields) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
	
		return dynamicFields;
	}

	public static Map<String, Map<String, String>> reminderQtyUnitLists()
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		Map<String, String> everyQtyUnits = new LinkedHashMap<String, String>();
		Map<String, String> retryQtyUnits = new LinkedHashMap<String, String>();
		Map<String, String> weekDayNos = new LinkedHashMap<String, String>();
		Map<String, String> weekDays = new LinkedHashMap<String, String>();
		Map<String, String> lastWeekDays = new LinkedHashMap<String, String>();
		Map<String, String> operators = new LinkedHashMap<String, String>();
		Map<String, Map<String, String>> listValues = new HashMap<String, Map<String, String>>();

		String masterCodesQry = "SELECT short_desc, type_class, type_code FROM xm_notification_type_lang_vw WHERE language_id = 'en' AND eff_status = 'E' ORDER BY short_desc";

		try
		{
			everyQtyUnits.put("", "Select");
			retryQtyUnits.put("", "Select");
			weekDayNos.put("", "Select");
			weekDays.put("", "Select");
			lastWeekDays.put("", "Select");
			operators.put("", "Select");

			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(masterCodesQry);
			resultSet = pstmt.executeQuery();

			while(resultSet.next())
			{
				String typeClass = resultSet.getString("type_class");
				String typeCode = resultSet.getString("type_code");
				String shortDesc = resultSet.getString("short_desc");

				if("EVERY_RETRY_QTY_UNIT".equals(typeClass)) {
					retryQtyUnits.put(typeCode, shortDesc);
				}
				else if("EVERY_WEEK_DAY_NUMBER".equals(typeClass)) {
					weekDayNos.put(typeCode, shortDesc);
				}
				else if("EVERY_WEEK_WEEK_DAY".equals(typeClass)) {
					weekDays.put(typeCode, shortDesc);
				}
				else if("LAST_WEEK_DAY".equals(typeClass)) {
					lastWeekDays.put(typeCode, shortDesc);
				}
				else if("SCHEDULE_EVERY_UNITS".equals(typeClass)) {
					everyQtyUnits.put(typeCode, shortDesc);
				}
				else if("OPERATOR".equals(typeClass)) {
					operators.put(typeCode, shortDesc);
				}
			}

			DAOUtil daoUtil = DAOUtil.getInstance();

			listValues.put("retryQtyUnits", retryQtyUnits);
			listValues.put("weekDayNos", weekDayNos);
			listValues.put("weekDays", weekDays);
			listValues.put("lastWeekDays", lastWeekDays);
			listValues.put("everyQtyUnits", everyQtyUnits);
			listValues.put("operators", operators);
		}
		catch (Exception exp)
		{
			System.out.println("(NotificationBean:searchCriteria) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}
		return listValues;
	}

	public static String getCriteriaTypeDesc(String criteriaType)
	{
		String criteriaTypeDesc = "Preferrences";

		if("CONT".equals(criteriaType)) {
			criteriaTypeDesc = "Contact Settings";
		}
		else if("RMND".equals(criteriaType)) {
			criteriaTypeDesc = "Reminder Settings";
		}
		else if("FRMT".equals(criteriaType)) {
			criteriaTypeDesc = "Format Settings";
		}
		else if("NTFY".equals(criteriaType)) {
			criteriaTypeDesc = "Subscriptions";
		}

		return criteriaTypeDesc;
	}
}
