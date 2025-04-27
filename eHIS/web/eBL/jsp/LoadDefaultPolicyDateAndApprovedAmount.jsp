<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,com.ehis.util.*,eBL.Common.*, eBL.*" contentType="text/html;charset=UTF-8" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0    
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
String Str																					=	"!";
String pateintId																			=	"";
String moduleId																				=	"";
String customerGroupcode																	=	"";
String customerCode																			=	"";
String policyTypeCode																		=	"";
String locale																				=	"";
String facilityId																			=	"";
Connection connection																		=   null;
PreparedStatement preparedStatement															= 	null;
ResultSet resultSet																			= 	null;
String	mId																					=	"@moduleId";
String	fId																					=	"@facilityId";
String	cGId																				=	"@customerGroupcode";
String	cId																					=	"@customerCode";
String	pTCId																				=	"@policyTypeCode";
StringBuffer sql																			= 	null;		
try
{
	
	request.setCharacterEncoding("UTF-8");
	System.err.println("In LoadDefaultPolicyDateAndApprovedAmount.jsp.::: ");
	sql																						=	new StringBuffer();	
	connection																				=	ConnectionManager.getConnection(request);
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	moduleId																				=	checkForNull(request.getParameter("strModuleId")); 
	customerGroupcode																		=	checkForNull(request.getParameter("cust_group_code"));
	customerCode																			=	checkForNull(request.getParameter("cust_code"));
	policyTypeCode																			=	checkForNull(request.getParameter("policy_type_code"));
	/*System.out.println("facilityId in LoadDefaultPolicyDateAndApprovedAmount.jsp:::::::::: "+facilityId);
	System.out.println("moduleId in LoadDefaultPolicyDateAndApprovedAmount.jsp:::::::::::: "+moduleId);
	System.out.println("customerGroupcode in LoadDefaultPolicyDateAndApprovedAmount.jsp::: "+customerGroupcode);
	System.out.println("customerCode in LoadDefaultPolicyDateAndApprovedAmount.jsp:::::::: "+customerCode);
	System.out.println("policyTypeCode in LoadDefaultPolicyDateAndApprovedAmount.jsp:::::: "+policyTypeCode);
	*/
	
	
	if(moduleId.equalsIgnoreCase("MP"))
	{
		sql.append(BlRepository.getBlKeyValue("BILLING_ADDPAYER_INSURANCE_DEFAULT_VALUES_MP"));
	}
	if(moduleId.equalsIgnoreCase("IP") || moduleId.equalsIgnoreCase("DC"))
	{
		sql.append(BlRepository.getBlKeyValue("BILLING_ADDPAYER_INSURANCE_DEFAULT_VALUES_IP"));
	}
	if(moduleId.equalsIgnoreCase("OP") || moduleId.equalsIgnoreCase("AE"))
	{
		sql.append(BlRepository.getBlKeyValue("BILLING_ADDPAYER_INSURANCE_DEFAULT_VALUES_OP"));
	}
	//System.out.println("sql in LoadDefaultPolicyDateAndApprovedAmount.jsp BEFORE:::::: "+sql);
	sql.replace(sql.indexOf(cGId),sql.indexOf(cGId)+cGId.length(),  customerGroupcode);
	sql.replace(sql.indexOf(cId),sql.indexOf(cId)+cId.length(),  customerCode);
	sql.replace(sql.indexOf(pTCId),sql.indexOf(pTCId)+pTCId.length(),  policyTypeCode);
	System.err.println("sql in LoadDefaultPolicyDateAndApprovedAmount.jsp AFTER:::::: "+sql);
	//System.out.println("connection in LoadDefaultPolicyDateAndApprovedAmount.jsp AFTER:::::: "+connection);
	preparedStatement = connection.prepareStatement(sql.toString());
	resultSet=preparedStatement.executeQuery();
		
	if( resultSet != null ) 
	{
		while(resultSet.next())
		{
			
			Str=Str+formatDate(checkForNull(resultSet.getString(1)))+"~"+formatDate(checkForNull(resultSet.getString(2)))+"~"+checkForNull(resultSet.getString(3))+"~"+checkForNull(resultSet.getString(4))+"~"+checkForNull(resultSet.getString(5))+"~";
		}
	}
	System.out.println("Str in LoadDefaultPolicyDateAndApprovedAmount.jsp AFTER:::::: "+Str);

 	out.println(Str);

}
catch(Exception e)
{
	System.err.println("EXCEPTION IN LoadDefaultPolicyDateAndApprovedAmount.jsp.::::: "+e); 
}
finally
{
	if(resultSet!=null) resultSet.close();
	if(preparedStatement!=null) preparedStatement.close();
	if(connection!=null) ConnectionManager.returnConnection(connection);
	
}
%>
<%!	
private String checkForNull(String inputString)
{
	
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}

public String formatDate(String inputDate){
	if(inputDate==null || inputDate.equals("")){
		return "";
	}
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Timestamp inputTimeStamp = null;
    String outputDate=inputDate;
    long longTimeStamp = 0;
    inputTimeStamp = Timestamp.valueOf(inputDate);
    longTimeStamp = inputTimeStamp.getTime();
    outputDate=sdf.format(longTimeStamp);
    return outputDate;
}
%>
