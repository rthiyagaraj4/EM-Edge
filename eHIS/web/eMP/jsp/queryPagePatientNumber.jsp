<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
String accept_national_id_no_yn = "N";
Connection con=null ;
PreparedStatement pstmt=null;
ResultSet rs=null;
try
{
con = ConnectionManager.getConnection(request);
pstmt = con.prepareStatement("select accept_national_id_no_yn from mp_param");
		rs= pstmt.executeQuery();
		if(rs.next())
		{
		accept_national_id_no_yn=rs.getString("accept_national_id_no_yn");
		}
if(accept_national_id_no_yn==null)
	accept_national_id_no_yn="N";

//Added by Sangeetha for ML-MMOH-CRF-0732 
Boolean increase_leng_pat_series	= CommonBean.isSiteSpecific(con, "MP","INCREASE_LENGTH_PAT_SERIES");

ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeriesCode.label","mp_labels"));	  // label
firstItem.add("pat_ser_grp_code");	//name of field
firstItem.add("2");	// SIZE
if(increase_leng_pat_series)  //Added by Sangeetha for ML-MMOH-CRF-0732 
firstItem.add("3");	//LENGTH
else
firstItem.add("2");

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSerieDesc.label","mp_labels"));	  // label
secondItem.add("long_desc");	//name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");   		
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SeriesType.label","mp_labels"));  	
thirdItem.add("id_type");	

if(accept_national_id_no_yn.equals("Y"))
{
thirdItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AlternateIDSeries.label","mp_labels")+",B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBornSeries.label","mp_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EmergencySeries.label","mp_labels")+",G,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GeneralSeries.label","mp_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UnrestrictedSeries.label","mp_labels")+",X,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalSourceSeries.label","mp_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalPatientDonorSeries.label","mp_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalIDSeries.label","mp_labels"));
}
else if(accept_national_id_no_yn.equals("N"))
{
thirdItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AlternateIDSeries.label","mp_labels")+",B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBornSeries.label","mp_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EmergencySeries.label","mp_labels")+",G,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GeneralSeries.label","mp_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UnrestrictedSeries.label","mp_labels")+",X,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalSourceSeries.label","mp_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalPatientDonorSeries.label","mp_labels"));
}

finAr.add(thirdItem); 	

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeriesCode.label","mp_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSerieDesc.label","mp_labels");

orderByColVals[0] = "pat_ser_grp_code";
orderByColVals[1] = "short_desc";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeries.label","mp_labels"),"../jsp/queryPatientNumber.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
}
catch (Exception e) {
	e.printStackTrace();
	//out.println(e.toString());
	}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
