<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
	<%
		request.setCharacterEncoding("UTF-8");	
		String sStyle = 	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
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

firstItem.add("Text");           //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RelationshipID.label","ca_labels"));     // label
firstItem.add("pract_reln_id");   //name of field
firstItem.add("20"); // SIZE
firstItem.add("20"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr
//firstItem.clear();

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RelationshipName.label","ca_labels"));    // label
secondItem.add("pract_reln_name");  //name of field
secondItem.add("60");   // SIZE
secondItem.add("60");   //LENGTH
finAr.add(secondItem); 
//secondItem.clear();//add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("List");           // Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.IPEnc.label","ca_labels"));			  // label
thirdItem.add("ip_attend_phys_yn");	  // name of field
thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(thirdItem);
//thirdItem.clear();

ArrayList fourthItem = new ArrayList();

fourthItem.add("List");           // Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.IPAdmit.label","ca_labels"));			  // label
fourthItem.add("ip_admit_phys_yn");	  // name of field
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(fourthItem);
//fourthItem.clear();

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");           // Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.OPVisit.label","ca_labels"));			  // label
fifthItem.add("op_attend_phys_yn");	  // name of field
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(fifthItem);
//fifthItem.clear();

ArrayList sixthItem = new ArrayList();

sixthItem.add("List");           // Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AccidentEmergency.label","ca_labels"));			  // label
sixthItem.add("ae_attend_phys_yn");	  // name of field
sixthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(sixthItem);
//sixthItem.clear();

ArrayList seventhItem = new ArrayList();

seventhItem.add("List");           // Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels"));					  // label
seventhItem.add("dc_attend_phys_yn");	  // name of field
seventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(seventhItem);
//seventhItem.clear();

ArrayList eigthItem = new ArrayList();

eigthItem.add("List");           // Type of item
eigthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReferralReln.label","ca_labels"));	  // label
eigthItem.add("referal_reln_yn");	  // name of field
eigthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");
//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(eigthItem);
//eigthItem.clear();

ArrayList ninthItem = new ArrayList();

ninthItem.add("List");           // Type of item
ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NurseRelation.label","ca_labels"));			  // label
ninthItem.add("attend_nurse_reln_yn");	  // name of field
ninthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(ninthItem);
//ninthItem.clear();


ArrayList tenthItem = new ArrayList();

tenthItem.add("List");           // Type of item
tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Default.label","common_labels")+ " " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.IPEnc.label","ca_labels"));			  // label
tenthItem.add("dflt_ip_attend_phys_yn");	  // name of field
tenthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(tenthItem);
//thirdItem.clear();

ArrayList eleventhItem = new ArrayList();

eleventhItem.add("List");           // Type of item
eleventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Default.label","common_labels")+ " " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.IPAdmit.label","ca_labels"));			  // label
eleventhItem.add("dflt_ip_admit_phys_yn");	  // name of field
eleventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(eleventhItem);
//fourthItem.clear();

ArrayList twelvethItem = new ArrayList();

twelvethItem.add("List");           // Type of item
twelvethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Default.label","common_labels")+ " " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.OPVisit.label","ca_labels"));			  // label
twelvethItem.add("dflt_op_attend_phys_yn");	  // name of field
twelvethItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(twelvethItem);
//fifthItem.clear();

ArrayList thirteenthItem = new ArrayList();

thirteenthItem.add("List");           // Type of item
thirteenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Default.label","common_labels")+ " " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AccidentEmergency.label","ca_labels"));		  // label
thirteenthItem.add("dflt_ae_attend_phys_yn");	  // name of field
thirteenthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(thirteenthItem);
//sixthItem.clear();

ArrayList fourteenthItem = new ArrayList();

fourteenthItem.add("List");           // Type of item
fourteenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Default.label","common_labels")+ " " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels"));		  // label
fourteenthItem.add("dflt_dc_attend_phys_yn");	  // name of field
fourteenthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(fourteenthItem);
//seventhItem.clear();

ArrayList fifteenthItem = new ArrayList();

fifteenthItem.add("List");           // Type of item
fifteenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Default.label","common_labels")+ " " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReferralReln.label","ca_labels"));			  // label
fifteenthItem.add("dflt_referal_reln_yn");	  // name of field
fifteenthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(fifteenthItem);
//eigthItem.clear();

ArrayList sixteenthItem = new ArrayList();

sixteenthItem.add("List");           // Type of item
sixteenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Default.label","common_labels")+ " " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NurseRelation.label","ca_labels"));			  // label
sixteenthItem.add("dflt_attend_nurse_reln_yn");	  // name of field
sixteenthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.finAr.add(fourthItem);            // add to ArrayList obj finAr
finAr.add(sixteenthItem);

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RelationshipName.label","ca_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RelationshipID.label","ca_labels");


orderByColVals[0] = "pract_reln_name";
orderByColVals[1] = "pract_reln_id";

strbuff = qrypg.getQueryPage(con,finAr,"Find Clinic","../../eCA/jsp/QueryResultPractRelation.jsp?mode=modify",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

finAr.clear();
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
fifthItem.clear();
sixthItem.clear();
seventhItem.clear();
eigthItem.clear();
ninthItem.clear();
tenthItem.clear();
eleventhItem.clear();
twelvethItem.clear();
thirteenthItem.clear();
fourteenthItem.clear();
fifteenthItem.clear();
sixteenthItem.clear();

out.println(strbuff.toString());
} catch (Exception e) {
	out.println("Exception "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}


%>


