<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.Connection, java.util.ArrayList, webbeans.eCommon.ConnectionManager" %>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String locale = (String)session.getAttribute("LOCALE"); 

	request.setCharacterEncoding("UTF-8");
%>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

String sortOrder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"); 
String select =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");

String executeQuery =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String speciality =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
String locationType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
String noteType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels");
String holdingAreaNotes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.HoldingAreaNotes.Label","ot_labels");

String surgeonNotes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SurgeonNotes.Label","ot_labels");

String recoveryNotes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RecoveryNotes.Label","ot_labels");
String All =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("List");           //Type of item
firstItem.add(speciality);     // label
firstItem.add("speciality_code");   //name of field
firstItem.add("SELECT A.SPECIALITY_CODE, A.LONG_DESC FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B WHERE A.LANGUAGE_ID='"+locale+"' AND NVL(A.EFF_STATUS,'E') = 'E'AND A.SPECIALITY_CODE = B.SPECIALITY_CODE ORDER BY 2"); // SIZE

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("List");          //Type of item
//secondItem.add("Location Type");    // label
secondItem.add(locationType);    // label
secondItem.add("locn_type");  //name of field
secondItem.add("all,"+All+",10,"+holdingAreaNotes+",30,"+surgeonNotes+",40,"+recoveryNotes);   // SIZE
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(noteType);    // label
thirdItem.add("note_type");  //name of field
thirdItem.add("4");   // SIZE
thirdItem.add("4");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

String[] orderByCols=null;
String[] orderByColVals=null;

orderByCols = new String[3];
orderByColVals = new String[3];

orderByCols[0] = speciality;
orderByCols[1] = locationType;
orderByCols[2] = noteType;
// orderByCols[3] = "Select";
    
orderByColVals[0] = "speciality_code";
orderByColVals[1] = "locn_type";
orderByColVals[2] = "note_type";
//orderByColVals[3] = "sel";
    
	

strbuff = qrypg.getQueryPage( con,finAr,"NoteTypeForSpeciality" ,"../../eOT/jsp/NoteTypeForSpecialitiesQueryResult.jsp",sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);
out.println(strbuff.toString());
} catch (Exception e) {}
finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

