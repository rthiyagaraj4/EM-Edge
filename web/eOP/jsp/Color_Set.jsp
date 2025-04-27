<!DOCTYPE html>


 <%!

	public String color_set(String p_case_type, String p_no_show, String p_appt_confirm_yn, String p_arrival_status, String p_tvisit_type)
	{
		String clr ="white";
		if (p_case_type.equals("A"))
			{
				if (p_arrival_status.equals("O"))
					clr = "green";
				else if (p_arrival_status.equals("L"))
							clr = "brown";
				else if (p_arrival_status.equals("E"))
						clr="RED";
				else if (p_no_show.equals("Y"))
					clr = "yellow";
				else if (p_appt_confirm_yn.equals("Y"))
					clr = "blue";
				else if (p_appt_confirm_yn.equals("N"))
					clr = "white";
			}
		else 
			{
				/*if (p_patient_class.equals("OP"))
					clr = "magenta";
				else*/
				if (p_tvisit_type.equals("E"))
					clr = "PATQRED";
			}
			
		return clr;
	}
%>
