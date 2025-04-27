<%@page  import=" eMM.*,eMM.Common.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"
contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
	UserAccessForMaterialGroupBean bean = (UserAccessForMaterialGroupBean)getBeanObject( "UserAccessForMaterialGroupBean","eMM.UserAccessForMaterialGroupBean", request ) ;  
	bean.setLanguageId(locale);
	String validate		=	(String)request.getParameter("validate");
	
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");
	String message			=	"";
	String flag				=	"";
	boolean	result			=	false;
	
	try {
			if(validate.equals("check")) {
			try { 
			result		=	true;
			
			ArrayList		materialGroupList = new ArrayList(bean. getmaterialGroupList());
			String material_group_code= (String)request.getParameter("material_group_code")==null?"":(String)request.getParameter("material_group_code");
			String selected_yn =   (String)request.getParameter("selected")==null?"":(String)request.getParameter("selected");


			String temp_drug_type="";
			int count=0;
			if(!material_group_code.equals("")){
				while((materialGroupList != null) && (count < materialGroupList.size())){
					temp_drug_type = (String)materialGroupList.get(count);
					if(material_group_code.equals(temp_drug_type)){
						if(selected_yn.equals("Y"))
							 materialGroupList.set(count+3, "E");
						else
							 materialGroupList.set(count+3, "D");

						if(materialGroupList.get(count+4).equals("N"))
							materialGroupList.set(count+4, "Y");
						else
							materialGroupList.set(count+4,"N");

					}
					count+=5;
					//index++;
				}
				}
			bean.setmaterialGroupList(materialGroupList);
			}
			catch (Exception exception) {
				message = exception.getMessage();
			}
		}else if(validate.equals("selectesYN")){
			try{
				ArrayList		materialGroupList = new ArrayList(bean. getmaterialGroupList());
				int totalcount=0;
				int count=0;
				while((materialGroupList != null) && (count < materialGroupList.size())){
					if(materialGroupList.get(count+4).equals("Y"))
						totalcount=totalcount+1;
						count+=5;
					}
					flag = totalcount+"";
					//out.println(" assignResult(" + true + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
			}catch(Exception e){
				e.printStackTrace();
			}
	}

	}
	catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean("UserAccessForMaterialGroupBean",bean,request);
%>
