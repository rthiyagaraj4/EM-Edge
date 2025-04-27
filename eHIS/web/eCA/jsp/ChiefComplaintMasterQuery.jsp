<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager,java.util.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;

try 
{
  con  =  ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");           // Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ComplaintID.label","ca_labels"));			 // label
firstItem.add("complaint_id");		 // name of field
firstItem.add("6");			 // SIZE
firstItem.add("6");             // LENGTH
finAr.add(firstItem);            // add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");           // Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ComplaintDescription.label","ca_labels"));			  // label
secondItem.add("complaint_desc");	  // name of field
secondItem.add("50");			  // SIZE
secondItem.add("50");             // LENGTH
finAr.add(secondItem);            // add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");           // Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityDesc.label","ca_labels"));			  // label
thirdItem.add("speciality_code");	  // name of field
thirdItem.add("select speciality_code, long_desc speciality_desc from am_speciality where eff_status = 'E' order by speciality_desc");		
finAr.add(thirdItem);            // add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("List");           // Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels"));			  // label
fourthItem.add("eff_status");	  // name of field
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");
//fourthItem.add("B,Both,Y,Yes,N,No");
finAr.add(fourthItem);			//	add to ArrayList obj finAr

String[] orderByCols = null;
String[] orderByColVals = null;


	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ComplaintID.label","ca_labels");
	orderByCols[1] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ComplaintDescription.label","ca_labels");
	orderByCols[2] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityDesc.label","ca_labels");
		
	orderByColVals[0] = "complaint_id";
	orderByColVals[1] = "complaint_desc";
	orderByColVals[2] = "speciality_code";
	

strbuff = qrypg.getQueryPage(con,finAr,"Chief Complaint Master","../../eCA/jsp/ChiefComplaintMasterResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());

finAr.clear();
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();



}//end of try

		catch (Exception e) 
		{
			//out.println("Exception: "+e);//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
		}

		finally	
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
%>


