<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"  %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<HTML>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	String user_id_new =request.getParameter( "user_id" );
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	String sortorder =
	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
	String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
	String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ; 
	String executequery =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	String user_id =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels") ;
	String roles=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Roles.Label","ot_labels") ;
	String function_id =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Roles.Label","ot_labels");
	String roles_type =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RoleType.Label","ot_labels");
	StringBuffer strbuff;
	Connection con=null ;
try {

		con  =  ConnectionManager.getConnection(request);
		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();
		ArrayList secondItem = new ArrayList();		
		firstItem.add("List");           //Type of item
		firstItem.add(user_id);     // label
		firstItem.add("user_id");   //name of field
		firstItem.add("SELECT APPL_USER_NAME, APPL_USER_ID FROM SM_APPL_USER WHERE NVL(EFF_STATUS,'E') = 'E'  ORDER BY  APPL_USER_ID "); //050488 changed the sort order

		finAr.add(firstItem);//add to ArrayList obj finAr

		secondItem.add("List");    //Type of item
		secondItem.add(roles);     // label
		secondItem.add("roles");   //name of field
		//secondItem.add("SELECT ROLE_ID, ROLE_DESC FROM ot_roles where APPL_TO_OT_SLATE='Y' ORDER BY ROLE_DESC"); // SIZE
		secondItem.add("SELECT A.ROLE_ID, A.ROLE_DESC, A.ROLE_TYPE, B.ROLE_TYPE_DESC,NVL (A.APPL_TO_OT_SLATE, 'N') APPL_TO_OT_SLATE,NVL (A.STATUS, 'E') STATUS FROM OT_ROLES_LANG_VW A, OT_ROLE_TYPE_LANG_VW B WHERE A.LANGUAGE_ID = '"+locale+"' AND B.LANGUAGE_ID = '"+locale+"' AND A.APPL_TO_OT_SLATE = 'Y' AND A.ROLE_TYPE = B.ROLE_TYPE(+) ORDER BY ROLE_DESC");//50519
		finAr.add(secondItem);//add to ArrayList obj finAr

		String[] orderByCols=null;
		String[] orderByColVals=null;

		orderByCols = new String[2];
		orderByColVals = new String[2];

		orderByCols[0] = user_id;
		orderByCols[1] = roles;
		
	   
		orderByColVals[0] = "appl_user_id";
		orderByColVals[1] = "role_id";

	
		strbuff = qrypg.getQueryPage( con,finAr,"Functions ","../../eOT/jsp/RolesForUserQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
		out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='user_id' id='user_id' value="<%=user_id_new%>">

</body>
</HTML>

