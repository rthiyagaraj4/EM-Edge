<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>


<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;
try 
{
	con = (Connection) session.getValue( "connection" );

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 
firstItem.add( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));  	
firstItem.add("facility_id");	
firstItem.add("2");				
firstItem.add("2");				

finAr.add(firstItem);				

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  			//Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));  	// label
secondItem.add("facility_name");   //name of field
secondItem.add("48");				// SIZE
secondItem.add("35");				//LENGTH

finAr.add(secondItem); 				//add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   				//Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FileTypeCode.label","mp_labels"));  	// label
thirdItem.add("file_type_code");		//name
thirdItem.add("2");					// SIZE
thirdItem.add("2");					//LENGTH

finAr.add(thirdItem); 				//add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");   					//Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FileTypeDescription.label","common_labels"));  	// label
fourthItem.add("long_desc");	//name
fourthItem.add("30");			// SIZE
fourthItem.add("30");			//LENGTH

finAr.add(fourthItem); 				//add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   		
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ApplicableTo.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OP.label","common_labels") );  	
fifthItem.add("appl_to_op");	
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));

finAr.add(fifthItem); 			

ArrayList sixthItem = new ArrayList();

sixthItem.add("List");   		//Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ApplicableTo.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IP.label","common_labels"));  	// label
sixthItem.add("appl_to_ip");	//name
sixthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));

finAr.add(sixthItem); 			//add to ArrayList obj finAr

ArrayList seventhItem = new ArrayList();

seventhItem.add("List"); 			//Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ApplicableTo.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EM.label","mp_labels"));  	// label
seventhItem.add("appl_to_em");		//name
seventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));

finAr.add(seventhItem); 			//add to ArrayList obj finAr

ArrayList eighthItem = new ArrayList();

eighthItem.add("List");   		 //Type of item
eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ApplicableTo.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DC.label","common_labels"));  	// label
eighthItem.add("appl_to_dc");	//name
eighthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));					

finAr.add(eighthItem); 			//add to ArrayList obj finAr


ArrayList ningthItem=new ArrayList();

ningthItem.add("List");  				//Type of item
ningthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  				// label
ningthItem.add("eff_status");   		//name of field
ningthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.

finAr.add(ningthItem); 				//add to ArrayList obj finAr


String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FileTypeCode.label","mp_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FileTypeDescription.label","common_labels");

orderByColVals[0] = "file_type_code";
orderByColVals[1] = "facility_id";
orderByColVals[2] = "facility_name";
orderByColVals[3] = "long_desc";


strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.filetype.label","common_labels"),"../../eMP/jsp/FileTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
}
catch (Exception e) {
 //out.println("error:" + e);
 e.printStackTrace(); // Added by lakshmanan for security issue ID 174245130 on 16-08-2023
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
