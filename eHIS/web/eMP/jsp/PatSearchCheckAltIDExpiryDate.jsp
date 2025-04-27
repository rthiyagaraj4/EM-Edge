<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
Connection conn					= null;
PreparedStatement pstmt			= null;
//PreparedStatement caPstmt		= null;
PreparedStatement pstmt7		= null;
PreparedStatement pstmt8		= null;
//PreparedStatement pstmt_chk_age = null;
//PreparedStatement pstmtSex		= null;
//PreparedStatement pstmtGest1	= null;
//PreparedStatement pstmtTEMP		= null;
ResultSet rsGest				= null;
//ResultSet rsGest1				= null;
//ResultSet rsTEMP				= null;
ResultSet rs					= null;
//ResultSet rs_chk_age			= null;
//ResultSet rs_sex				= null;
ResultSet rs7					= null;
ResultSet rs8					= null;
//ResultSet caRS					= null;
CallableStatement cstmt			=null;

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String alt_id1_exp_warn_yn			= "";
String alt_id2_exp_warn_yn			= "";
String alt_id3_exp_warn_yn			= "";
String alt_id4_exp_warn_yn			= "";
String alt_id1_adv_alert_reqd_yn	= "";
String alt_id2_adv_alert_reqd_yn	= "";
String alt_id3_adv_alert_reqd_yn	= "";
String alt_id4_adv_alert_reqd_yn	= "";
String sex_det						= ""; 
String p_alt_id1_type				= "";
String p_alt_id2_type				= "";
String p_alt_id3_type				= "";
String p_alt_id4_type				= "";
String multiple_birth_yn			= "";
String sub_multi_birth_hw			= "";
String age_flag						= "false";
String age_flag1					= "false";
String flag							= "true";

String jsp_name				= request.getParameter("jsp_name"); 
String retback				= request.getParameter("flag"); 
String func					= request.getParameter("func_id") == null?"":request.getParameter("func_id");

String sflag				= request.getParameter("sflag"); 
String nursing_unit_code	= request.getParameter("nursing_unit_code") == null ? "" : request.getParameter("nursing_unit_code");
String bed_no				= request.getParameter("bed_no") == null ? "" : request.getParameter("bed_no");
String IPValue				= request.getParameter("IPValue"); 

String pat_id				= request.getParameter("pat_id"); 
pat_id = java.net.URLDecoder.decode(pat_id);
String win_top				= request.getParameter("win_top");
String win_width			= request.getParameter("win_width");
String win_height			= request.getParameter("win_height");
String func_idpassed		= request.getParameter("func_idpassed") == null ? "" : request.getParameter("func_idpassed");
String function_id			= request.getParameter("function_id")== null ?"":request.getParameter("function_id");
String calling_module_id	= request.getParameter("calling_module_id")==null?"":request.getParameter("calling_module_id");


//session.setAttribute("Special_case","N");  // added on 14th Oct 2009

if(jsp_name == null) jsp_name = "";
if(retback == null) retback = "";
if(func == null) func = "";
if(sflag == null) sflag = "";
if(IPValue == null) IPValue = "";
if(pat_id == null) pat_id = "";
if(function_id == null) function_id = "";

int alt_id1_exp_grace_days	= 0;
int alt_id2_exp_grace_days	= 0;
int alt_id3_exp_grace_days	= 0;
int alt_id4_exp_grace_days	= 0;
int alt_id1_adv_alert_days	= 0;
int alt_id2_adv_alert_days	= 0;
int alt_id3_adv_alert_days	= 0;
int alt_id4_adv_alert_days	= 0;
int p_adv_diff_days			= 0;
int min_age					= 0;
int min_age1				= 0;
int min_age2				= 0;
int mother_min_age			= 0;
int last_nb_order			= 0;
int no_of_births			= 0;
int father_age				= 0;
int father_min_age			= 0;
int mother_max_age			= 0;
int mother_cutoff_age		= 0;
int p_alt_id1_diff_days		= 0;
int p_alt_id2_diff_days		= 0;
int p_alt_id3_diff_days		= 0;
int p_alt_id4_diff_days		= 0;

double MAX_MULTIPLE_BIRTH_REGN_HRS	= 0.0;
double diffWeeks = 0.0;
double diffDays = 0.0;
double diffHours = 0.0;

//double temp1 = 0.0;
double min_gest_bet_del			= 0.0;
double min_gest_bet_del_days	= 0.0;

java.util.Date current_date	= null;
java.util.Date p_alt_id1_exp_date = null, p_alt_id1_total_exp_date = null;
java.util.Date p_alt_id2_exp_date = null, p_alt_id2_total_exp_date = null;
java.util.Date p_alt_id3_exp_date = null, p_alt_id3_total_exp_date = null;
java.util.Date p_alt_id4_exp_date = null, p_alt_id4_total_exp_date = null;
session.removeValue("mc_cycle_number");//clearing value from session 

%>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<Script language="JavaScript" src="../../eMP/js/PatientSearch.js"></Script>
		<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
		async function showRegisterNewBorn(patientid)
		{ 
			var nursing_unit_code = "<%=nursing_unit_code%>";
			var calling_module_id = "<%=calling_module_id%>";
			var bed_no = "<%=bed_no%>";
			var retVal =    new String();
			var dialogHeight= "95vh" ;
			var dialogWidth = "95vw" ;
			var dialogPadding = "10px";;
			var status = "no";
			var arguments   = "" ;
			var features    = "dialogPadding:" + dialogPadding +"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status;		
					
						var retVal = await top.window.showModalDialog("../../eMP/jsp/PaintNewbornMotherBabyLink.jsp?mother_id="+escape(patientid),arguments,features);
						if(retVal != null)
						{
							var arr = retVal.split('`');
							if(arr[1] == 'N')
							{
								alert(getMessage("NO_MOTHER_BABY_LINKS",'MP'));
								
								dialogHeight= "95vh" ;
								dialogWidth = "95vw" ;
								dialogPadding = "10px";

								features    = "dialogPadding:" + dialogPadding +";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
								arguments   = "" ;
								var param="../../eMP/jsp/NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name="+encodeURIComponent(getLabel("eMP.RegNewBorn.label","MP"))+"&function_type=F&access=NNNNN&home_required_yn=N&Patient_ID="+escape(patientid)+"&mother_nursing_unit="+nursing_unit_code+"&mother_bed_no="+bed_no+"&calling_module_id="+calling_module_id;
								
								var retVal = await top.window.showModalDialog(param,arguments,features);
							}
							else if(arr[1] == 'Y')
							{
								dialogHeight= "95vh" ;
								dialogWidth = "95vw" ;
								dialogPadding = "10px";

								features    = "dialogPadding:" + dialogPadding +";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
								arguments   = "" ;
								var param="../../eMP/jsp/NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NNNNN&home_required_yn=N&Patient_ID="+escape(patientid)+"&mother_nursing_unit="+nursing_unit_code+"&mother_bed_no="+bed_no+"&calling_module_id="+calling_module_id;
																
								var retVal = await top.window.showModalDialog(param,arguments,features);
								//var retVal = window.open(param,arguments,features);
							}
						}
					
		}
		
		async function returnPatient(pat,flag) 
		{
			/* Code Added by Vedesh A D for Edge Conversion */
			var dialogTagFrame = "";
			var dialogBodyFrame = "";
			const diagElement = top.document.getElementsByTagName("dialog");
            var i = 0; var j = 0;
            for (i = 0; i < diagElement.length; i++) 
    		{
            	for (j = 0; j < diagElement[i].children.length; j++) 
				{
            		var element = diagElement[i].children[j];
            		let dialogSrc = element.src;
            		if (typeof dialogSrc !== "undefined")
            		{ 
        	    		if (dialogSrc.includes("ModelPatientSearch.jsp") )
        	        	{
        	    			dialogTagFrame = diagElement[i];
        	    			dialogBodyFrame = element;
        	        	}
            		}    		
            	} 
            }
            
            if(dialogTagFrame == undefined && dialogBodyFrame == undefined){
            	dialogTagFrame = parent.parent.document.getElementById('dialog_tag');
            	dialogBodyFrame = parent.parent.document.getElementById('dialog-body');
            }
            /* end */
            
			
			if(flag == 'false')
			{
				//var desc = parent.parent.frames[1].document.forms[0].jsp_name.value;
				var desc = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.jsp_name.value;
				var chk = desc.indexOf("?");
				var url_to_pass = "";
				
				if ((chk == -1)) url_to_pass ='?';
				else url_to_pass ='&';
				
				//var window_styl =   parent.frames[1].document.forms[0].window_styl.value;
				var window_styl =   dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.window_styl.value;
				//var close_yn    =   parent.frames[1].document.forms[0].close_yn.value;
				var close_yn    =  dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.close_yn.value;
				if(desc == null || desc.length == 0)
				{
					dialogBodyFrame.contentWindow.returnValue = escape(pat);
					dialogTagFrame.close();
					//parent.returnValue = escape(pat);
					//parent.close();
				}
				else
				{
					if(window_styl == 'N')
					{
						var url = desc+url_to_pass+"Patient_Id=" + escapse(pat);
						if(close_yn == 'Y') dialogTagFrame.close();
						//parent.close();
						parent.location.href=url;
					}
					if(window_styl == 'O')
					{
						var url = desc+url_to_pass+"Patient_Id=" + escape(pat);
						var dialogTop       = '<%=win_top%>';
						var dialogHeight    = '<%=win_height%>' ;
						var dialogWidth     = '<%=win_width%>' ;
						var arguments   = "" ;
						var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no" ;
						var returnval = await window.showModalDialog( url, arguments, features ) ;
						//parent.location.href=url;
						if(close_yn == 'Y') dialogTagFrame.close();  //parent.close();
						return returnval;
					}
				}
			}
			else
			{
				var desc = "";
				var window_styl = "";
				var close_yn    = "";
				
				if (parent.Pat_Search_Tabs_Frame)
				{
					if (parent.Pat_Search_Tabs_Frame.document.getElementById("tab_id_clicked").value == "AdvanceTab"){						 
						//desc = parent.parent.document.getElementById('dialog-body').contentWindow.document.Pat_Search_Tabs_Frame.jsp_name.value;
						//window_styl = parent.parent.document.getElementById('dialog-body').contentWindow.document.Pat_Search_Tabs_Frame.window_styl.value;
						//close_yn    = parent.parent.document.getElementById('dialog-body').contentWindow.document.Pat_Search_Tabs_Frame.close_yn.value;
					
						desc = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.jsp_name.value;
						window_styl = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.window_styl.value;
						close_yn    = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.close_yn.value;
						
					}
					else
					{
						 if (parent.Pat_Search_Tabs_Frame.document.getElementById("tab_id_clicked").value == "BasicTab"){							 
							desc = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.jsp_name.value;
							window_styl = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.window_styl.value;
							close_yn    = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.close_yn.value;
						 }
					}
				}
				else
				{
					desc = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.jsp_name.value;
					window_styl = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.window_styl.value;
					close_yn    = dialogBodyFrame.contentWindow.document.Pat_Search_Tabs_Frame.close_yn.value;
				}
					
				//var desc = parent.parent.frames[1].document.forms[0].jsp_name.value;
				//var desc = parent.parent.document.getElementById('dialog-body').contentWindow.document.Pat_Search_Tabs_Frame.jsp_name.value;
				
				var chk = desc.indexOf("?");
				var url_to_pass = "";

				if((chk == -1)) url_to_pass = '?';
				else url_to_pass ='&';
				
				//var window_styl = parent.frames[1].document.forms[0].window_styl.value;
				//var close_yn    = parent.frames[1].document.forms[0].close_yn.value;
				
				//var window_styl = parent.parent.document.getElementById('dialog-body').contentWindow.document.Pat_Search_Tabs_Frame.window_styl.value;
				//var close_yn    = parent.parent.document.getElementById('dialog-body').contentWindow.document.Pat_Search_Tabs_Frame.close_yn.value;
				
				if(desc == null || desc.length == 0)
				{	
					/*
					parent.returnValue = escape(pat);
					parent.close();
					*/
					
					if (parent.Pat_Search_Tabs_Frame)
					{
						if (parent.Pat_Search_Tabs_Frame.document.getElementById("tab_id_clicked").value == "AdvanceTab"){	
							dialogBodyFrame.contentWindow.returnValue = pat;
							dialogTagFrame.close();
							/* let dialogBody = parent.parent.document.getElementById('dialog-body');
						    dialogBody.contentWindow.returnValue = pat;
						    
						    const dialogTag = parent.parent.document.getElementById("dialog_tag");  
						    dialogTag.close();  */
						}
						else
						{
							dialogBodyFrame.contentWindow.returnValue = pat;
							dialogTagFrame.close(); 
						}
					}
					else
					{
						dialogBodyFrame.contentWindow.returnValue = pat;
						dialogTagFrame.close();
					}
					 
				}
				else
				{
					if(window_styl == 'N')
					{
						var url = desc+url_to_pass+"Patient_Id=" + escape(pat);
						if(close_yn == 'Y') dialogTagFrame.close();
						//parent.close();
						parent.location.href=url;
					}
					if(window_styl == 'O')
					{
						var url = desc+url_to_pass+"Patient_Id=" + escape(pat);
								
						var dialogTop       = '<%=win_top%>';
						var dialogHeight    = '<%=win_height%>' ;
						var dialogWidth     = '<%=win_width%>' ;
						var arguments   = "" ;
						var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no" ;
						var returnval = await window.showModalDialog( url, arguments, features ) ;

						if (close_yn == 'Y') dialogTagFrame.close();
						//parent.close();

						return returnval;
				   }
				}
			}
		}
		async function aa(flag)
		{
			
			/* Code Added by Vedesh A D for Edge Conversion */
			var dialogTagFrame = "";
			var dialogBodyFrame = "";
			const diagElement = top.document.getElementsByTagName("dialog");
            var i = 0; var j = 0;
            for (i = 0; i < diagElement.length; i++) 
    		{
            	for (j = 0; j < diagElement[i].children.length; j++) 
				{
            		var element = diagElement[i].children[j];
            		let dialogSrc = element.src;
            		if (typeof dialogSrc !== "undefined")
            		{ 
        	    		if (dialogSrc.includes("ModelPatientSearch.jsp") )
        	        	{
        	    			dialogTagFrame = diagElement[i];
        	    			dialogBodyFrame = element;
        	        	}
            		}    		
            	} 
            }
            
            if(dialogTagFrame == undefined && dialogBodyFrame == undefined){
            	dialogTagFrame = parent.parent.document.getElementById('dialog_tag');
            	dialogBodyFrame = parent.parent.document.getElementById('dialog-body');
            }
            /* end */
            
			if(flag=='false')
			{
				var hyp_yn = '<%=jsp_name%>';
				if(!(hyp_yn == null || hyp_yn.length == 0 ))
				{
					var chk = hyp_yn.indexOf("?");
					var url_to_pass = "";
					
					if((chk == -1)) url_to_pass = '?';
					else url_to_pass ='&';
				
					var p_desc          =   parent.frames[1].document.getElementById('jsp_name').value;
					var p_window_styl   =   parent.frames[1].document.getElementById('window_styl').value;
					var p_close_yn      =   parent.frames[1].document.getElementById('close_yn').value;

					if(p_window_styl == 'N')
					{
						var url = p_desc+url_to_pass+"Patient_Id="+escape("<%=pat_id%>");
						if(p_close_yn == 'Y') dialogTagFrame.close(); //parent.close();
						parent.location.href=url;
					}
					if(p_window_styl == 'O')
					{
						var url = p_desc+url_to_pass+"Patient_Id="+escape("<%=pat_id%>");
						var dialogTop       = "<%=win_top%>"               //"61";
						var dialogHeight    = "<%=win_height%>"            //"34" ;
						var dialogWidth     = "<%=win_width%>"             //"50" ;
						var arguments   = "" ;
						var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no ";
						var returnval = await window.showModalDialog( url, arguments, features ) ;

						if(p_close_yn == 'Y') //parent.close();
							dialogTagFrame.close();
					}
				}
				else
				{
					dialogBodyFrame.contentWindow.returnValue = escape("<%=pat_id%>") ;
					dialogTagFrame.close();
					<%-- parent.returnValue=escape("<%=pat_id%>") ;
					parent.close();	 --%>			
				}
			}
			else			
			{
				var hyp_yn = '<%=jsp_name%>';
				if(!(hyp_yn == null || hyp_yn.length == 0))
				{
					var chk = hyp_yn.indexOf("?");
					var url_to_pass = "";
					
					if((chk == -1))	url_to_pass = '?';
					else url_to_pass = '&';
					
					var p_desc          =   parent.frames[1].document.getElementById('jsp_name').value;
					var p_window_styl   =   parent.frames[1].document.getElementById('window_styl').value;
					var p_close_yn      =   parent.frames[1].document.getElementById('close_yn').value;
					if(p_window_styl == 'N')
					{
						var url = p_desc+url_to_pass+"Patient_Id="+escape("<%=pat_id%>");
						if(p_close_yn == 'Y') dialogTagFrame.close();
						parent.location.href=url;
					}
					if(p_window_styl == 'O')
					{
						var url				= p_desc+url_to_pass+"Patient_Id="+escape("<%=pat_id%>");
						var dialogTop		= "<%=win_top%>"    //"61";
						var dialogHeight	= "<%=win_height%>" //"34";
						var dialogWidth		= "<%=win_width%>"  //"50";
						var arguments		= "" ;
						var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no ";
						var returnval		= await window.showModalDialog( url, arguments, features ) ;

						if(p_close_yn == 'Y') //parent.close();
							dialogTagFrame.close();  
					}
				}
				else
				{
					if(dialogBodyFrame)
					{
						dialogBodyFrame.contentWindow.returnValue = escape("<%=pat_id%>") ;
						dialogTagFrame.close();
					}
					<%-- parent.returnValue=escape("<%=pat_id%>") ;
					parent.close();  --%>				
				}
			}
		}
	</script>
</head>
<body CLASS='MESSAGE' onKeyDown = 'lockKey()'>
	<%

	String CountNo = "0"; 

	String expsql = "SELECT alt_id1_exp_warn_yn, alt_id1_exp_grace_days, alt_id2_exp_warn_yn, alt_id2_exp_grace_days, alt_id3_exp_warn_yn, alt_id3_exp_grace_days, alt_id4_exp_warn_yn, alt_id4_exp_grace_days, sysdate, alt_id1_adv_alert_reqd_yn, alt_id1_adv_alert_days, alt_id2_adv_alert_reqd_yn, alt_id2_adv_alert_days, alt_id3_adv_alert_reqd_yn, alt_id3_adv_alert_days, alt_id4_adv_alert_reqd_yn, alt_id4_adv_alert_days, NB_MOTHER_MIN_AGE, NB_MOTHER_UPPER_AGE, NB_MOTHER_CUTOFF_AGE, NB_MIN_GEST_BET_2_DELY, NB_FATHER_MIN_AGE, MAX_MULTIPLE_BIRTH_REGN_HRS,sub_multi_birth_hw, (select count(module_id) from sm_module where module_id='MC' and install_yn='Y') countNo FROM mp_param where module_id='MP'";

	try{
		conn = ConnectionManager.getConnection(request);
		pstmt8 = conn.prepareStatement(expsql);
		rs8=pstmt8.executeQuery();    
		if (rs8.next()) {

			alt_id1_exp_warn_yn			= rs8.getString(1);
			alt_id1_exp_grace_days		= rs8.getInt(2);
			alt_id2_exp_warn_yn			= rs8.getString(3);
			alt_id2_exp_grace_days		= rs8.getInt(4);
			alt_id3_exp_warn_yn			= rs8.getString(5);
			alt_id3_exp_grace_days		= rs8.getInt(6);
			alt_id4_exp_warn_yn			= rs8.getString(7);
			alt_id4_exp_grace_days		= rs8.getInt(8);
			current_date				= rs8.getDate(9);
			alt_id1_adv_alert_reqd_yn	= rs8.getString(10);
			alt_id1_adv_alert_days		= rs8.getInt(11);
			alt_id2_adv_alert_reqd_yn	= rs8.getString(12);
			alt_id2_adv_alert_days		= rs8.getInt(13);
			alt_id3_adv_alert_reqd_yn	= rs8.getString(14);
			alt_id3_adv_alert_days		= rs8.getInt(15);
			alt_id4_adv_alert_reqd_yn	= rs8.getString(16);
			alt_id4_adv_alert_days		= rs8.getInt(17);

			mother_min_age				= rs8.getInt("NB_MOTHER_MIN_AGE"); 	
			mother_max_age				= rs8.getInt("NB_MOTHER_UPPER_AGE"); 
			mother_cutoff_age			= rs8.getInt("NB_MOTHER_CUTOFF_AGE");
			min_gest_bet_del			= rs8.getDouble("NB_MIN_GEST_BET_2_DELY");
			MAX_MULTIPLE_BIRTH_REGN_HRS	= rs8.getDouble("MAX_MULTIPLE_BIRTH_REGN_HRS");
			sub_multi_birth_hw = rs8.getString("sub_multi_birth_hw");
			CountNo = rs8.getString("countNo")==null?"0":rs8.getString("countNo");
			father_min_age = rs8.getInt("NB_FATHER_MIN_AGE");

			if(alt_id1_exp_warn_yn == null) alt_id1_exp_warn_yn = "";    
			if(alt_id2_exp_warn_yn == null) alt_id2_exp_warn_yn = "";        
			if(alt_id3_exp_warn_yn == null) alt_id3_exp_warn_yn = "";        
			if(alt_id4_exp_warn_yn == null) alt_id4_exp_warn_yn = "";        
			if(alt_id1_adv_alert_reqd_yn == null) alt_id1_adv_alert_reqd_yn = "";
			if(alt_id2_adv_alert_reqd_yn == null) alt_id2_adv_alert_reqd_yn = "";
			if(alt_id3_adv_alert_reqd_yn == null) alt_id3_adv_alert_reqd_yn = "";
			if(alt_id4_adv_alert_reqd_yn == null) alt_id4_adv_alert_reqd_yn = "";
			if(sub_multi_birth_hw == null) sub_multi_birth_hw = "";

			/*
			if(alt_id1_adv_alert_days == null) alt_id1_adv_alert_days = 0;
			if(alt_id2_adv_alert_days == null) alt_id2_adv_alert_days = 0;
			if(alt_id3_adv_alert_days == null) alt_id3_adv_alert_days = 0;
			if(alt_id4_adv_alert_days == null) alt_id4_adv_alert_days = 0;

			if(mother_min_age == null) mother_min_age = 0;
			if(father_min_age == null) father_min_age = 0;
			if(mother_max_age == null) mother_max_age = 0;
			if(mother_cutoff_age == null) mother_cutoff_age = 0;
			if(min_gest_bet_del == null) min_gest_bet_del = 0.0;
			if(MAX_MULTIPLE_BIRTH_REGN_HRS == null) MAX_MULTIPLE_BIRTH_REGN_HRS = 0.0;
			*/
		}

		if(pstmt8 != null) pstmt8.close();
		if(rs8!=null) rs8.close();

		String psql="SELECT TRUNC(ALT_ID1_EXP_DATE), TRUNC(ALT_ID2_EXP_DATE), TRUNC(ALT_ID3_EXP_DATE), TRUNC(ALT_ID4_EXP_DATE), ABS(TRUNC(ALT_ID1_EXP_DATE)-TRUNC(SYSDATE)), ABS(TRUNC(ALT_ID2_EXP_DATE)-TRUNC(SYSDATE)), ABS(TRUNC(ALT_ID3_EXP_DATE)-TRUNC(SYSDATE)),  ABS(TRUNC(ALT_ID4_EXP_DATE)-TRUNC(SYSDATE)), calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'), 1),  TRUNC(SYSDATE)-TRUNC(regn_date),(CASE WHEN alt_id1_no IS NOT NULL THEN 	    MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id1_type,?,1) END) alt_id1_type, (CASE WHEN alt_id2_no IS NOT NULL THEN MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id2_type,?,1) END) alt_id2_type, (CASE WHEN alt_id3_no IS NOT NULL THEN  MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id3_type,?,1) END) alt_id3_type, (CASE WHEN alt_id4_no IS NOT NULL THEN MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id4_type,?,1) END)   alt_id4_type,calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'), 2),   calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'), 3), sex FROM mp_patient  WHERE patient_id = ?";

		try{
			pstmt7 = conn.prepareStatement(psql);
			pstmt7.setString(1,locale);
			pstmt7.setString(2,locale);
			pstmt7.setString(3,locale);
			pstmt7.setString(4,locale);
			pstmt7.setString(5,pat_id);
			rs7 = pstmt7.executeQuery();
			if(rs7.next()){
				p_alt_id1_exp_date	= rs7.getDate(1);
				p_alt_id2_exp_date	= rs7.getDate(2);
				p_alt_id3_exp_date	= rs7.getDate(3);
				p_alt_id4_exp_date	= rs7.getDate(4);
				p_alt_id1_diff_days	= rs7.getInt(5);
				p_alt_id2_diff_days = rs7.getInt(6);
				p_alt_id3_diff_days = rs7.getInt(7);
				p_alt_id4_diff_days = rs7.getInt(8);
				min_age				= rs7.getInt(9);
				father_age			= rs7.getInt(9);
				p_adv_diff_days		= rs7.getInt(10);
				p_alt_id1_type		= rs7.getString(11);
				p_alt_id2_type		= rs7.getString(12);
				p_alt_id3_type		= rs7.getString(13);
				p_alt_id4_type		= rs7.getString(14);
				min_age1			= rs7.getInt(15);
				min_age2			= rs7.getInt(16);				
				sex_det			= rs7.getString("sex") == null?"":rs7.getString("sex");				
			}
	    }catch(Exception e) { 
			e.printStackTrace();
		}finally{
			if (pstmt7 != null) pstmt7.close();
	        if (rs7 != null) rs7.close();
		}
		if(alt_id1_exp_warn_yn.equals("Y")){
			if(p_alt_id1_exp_date != null){
				p_alt_id1_total_exp_date=new java.util.Date(p_alt_id1_exp_date.getTime());
				p_alt_id1_total_exp_date.setDate(p_alt_id1_exp_date.getDate()+alt_id1_exp_grace_days);  
				if((p_alt_id1_exp_date.compareTo(current_date))< 0){
				    if((p_alt_id1_total_exp_date.compareTo(current_date))< 0){
						flag="false"; 
					%>
						<script>
							var msg = getMessage("ALT_ID_EXPIRED",'MP'); 
							msg = msg.replace('$', "<%=p_alt_id1_type%>"); 
							alert(msg);
						</script>
					   <%
					}
					else
					{
						%>
						<script>
							var msg = getMessage("ALT_ID_EXP_WITH_GRACE",'MP'); 
							msg = msg.replace('$', "<%=p_alt_id1_type%>"); 
							alert(msg);
						</script>
						<%
					}
				}
			}
		}
		if(alt_id2_exp_warn_yn.equals("Y"))
		{
		   if(p_alt_id2_exp_date != null)
		   {
				p_alt_id2_total_exp_date=new java.util.Date(p_alt_id2_exp_date.getTime());
				p_alt_id2_total_exp_date.setDate(p_alt_id2_exp_date.getDate()+alt_id2_exp_grace_days);  
				if((p_alt_id2_exp_date.compareTo(current_date))< 0)
				{
					if((p_alt_id2_total_exp_date.compareTo(current_date))< 0)
					{
						flag="false";
						%>
						<script>
							var msg = getMessage("ALT_ID_EXPIRED",'MP'); 
							msg = msg.replace('$', "<%=p_alt_id2_type%>");
							alert(msg);
						</script>
						<%
					}
			        else
					{
					   %>
				       <script>
							var msg = getMessage("ALT_ID_EXP_WITH_GRACE",'MP'); 
							msg = msg.replace('$', "<%=p_alt_id2_type%>"); 
							alert(msg);
						</script>
						<%
					}  
				}
			}
		}
		if(alt_id3_exp_warn_yn.equals("Y"))
		{
			if(p_alt_id3_exp_date != null)
			{
			    p_alt_id3_total_exp_date=new java.util.Date(p_alt_id3_exp_date.getTime());
				p_alt_id3_total_exp_date.setDate(p_alt_id3_exp_date.getDate()+alt_id3_exp_grace_days);  
				if((p_alt_id3_exp_date.compareTo(current_date))< 0)
				{
			       if((p_alt_id3_total_exp_date.compareTo(current_date))< 0)
					{
						flag = "false";
						%>
						<script>
							var msg = getMessage("ALT_ID_EXPIRED",'MP');
							msg = msg.replace('$', "<%=p_alt_id3_type%>"); 
							alert(msg);
						</script>
						<%
					}
					else
					{
						%>
			            <script>
							var msg = getMessage("ALT_ID_EXP_WITH_GRACE",'MP'); 
							msg = msg.replace('$', "<%=p_alt_id3_type%>"); 
							alert(msg);
						</script>
						<%
					}  
				}
			}
		}
		if(alt_id4_exp_warn_yn.equals("Y"))
		{
		   if(p_alt_id4_exp_date != null)
			{
				p_alt_id4_total_exp_date = new java.util.Date(p_alt_id4_exp_date.getTime());
				p_alt_id4_total_exp_date.setDate(p_alt_id4_exp_date.getDate()+alt_id4_exp_grace_days);  if((p_alt_id4_exp_date.compareTo(current_date))< 0)
				{
				    if((p_alt_id4_total_exp_date.compareTo(current_date))< 0)
					{
						flag = "false";
						%>
						<script>
							var msg = getMessage("ALT_ID_EXPIRED",'MP'); 
							msg = msg.replace('$', "<%=p_alt_id4_type%>"); 
							alert(msg);
						</script>
						<%
					}
					else
					{
						%>
				        <script>
							var msg = getMessage("ALT_ID_EXP_WITH_GRACE",'MP');
							msg = msg.replace('$', "<%=p_alt_id4_type%>"); 
							alert(msg);
						</script>
						<%
					}  
				}
			}
		}
		if(alt_id1_adv_alert_reqd_yn.equals("Y"))
		{    
			if(p_alt_id1_exp_date != null)
			{
				if((p_alt_id1_exp_date.compareTo(current_date))> 0)
				{
					if(p_alt_id1_diff_days > 0) 
					{
						if( p_alt_id1_diff_days <= alt_id1_adv_alert_days)
						{
							%>
							<script>
								var msg = getMessage("ALT_ID_EXP_WITHIN",'MP'); 
								msg = msg.replace('$',"<%=p_alt_id1_type%>"); 
								var alt_days = <%=alt_id1_adv_alert_days%>;
								var p_alt_id1_diff_days = <%=p_alt_id1_diff_days%>;

								alt_days = alt_days-<%=p_adv_diff_days%>;
								alert(msg+' '+p_alt_id1_diff_days+' days');
							</script>
							<%
						}
					}
				}
			}
		}
		if(alt_id2_adv_alert_reqd_yn.equals("Y"))
		{
			if(p_alt_id2_exp_date != null)
			{
				if((p_alt_id2_exp_date.compareTo(current_date))> 0)
				{
					if(p_alt_id2_diff_days > 0) 
					{
						if(p_alt_id2_diff_days <= alt_id2_adv_alert_days)
						{
							%>
							<script>
								var msg = getMessage("ALT_ID_EXP_WITHIN",'MP'); 
								msg = msg.replace('$',"<%=p_alt_id2_type%>"); 
								var alt_days = <%=alt_id2_adv_alert_days%>;
								var p_alt_id2_diff_days = <%=p_alt_id2_diff_days%>;
								alt_days = alt_days-<%=p_adv_diff_days%>;
								alert(msg+' '+p_alt_id2_diff_days+' days');
							</script>
							<%
						}
					}
				}
			}
		}
		if(alt_id3_adv_alert_reqd_yn.equals("Y"))
		{
			if(p_alt_id3_exp_date != null)
			{                 
				if((p_alt_id3_exp_date.compareTo(current_date))> 0)
				{
					if(p_alt_id3_diff_days > 0) 
					{
						if(p_alt_id3_diff_days <= alt_id3_adv_alert_days)
						{
							%>
							<script>
								var msg = getMessage("ALT_ID_EXP_WITHIN",'MP'); 
								msg = msg.replace('$',"<%=p_alt_id3_type%>"); 
								var alt_days = <%=alt_id3_adv_alert_days%>;
								var p_alt_id3_diff_days = <%=p_alt_id3_diff_days%>;
								alt_days = alt_days-<%=p_adv_diff_days%>;
								alert(msg+' '+p_alt_id3_diff_days+' days');
							</script>
							<%
						}
					}
				}
			}
		}
		if(alt_id4_adv_alert_reqd_yn.equals("Y"))
		{
			if(p_alt_id4_exp_date != null)
			{
				if((p_alt_id4_exp_date.compareTo(current_date)) > 0)
				{
					if(p_alt_id4_diff_days > 0) 
					{
						if(p_alt_id4_diff_days <= alt_id4_adv_alert_days)
						{
							%>
							<script>
								var msg = getMessage("ALT_ID_EXP_WITHIN",'MP'); 
								msg = msg.replace('$',"<%=p_alt_id4_type%>"); 
								var alt_days = <%=alt_id4_adv_alert_days%>;
								var p_alt_id4_diff_days = <%=p_alt_id4_diff_days%>;
								alt_days = alt_days-<%=p_adv_diff_days%>;
								alert(msg+' '+p_alt_id4_diff_days+' days');
							</script>
							<%
						}
					}
				}
			}
		}
		if(!func_idpassed.equals("MP_VIEW_BIRTH_REG")&&!func_idpassed.equals("MP_MAIN_NB_REG")){
			if(func.equals("NEWBORN_REG")){  
				try{
					/*
					pstmtSex=conn.prepareStatement("SELECT SEX FROM MP_PATIENT WHERE PATIENT_ID='"+pat_id+"'");
					rs_sex=pstmtSex.executeQuery();
					if(rs_sex.next()){
						sex_det = rs_sex.getString(1);
					}
					if(pstmtSex != null) pstmtSex.close();
					if(rs_sex != null) rs_sex.close();
					*/

					if(sex_det.equals("F")){
						//pstmt_chk_age = conn.prepareStatement("SELECT alt_id1_exp_warn_yn, alt_id1_exp_grace_days, alt_id2_exp_warn_yn, alt_id2_exp_grace_days, alt_id3_exp_warn_yn, alt_id3_exp_grace_days, alt_id4_exp_warn_yn, alt_id4_exp_grace_days,sysdate, alt_id1_adv_alert_reqd_yn, nvl(alt_id1_adv_alert_days,0) alt_id1_adv_alert_days, alt_id2_adv_alert_reqd_yn, nvl(alt_id2_adv_alert_days, 0) alt_id2_adv_alert_days, alt_id3_adv_alert_reqd_yn, nvl(alt_id3_adv_alert_days, 0) alt_id3_adv_alert_days, alt_id4_adv_alert_reqd_yn, nvl(alt_id4_adv_alert_days, 0) alt_id4_adv_alert_days, nvl(NB_MOTHER_MIN_AGE,0) NB_MOTHER_MIN_AGE, nvl(NB_MOTHER_UPPER_AGE,0) NB_MOTHER_UPPER_AGE, nvl(NB_MOTHER_CUTOFF_AGE,0) NB_MOTHER_CUTOFF_AGE, NB_MIN_GEST_BET_2_DELY, UNIT_OF_GEST_NB, nvl(NB_FATHER_MIN_AGE,0) NB_FATHER_MIN_AGE, MAX_MULTIPLE_BIRTH_REGN_HRS FROM mp_param where module_id='MP'"); 						
						try{
							if(func!=null & func.equals("NEWBORN_REG")){
								/*
								String mcModuleSQL="select count(module_id) countNo from sm_module where module_id='MC' and install_yn='Y'";
								pstmt=conn.prepareStatement(mcModuleSQL);
								rs=pstmt.executeQuery();
								if(rs!=null && rs.next()){
								*/
									//String CountNo=rs.getString("countNo");
									if(CountNo.equals("1")) {
										cstmt=conn.prepareCall("{call MP_VALIDATE_NB_REG( ?,?,?)}");
										cstmt.setString(1,pat_id);
										cstmt.registerOutParameter(2,java.sql.Types.INTEGER);
										cstmt.registerOutParameter(3,java.sql.Types.VARCHAR) ;
										cstmt.execute() ;
										int mc_cycle_number=cstmt.getInt(2);
										String msg=cstmt.getString(3);
										session.putValue("mc_cycle_number",new Integer(mc_cycle_number));
										if(msg!=null && !msg.equals("")){
											out.println("<script>alert(getMessage('"+msg+"','MP'))</script>");
											flag		= "false";
											return;
										}else{
											session.putValue("dft_vlaues_from_mc","Y");
										}
									}
								//}
							}
						}catch(Exception ex){
							ex.printStackTrace();
							//out.println("<script>alert('Exception in prepared statement')</script>");
							//flag		= "false";
							//return;
						}
					} 
					/*
					else if(sex_det.equals("M")){
						pstmt_chk_age = conn.prepareStatement("select nvl(NB_FATHER_MIN_AGE,0)NB_FATHER_MIN_AGE from mp_param where module_id='MP'"); 
					} 
					*/
					//rs_chk_age = pstmt_chk_age.executeQuery(); 
					if(sex_det.equals("M")){	 			    
						//father_min_age = rs_chk_age.getInt("NB_FATHER_MIN_AGE");
						if(father_age < father_min_age){
							out.println("<script>var msg=getMessage('FATHER_AGE_PARAM','MP');alert(msg)</script>"); 
							flag = "false";
							age_flag	= "true";
							age_flag1	= "true";
						}			
					}					
					if(flag=="true"){
						//if(rs_chk_age.next()){

							/*
							mother_min_age				= rs_chk_age.getInt("NB_MOTHER_MIN_AGE"); 	
							mother_max_age				= rs_chk_age.getInt("NB_MOTHER_UPPER_AGE"); 
							mother_cutoff_age			= rs_chk_age.getInt("NB_MOTHER_CUTOFF_AGE");
							min_gest_bet_del			= rs_chk_age.getDouble("NB_MIN_GEST_BET_2_DELY");
							MAX_MULTIPLE_BIRTH_REGN_HRS	= rs_chk_age.getDouble("MAX_MULTIPLE_BIRTH_REGN_HRS");
							*/
						if(sex_det.equals("F")){	
							if((mother_cutoff_age > 0) && (min_age < mother_cutoff_age))
							{
								// Mother's age shd be > MP Param value
								out.println("<script>var msg=getMessage('MOTHER_AGE_PARAM','MP');alert(msg)</script>");   
								flag		= "false";
								age_flag	= "true";
								age_flag1	= "true";
							}
							else if((mother_min_age > 0) && (min_age < mother_min_age))
							{
								//** The alert is just for warning. When pressed ok it will proceed further.**//

								out.println("<script>var msg=getMessage('MOTHER_CUTOFF_AGE','MP');alert(msg)</script>");  
								flag		= "true";
								age_flag	= "false";
								age_flag1	= "false";
							}
							else if ((mother_max_age > 0) && (min_age > mother_max_age))
							{
								out.println("<script>var msg=getMessage('MOTHER_MAX_AGE','MP');alert(msg)</script>");	
								flag		= "false";
								age_flag	= "true";
								age_flag1	= "true";
							}

							else if((mother_max_age > 0) && (min_age == mother_max_age))
							{
								if(min_age1 > 0)
								{
									out.println("<script>var msg=getMessage('MOTHER_MAX_AGE','MP');alert(msg)</script>");	
									flag		= "false";
									age_flag	= "true";
									age_flag1	= "true";
								}
								else if((min_age1 == 0) && (min_age2 > 0))
								{	
									out.println("<script>var msg=getMessage('MOTHER_MAX_AGE','MP');alert(msg)</script>");	
									flag		= "false";
									age_flag	= "true";
									age_flag1	= "true";
								}
								else flag = "true";
							}
							else flag = "true";

						  //}
							if(flag == "true") 
							{
								try 
								{
									int noofmultibabiesregistered = 0;
									//pstmtTEMP = conn.prepareStatement("select count(*) from mp_birth_register where mother_patient_id=?");

									pstmt = conn.prepareStatement(" select no_of_multi_babies_regd, round(abs(sysdate - TIME_OF_BIRTH)*24,2) diffHours, patient_id last_nb_ID, birth_order last_nb_order, no_of_births, multiple_birth_yn from mp_birth_register where mother_patient_id = ? order by ADDED_DATE DESC ");

									pstmt.setString(1,pat_id);
									rs=pstmt.executeQuery();

									if(rs!=null && rs.next())
									{
										/*
										count = rs.getInt(1);
									}
									if(count > 0)
									{
										
										int noofmultibabiesregistered = 0;										

										pstmt = conn.prepareStatement("Select no_of_multi_babies_regd from mp_birth_register where mother_patient_id = ? order by ADDED_DATE DESC");
										
										pstmt.setString(1,pat_id);
										rs = pstmt.executeQuery();
										if(rs != null && rs.next()){
											noofmultibabiesregistered = rs.getInt(1);
										}									

										pstmtGest1=conn.prepareStatement ("SELECT round(abs(sysdate - max(TIME_OF_BIRTH))*24,2) diffHours,max(patient_id) last_nb_ID,max(birth_order) last_nb_order, max(no_of_births) no_of_births, max(multiple_birth_yn) multiple_birth_yn FROM MP_BIRTH_REGISTER WHERE MOTHER_PATIENT_ID=?");
										
										pstmtGest1.setString(1,pat_id);
										rsGest1 = pstmtGest1.executeQuery();

										if(rsGest1.next())
										{
											*/
											noofmultibabiesregistered = rs.getInt("no_of_multi_babies_regd");
											diffHours			= rs.getDouble("diffHours");
											last_nb_order		= rs.getInt("last_nb_order");
											no_of_births		= rs.getInt("no_of_births");
											multiple_birth_yn	= rs.getString("multiple_birth_yn");									
										//}
										last_nb_order			= last_nb_order;
										no_of_births			= no_of_births;									
										diffWeeks					= (double)diffHours/(24*7);						
										diffDays				= diffWeeks * 7;
										min_gest_bet_del_days	= min_gest_bet_del * 7;					
										if(multiple_birth_yn.equals("N"))
										{	
											if((diffWeeks <= min_gest_bet_del) || (diffDays <= min_gest_bet_del_days))
											{	
												out.println("<script>var msg=getMessage('DIFF_BET_TWO_DELY','MP');alert(msg)</script>");	
												flag= "false";
												age_flag	= "true";
												age_flag1	= "true";
											}
										}
										else 
										{						
											if(noofmultibabiesregistered > 0)
											{
												if(MAX_MULTIPLE_BIRTH_REGN_HRS > 0)
												{
													if(sub_multi_birth_hw.equals("H")){
														if(diffHours > MAX_MULTIPLE_BIRTH_REGN_HRS){  												
															out.println("<script>var msg=getMessage('SUBSEQUENT_DELY','MP');alert(msg)</script>");
															flag		= "false";
															age_flag	= "true";
															age_flag1	= "true";														
														}
													}else if(sub_multi_birth_hw.equals("W")){
														if(diffWeeks > MAX_MULTIPLE_BIRTH_REGN_HRS){  																
															out.println("<script>var msg=getMessage('SUBSEQUENT_DELY','MP');alert(msg)</script>");
															flag		= "false";
															age_flag	= "true";
															age_flag1	= "true";														
														}
													}
												}
											}
											else if(noofmultibabiesregistered == 0)
											{
												if((diffWeeks <= min_gest_bet_del) && (diffDays <= min_gest_bet_del_days))
												{ 
													out.println("<script>var msg=getMessage('DIFF_BET_TWO_DELY','MP');alert(msg)</script>");
													flag		= "false";
													age_flag	= "true";
													age_flag1	= "true";
												}
											}
											else
											{	
												flag		= "true";
												age_flag	= "false";
												age_flag1	= "false";
											}
										}
									} //end if count > 0
								}
								catch(Exception e) {out.println(e.toString());}
							}
						}
						//}
					}
				} //end try
				catch(Exception e) {out.println(e.toString());}
			}//end if
		}
		else 
		{					
			flag		= "true";
			age_flag	= "false";
			age_flag1	= "false";  
		}
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
	finally
	{
		//if(rs_sex != null) rs_sex.close();
		//if(pstmtSex != null) pstmtSex.close();
		if (pstmt8 != null) pstmt8.close();
		if (rs8 != null) rs8.close();

		if(pstmt!=null) pstmt.close();
		if (rs != null) rs.close();	

		//if (rs_chk_age != null) rs_chk_age.close();
		//if (pstmtTEMP != null) pstmtTEMP.close();
		//if (pstmt_chk_age !=null) pstmt_chk_age.close();
		//if (pstmtGest1 != null) pstmtGest1.close();
		if (rsGest != null) rsGest.close();
		//if (rsGest1 != null) rsGest1.close();
		//if (rsTEMP != null) rsTEMP.close();
		ConnectionManager.returnConnection(conn,request);
	}
	if(sflag.equals("") || sflag.equals("undefined")){
		if(retback.equals("retback")){
			%>
			<script>
				var cflag  = '<%=age_flag%>';
				var cflag1 = '<%=age_flag1%>';
				if('<%=function_id%>' != 'PAT_REG'){
					if(cflag == "false"){
						aa('<%=flag%>');
					}else if('<%=sex_det%>' == 'F'){	
						if(cflag1 == "false"){		
							alert(getMessage("MOTHER_AGE_PARAM",'MP'));
						}
					}
				}
			</script>
			<%
		}
		else
		{
			%>
			<script>
				var cflag = '<%=age_flag%>';
				var cflag1 = '<%=age_flag1%>';
				if('<%=function_id%>' != 'PAT_REG'){
					if(cflag=="false"){
						returnPatient("<%=pat_id%>",'<%=flag%>');
					}else if('<%=sex_det%>' == 'F'){
						if(cflag1 == "false"){					
							alert(getMessage("MOTHER_AGE_PARAM",'MP'));
						}
					}
				}
			</script>
			<%
		}
	}else if(flag.equals("true")){
		out.println("<script>callMenu('"+sflag+"',\""+pat_id+"\");</script>");
	}
	if(!IPValue.equals("")){
		if (flag.equals("true")){
			out.println("<script>showRegisterNewBorn('"+pat_id+"');</script>");
		}else{
			return;
		}
	}
%>
</body>
</html> 

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

