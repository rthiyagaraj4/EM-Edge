 <%@page import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	String validate = request.getParameter( "validate" ) ;
	String flag_From_To = request.getParameter( "flag_From_To" ) ;


	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	ConstituentPrecipitationLimitBean bean = (ConstituentPrecipitationLimitBean)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);

	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;

	if (validate.equals("POPULATE_MOLE")){

				String Gen_Name_Limit = request.getParameter("Gen_Name_Limit");
				String cnt = request.getParameter("cnt");
			
		
				if(flag_From_To.equals("F") )
				{
				//out.println("eval('document.FormConstituentPresLimitAddmodify.Mol_Name_From'); ");
				out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_From_"+cnt+"'); ");
				//out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM_"+cnt+".value=''; ");
				}
				if(flag_From_To.equals("T") )
				{
				//out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_To'); ");
				out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_To_"+cnt+"'); ");
				//out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_UOM_"+cnt+".value=''; ");
				}
					
				ArrayList mol_names = bean.getConstituentMoleculeName(Gen_Name_Limit);
				

	
				if(mol_names.size()>0)
				{
				for(int i=0; i< mol_names.size(); i=i+2) {
					if(flag_From_To.equals("F"))
					{

					//out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_From_"+cnt+"'); ");
					out.println("addListItem(\"FormConstituentPresLimitAddmodify.Mol_Name_From_"+cnt+"\", \"" + mol_names.get(i) + "\",\"" + mol_names.get(i+1) + "\");");
				
					}
					else
					{
					//out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_To_"+cnt+"'); ");
					out.println("addListItem(\"FormConstituentPresLimitAddmodify.Mol_Name_To_"+cnt+"\", \"" + mol_names.get(i) + "\",\"" + mol_names.get(i+1) + "\");");
				
					}
				}
				}else
				{
				if(flag_From_To.equals("F"))
					{
					out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_From_"+cnt+"'); ");
					}else
					{
					out.println("clearListItems('document.FormConstituentPresLimitAddmodify.Mol_Name_To_"+cnt+"'); ");
					}
				}
			}
			if (validate.equals("CONST_GENRIC_UOM")){


				String cnt = request.getParameter("cnt");
				String Gen_To_UOM = (request.getParameter("Gen_To_UOM"));
				String Gen_To_UOM_code = request.getParameter("Gen_To_UOM_code");
				String Gen_UOM_conv_litre = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PerLitre.label","ph_labels");
				String Gen_UOM_conv_decilitre = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Perdecilitre.label","ph_labels");
		
				
				out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_UOM_"+cnt+".value = '"+Gen_To_UOM_code+"';");
			

				if(Gen_To_UOM.equals("MMOL"))
				{
				out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM_Conv_"+cnt+".value = '"+Gen_UOM_conv_litre+"';");
				out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_UOM_Conv_"+cnt+".value = '"+Gen_UOM_conv_litre+"';");
				}else
				{
				out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_From_UOM_Conv_"+cnt+".value = '"+Gen_UOM_conv_decilitre+"';");
				out.println("document.FormConstituentPresLimitAddmodify.Con_ConCen_To_UOM_Conv_"+cnt+".value = '"+Gen_UOM_conv_decilitre+"';");
				}
		
			}


			if (validate.equals("CONST_GENRIC_RANGE")){


				String num = request.getParameter("num");
				String Con_ConCen_Min = (String)request.getParameter("Con_ConCen_Min")==null?"":(String) request.getParameter("Con_ConCen_Min");
				String Con_ConCen_Max = (String)request.getParameter("Con_ConCen_Max")==null?"":(String) request.getParameter("Con_ConCen_Max");
				String Gen_Name_Limit_From = (String)request.getParameter("Gen_Name_Limit_From")==null?"":(String) request.getParameter("Gen_Name_Limit_From");
				String Gen_Name_Limit_To = (String)request.getParameter("Gen_Name_Limit_To")==null?"":(String) request.getParameter("Gen_Name_Limit_To");
				String chkFlag = request.getParameter("chkFlag");
				String uom = request.getParameter("uom");
		
				if(!(Con_ConCen_Min.equals("")) && !(Con_ConCen_Max.equals("")))
				{
				
					float Con_Con_Min =Float.parseFloat(Con_ConCen_Min) ;
					float Con_Con_Max = Float.parseFloat(Con_ConCen_Max) ;
		
				    boolean validRange= bean.getRangeOverlapValidate((ArrayList)bean.getConstituentRange(Gen_Name_Limit_From,Gen_Name_Limit_To,chkFlag),Con_Con_Min,Con_Con_Max,uom);

				
				
					 if(validRange)
						{
							out.println("callInfo("+num+",\""+chkFlag+"\");") ;
							
						}
				
			
				}
		
			}
		






putObjectInBean(bean_id,bean,request);
%>
