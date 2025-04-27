/***************************************************************************************************************
 * Author   :   Ravindranath.O
 * Desc     :	
 ***************************************************************************************************************/
package eXH;

import java.util.Map;
import java.util.LinkedHashMap;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Properties;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.json.simple.JSONValue;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import webbeans.eCommon.*;

public class FilterCriteriaSettingsServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		HttpSession session = request.getSession(false);

		
		String locale = ((Properties) session.getValue("jdbc")).getProperty("LOCALE");	
		String requestType = request.getParameter("requestType");
		String filterGroupCode = request.getParameter("filterGroupCode");

		System.out.println("requestType " + requestType);
		System.out.println("session " + session);
		System.out.println("locale" + locale);

		if("GET_CRITERIA_ELEMENT_LIST".equals(requestType))
		{
			Map<String, String> criteriaElementList = getCriteriaElementList(filterGroupCode);
			String[] operatorList = getOperatorList();
			request.setAttribute("criteriaElementList", criteriaElementList);
			request.setAttribute("operatorList", operatorList);
			session.getServletContext().getRequestDispatcher("/eXH/jsp/FilterCriteriaSettings.jsp").forward(request, response);
		}
		else if("GET_QRY_RESULT".equals(requestType))
		{
			String filterQryResult = getFilterResults(request);

			PrintWriter responseWriter = response.getWriter();
			responseWriter.write(filterQryResult);
			responseWriter.flush();
			responseWriter.close();
		}
		else if("SAVE_FILTER".equals(requestType) || "DELETE_FILTER_CRITERIA".equals(requestType))
		{
			String statusMessage = processFilter(request, locale);
			request.setAttribute("statusMessage", statusMessage);
			session.getServletContext().getRequestDispatcher("/eXH/jsp/FilterCriteriaDispResult.jsp?stMessage="+statusMessage).forward(request, response);
		}
		else if("DISP_FILTER_CRITERIA".equals(requestType))
		{
			Map<String, String> filterCriterisList = getFilterCriteriaList(filterGroupCode);
			request.setAttribute("filterCriterisList", filterCriterisList);
			session.getServletContext().getRequestDispatcher("/eXH/jsp/FilterCriteriaSettingsApplicationLevel.jsp").forward(request, response);
		}
    }
/*
	private Map<String, String> getColumnList(String filterGroupCode)
	{
		Map<String, String> columnList = new LinkedHashMap<String, String>();
		int count = 1;

		try
		{
			String rawColumnElements = getRawColumnElements(filterGroupCode);
			String[] elements = rawColumnElements.split(Pattern.quote("$#$"));

			for(String currentElement : elements)
			{
				String[] currentElementAttributes = currentElement.split(Pattern.quote("$#!"));

				String id = currentElementAttributes[0].replace(":[COL_NO]", String.valueOf(count++));
				String desc = currentElementAttributes[1];
				columnList.put(id, desc);
			}
			System.out.println("columnList "+columnList);
		}
		catch (Exception exp)
		{
			System.out.println("(FilterRuleSettings:getColumnList) Filter Group Code - " + filterGroupCode);
			System.out.println("(FilterRuleSettings:getColumnList) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		return columnList;
	}
*/
	private Map<String, String> getCriteriaElementList(String filterGroupCode)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Map<String, String> criteriaElementList = new LinkedHashMap<String, String>();
		String qry = "SELECT filter_element_id || '-' || level_number || '-' || dependant_levels id , filter_element_type_desc"
					+ "  FROM xh_filter "
					+ " WHERE filter_group_code = ?";
		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			pstmt.setString(1, filterGroupCode);
			resultSet = pstmt.executeQuery();

			while(resultSet.next()) {
				criteriaElementList.put(resultSet.getString("id"), resultSet.getString("filter_element_type_desc"));
			}
			System.out.println("criteriaElementList "+criteriaElementList);
		}
		catch (Exception exp) {
			System.out.println("(FilterRuleSettings:getRawColumnElements) Filter Group Code - " + filterGroupCode);
			System.out.println("(FilterRuleSettings:getRawColumnElements) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally {
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}
		return criteriaElementList;
	}

	private String getFilterResults(HttpServletRequest request)
	{
		Map<String, String> filterResultsMap = null;

		String filterResultDataJSON = "";

		try
		{
			String criteriaElement = request.getParameter("criteriaElement");
			String filterGroupCode = request.getParameter("filterGroupCode");
			JSONObject dependantCriteriaDtlsJSON = convertStrToJSONObj(request.getParameter("dependantCriteriaDtlsJSON"));
			String[] criteriaElementArray = criteriaElement.split("-");

			filterResultsMap = getFilterQryResults(criteriaElementArray, filterGroupCode, dependantCriteriaDtlsJSON);

			filterResultDataJSON = JSONValue.toJSONString(filterResultsMap);
		}
		catch (Exception exp)
		{
			System.out.println("(FilterCriteriaSettingsServlet:getFilterResults) Exception " + exp);
			exp.printStackTrace(System.err);
		}

		return filterResultDataJSON;
	}

	private Map<String, String> getFilterQryResults(String[] filterLevelTypeArray, String filterGroupCode, JSONObject dependantCriteriaDtlsJSON)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Map<String, String> filterDataMap = new LinkedHashMap<String, String>();

		String actualQry = null;
		String qry = "SELECT query FROM xh_filter WHERE filter_group_code = '" + filterGroupCode + "' AND level_number = '" + filterLevelTypeArray[1] + "'";
		try
		{
			actualQry = XHUtil.singleParamExeQry(qry);

			actualQry = replaceDependantValues(actualQry, dependantCriteriaDtlsJSON);

			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(actualQry);
			resultSet = pstmt.executeQuery();

			while(resultSet.next())
			{
				filterDataMap.put(resultSet.getString("code"), resultSet.getString("description"));
			}
			System.out.println("filterDataMap "+filterDataMap);
		}
		catch (Exception exp)
		{
			System.out.println("(FilterRuleSettings:getFilterQryResults) Query " + actualQry);
			System.out.println("(FilterRuleSettings:getFilterQryResults) Filter Group Code  [" + filterGroupCode + "] Level number [" + filterLevelTypeArray[1] + "]");
			System.out.println("(FilterRuleSettings:getFilterQryResults) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally {
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}
		return filterDataMap;
	}

	/**
	 * Method replaces the dynamic parameters in the query with the values selected by the user.
	 * @param qry Query set in xh_filter. 
	 * Eg:- SELECT '*' || ' - ' || 'NONE' description, '*' code FROM DUAL UNION SELECT clinic_code||'-'||short_desc description,clinic_code code from op_clinic WHERE facility_id = :1 AND care_locn_type_ind = :2
	 * @param jsonObj Dynamic values selected by the user stored in json string format
	 */
	public String replaceDependantValues(String qry, JSONObject jsonObj) throws Exception
	{
		try
		{
			Pattern pattern = Pattern.compile(":(.?)");
			Matcher matcher = pattern.matcher(qry);

			while(matcher.find()) {
				String currentMatch = matcher.group();
				String currentDependancyNo = matcher.group(1);
				qry = qry.replaceAll(currentMatch, (String) jsonObj.get(currentDependancyNo));
			}
		}
		catch (Exception exp) {
			System.out.println("replaceDependantValues) Query [" + qry + "] DependantValues [" + jsonObj + "]");
			throw exp;
		}
		
		return qry;
	}

	private String processFilter(HttpServletRequest request, String locale)
	{
		String filterGroupCode = request.getParameter("filterGroupCode");
		String guiFilterSyntax = request.getParameter("guiFilterSyntax");
		String processingFilterSyntax = request.getParameter("processingFilterSyntax");
		String trxNo = request.getParameter("trxNo");
		String requestType = request.getParameter("requestType");
		String mode = "I";
		
		if("DELETE_FILTER_CRITERIA".equals(requestType)) {
			mode = "D";
		}
		String statusMessage = null;

		String errCode = processFilterAction(mode, locale, filterGroupCode, trxNo, guiFilterSyntax, processingFilterSyntax);

		if("0".equals(errCode)) statusMessage = XHUtil.getMessage("0", locale);
		else if("1".equals(errCode)) statusMessage = XHUtil.getMessage("1", locale);
		else if("2".equals(errCode)) statusMessage = XHUtil.getLocaleMessage(locale, "XH1024", "XH");

		return statusMessage;
	}

	private String processFilterAction(String mode, String locale, String filterGroupCode, String trxNo, 
			String guiFilterSyntax,	String processingFilterSyntax) 
	{
		Connection dbConn = null;
		CallableStatement cstmt = null;

		String errCode = "";
		String procedureCall = "{ CALL xhgenericfilter.FILTER_GRP_APPL_RULE_DETAIL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";

		try
		{
			dbConn = ConnectionManager.getConnection();
			cstmt = dbConn.prepareCall(procedureCall);

			cstmt.setString(1, mode);
			cstmt.setString(2, trxNo);
			cstmt.setString(3, filterGroupCode);
			cstmt.setString(4, "");
			cstmt.setString(5, "");
			cstmt.setString(6, "");
			cstmt.setString(7, "");
			cstmt.setString(8, "");
			cstmt.setString(9, "");
			cstmt.setString(10, "");
			cstmt.setString(11, "");
			cstmt.setString(12, "");
			cstmt.setString(13, "");
			cstmt.setString(14, "");
			cstmt.setString(15, "");
			cstmt.setString(16, "");
			cstmt.setString(17, "");
			cstmt.setString(18, "");
			cstmt.setString(19, "");
			cstmt.setString(20, "");
			cstmt.setString(21, "");
			cstmt.setString(22, "");
			cstmt.setString(23, "");
			cstmt.setString(24, "");
			cstmt.setString(25, "");
			cstmt.setString(26, "");
			cstmt.setString(27, "");
			cstmt.setString(28, "");
			cstmt.setString(29, "");
			cstmt.setString(30, "");
			cstmt.setString(31, "");
			cstmt.setString(32, "");
			cstmt.setString(33, "");
			cstmt.setString(34, "");
			cstmt.setString(35, "");
			cstmt.setString(36, "");
			cstmt.setString(37, "");
			cstmt.setString(38, "");
			cstmt.setString(39, "");
			cstmt.setString(40, "");
			cstmt.setString(41, "");
			cstmt.setString(42, "");
			cstmt.setString(43, "");
			cstmt.setString(44, "");
			cstmt.setString(45, "");
			cstmt.setString(46, "");
			cstmt.registerOutParameter(47,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(48,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(49,java.sql.Types.VARCHAR);
			cstmt.setString(50, guiFilterSyntax);
			cstmt.setString(51, processingFilterSyntax);
			cstmt.execute();
	
		    errCode = cstmt.getString(48);
		    String errorMsg = cstmt.getString(49);
			
			if("0".equals(errCode)) {
				dbConn.commit();
			}
			else {
				dbConn.rollback();
				System.out.println("(FilterCriteriaSettingsServlet:processFilterAction) Error Code: " + errCode);
				System.out.println("(FilterCriteriaSettingsServlet:processFilterAction) Error Message: " + errorMsg);
			}
		}
		catch (Exception exp) {
			System.out.println("(FilterCriteriaSettingsServlet:processFilterAction) Filter Group Code - " + filterGroupCode);
			System.out.println("(FilterCriteriaSettingsServlet:processFilterAction) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally {
			XHUtil.closeDBResources(null, cstmt, dbConn);
		}
		return errCode;
	}
	
	private String[] getOperatorList()
	{
		String[] operatorList = {" = ", " <> ", " > ", " >= ", " < ", " <= ", " LIKE ", " BETWEEN ", " IS NOT NULL ", " IS NULL ", " IN ", " NOT IN "};
		return operatorList;
	}

	public JSONObject convertStrToJSONObj(String jsonStr) throws Exception
	{
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParser.parse(jsonStr);
		return jsonObj;
	}

	private Map<String, String> getFilterCriteriaList(String filterGroupCode)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Map<String, String> filterCriteriaList = new LinkedHashMap<String, String>();
		String qry = "SELECT TRX_NO, GUI_FILTER_SYNTAX from XH_APPL_FILTER_RULE_DETAIL where filter_group_code = ?";
		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			pstmt.setString(1, filterGroupCode);
			resultSet = pstmt.executeQuery();

			while(resultSet.next())
			{
				filterCriteriaList.put(resultSet.getString("TRX_NO"), resultSet.getString("GUI_FILTER_SYNTAX"));
			}
			System.out.println("filterCriteriaList "+filterCriteriaList);
		}
		catch (Exception exp)
		{
			System.out.println("(FilterRuleSettings:getFilterCriteriaList) Filter Group Code - " + filterGroupCode);
			System.out.println("(FilterRuleSettings:getFilterCriteriaList) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}
		return filterCriteriaList;
	}	
}