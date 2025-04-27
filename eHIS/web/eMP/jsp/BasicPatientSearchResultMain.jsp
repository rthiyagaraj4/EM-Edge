<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*,java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,javax.naming.*,javax.ejb.*,java.rmi.*,javax.rmi.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
 <HTML>
        <head>
            <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
            <Script src="../../eMP/js/PatientSearch.js" language="JavaScript"></Script>
			<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
            <Script language='JavaScript'>
                function checkExpiry(pat_id,jsp_name,flag,func_id, sflag)
                {
					//alert("inside basicpatient 2");
					var sStyle = "<%=sStyle%>";
					 var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'>";
                     HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eMP/jsp/PatSearchCheckAltIDExpiryDate.jsp'>";
                     HTMLVal = HTMLVal +"<input name='pat_id' id='pat_id' type='hidden' value= \""+escape(pat_id) + "\">";
                     HTMLVal = HTMLVal +"<input name='jsp_name' id='jsp_name' type='hidden' value= '"+jsp_name+"'>";
                     HTMLVal = HTMLVal +"<input name='flag' id='flag' type='hidden' value= '"+flag+"'>";
                     HTMLVal = HTMLVal +"<input name='func_id' id='func_id' type='hidden' value= '"+func_id+"'>";
                     HTMLVal = HTMLVal +"<input name='sflag' id='sflag' type='hidden' value= '"+sflag+"'>";
///                     HTMLVal = HTMLVal +"</form></BODY></HTML>";
					 
                     parent.messageFrame.document.write(HTMLVal);
                     parent.messageFrame.document.form1.submit(); 
                }
              async   function ViewPatDtl(Pat_id)
                {
					Pat_id=unescape(Pat_id)
                    var url         = "../jsp/ViewPatDetailsMain.jsp?Patient_ID="+escape(Pat_id);
                    var dialogTop       = "65";
                    var dialogHeight    = "40"; //33.4
                    var dialogWidth     = "65";
                    var arguments   = "" ;
                    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
                    var returnval = await window.showModalDialog( url, arguments, features ) ;
                }
			</script>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			</head>
<%
request.setCharacterEncoding("UTF-8");
//String locale			= (String)session.getAttribute("LOCALE");
Connection conn = ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
ResultSet rSet = null;
String pat_id1			= request.getParameter("pat_id1");
String valid_patient_id="";
boolean continueFlag=true;
pat_id1=pat_id1.toUpperCase();
String national_id_no1	= request.getParameter("national_id_no1");
String alt_id1_no1		= request.getParameter("alt_id1_no1");
String alt_id2_no1		= request.getParameter("alt_id2_no1");
String alt_id3_no1		= request.getParameter("alt_id3_no1");
String alt_id4_no1		= request.getParameter("alt_id4_no1");
String pr_resNo1		= request.getParameter("pr_resNo1");
String oth_no1			= request.getParameter("oth_no1");
String search_in		= request.getParameter("search_in");
String func_act			= request.getParameter("func_act");
String act_yn			= request.getParameter("act_yn");
String function_id		= request.getParameter("function_id");
String First_Name1		= checkForNull(request.getParameter("First_Name1"));
String Second_Name1		= checkForNull(request.getParameter("Second_Name1"));
String Third_Name1		= checkForNull(request.getParameter("Third_Name1"));
String Family_Name1		= checkForNull(request.getParameter("Family_Name1"));
String first_name_loc_lang1		= checkForNull(request.getParameter("first_name_loc_lang1"));
String second_name_loc_lang1		= checkForNull(request.getParameter("second_name_loc_lang1"));
String third_name_loc_lang1		= checkForNull(request.getParameter("third_name_loc_lang1"));
String family_name_loc_lang1		= checkForNull(request.getParameter("family_name_loc_lang1"));
String order_by1		= checkForNull(request.getParameter("order_by1"));
String gender		= checkForNull(request.getParameter("gender"));

//For Duplicate Patient ID validation
if (!search_in.equals("D")&&(function_id.equals("") || function_id.equals("PAT_REG") ||func_act.equals("DuplicateRegistration") || 	function_id.equals("NEWBORN_REG"))){
	pstmt = conn.prepareStatement("select valid_patient_id from dr_mp_patient where duplicate_patient_id = ?");
	pstmt.setString(1,pat_id1);
	rSet=pstmt.executeQuery();
	if (rSet!=null && rSet.next())
		valid_patient_id = rSet.getString("valid_patient_id");
	if (valid_patient_id==null) valid_patient_id = "";
	if (search_in.equals("P") && !valid_patient_id.equals("")){
			out.println("<script>");
			out.println("for (var i=0;i<parent.criteria.document.forms[0].elements.length;i++) {parent.criteria.document.forms[0].elements[i].disabled=false;}");
			out.println("parent.search_toolbar.document.forms[0].Search.disabled = false;");
			out.println("if(parent.criteria.document.forms[0].maintain_doc_or_file.value == 'D') {");
			out.println("parent.criteria.document.forms[0].MRN.disabled = true;");
			out.println("parent.criteria.document.forms[0].OldFileNo.disabled = true; }");
			out.println("parent.criteria.enableRegister()");
			out.println("</script>");
			if (function_id.equals("DR_VALID_DUPLICATE_PATIENT") || function_id.equals("DR_ENTER_DUPLICATES") || function_id.equals("DR_MERGED_PATIENT_ID") || 												function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS") 	|| function_id.equals("DR_EXCLUDED_PATIENT_ID"))
				out.println("<script>parent.criteria.document.forms[0].search_in.disabled=true;</script>");			
			out.println("<script>if (parent.criteria.document.forms[0].searchby1 !=null) if (parent.criteria.document.forms[0].searchby1.value =='') parent.criteria.document.forms[0].searchby1.disabled=true;</script>");
			out.println("<script>parent.commontoolbar.location.href='../jsp/PatientSearchToolBar.jsp'</script>");		
			out.println("<script>var msg = parent.criteria.getMessage('PAT_MERGED_VALID','MP');msg= msg.replace('#','"+valid_patient_id+"');alert(msg);</script>");			out.println("<script>parent.criteria.document.forms[0].Patient_Id1.value='"+valid_patient_id+"';parent.search_toolbar.document.forms[0].Search.focus();</script>");
			continueFlag=false;
	}
}
if(!continueFlag){
}else{%>
<iframe name='PatIdResult' id='PatIdResult' src="../../eCommon/html/blank.html" frameborder=0  framespacing=0 noresize scrolling='NO' style="height:100vh;width:100vw;BORDER:0"></iframe>
<script>
			var htmlVal="<html><body onKeyDown='lockKey()'><form name='f1' id='f1' action='../../eMP/jsp/PatientQuickSearchResult.jsp' method='post'>"+
						"<input type='hidden' name='pat_id1' id='pat_id1' value=\"<%=pat_id1%>\">"+
						"<input type='hidden' name='national_id_no1' id='national_id_no1' value=\"<%=national_id_no1%>\">"+
						"<input type='hidden' name='alt_id1_no1' id='alt_id1_no1' value=\"<%=alt_id1_no1%>\">	"+
						"<input type='hidden' name='alt_id2_no1' id='alt_id2_no1' value=\"<%=alt_id2_no1%>\">"+
						"<input type='hidden' name='alt_id3_no1' id='alt_id3_no1' value=\"<%=alt_id3_no1%>\">"+
						"<input type='hidden' name='alt_id4_no1' id='alt_id4_no1' value=\"<%=alt_id4_no1%>\">"+
						"<input type='hidden' name='First_Name1' id='First_Name1' value=\"<%=First_Name1%>\">"+
						"<input type='hidden' name='Second_Name1' id='Second_Name1' value=\"<%=Second_Name1%>\">"+
						"<input type='hidden' name='Third_Name1' id='Third_Name1' value=\"<%=Third_Name1%>\">"+
						"<input type='hidden' name='Family_Name1' id='Family_Name1' value=\"<%=Family_Name1%>\">"+
						"<input type='hidden' name='first_name_loc_lang1' id='first_name_loc_lang1' value=\"<%=first_name_loc_lang1%>\">"+
						"<input type='hidden' name='second_name_loc_lang1' id='second_name_loc_lang1' value=\"<%=second_name_loc_lang1%>\">"+
						"<input type='hidden' name='third_name_loc_lang1' id='third_name_loc_lang1' value=\"<%=third_name_loc_lang1%>\">"+
						"<input type='hidden' name='family_name_loc_lang1' id='family_name_loc_lang1' value=\"<%=family_name_loc_lang1%>\">"+
						"<input type='hidden' name='pr_resNo1' id='pr_resNo1' value=\"<%=pr_resNo1%>\">"+	
						"<input type='hidden' name='oth_no1' id='oth_no1' value=\"<%=oth_no1%>\">"+	
						"<input type='hidden' name='search_in' id='search_in' value=\"<%=search_in%>\">"+	
						"<input type='hidden' name='func_act' id='func_act' value=\"<%=func_act%>\">"+	
						"<input type='hidden' name='act_yn' id='act_yn' value=\"<%=act_yn%>\">"+	
						"<input type='hidden' name='function_id' id='function_id' value=\"<%=function_id%>\">"+	
						"<input type='hidden' name='order_by1' id='order_by1' value=\"<%=order_by1%>\">"+	
						"<input type='hidden' name='gender' id='gender' value=\"<%=gender%>\">"+	
						"</form></body></html>"
			
			PatIdResult.document.write(htmlVal);
			PatIdResult.document.f1.submit(); 			
</script>
<%}%>
<input type="hidden" name="pat_id1" id="pat_id1" value="<%=pat_id1%>">
<input type="hidden" name="national_id_no1" id="national_id_no1" value="<%=national_id_no1%>">
<input type="hidden" name="alt_id1_no1" id="alt_id1_no1" value="<%=alt_id1_no1%>">
<input type="hidden" name="alt_id2_no1" id="alt_id2_no1" value="<%=alt_id2_no1%>">
<input type="hidden" name="alt_id3_no1" id="alt_id3_no1" value="<%=alt_id3_no1%>">
<input type="hidden" name="alt_id4_no1" id="alt_id4_no1" value="<%=alt_id4_no1%>">
<input type="hidden" name="pr_resNo1" id="pr_resNo1" value="<%=pr_resNo1%>">
<input type="hidden" name="oth_no1" id="oth_no1" value="<%=oth_no1%>">
<input type="hidden" name="search_in" id="search_in" value="<%=search_in%>">
<input type="hidden" name="func_act" id="func_act" value="<%=func_act%>">
<input type="hidden" name="act_yn" id="act_yn" value="<%=act_yn%>">
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">

</HTML>
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

