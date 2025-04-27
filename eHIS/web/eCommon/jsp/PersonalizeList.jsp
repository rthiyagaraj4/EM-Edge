<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> New Document </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	String persFrom=request.getParameter("persFrom")==null?"":request.getParameter("persFrom");
	String called_from=request.getParameter("persFrom")==null?"":request.getParameter("called_from");
	
%>

<SCRIPT LANGUAGE="JavaScript">

	async	function toolFunction(opt) {  
			if(opt ==1) {
				var retVal = new Array();
			var features	= 'dialogHeight:20; dialogWidth:28;dialogTop:150;status=no;scroll=no';
			var arguments	= '' ;
			retVal =await window.showModalDialog('../../eSM/jsp/change_password_frames.jsp',arguments,features);
			//window.location.href='../../eSM/jsp/change_password.jsp'
			}
			if(opt ==2 ){
				//color theme
				if('<%=persFrom%>'=='HomeSummary'){ 
					parent.workAreaFrame.location.href="../../eCommon/jsp/personoliseTheme.jsp?mode=view&persFrom=<%=persFrom%>";
					parent.CommonToolbar.document.getElementById("dispname").innerHTML = '';
				}else{ 
					parent.parent.frames[2].location.href="../../eCommon/jsp/personoliseTheme.jsp?mode=view"
				} 
			}
			if(opt ==3 ){
				if('<%=persFrom%>'=='HomeSummary'){
					//parent.workAreaFrame.location.href='../../eSM/jsp/FreqAccessFunc.jsp?module_id=SM&function_id=FREQ_ACCESS_FUNC&function_name='+encodeURIComponent(getLabel("Common.frequentlyAccessedFunctions.label","common"))+'&function_type=F&access=YYNNY&persFrom=<%=persFrom%>'
					parent.workAreaFrame.location.href='../../eSM/jsp/FreqAccessFunc.jsp?module_id=SM&function_id=FREQ_ACCESS_FUNC&function_name='+encodeURIComponent(getLabel("Common.frequentlyAccessedFunctions.label","common"))+'&function_type=F&access=YYNNY&persFrom=<%=persFrom%>';
					parent.CommonToolbar.document.getElementById("dispname").innerHTML = '';
				}else{
					parent.parent.frames[2].location.href='../../eSM/jsp/FreqAccessFunc.jsp?module_id=SM&function_id=FREQ_ACCESS_FUNC&function_name='+encodeURIComponent(getLabel("Common.frequentlyAccessedFunctions.label","common"))+'&function_type=F&access=YYNNY'
				}
		//parent.parent.frames[1].expand()
			}
		if(opt ==4 ){			
			if('<%=persFrom%>'=='HomeSummary'){
				
				if ("<%=called_from%>"  == "CA")
				{
					if (top.window.top.content.CommonToolbar.pat_info != null ){
						var pat_info_temp = new Array();						
						pat_info_backup = top.window.top.content.CommonToolbar.pat_info;
						var j=0 ;
						var pat_info_len;
						if( top.window.top.content.CommonToolbar.pat_info != null)
							pat_info_len = top.window.top.content.CommonToolbar.pat_info.length;

						if(top.window.top.content.CommonToolbar.pat_info != null)
						{
						  for(var i=0;i<pat_info_len;i++)
						  {
							 if(!top.window.top.content.CommonToolbar.pat_info[i].window_obj.closed  )
								{
								  pat_info_temp[j] = top.window.top.content.CommonToolbar.pat_info[i]
								  j++
								}
							}
						}
						top.window.top.content.CommonToolbar.pat_info = pat_info_temp;						
						if (top.window.top.content.CommonToolbar.pat_info.length >0){							
							alert(getMessage("CANNOT_SWITCH_LANG","COMMON"));							
						}else{
							parent.workAreaFrame.location.href='../../eCommon/jsp/SwitchLanguage.jsp?module_id=SM&function_id=SWITCH_LANG&function_name='+encodeURIComponent(getLabel("Common.switchlanguage.label","common"))+'&function_type=F&access=NYNNY&persFrom=<%=persFrom%>';
						}
					}
					
					
				}else	{	
					parent.workAreaFrame.location.href='../../eCommon/jsp/SwitchLanguage.jsp?module_id=SM&function_id=SWITCH_LANG&function_name='+encodeURIComponent(getLabel("Common.switchlanguage.label","common"))+'&function_type=F&access=NYNNY&persFrom=<%=persFrom%>';
				}
						parent.CommonToolbar.document.getElementById("dispname").innerHTML = '';
			}else{
				
				parent.parent.frames[2].location.href='../../eCommon/jsp/SwitchLanguage.jsp?module_id=SM&function_id=SWITCH_LANG&function_name='+encodeURIComponent(getLabel("Common.switchlanguage.label","common"))+'&function_type=F&access=NYNNY'
			}
		//parent.parent.frames[1].expand()
			}
		}

</SCRIPT>

<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";		
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script type='text/javascript' src='../../eCommon/js/dtree.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
</HEAD>

<BODY class='NavigIconsBorderTop' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<script>
		d = new dTree('freqd');
		d.config.useStatusText=true;
		d.add(0,-1,"<b>"+getLabel('Common.personalizeoptions.label','common')+"</b>");
		d.add(1,0,getLabel('Common.changepassword.label','common'),"javascript:toolFunction(1)",'','');
		//d.add(2,0,'Color Theme',"javascript:toolFunction(2)",'','');
		<%if(persFrom.equals("HomeSummary")){
		}else{%>
		d.add(2,0,getLabel('Common.frequentlyAccessedFunctions.label','common'),"javascript:toolFunction(3)",'','');
		<%}%>
		d.add(3,0,getLabel('Common.colortheme.label','common'),"javascript:toolFunction(2)",'Personalize look and feel, choose your favorite theme','');
		d.add(4,0,getLabel('Common.switchlanguage.label','common'),"javascript:toolFunction(4)",'Switch Language',''); 
console.log(d);
console.log(dTree);
document.write(d);
</script>
</BODY>
</HTML>

