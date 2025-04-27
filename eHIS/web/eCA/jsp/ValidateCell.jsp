<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%! int maxrow=0; %>
<%! int maxcolumn=0; %>



<%! boolean print=true; %>
<%! boolean value=false; %>
<%! boolean submitvalue=false; %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCommon.RecordSet SubSecRecordSet = (webbeans.eCommon.RecordSet)getObjectFromBean("SubSecRecordSet","webbeans.eCommon.RecordSet",session);
	webbeans.eCommon.RecordSet SubSecondRecordSet = (webbeans.eCommon.RecordSet)getObjectFromBean("SubSecondRecordSet","webbeans.eCommon.RecordSet",session);
	webbeans.eCommon.RecordSet FinalBean = (webbeans.eCommon.RecordSet)getObjectFromBean("FinalBean","webbeans.eCommon.RecordSet",session);
%>


<html>
	<head> 
		
		<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/ChartHistoryTemplate.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	</head>
		
	<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
		<form name="Temp_form" id="Temp_form" action="../../servlet/eCA.ChartHistoryTemplateServlet" target="messageFrame" method ="post">

<%
			String row_pos_h ="",cols_pos_h = "",row_span_h ="",col_span_h = "",cont_id="";
			int prev_row_pos_h=0,prev_cols_pos_h=0,prev_row_span_h=0, prev_col_span_h=0;
			int  prev_cont_id_sec=0;
			int rowpos,	colpos,	rowspan ,		colspan  ;

			
			int xval = 0;
			
			StringTokenizer stoken_code_value = null,stoken_code = null;
			String sel_code_seq="";
			HashMap htRecord = null,htRecord_atl = null;
			
			//String row_pos="",row_span="",col_span="";
			
			String SelectYNStr			=	request.getParameter("SelectYNStr"); 
			
	
			if(SelectYNStr == null || SelectYNStr.equals("null"))  SelectYNStr="";
			String maxr = request.getParameter("rows"); 
			String maxc = request.getParameter("cols"); 

			String summarydesc=request.getParameter("summarydesc")==null?"":request.getParameter("summarydesc");
			String value1="";
			maxrow = (Integer.parseInt(maxr));
			maxcolumn = (Integer.parseInt(maxc));
			if(!(SelectYNStr.equals(""))){
						SubSecRecordSet.clearAll();
						stoken_code			=	new StringTokenizer(SelectYNStr,"~");
						int count_code		=	stoken_code.countTokens();
						if(SubSecRecordSet.getSize() > 0) SubSecRecordSet.clearAll();
						if(SubSecondRecordSet.getSize() > 0) SubSecondRecordSet.clearAll();
						if(FinalBean.getSize() > 0) FinalBean.clearAll(); 
						for(int i=0;i<count_code;i++){
								sel_code_seq		=	stoken_code.nextToken();
								value1 = sel_code_seq;
								stoken_code_value		=	new StringTokenizer(value1,"||");
								row_pos_h = stoken_code_value.nextToken();
								if((Integer.parseInt(row_pos_h)) == 0){ 
								}else{
									cols_pos_h = stoken_code_value.nextToken();
									row_span_h = stoken_code_value.nextToken();
									col_span_h = stoken_code_value.nextToken();
									cont_id    = stoken_code_value.nextToken();	
									htRecord = new HashMap();
									htRecord.put("row_pos",row_pos_h);
									htRecord.put("cols_pos",cols_pos_h);
									htRecord.put("row_span",row_span_h);
									htRecord.put("col_span",col_span_h);
									htRecord.put("cont_id",cont_id);
									SubSecRecordSet.putObject(htRecord);
							}	
					}
			}

		putObjectInBean("SubSecRecordSet",SubSecRecordSet,session);

		try{
			 
			
			 
			 
 			int testArray[][]=new int[maxrow][maxcolumn];
			int i1,j1;
			for( i1=0;i1<maxrow;i1++){
					for( j1=0;j1<maxcolumn;j1++){
							testArray[i1][j1]=0	;
				}
			}

			String row_pos_return, cols_pos_h_return, row_span_h_return, col_span_h_return, cont_id_sec;
			 for(int i=0; i<SubSecRecordSet.getSize(); i++){
					boolean flag=false;
					htRecord_atl   = (HashMap)SubSecRecordSet.getObject(i);
					row_pos_return		= (String)htRecord_atl.get("row_pos");
					cols_pos_h_return  = (String)htRecord_atl.get("cols_pos");  
					row_span_h_return	= (String)htRecord_atl.get("row_span");
					col_span_h_return	= (String)htRecord_atl.get("col_span"); 
					cont_id_sec				= (String)htRecord_atl.get("cont_id"); 
					prev_row_pos_h		= (Integer.parseInt(row_pos_return));
					prev_cols_pos_h		= (Integer.parseInt(cols_pos_h_return));
					prev_row_span_h	= (Integer.parseInt(row_span_h_return));
					prev_col_span_h		= (Integer.parseInt(col_span_h_return));
					prev_cont_id_sec	= (Integer.parseInt(cont_id_sec));
					rowpos      = (Integer.parseInt(row_pos_return));
					colpos     = (Integer.parseInt(cols_pos_h_return));
					rowspan    = (Integer.parseInt(row_span_h_return));
					colspan     = (Integer.parseInt(col_span_h_return));
					rowpos=rowpos-1;
					colpos=colpos-1;

					if((rowpos+rowspan)>maxrow)  flag=true;
					if((colpos+colspan)>maxcolumn) flag=true;
					if (flag){	%>
						<script>
								var msg=getMessage("WRONG_ROW_COLUMN_VALUES",'CA');
								if (msg!=""){
										parent.parent.frames[2].messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
								}
								eval("parent.frames[1].frames[1].document.forms[0].row_pos"+<%=xval%>+".focus()");
						</script>
					<%}
	
					for( i1=rowpos;i1<(rowpos+rowspan);i1++){
						for( j1=colpos;j1<(colpos+colspan);j1++){
								if(testArray[i1][j1]==1){
										flag=true;
										break;
								}else{
										testArray[i1][j1]=1;
								}
						}
						if (flag) break;
					}

					if (flag){%>
							<script>
									var msg=getMessage("WRONG_ROW_COLUMN_VALUES",'CA');
									if (msg!=""){
										parent.parent.frames[2].messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
									}
									eval("parent.frames[1].frames[1].document.forms[0].row_pos"+<%=xval%>+".focus()");
							</script>
				<%}
				
				if(!value){
							HashMap finalcount = new HashMap();
							finalcount.put("prev_row_pos_h",new Integer(prev_row_pos_h));
							finalcount.put("prev_cols_pos_h",new Integer(prev_cols_pos_h));
							finalcount.put("prev_row_span_h",new Integer(prev_row_span_h));
							finalcount.put("prev_col_span_h",new Integer(prev_col_span_h));
							finalcount.put("prev_cont_id_sec",new Integer(prev_cont_id_sec));
							FinalBean.putObject(finalcount);
							print = true;	
					}
				
				value = false;
				submitvalue = true;
			 }

			boolean flag1=false;
			/*for( i1=0;i1<maxrow;i1++){  // CHECKING for whether all the cells are filled or not.
						for( j1=0;j1<maxcolumn;j1++){
							out.println("<script language=javascript>alert("+testArray[i1][j1]+")</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


");
						}
				}*/

				for( i1=0;i1<maxrow;i1++){  // CHECKING for whether all the cells are filled or not.
						for( j1=0;j1<maxcolumn;j1++){
									if(testArray[i1][j1]==0){ 
											flag1=true;			
											break;
								}
						}
					if (flag1) break;
				}

				if (flag1){%>
							<script>
									var msg=getMessage("VAL_NOT_BLANK",'CA');
									if (msg!=""){
											parent.parent.frames[2].messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
									}
									eval("parent.frames[1].frames[1].document.forms[0].row_pos"+<%=xval%>+".focus()");
							</script>
				 <% }

			/*HashMap finalcounting = null;
			for(int i=0; i<FinalBean.getSize(); i++){
					finalcounting   = (java.util.HashMap)FinalBean.getObject(i);
					 int cols_pos_h_return_int	= ((Integer)finalcounting.get("prev_cols_pos_h")).intValue() ;
					 int row_pos_return_int    = ((Integer)finalcounting.get("prev_row_pos_h")).intValue(); 	 
					 int col_span_h_return_int	= ((Integer)finalcounting.get("prev_col_span_h")).intValue();
					 int row_span_h_return_int	= ((Integer)finalcounting.get("prev_row_span_h")).intValue(); 
					 int prev_cont_id_sec_int    = ((Integer)finalcounting.get("prev_cont_id_sec")).intValue(); 
			}*/
	
	putObjectInBean("FinalBean",FinalBean,session);

	}catch(Exception e){
			//out.println("Exception@2: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
	}finally {  %>
             <script>
					if(<%=submitvalue%>){
							
							parent.frames[1].frames[1].document.forms[0].summarydesc.value='<%=summarydesc%>'
							parent.frames[1].frames[1].document.forms[0].submit();
					}
			</script>
<%}%>
</script> 
</form>
</body>
</html>

