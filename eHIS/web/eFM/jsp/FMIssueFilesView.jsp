<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" 
import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.Common.*,eFM.*,java.text.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
 
%>


<jsp:useBean id="FMIssueFilesCart" scope="session" class="webbeans.eFM.FMFilesIssueCart"/>
	<jsp:useBean id="FMIssueFileAddBean" scope="session" class="eFM.FMIssueFileAddBean"/>


<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->

	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMIssueFiles.js'></script>
	<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script><!-- Supporting Js File For Fixed Header with scroll.... -->
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 

</head>
<SCRIPT>
IssueTabSel='Y';
<!-- Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 25th 2014 Start -->
window.onload=function(){

	if(document.getElementById("ViewTabledata")!=null && document.forms[0].fileCount.value > 0){	
		fxheaderInit('ViewTabledata',420);
	}
};
<!-- Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 25th 2014 End -->


function ValidateDateTime(from,sys_date) {
	var originalObj = from ;
	var obj=from;
	if(from.value!="") {
	  var obj=convertDate(from.value,"DMYHM",localeName,"en");
		if(doDateTimeChk(obj)) {
			//from = from.value
			from = obj;
			sys_date =	sys_date.value;
			
			var a=  from.split(" ");
			splitdate=a[0];
			splittime=a[1];

			var splitdate1 =a[0].split("/");
			var splittime1= a[1].split(":");

			var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
				
			a= sys_date.split(" ");
			splitdate=a[0];
			splittime=a[1];

			splitdate1 =a[0].split("/");
			splittime1= a[1].split(":");

			var sys_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));
			
			if(Date.parse(from_date) >= Date.parse(sys_date)) {
				var msg = "";
				parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				return true;
			} else {
				var msg = getMessage('RETURN_DATE_NOT_LESS_SYSDATE','FM');
				alert(msg);
				originalObj.value="";
				originalObj.focus();
				originalObj.select();
				return false;
			}
		} else if(doDateTimeChk(from)== false) {
		alert(getMessage("INVALID_DATE_TIME","SM"));
			originalObj.value="";
			originalObj.focus();
			originalObj.select();
			return false;	
		}
	}
}



</SCRIPT>
<%
	Connection conn				= null;
	PreparedStatement pstmt		= null;
	ResultSet rset				= null;
	java.sql.Statement stmt     = null;
	ResultSet rs				= null;
	String classValue			= "";
	String otherValue			= "";
	String sql					= "";
	String daystoreturn			= "";
	String reqlocndesc			= "";	
	String p_locncode			= "";	
	//String sys_date_query		= "";
	String sys_date				= "";
	String return_criteria		= "";
	String returndays			= "";
	String userSecurity			= request.getParameter("userSecurity");
	String resLocnIdentities	= request.getParameter("resLocnIdentities");
	String refresh 				= request.getParameter("refresh ");
	String strLocn				= request.getParameter("strLocn");
	String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");
//	String file_doc				= request.getParameter("file_doc");	
	String file_type_yn			= request.getParameter("file_type_yn")==null?"N":request.getParameter("file_type_yn");
	String file_type_appl_yn	= request.getParameter("file_type_yn");
	//Added for this CRF HSA-CRF-0306.1
	boolean isCurrentFsLocation=false;	
		
	String dischargedatetime=""; //Added CRF HSA-CRF-0306.1
	
	Properties p=(java.util.Properties) session.getValue("jdbc"); 
	java.sql.Statement stmt1	= null;
	ResultSet rset1				= null;
	
	try
	{
		
		conn	= ConnectionManager.getConnection(request);
        
        isCurrentFsLocation = CommonBean.isSiteSpecific(conn,"FM","CURRENT_FS_LOCATION");//Added for this CRF HSA-CRF-0306	
       

		if((file_type_appl_yn==null) || (file_type_appl_yn.equals("null"))) file_type_appl_yn = "N";

	/*	sys_date_query = "select to_char(sysdate,'dd/mm/yyyy hh24:mi')from dual";
		stmt = conn.createStatement();
		rs   = stmt.executeQuery(sys_date_query);
		if(rs !=null && rs.next())
		{
			sys_date = rs.getString(1);
		} if(rs !=null) rs.close();  ) */
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='IssueFileView_form' id='IssueFileView_form'>
	<Script>
	function tab_click1(id) 
	{
		selectTab(id);
		objClick(id);
	}

function objClick(objName) {
	if(objName == 'page_one_tab') { 
		//parent.parent.parent.frames[2].IssueFileFrameSet.rows='6%,4%,33%,*,9%';
		parent.parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height = '6vh';
		parent.parent.parent.frames[2].document.getElementById("issue_header").style.height = '4vh';
		parent.parent.parent.frames[2].document.getElementById("issue_tab").style.height = '81vh';
		parent.parent.parent.frames[2].document.getElementById("issue_detail").style.height = '0vh';
		parent.parent.parent.frames[2].document.getElementById("messageFrame").style.height = '9vh';
		parent.parent.frames[2].location.href = '../../eFM/jsp/FMIssueFilesTab.jsp?userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&refresh=<%=refresh%>&access_all=<%=access_all%>&file_type_yn=<%=file_type_yn%>';
		parent.parent.issue_detail.location.href = "../../eCommon/html/blank.html";
		parent.parent.frames[1].document.forms[0].selected_tab.value='page_one_tab';
	} else if(objName == 'page_two_tab') {
			//parent.parent.parent.frames[2].IssueFileFrameSet.rows='6%,4%,*,0%,9%';
					parent.parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height = '6vh';
					parent.parent.parent.frames[2].document.getElementById("issue_header").style.height = '4vh';
					parent.parent.parent.frames[2].document.getElementById("issue_tab").style.height = '81vh';
					parent.parent.parent.frames[2].document.getElementById("issue_detail").style.height = '0vh';
					parent.parent.parent.frames[2].document.getElementById("messageFrame").style.height = '9vh';
			parent.parent.frames[2].location.href = '../../eFM/jsp/FMIssueFileManualEntry.jsp?userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&refresh=<%=refresh%>&access_all=<%=access_all%>&file_type_yn=<%=file_type_yn%>';
			parent.parent.frames[1].document.forms[0].selected_tab.value='page_two_tab';

			
	} else if(objName == 'page_three_tab') {
		parent.parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height = '6vh';
		parent.parent.parent.frames[2].document.getElementById("issue_header").style.height = '4vh';
		parent.parent.parent.frames[2].document.getElementById("issue_tab").style.height = '81vh';
		parent.parent.parent.frames[2].document.getElementById("issue_detail").style.height = '0vh';
		parent.parent.parent.frames[2].document.getElementById("messageFrame").style.height = '9vh';
	// Changes Modified By Saanthaakumar
			//parent.parent.parent.frames[2].IssueFileFrameSet.rows='6%,4%,10%,*,9%';
			parent.parent.frames[2].location.href = '../../eFM/jsp/FMIssueFilesViewMain.jsp?file_type_yn=<%=file_type_yn%>&userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&refresh=<%=refresh%>&access_all=<%=access_all%>';
			parent.parent.frames[1].document.forms[0].selected_tab.value='page_three_tab';
	}
	}	
</Script>
<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
		<tr>
		<td width= "85%" class="white">
		<ul id="tablist" class="tablist" style="width: 1330px; padding-left: 5px;">
			<li class="tablistitem" title="Outstanding Request">
				<a onclick="tab_click1('page_one_tab')" class="tabA" id="page_one_tab" >
					<span class="tabAspan" id="page_one_tabspan"><fmt:message key="eFM.OutstandingRequest.label" bundle="${fm_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Manual Request">
				<a onclick="tab_click1('page_two_tab')" class="tabA" id="page_two_tab" >
					<span class="tabAspan" id="page_two_tabspan"><fmt:message key="eFM.ManualRequest.label" bundle="${fm_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title="Issue File">
				<a onclick="tab_click1('page_three_tab')" class="tabClicked" id="page_three_tab" >
					<span class="tabSpanclicked" id="page_three_tabspan"><fmt:message key="eFM.IssueFile.label" bundle="${fm_labels}"/></span>
				</a>
			</li>	
		</ul>
		<td width="10%" class='button' id="tab1">	<input type='button' class='button' name='add' id='add' value='<fmt:message key="Common.ModeOfTransport.label" bundle="${common_labels}"/>' 			onClick="javascript:GetRemarks(); "><input type="hidden" name="file_transport_mode" id="file_transport_mode" value=""><input type="hidden" name="carried_by_name" id="carried_by_name" value="">
	 </td>
	 </tr>
	 </table>
	<!-- The below line is required to change the select state of 'Outstanding Request' tab initially selected -->
	<script>prevTabObj='page_three_tab'</script>
	<table border="1" width="100%" style='border-spacing:0px ;border-collapse: collapse;' id='ViewTabledata'>
 	<td class='COLUMNHEADER' width='14%'><fmt:message key="Common.requesteddate.label" bundle="${common_labels}"/></td> 	
	<% if (file_type_appl_yn.equals("N")) { %>
		<td class='COLUMNHEADER'><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></td>	
		<td class='COLUMNHEADER' width="5%"><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>	
	<% } else if (file_type_appl_yn.equals("Y")) { %>
		<td class='COLUMNHEADER'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>	
		<td class='COLUMNHEADER' width="5%"><fmt:message key="eFM.FileTypeVolumeNo.label" bundle="${fm_labels}"/></td>	
	<% } %>
	<td class='COLUMNHEADER'><fmt:message key="Common.RequestNo.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><!--Modified for this CRF HSA-CRF-0306<%if(isCurrentFsLocation){%><fmt:message key="eFM.ReturnDueDateTime.label" bundle="${fm_labels}"/><%}else{%><fmt:message key="eFM.ReturnDate.label" bundle="${fm_labels}"/><%}%>--> <!--Modified by Ashwini on 18-Jul-2017 for ML-MMOH-SCF-0763--><fmt:message key="eFM.ReturnDueDateTime.label" bundle="${fm_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.TransportMode.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.Issue.label" bundle="${common_labels}"/>?</td>
<%
	sortFMFilesIssueCart(FMIssueFilesCart);
	ArrayList ArrFileCart	= (ArrayList) FMIssueFilesCart.getPresCart();
	int countRec			= ArrFileCart.size();

	if(countRec > 0)
	{
		out.println("<script>if (parent.parent.parent.frames[2].document.getElementById('tab1')) { parent.parent.parent.frames[2].document.getElementById('tab1').style.visibility='visible'; parent.parent.parent.frames[2].document.getElementById('tab1').style.display='inline'; }</script>");
	}
	
	int ind = 0;
	
	for(ind=0;ind < ArrFileCart.size();ind++)
	{
		if( ind % 2 == 0) classValue = "QRYEVEN" ;
		else classValue = "QRYODD" ;
		
		webbeans.eFM.FMFilesIssueDetail fissuebean = new webbeans.eFM.FMFilesIssueDetail();
		fissuebean = FMIssueFilesCart.getIssuesfromCart(ind);	
		//String issue_remarks			= request.getParameter("rem_recnum_"+ind);
		
		
//		String indval			= fissuebean.getIndex_Value();
		String fileno			= fissuebean.getFile_No();
		String pline			= fissuebean.getPatient_Line();
		pline=java.net.URLDecoder.decode(pline,"UTF-8");
		String Patient_Id		= fissuebean.getPatient_Id();
		String reqno			= fissuebean.getReq_No();
		String file_type		= fissuebean.getFile_Type();
		String volume_no		= fissuebean.getVolume_No();
		String reqby			= fissuebean.getRec_Name_Desc();
		String locncode			= fissuebean.getRec_Locn_Code();
		String locn_identity	= fissuebean.getRec_Locn_Identity();
		String fac_id			= fissuebean.getReq_Facility_Id();
//		String from				= fissuebean.getRequest_From();
		String reqfrom			= fissuebean.getRequest_From();
		String  Reqlocnid     =fissuebean.getRequesting_From(); 
		
		
		
		
		/*Below line added for the incident [46675]*/
		String reqdatetime		= fissuebean.getRequest_Date_Time();				
		if(reqdatetime==null) reqdatetime="";
		if(!reqdatetime.equals(""))  reqdatetime=DateUtils.convertDate(reqdatetime,"DMYHM","en",localeName);
		//End incident [46675]
		
		String mlc_check		= fissuebean.getMLC_Check();
		String file_type_desc	= fissuebean.getFile_Typedesc();
		if((file_type == null) || (file_type.equals("")))  file_type = "";
		if (volume_no == null)  volume_no = "&nbsp;";
		String number			= "";
		String duration_type	= "";
		String fslocn_return_criteria="",permanent_file_area_yn="",fslocn_identity="";//Added for this CRF HSA-CRF-0306.1
		

		int hrs = 0;	
    /*below line modified for this incident  [IN:058795]*/      		
	//if(locn_identity.equals("C") || locn_identity.equals("N")|| locn_identity.equals("E") ||  locn_identity.equals("D") || locn_identity.equals("Y")){
	if(locn_identity.equals("C") || locn_identity.equals("N")|| locn_identity.equals("E") ||  locn_identity.equals("D") || locn_identity.equals("Y") || locn_identity.equals("T")){ // Modified By Dharma on Aug 3rd 2016 agianst ML-MMOH-SCF-0466 [IN:061037]
		
		sql="SELECT (CASE  WHEN locn_identity IN 'C' and exists (SELECT 1 FROM op_clinic             WHERE clinic_type = 'C' AND level_of_care_ind = 'E'   AND clinic_code = ? AND mr_location_code = ? ) THEN  no_of_dh_to_return_em     ELSE (CASE                  WHEN locn_identity IN ('C', 'E') THEN no_of_dh_to_return_op   ELSE (CASE                            WHEN locn_identity = 'N' THEN no_of_dh_to_return_ip    ELSE (CASE                                      WHEN locn_identity = 'Y' THEN no_of_dh_to_return_dc   END)  END)                  END) END) no_of_dh_to_return,duration_type,return_criteria,permanent_file_area_yn,locn_identity FROM fm_storage_locn WHERE fs_locn_code = ? AND facility_id = ? " ;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,Reqlocnid);
			pstmt.setString(2,locncode);
			pstmt.setString(3,locncode);
			pstmt.setString(4,fac_id);
			rset = pstmt.executeQuery();
			while(rset != null && rset.next())
			{
				number			= rset.getString(1);
				duration_type	= rset.getString(2);
				fslocn_return_criteria= rset.getString(3); //Added for this CRF HSA-CRF-0306.1
				permanent_file_area_yn= rset.getString(4);	
			    fslocn_identity= rset.getString(5);
			}
			
			if(rset  !=null) rset.close();
			if(pstmt !=null) pstmt.close();

			if(number==null || number.equals("")) number = "0";
			if(duration_type == null || duration_type.equals("null"))	  duration_type = "";
			
			//Added for this CRF HSA-CRF-0306.1
			if(fslocn_return_criteria == null || fslocn_return_criteria.equals("null")) fslocn_return_criteria = ""; 
			if(fslocn_return_criteria.equals("")) fslocn_return_criteria="I";
			
        if(duration_type.equals("D")) hrs = Integer.parseInt(number)*24;
			else if(duration_type.equals("H")) hrs = Integer.parseInt(number);
			
		}

		//sql = "Select to_char(SYSDATE+"+(hrs)+"/24,'DD/MM/YYYY HH24:MI') RET, SHORT_DESC,RETURN_CRITERIA from FM_STORAGE_LOCN Where FACILITY_ID = ? and FS_LOCN_CODE = ? ";
		sql = "SELECT To_char(SYSDATE + "+(hrs)+" / 24,'DD/MM/YYYY HH24:MI') RET, SHORT_DESC, RETURN_CRITERIA,to_char(sysdate,'dd/mm/yyyy hh24:mi') sydat FROM   FM_STORAGE_LOCN_LANG_VW WHERE  FACILITY_ID = ? AND FS_LOCN_CODE = ? AND LANGUAGE_ID=? ";
 	   
	   pstmt = conn.prepareStatement(sql);
	   
		pstmt.setString(1,fac_id);
		pstmt.setString(2,locncode);
		pstmt.setString(3,localeName);
		rset = pstmt.executeQuery();

		if(rset != null && rset.next())
		{
			returndays		= rset.getString(1);
			reqlocndesc		= rset.getString(2);
			return_criteria = rset.getString(3);
		   sys_date     = rset.getString(4);
		}
		
		if(rset  !=null) rset.close();
		if(pstmt !=null) pstmt.close();		

     if(return_criteria == null || return_criteria.equals("null")) return_criteria = "";
	  if(hrs<=0 || return_criteria.equals("D"))
		{
     returndays =null;
		}
		if((file_type_desc==null) || (file_type_desc.equals(""))) file_type_desc = "&nbsp;";
		//else file_type_desc =file_type_desc + " / " ;
        else file_type_desc =file_type_desc;
		if(returndays != null )
		{
		returndays=DateUtils.convertDate(returndays,"DMYHM","en",localeName);
		}else
			returndays = "";

		
		
		if(return_criteria.equals("I") || locn_identity.equals("D")|| locn_identity.equals("C")|| 
		locn_identity.equals("N"))
		{
			daystoreturn = returndays;
			}
		else
		{
			daystoreturn = "";
		 }

		if(reqno.equals("")) reqno = "&nbsp;";
		if(reqfrom.equals("S") || reqfrom.equals("MS")) otherValue = "lightgreen";  //"CCEEDD";
		else if(reqfrom.equals("D") || reqfrom.equals("MD")) otherValue = "lightpink";	//"FFEECC";
		
		
		//Added for this CRF HSA-CRF-0306.1	
				
		String returndate="";
        int hours=0;
        boolean comparecurrDate=true;		
	   
	  //if(isCurrentFsLocation&&(!dischargedatetime.equals("")&&fslocn_return_criteria.equals("D"))|| fslocn_return_criteria.equals("I")){
	   if(isCurrentFsLocation){	   
	   
	   int recorCount=0;	   
	   //Added for this CRF HSA-CRF-0306.1	
		 ArrayList List=(ArrayList)FMCurrentEncounterDetails.getFileCurrentEncounterDetails(conn,Patient_Id,Reqlocnid,locn_identity,fac_id,p);
		 recorCount=List.size();  
		 for(int k=0; k<List.size(); k++){
			   FMCurrentEncounterDetailsBean currencounterDetails=(FMCurrentEncounterDetailsBean)List.get(k);            
			   dischargedatetime=currencounterDetails.getDischargedatetime();		
			   if((dischargedatetime==null) || (dischargedatetime.equals("null")))	dischargedatetime = "";
		 }	
		//End HSA-CRF-0306.1	   
	   
	   
	   //Added HSA-CRF-0306.1
	   
	  String assigncare_locn="";
	   if(!locn_identity.equals("") && locn_identity.equals("Y")){
	   try{
	     assigncare_locn=FMCurrentEncounterDetails.getCurrentAssignCareLocation(conn,Patient_Id,Reqlocnid,fac_id,p);
		 Reqlocnid=assigncare_locn;
	    }catch(Exception e){
	      e.printStackTrace() ;
	    }
	   }
	   
		//End HSA-CRF-0306.1
		
		hours = Integer.parseInt(number);			
		/*String returndateSqlQuery="select FM_GET_RETURN_DATE("+hours+",'"+fac_id+"','"+PatientClass+"','"+Assigncarecode+"','"+fileno+"',"+volume_no+",'"+Patient_Id+"','"+strLocn+"','"+fslocn_return_criteria+"','"+duration_type+"','FI') returndate from dual";*/
		
		String returndateSqlQuery="select FM_GET_RETURN_DATE("+hours+",'"+fac_id+"','"+Reqlocnid+"','"+fileno+"',"+volume_no+",'"+Patient_Id+"','"+strLocn+"','"+fslocn_return_criteria+"','"+duration_type+"','FI') returndate from dual";
		
                  
		 
		 stmt1 = conn.createStatement();
		 rset1 = stmt1.executeQuery(returndateSqlQuery);
    	 if(rset1 != null && (rset1.next())){
		      // returndate =rset1.getString("returndate");
             returndate =rset1.getString("returndate")==null?"":rset1.getString("returndate");          
		 }	
         		 
		
	  
 if(returndate == null || returndate.equals("null"))	returndate="";
 
	if(!returndate.equals("") && returndate!=null && !returndate.equals("null")){	
	    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
     	    java.util.Date retd1 = null;
		    java.util.Date sysd2 = null;		
			retd1 = format.parse(returndate);
			sysd2 = format.parse(sys_date);
			 if(retd1.compareTo(sysd2)<0){
			 comparecurrDate=false;	             		 
			 }	  
		} 
		 
		   if(rset1!=null)	rset1.close();
		   if(stmt1!=null) stmt1.close();	   
		   if(returndate==null) returndate="";
		   if(!returndate.equals("") || returndate!=null){
				  returndate=DateUtils.convertDate(returndate,"DMYHM","en",localeName);
			}
			           
		  			
	  }	 
	   //End HSA-CRF-0306.1
		
		

        if(ind == 0)
        {
			p_locncode = locncode;
			%>
	        <tr>
		        <td  width="90%" height="20" colspan=8  class='CAGROUPHEADING' ><b><%=reqlocndesc%></b></td>
			</tr>
			<%
        }
		else if (!p_locncode.equals(locncode))
        {
			p_locncode = locncode;
			%>
	        <tr>
		        <td  width="90%" height="20" colspan=8 class='CAGROUPHEADING' ><b><%=reqlocndesc%></b></td>
			</tr>
			<%
		}
		out.println("<tr><td class='"+classValue+"' nowrap><font size='1'>");
		out.println(reqdatetime);
		if(file_type_appl_yn.equals("Y"))
		{
			out.println("</font></td><td class='"+classValue+"'><font size='1'><b>");
			out.println("</b><br>&nbsp;&nbsp;"+pline);
			out.println("</font></td><td class='"+classValue+"' align='CENTER'><font size='1'>");
			out.println(file_type_desc+volume_no);
		}
		else if (file_type_appl_yn.equals("N"))
		{

			out.println("</font></td><td class='"+classValue+"'><font size='1'><b>");
			out.println(fileno+"</b><br>&nbsp;&nbsp;"+pline);
			out.println("</font></td><td class='"+classValue+"' align='CENTER'><font size='1'>");
			out.println(volume_no);
		}
		out.println("</font></td><td class='"+classValue+"'><font size='1'>");
		out.println(reqno);
		out.println("</font></td><td class='"+classValue+"'><font size='1'>");
		out.println(reqby);
		out.println("</font></td>");
		%>
		<td class='"+classValue+"' >
		<input type='text' name='retdate<%=ind %>' id='retdate<%=ind %>' id='datetd<%=ind %>' size='16' maxlength='16' tabIndex='3' value='' onBlur="ValidateDateTime(this,sys_date);<%if(isCurrentFsLocation){%>holiday('<%=fac_id%>','<%=fileno%>','<%=volume_no%>','<%=Patient_Id%>','<%=strLocn%>','<%=ind%>');<%}%>"><img name='im<%=ind %>' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('retdate<%=ind %>', null, 'hh:mm');" onMouseover="changeCursor(this)"></img>
		</td>
		<%		
		if(locn_identity.equals("C") || locn_identity.equals("N") || locn_identity.equals("D") || locn_identity.equals("E") || locn_identity.equals("Y"))
		{      /*Above line modified for this CRF HSA-CRF-0306.1*/
			%>	  		
			<SCRIPT>
			    if("<%=isCurrentFsLocation%>"=="true"){ 
				    if("<%=comparecurrDate%>"=="true")document.forms[0].retdate<%=ind %>.value="<%=returndate%>"; 					
				    document.forms[0].retdate<%=ind %>.disabled = false; 
					document.forms[0].im<%=ind %>.disabled    = false ;	
                    					
				}else{				
		    	document.forms[0].retdate<%=ind %>.value    = "<%=daystoreturn%>"; 
				if("<%=return_criteria%>"=="I" && "<%=number%>" > 0){
					document.forms[0].retdate<%=ind %>.disabled = true; 
					document.forms[0].im<%=ind %>.disabled      = true; 
				} else{			
					document.forms[0].retdate<%=ind %>.disabled = false; 
					document.forms[0].im<%=ind %>.disabled    = false ;
			   }
			 }
             <!--End Added for this CRF HSA-CRF-0306.1 -->			 
			
			</SCRIPT> 
			<%
		}
		else if(locn_identity.equals("T") || locn_identity.equals("D"))
		{
			%>			
			<SCRIPT>
				if(document.forms[0].retdate<%=ind %>.disabled  == true)
				document.forms[0].retdate<%=ind %>.disabled = false;
				if(document.forms[0].im<%=ind %>.disabled  == true)
					document.forms[0].im<%=ind %>.disabled = false
			    </SCRIPT> 
			   <%
		   }
		  out.println("<td class='"+classValue+"'><font size='1'>");
		 %>
		 <a href='javascript:GetIssueFileViewRemarks(<%=ind %>)'><fmt:message key="Common.ModeOfTransport.label" bundle="${common_labels}"/></a></font></td>
	
		<input type="hidden" name="rem_recnum_<%= ind %>" id="rem_recnum_<%= ind %>" value="">
		<input type="hidden" name="file_transport_mode<%= ind %>" id="file_transport_mode<%= ind %>" value="">
		<input type="hidden" name="carried_by_name<%= ind %>" id="carried_by_name<%= ind %>" value="">
		<input type="hidden" name="ret_date<%= ind %>" id="ret_date<%= ind %>" value="">
		<input type='hidden' name='tab_check' id='tab_check' value='1'>
		<!--Below line added for this CRF HSA-CRF-0306.1 --> 		
		<input type='hidden' name="return_date<%=ind%>" id="return_date<%=ind%>" value="<%=returndate%>">		
		<input type='hidden' name="fslocn_return_criteria<%=ind%>" id="fslocn_return_criteria<%=ind%>" value="<%=fslocn_return_criteria%>"> 
        <input type='hidden' name="dischargedatetime<%=ind%>" id="dischargedatetime<%=ind%>" value="<%=dischargedatetime%>"> 		
		<!--End HSA-CRF-0306.1-->		
		<input type='hidden' name='Patient_Id' id='Patient_Id' value=<%=Patient_Id%>>
		<%
		out.println("</font></td><td style='background-color:"+otherValue+";' align='CENTER'>");
		if(mlc_check.equals("Y"))
		{
			if(reqfrom.equals("MS") || reqfrom.equals("MD"))
				out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'><img src='../../eFM/images/stop.gif' align='center'></img>#");
			else
				out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'>&nbsp;<img src='../../eFM/images/stop.gif' align='center'></img>");
		}
		else
		{
			if(reqfrom.equals("MS") || reqfrom.equals("MD"))
				out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'>&nbsp;#");
			else
				out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'>&nbsp;");
		}
		out.println("</font></td></tr>");
	}
	out.println("<input type='hidden' name='fileCount' id='fileCount' value=\""+ind+"\">");
if(rs    !=null) rs.close();
if(rset  !=null) rset.close();
if(stmt  !=null) stmt.close();
if(pstmt !=null) pstmt.close();
}catch(Exception e){out.println("Exception e :"+e);}
finally
{	
	ConnectionManager.returnConnection(conn,request);
}

%>
	<input type="hidden" name="comm_file_transport_mode" id="comm_file_transport_mode" value="">
	<input type="hidden" name="comm_carried_by_name" id="comm_carried_by_name" value="">
	<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
	<input type='hidden' name='isCurrentFsLocation' id='isCurrentFsLocation' value="<%=isCurrentFsLocation%>"><!--Added for this CRF HSA-CRF-0306.1-->
	<input type='hidden' name="localeName" id="localeName" value="<%=localeName%>">    
	
</form>
</body>
</html>
<%!
	public boolean sortFMFilesIssueCart(webbeans.eFM.FMFilesIssueCart FMIssueFilesCart) throws Exception
	{
		String	Rec_Locn_Code	=	"", next_Rec_Locn_Code		=	"";
		boolean	isSorted		=	true;

		ArrayList ArrFileCart						= (ArrayList) FMIssueFilesCart.getPresCart();
		webbeans.eFM.FMFilesIssueDetail fissuebean	= new webbeans.eFM.FMFilesIssueDetail();
		webbeans.eFM.FMFilesIssueDetail fissuebean2 = new 	
		webbeans.eFM.FMFilesIssueDetail();
		
		try
		{
			for( int i=0; i<ArrFileCart.size(); i++ )
			{
				for(int j=0; j<ArrFileCart.size()-1-i;j++)
				{
					fissuebean	=	FMIssueFilesCart.getIssuesfromCart(j);
					Rec_Locn_Code	=	(String)			
					fissuebean.getRec_Locn_Code();
					fissuebean2	=	FMIssueFilesCart.getIssuesfromCart(j+1);
					next_Rec_Locn_Code	=	(String)				fissuebean2.getRec_Locn_Code();

					if(Rec_Locn_Code.compareToIgnoreCase(next_Rec_Locn_Code)<0)
					{
	    FMIssueFilesCart.updIssuestoCart(fissuebean2.cloneFMFilesIssueDetail(), j);
		FMIssueFilesCart.updIssuestoCart(fissuebean.cloneFMFilesIssueDetail(), j+1);
					}
				}
			}
		}catch(Exception e){isSorted = false;}
		return isSorted;
	}
%>

