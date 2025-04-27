<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<%

Connection con             = null;
ResultSet rs	           = null;
java.sql.Statement stmt	   = null;

String locale=(String)session.getAttribute("LOCALE"); 
String	 facilityId 	= (String) session.getValue( "facility_id" ) ;
String sql         = "";
String postmortem_reqd_yn = "N";
String area_code         ="";
String area_type="";
String CLAIMANT_TYPE="";
request.setCharacterEncoding("UTF-8");
String popareaforbprt=request.getParameter("popareaforbprt")==null?"":request.getParameter("popareaforbprt");
String area_code1           = request.getParameter("area_code")==null?"":request.getParameter("area_code");

String area_desc           = null;
String startendstat=request.getParameter("startendstat")==null?"":request.getParameter("startendstat");
postmortem_reqd_yn=request.getParameter("postmortem_reqd_yn")==null||request.getParameter("postmortem_reqd_yn").equals("")?"N":request.getParameter("postmortem_reqd_yn");
CLAIMANT_TYPE = request.getParameter("CLAIMANT_TYPE")==null?"":request.getParameter("CLAIMANT_TYPE");

try
{
	if(area_code1.equals(""))
	{
	
	if (postmortem_reqd_yn.equalsIgnoreCase("Y")){
    sql="select area_type, area_code, long_desc from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and facility_id = '"+facilityId+"' and eff_status='E' and Area_Type not in ('R') order by long_desc";

   }
   else if (postmortem_reqd_yn.equalsIgnoreCase("N"))
   {
 	sql	=	"select area_type, area_code, long_desc from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and  facility_id = '"+facilityId+"' and eff_status='E' and Area_Type not in ('P') order by long_desc";
    }
	
	}
	else
	{
	 if ((postmortem_reqd_yn.equalsIgnoreCase("Y"))&& (CLAIMANT_TYPE .equalsIgnoreCase("F")))
	{
	 sql	=	"select area_type, area_code, long_desc from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and facility_id = '"+facilityId+"' and  eff_status='E' order by long_desc";
	}
	
	else if (postmortem_reqd_yn.equalsIgnoreCase("Y"))
    {
     sql	=	"select area_type, area_code, long_desc from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and facility_id = '"+facilityId+"' and  eff_status='E' and Area_Type not in ('R') order by long_desc";
    }
	else{
	sql	="select area_type,area_code, long_desc from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and facility_id = '"+facilityId+"' and  eff_status='E' and Area_Type not in ('P') order by long_desc";
	
	}
	
	
	}
	
  if ((startendstat.equalsIgnoreCase("E")))
  {
   sql	=	"select area_type ,area_code, long_desc from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and facility_id = '"+facilityId+"' and  eff_status='E'  order by long_desc";
  }
	
	
  /*  if(postmortem_reqd_yn.equals("Y"))
       sql = "select area_code, short_desc from mo_area where eff_status='E' and area_type not in ('R') order by 2";
    else
       sql = "select area_code, short_desc from mo_area where eff_status='E' and area_type not in ('P') order by 2";*/
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql);
	
	if(popareaforbprt.equals("popareaforbprt"))
	{
	
	out.println("<script>if(parent.frames[3].document.MO_regn_form!=null)");
    out.println("var obj =parent.frames[3].document.MO_regn_form.area_type;else");
	out.println("var obj =parent.frames[3].document.forms[0].area_type");
	out.println("var length  = obj.length;");
	out.println("for(i=0;i<length;i++) {obj.remove(0);}");

	out.println("var element1 = document.createElement('OPTION')");
	out.println("element1.text = '----'+getLabel('Common.defaultSelect.label','Common')+'----'");
	out.println("element1.value= ''");
	out.println("obj.add(element1)");
	out.println("</script>");
	}else
	{
	out.println("<script>if(parent.frames[1].frames[3].document.MO_regn_form!=null)");
    out.println("var obj =parent.frames[1].frames[3].document.MO_regn_form.area_type;else");
	out.println("var obj =parent.frames[1].frames[0].frames[3].document.forms[0].area_type");
	out.println("var length  = obj.length;");
	out.println("for(i=0;i<length;i++) {obj.remove(0);}");

	out.println("var element1 = document.createElement('OPTION')");
	out.println("element1.text = '----'+getLabel('Common.defaultSelect.label','Common')+'----'");
	out.println("element1.value= ''");
	out.println("obj.add(element1)");
	out.println("</script>");
	}
int i=1;
	while(rs.next())
					{

					 area_type          =rs.getString("area_type")==null?"":rs.getString("area_type");
					 area_code			=	rs.getString("area_code");
					 area_desc	        =	rs.getString("long_desc");
					if(area_code==null || area_code.equals("null"))
						area_code="";
                    if(area_desc==null || area_desc.equals("null"))
						area_desc="";
if(popareaforbprt.equals("popareaforbprt"))
{

	
	
	
	%>
						
<script>
	
var opt= parent.frames[3].document.createElement('Option');


opt.text="<%=area_desc%>"; 
opt.value="<%=area_code%>";
obj.add(opt) ;
if("<%=area_code%>"=="<%=area_code1%>")
{
	
if(("<%=area_type%>"=="P")||("<%=area_type%>"=="R")||("<%=startendstat%>"=="E")||("<%=startendstat%>"=="R")||(parent.frames[3].document.getElementById('mode').value=='viewdata'))
		{
	parent.frames[3].document.MO_regn_form.area_type.options['<%=i%>'].selected=true;
	parent.frames[3].document.MO_regn_form.area_type.disabled=false;
//	if(parent.frames[1].frames[3].document.MO_regn_form.mode.value!="viewdata")
	parent.frames[3].document.MO_regn_form.bed_no.disabled=true;
	parent.frames[3].document.MO_regn_form.bed_button.disabled=true;	
	
		}else{
	parent.frames[3].document.MO_regn_form.area_type.options['<%=i%>'].selected=true;
	parent.frames[3].document.MO_regn_form.area_type.disabled=false;
//	if(parent.frames[1].frames[3].document.MO_regn_form.mode.value!="viewdata")
	parent.frames[3].document.MO_regn_form.bed_no.disabled=false;
	parent.frames[3].document.MO_regn_form.bed_button.disabled=false;	
		
		
		
		}


}
</script>						


<% i++;}else{	%>
<script>
var opt= parent.frames[1].frames[2].document.createElement('Option');

opt.text="<%=area_desc%>"; 
opt.value="<%=area_code%>";
obj.add(opt) ;


if("<%=area_code%>"=="<%=area_code1%>")
{
if(parent.frames[1].frames[3].document.MO_regn_form!=null)
	{
	
	parent.frames[1].frames[3].document.MO_regn_form.area_type.options['<%=i%>'].selected=true;
	//parent.frames[1].frames[3].document.MO_regn_form.area_type.disabled=true;
//	if(parent.frames[1].frames[3].document.MO_regn_form.mode.value!="viewdata")
	
	
	if(("<%=area_type%>"=="P")||("<%=area_type%>"=="R")||("<%=startendstat%>"=="E")||("<%=startendstat%>"=="R")||(parent.frames[1].frames[3].document.getElementById('mode').value=='viewdata') )
		{
			if(parent.frames[1].frames[3].document.MO_regn_form.area_type)
			{
				if(parent.frames[1].frames[3].document.MO_regn_form.postmortem_reqd_yn.value!='Y')
				{parent.frames[1].frames[3].document.MO_regn_form.area_type.disabled=true;}
				else{parent.frames[1].frames[3].document.MO_regn_form.area_type.disabled=false;}
				

				if( parent.frames[1].frames[3].document.MO_regn_form.area_type.value!="" && parent.frames[1].frames[3].document.MO_regn_form.bed_no.value=="")
				{
					parent.frames[1].frames[3].document.MO_regn_form.bed_no.disabled=false;
					parent.frames[1].frames[3].document.MO_regn_form.bed_button.disabled=false;
				}	
				else
				{
					parent.frames[1].frames[3].document.MO_regn_form.bed_no.disabled=true;
					parent.frames[1].frames[3].document.MO_regn_form.bed_button.disabled=true;
				}
			}
					
				
		}
		else{
		
	parent.frames[1].frames[3].document.MO_regn_form.bed_no.disabled=false;
	parent.frames[1].frames[3].document.MO_regn_form.bed_button.disabled=false;
	parent.frames[1].frames[3].document.MO_regn_form.area_type.disabled=false;
		}
	}
else
	{
parent.frames[1].frames[0].frames[3].document.forms[0].area_type.options['<%=i%>'].selected=true
	}

}
parent.frames[1].frames[2].document.createElement('Option');
</script>					
				<%   i++;} }

				if(!popareaforbprt.equals("popareaforbprt"))
					{
				out.println("<script>parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'</script>");
					}


    if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();
 }
 catch(Exception ee)
 {
	out.println("Exception in MOPopulateArea"+ee.getMessage());
	ee.printStackTrace();
 }
finally
{
   ConnectionManager.returnConnection(con,request);
}
%>


