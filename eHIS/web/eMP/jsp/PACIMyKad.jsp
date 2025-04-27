<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eMP.PACIReader.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<% String function_id=request.getParameter("function_id");
//out.println("======jjj"+function_id);
try{
PACIReader tc = new PACIReader();
out.println(tc.getCardReaderValues());
}
catch(Exception e)
	{
	out.println(e.toString());
	}
//out.println("281032704997$SAMAH ABDULHADI ALSAYED ALI$19810327$20151108$EGY$F$AB$Pse33234444P$");

%>
