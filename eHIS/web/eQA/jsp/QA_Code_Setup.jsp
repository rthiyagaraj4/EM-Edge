<!DOCTYPE html>
<html>
	<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<style>
		A:active { 
			COLOR: white; 
		}
	</style>
		
	<script language="JavaScript">
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();
	function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR"
				prev=ro.rowIndex;
			
		}

		function callJSPs(val)
		{
			
			if(val == 'QA_QIND_GROUP'){
			 parent.frames[1].location.href ='../../eQA/jsp/QAIndicatorGroup.jsp?module_id=QA&function_id=QA_QIND_GROUP&function_name=Indicator Group&function_type=F&access=YYYNN';
			
			}

			if(val == 'QA_QIND_CLIND'){
			 parent.frames[1].location.href='../../eQA/jsp/QAIndicator.jsp?module_id=QA&function_id=QA_QIND_CLIND&function_name=Indicator&function_type=F&access=YYYNN';
			
			}
			if(val == 'QA_QIND_DISCIPLINE'){
			 parent.frames[1].location.href='../../eQA/jsp/QADiscipline.jsp?module_id=QA&function_id=QA_QIND_DISCIPLINE&function_name=Discipline&function_type=F&access=YYYNN';
			
			
			}
		

			if(val == 'QA_QIND_FACILITY_CLIND'){
			 parent.frames[1].location.href='../../eQA/jsp/QAIndicatorsForFacility.jsp?module_id=QA&function_id=QA_QIND_ASSOCIATE_FACILITY&function_name=Indicators for Facility&function_type=F&access=YYYNN';
			
			
			}
			if(val == 'QA_ASSO_COMP_IND'){
				parent.frames[1].location.href='../../eQA/jsp/QAComplicationsForIndicator.jsp?module_id=QA&function_id=QA_ASSO_COMP_IND&function_name=Complications for Indicator&function_type=F&access=YYYNN';
			
			
			}
          
		  if(val == 'QA_QIND_CLIND_DIAG_PROC'){
				parent.frames[1].location.href='../../eQA/jsp/QADiagProcForIndicator.jsp?module_id=QA&function_id=QA_ASSO_COMP_IND&function_name=Diag/Procedures for Indicator&function_type=F&access=YYYNN';
			
			
			}
			if(val == 'QA_QIND_DISCIPLINE_CLIND'){
				parent.frames[1].location.href='../../eQA/jsp/QAIndicatorsForDiscipline.jsp?module_id=QA&function_id=QA_ASSO_COMP_IND&function_name=Indicators for Discipline&function_type=F&access=YYYNN';
					
			}
		
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body style="background-color:dimgray;" onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
	<form name="SMMasterMenu_form" id="SMMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>

			<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('QA_QIND_GROUP')" >Indicator Group</a></td>
			</tr>
			<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('QA_QIND_CLIND')" > Indicator</a></td>
			</tr>
			<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('QA_QIND_CLIND_DIAG_PROC')" >Diag/Procedures for Indicator</a></td>
			</tr>
			<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('QA_QIND_DISCIPLINE')" >Discipline</a></td>
			</tr>

		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('QA_QIND_DISCIPLINE_CLIND')" >Indicators for Discipline</a></td>
		</tr>

		
		
				<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("QA_QIND_FACILITY_CLIND")' >Indicators for Facility</a></td>
		</tr>
		
				<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='javascript:callJSPs("QA_ASSO_COMP_IND")' >Complications for Indicator</a></td>
		</tr>
		 
		
		<tr>
			<td class='MENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><b>MENU</b></a></td> 
	</tr>
		</table>

	</body>
	
	</form>
</html>

