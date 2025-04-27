<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));     // label
firstItem.add("note_type");   //name of field
firstItem.add("4"); // SIZE
firstItem.add("4"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));    // label
secondItem.add("note_type_desc");  //name of field
secondItem.add("20");   // SIZE
secondItem.add("20");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
if(license_rights.equals("FULL") || license_rights.equals("BASIC"))
{
thirdItem.add("List");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Class.label","common_labels"));  // label
thirdItem.add("event_class");//name
thirdItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",PHY$,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",NUR$,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nursing.label","common_labels")+",CLI$,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Clinician.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(thirdItem); //add to ArrayList obj finAr
}
//ArrayList fourthItem = new ArrayList();


ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fourthItem.add("eff_status");//name
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");           //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoteGroup.label","ca_labels"));     // label
fifthItem.add("note_group");   //name of field
fifthItem.add("select NOTE_GROUP,NOTE_GROUP_DESC from ca_note_group where EFF_STATUS = 'E' order by 2"); // SIZE
finAr.add(fifthItem);//add to ArrayList obj finAr

ArrayList sixthIem = new ArrayList();

sixthIem.add("List");          //Type of item
sixthIem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Applicability.label","common_labels"));    // label
sixthIem.add("applicability");  //name of field
sixthIem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",INPATIENT_YN,IP,OUTPATIENT_YN,OP,DAYCARE_YN,DC,EMERGENCY_YN,EM,PATIENT_SPECIFIC_YN,XT");   
//sixthIem.add("A,--All--,I,IP,O,OP,D,DC,E,EM,X,XT");   

finAr.add(sixthIem);    //add to ArrayList obj finAr

ArrayList senventhhIem = new ArrayList();

senventhhIem.add("List");   //Type of item
senventhhIem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ServiceFacilitySpecific.label","ca_labels"));  // label
senventhhIem.add("serv_facility");//name
senventhhIem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");   
finAr.add(senventhhIem); //add to ArrayList obj finAr

ArrayList eigthIem = new ArrayList();

eigthIem.add("List");   //Type of item
eigthIem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DocumentLinkedNote.label","ca_labels"));  // label
eigthIem.add("doc_link_note");//name
eigthIem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(eigthIem); //add to ArrayList obj finAr

ArrayList ninthIem = new ArrayList();

ninthIem.add("List");   //Type of item
ninthIem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AmendmentType.label","ca_labels"));  // label
ninthIem.add("amnd_type");//name
ninthIem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CreateNewAddendum.label","ca_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AmendOriginalSection.label","ca_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NotAllowed.label","ca_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(ninthIem); //add to ArrayList obj finAr

ArrayList tenthIem = new ArrayList();

tenthIem.add("List");   //Type of item
tenthIem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Confidential.label","common_labels"));  // label
tenthIem.add("confidential_yn");//name
tenthIem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(tenthIem); //add to ArrayList obj finAr

String[] orderByCols = null;
String[] orderByColVals = null;

if(license_rights.equals("FULL") || license_rights.equals("BASIC"))
{
	orderByCols = new String[3];
	orderByColVals = new String[3];



	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels") ;
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Class.label","common_labels");

	orderByColVals[0] = "note_type";
	orderByColVals[1] = "note_type_desc";
	orderByColVals[2] = "event_class";
}
else if(license_rights.equals("MINI"))
{
	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels") ;
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	//orderByCols[2] = "Class";

	orderByColVals[0] = "note_type";
	orderByColVals[1] = "note_type_desc";
	//orderByColVals[2] = "event_class";

}

strbuff = qrypg.getQueryPage(con,finAr,"Find Clinic","../../eCA/jsp/NoteTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
finAr.clear();
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fifthItem.clear();
fourthItem.clear();
sixthIem.clear();
senventhhIem.clear();
eigthIem.clear();
ninthIem.clear();
tenthIem.clear();


} catch (Exception e) {
	//out.println("Exception "+e.toString());//COMMON-ICN-0181
   e.printStackTrace();//COMMON-ICN-0181
}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

