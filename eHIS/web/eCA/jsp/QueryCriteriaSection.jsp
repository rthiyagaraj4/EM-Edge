<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
String license_rights = "";
if( (eCA._ca_license_rights.getKey()).equals("CACLDC") )
{
	license_rights= "FULL";
}
else if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
{
	license_rights= "BASIC";
}
else if((eCA._ca_license_rights.getKey()).equals("CAMINI"))
{
	license_rights= "MINI";
}
Connection con=null ;

try {

   con  =  ConnectionManager.getConnection(request);


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");           //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels"));     // label
firstItem.add("sec_hdg_code");   //name of field
firstItem.add("4"); // SIZE
firstItem.add("4"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionDescription.label","common_labels"));    // label
secondItem.add("sec_hdg_desc");  //name of field
secondItem.add("20");   // SIZE
secondItem.add("20");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();
if(license_rights.equals("FULL") || license_rights.equals("BASIC"))
{
sixthItem.add("Text");          //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TITLE.label","common_labels"));    // label
sixthItem.add("sec_hdr_meta_desc");  //name of field
sixthItem.add("20");   // SIZE
sixthItem.add("30");   //LENGTH
finAr.add(sixthItem);    //add to ArrayList obj finAr
}
else if(license_rights.equals("MINI")) //putting a hidden field without any value
{
sixthItem.add("Hidden");          //Type of item
//sixthItem.add("Meta Section Desc");    // label
sixthItem.add("sec_hdr_meta_desc");  //name of field
sixthItem.add("");   // Value
//sixthItem.add("30");   
finAr.add(sixthItem);    //add to ArrayList obj finAr

}

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels"));  // label
thirdItem.add("content_type");//name
if(license_rights.equals("FULL") || license_rights.equals("BASIC"))
{
	thirdItem.add("'',--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------,F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FreeFormat.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Resultlinked.label","ca_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MainSection.label","ca_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TemplateBased.label","ca_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
}
else if(license_rights.equals("MINI"))
{
	thirdItem.add("'',--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------,F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FreeFormat.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MainSection.label","ca_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
}

finAr.add(thirdItem); //add to ArrayList obj finAr
/********* For *************/
ArrayList seventh = new ArrayList();

seventh.add("List");   //Type of item
seventh.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TemplateType.label","ca_labels"));  // label
seventh.add("template_type");//name
seventh.add("'',--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------,H,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoteHeader.label","ca_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoteFooter.label","ca_labels")+",B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoteBody.label","ca_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReportHeader.label","ca_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.

finAr.add(seventh); //add to ArrayList obj finAr
/**********************/
ArrayList fourthItem = new ArrayList();

if(license_rights.equals("FULL") || license_rights.equals("BASIC"))
{
fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ResultCategory.label","ca_labels"));  // label
fourthItem.add("result_linked_rec_type");//name
fourthItem.add("select hist_rec_type, short_desc from cr_hist_rec_Type order by 2");
//fourthItem.add("'',------------------Select------------------,LBIN,Laboratory Investigations,BLTF,Blood Transfusions,RDIN,Radiology Investigations,MEDN,Medication,SUNT,Theater/Surgical,DIET,Dietery,TRET,Treatments,CLNT,Clinical Notes,PTCR,Patient Care");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem); //add to ArrayList obj finAr
}
else if(license_rights.equals("MINI")) //putting a hidden field without any value
{
fourthItem.add("Hidden");   //Type of item
fourthItem.add("result_linked_rec_type");//name
fourthItem.add(""); //value
finAr.add(fourthItem); //add to ArrayList obj finAr

}
ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fifthItem.add("eff_status");//name
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fifthItem); //add to ArrayList obj finAr

//ArrayList seventhItem = new ArrayList();
//seventhItem.add("List");
//seventhItem.add("Image Linked");  // label
//seventhItem.add("image_linked_yn");  // name
//seventhItem.add("B,Both,Y,Linked,N,Not Linked");//static values that need to be displayed as option.Send it along with the value that is inserted.
//finAr.add(seventhItem); //add to ArrayList obj finAr


String[] orderByCols=null;
String[] orderByColVals=null;
if(license_rights.equals("FULL") || license_rights.equals("BASIC"))
{
	orderByCols = new String[5];
	orderByColVals = new String[5];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionDescription.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TemplateType.label","ca_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ResultCategory.label","ca_labels");
	//orderByCols[4] = "Meta Section Desc";

	orderByColVals[0] = "sec_hdg_code";
	orderByColVals[1] = "sec_hdg_desc";
	orderByColVals[2] = "content_type";
	orderByColVals[3] = "template_type";
	orderByColVals[4] = "result_linked_rec_type";
	//orderByColVals[4] = "sec_hdr_meta_desc";

}
else if(license_rights.equals("MINI"))
{
	orderByCols = new String[4];
	orderByColVals = new String[4];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionDescription.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TemplateType.label","ca_labels");
	//orderByCols[3] = "Result Category";
	//orderByCols[4] = "Meta Section Desc";

	orderByColVals[0] = "sec_hdg_code";
	orderByColVals[1] = "sec_hdg_desc";
	orderByColVals[2] = "content_type";
	orderByColVals[3] = "template_type";
	//orderByColVals[3] = "result_linked_rec_type";
	//orderByColVals[4] = "sec_hdr_meta_desc";


}
strbuff = qrypg.getQueryPage( con,finAr,"Find Clinic","../../eCA/jsp/QueryResultSection.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
//../../eCA/jsp/QueryResultSection.jsp
out.println(strbuff.toString());
finAr.clear();
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
fifthItem.clear();
sixthItem.clear();
seventh.clear();

} catch (Exception e) {
//out.println("Exception "+e.toString());//COMMON-ICN-0181
e.printStackTrace();//COMMON-ICN-0181
}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

