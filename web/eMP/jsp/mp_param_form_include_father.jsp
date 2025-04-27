<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.*,java.util.HashMap,java.util.Properties, java.util.ArrayList, java.text.SimpleDateFormat, com.ehis.util.*, webbeans.eCommon.ConnectionManager,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html> 
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../js/mp_param.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<% 
	Connection con=null ;
	String first_name_length = "";
	String second_name_length = "";
	String third_name_length = "";
	String family_name_length = "";
try{
	request.setCharacterEncoding("UTF-8");
    con = ConnectionManager.getConnection(request);
	Boolean mpDisableFieldsNBFather = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","MP_DISABLE_FIELDS_NB_FATHER");
	JSONObject getLengthHeadValueYN = new JSONObject();
	   getLengthHeadValueYN		=	eMP.MPCommonBean.getLengthHeadValueYN(con);
	   first_name_length =	checkForNull((String)getLengthHeadValueYN.get("first_name_length"));
	   second_name_length =	checkForNull((String)getLengthHeadValueYN.get("second_name_length"));
	   third_name_length =	checkForNull((String)getLengthHeadValueYN.get("third_name_length"));
	   family_name_length =	checkForNull((String)getLengthHeadValueYN.get("family_name_length"));
	String enableMaritalValue = "";
	String enable_marital_status_chked = "";
	String order = "";
	int emptyCnt			= 0;
	HashMap Name_Order 			=	 new HashMap(); 
	String nb_father_name_mandatory_yn = checkForNull( request.getParameter( "nb_father_name_mandatory_yn") );
	if(nb_father_name_mandatory_yn.equals("Y")){
	enableMaritalValue = "";
	 }else{
	enableMaritalValue = "disabled";}
	String first_name_accept_yn = checkForNull( request.getParameter( "first_name_accept_yn") );
	String first_name_reqd_yn = checkForNull( request.getParameter( "first_name_reqd_yn") );
	String first_name_order = checkForNull( request.getParameter( "first_name_order") );
	String first_name_prompt = checkForNull( request.getParameter( "first_name_prompt") );
	if(first_name_prompt.equals("")) first_name_prompt = "First Name";
	String second_name_accept_yn = checkForNull( request.getParameter( "second_name_accept_yn") );
	String second_name_reqd_yn = checkForNull( request.getParameter( "second_name_reqd_yn") );
	String second_name_order = checkForNull( request.getParameter( "second_name_order") );
	String second_name_prompt = checkForNull( request.getParameter( "second_name_prompt") );
	if(second_name_prompt.equals("")) second_name_prompt = "Second Name";
	String third_name_accept_yn = checkForNull( request.getParameter( "third_name_accept_yn") );
	String third_name_reqd_yn = checkForNull( request.getParameter( "third_name_reqd_yn") );
	String third_name_order = checkForNull( request.getParameter( "third_name_order") );
	String third_name_prompt = checkForNull( request.getParameter( "third_name_prompt") );
	if(third_name_prompt.equals("")) third_name_prompt = "Third Name";
	String family_name_accept_yn = checkForNull( request.getParameter( "family_name_accept_yn") );
	String family_name_reqd_yn = checkForNull( request.getParameter( "family_name_reqd_yn") );
	String family_name_order = checkForNull( request.getParameter( "family_name_order") );
	String family_name_prompt = checkForNull( request.getParameter( "family_name_prompt") );
	if(family_name_prompt.equals("")) family_name_prompt = "Family Name";
	String enable_marital_status    = checkForNull( request.getParameter( "enable_marital_status") ) ;
    String dflt_father_first_name_prompt    = checkForNull( request.getParameter( "dflt_father_first_name_prompt") ) ;
    String dflt_father_Second_name_prompt    = checkForNull( request.getParameter( "dflt_father_Second_name_prompt") ) ;
    String dflt_father_third_name_prompt    = checkForNull( request.getParameter( "dflt_father_third_name_prompt") ) ;
    String dflt_father_family_name_prompt    = checkForNull( request.getParameter( "dflt_father_family_name_prompt") ) ;
	if(enable_marital_status.equals("Y")) enable_marital_status_chked = "checked";
	String mandateFather = "";
	if(enable_marital_status.equals("Y") && nb_father_name_mandatory_yn.equals("Y")){
	mandateFather = "visibility:visible";}
	Name_Order.put(family_name_order,"Family_Name_Order");
	Name_Order.put(first_name_order,"First_Name_Order");
	Name_Order.put(second_name_order,"Second_Name_Order");
	Name_Order.put(third_name_order,"Third_Name_Order");
if(mpDisableFieldsNBFather){%>
      <tr><td class='label'  nowrap ><fmt:message key="Common.Enable.label" bundle="${common_labels}"/> "<fmt:message key="eMP.No_bc.label" bundle="${mp_labels}"/> <fmt:message key="eMP.maritalstatus.label" bundle="${mp_labels}"/>" <fmt:message key="eMP.ChkBoxFatherDetail.label" bundle="${mp_labels}"/> </td>
            <td class='fields'><input type='checkbox' name='enable_marital_status' id='enable_marital_status'  value='Y' <%=enable_marital_status_chked%> onClick='checkForMode(this);checkDefaultFather(this)' <%=enableMaritalValue%>></td>
			</tr><tr><td class='label'  nowrap ><fmt:message key="eMP.DefaultFather.label" bundle="${mp_labels}"/></td> 
			<td><table border= '0' cellpadding='0' cellspacing='0' width='100%'><tr>
			<%for(int i=1;i<=4;++i)
					 {
						 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

						 if (order.equals("First_Name_Order"))
						 {
							if(first_name_accept_yn.equals("Y")) 
							{ 
								if(first_name_reqd_yn.equals("Y")) 
								{%>
									<td class='label' nowrap ><%=first_name_prompt%> : </td>
									<td  class='fields'><input type='text' name='dflt_father_first_name_prompt' id='dflt_father_first_name_prompt' value='<%=dflt_father_first_name_prompt%>' <%=enableMaritalValue%> size="20" maxlength='<%=first_name_length%>'><img id='dflt_father_first_name_img' style='<%=mandateFather%>' src='../../eCommon/images/mandatory.gif'></img></td>
								<%}
							}
							 else
								emptyCnt++;						 
						 }
						 else
						 if (order.equals("Second_Name_Order"))
						 {
							 if(second_name_accept_yn.equals("Y")) 
							{
								if(second_name_reqd_yn.equals("Y")) { %>
								<td class='label' nowrap ><%=second_name_prompt%> : </td>
								<td  class='fields'><input type='text' name='dflt_father_Second_name_prompt' id='dflt_father_Second_name_prompt' value='<%=dflt_father_Second_name_prompt%>' <%=enableMaritalValue%> size="20" maxlength='<%=second_name_length%>'><img id='dflt_father_Second_name_img' style='<%=mandateFather%>' src='../../eCommon/images/mandatory.gif'></img></td>
								<% }
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Third_Name_Order"))
						 {
							 if (third_name_accept_yn.equals("Y") )
							{ 
							if(third_name_reqd_yn.equals("Y")) { %>
								<td class='label' nowrap ><%=third_name_prompt%> : </td> 
								<td  class='fields'><input type='text' name='dflt_father_third_name_prompt' id='dflt_father_third_name_prompt'  value='<%=dflt_father_third_name_prompt%>' <%=enableMaritalValue%> size="20" maxlength='<%=third_name_length%>'><img id='dflt_father_third_name_img' style='<%=mandateFather%>' src='../../eCommon/images/mandatory.gif'></img></td>
								<% }
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Family_Name_Order"))
						 {
							 if (family_name_accept_yn.equals("Y") ) 
							{ 
								if(family_name_reqd_yn.equals("Y")) { %>
								<td class='label' nowrap ><%=family_name_prompt%> : </td> 
								<td  class='fields'><input type='text' name='dflt_father_family_name_prompt' id='dflt_father_family_name_prompt' value='<%=dflt_father_family_name_prompt%>' <%=enableMaritalValue%> size="20" maxlength='<%=family_name_length%>'><img id='dflt_father_family_name_img' style='<%=mandateFather%>' src='../../eCommon/images/mandatory.gif'></img></td>
								<% } 
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 {
							 emptyCnt++;
						 }
					}%>
				</tr></table></td></tr>
	   <% }}
	catch( Exception ce ) {ce.printStackTrace();}
    finally{if(con != null) ConnectionManager.returnConnection(con,request); }%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>  

