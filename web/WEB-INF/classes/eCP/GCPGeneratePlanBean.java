/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 18/10/2005.

package eCP;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eCommon.Common.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;

public class GCPGeneratePlanBean implements java.io.Serializable {

	HashMap case_type_code	 = new HashMap();
	HashMap case_code		 = new HashMap();
	HashMap inter_details	 = new HashMap();
	HashMap term_code		 = new HashMap();
	HashMap select_lib		 = new HashMap();
	HashMap selected_intvn	 = new HashMap();
	HashMap limit_lib		 = new HashMap();
	HashMap date_vals		 = new HashMap();

	protected String caremanager_desc	= "";
	protected String selected_diags		= "";
	protected String patient_class		= "";
	protected String patient_id			= "";
	protected String goal_stmt			= "";
	protected String inter_code			= "";
	protected String plan_start_date	= "";
	protected String plan_end_date		= "";

	protected int pagefirst_time		= 0;
	
	public void setDiags(String selected_diags){				this.selected_diags = selected_diags;	}
	public void setPlanStart(String plan_start_date){			this.plan_start_date = plan_start_date;	}
	public void setPlanEnd(String plan_end_date){				this.plan_end_date = plan_end_date;		}
	public void setInterCode(String inter_code){				this.inter_code = inter_code;			}
	public void setGoalStmt(String goal_stmt){					this.goal_stmt = goal_stmt;				}
	public void setPatientId(String patient_id){				this.patient_id = patient_id;			}
	public void setPageFirst(int pagefirst_time){				this.pagefirst_time = pagefirst_time;	}
	public void setCareManagerDesc(String caremanager_desc){	this.caremanager_desc = caremanager_desc;	}
	public void setPatientClass(String patient_class){			this.patient_class= patient_class;		}
	public void setLimitLib(HashMap limit_lib){					this.limit_lib= limit_lib;				}
	public void setSelectedLib(HashMap select_lib){				this.select_lib= select_lib;			}
	public void setSelectedIntvn(HashMap selected_intvn){		this.selected_intvn= selected_intvn;	}
	public void setCaseCode(HashMap case_type_code){			this.case_type_code = case_type_code;	}
	public void setDgCaseCode(HashMap case_code){				this.case_code = case_code;				}
	public void setTermCode(HashMap term_code){					this.term_code = term_code;				}
	public void setInterDetail(HashMap inter_details){			this.inter_details = inter_details;		}
	public void setDateValues(HashMap date_vals){				this.date_vals = date_vals;				}
	
	public String getDiags(){						return selected_diags;	}
	public String getPlanStart(){					return plan_start_date;	}
	public String getPlanEnd(){						return plan_end_date;	}
	public String getInterCode(){					return inter_code;		}
	public int getPageFirst(){						return pagefirst_time;	}
	public String getCareManagerDesc(){				return caremanager_desc;}
	public String getPatientClass(){				return patient_class;	}
	public String getGoalStmt(){					return goal_stmt;		}
	public String getPatientId(){					return patient_id;		}
	public HashMap getLimitLib(){					return limit_lib;		}
	public HashMap getSelectedLib(){				return select_lib;		}
	public HashMap getSelectedIntvn(){				return selected_intvn;	}
	public HashMap getCaseCode(){					return case_type_code;	}
	public HashMap getDgCaseCode(){					return case_code;		}

	public HashMap getTermCode(){					return term_code;		}
	public HashMap getInterDetail(){				return inter_details;	}
	public HashMap getDateValues(){					return date_vals;		}

	public void clearBean()
	{	
	
		case_code		 = new HashMap();
		case_type_code	 = new HashMap();
		term_code		 = new HashMap();
		select_lib		 = new HashMap();
		selected_intvn	 = new HashMap();
		inter_details	 = new HashMap();
		limit_lib		 = new HashMap();
		date_vals		 = new HashMap();
		selected_diags	 = "";
		patient_id		 = "";
		patient_class	 = "";
		pagefirst_time	 = 0;
		goal_stmt		 = "";
		inter_code		 = "";
		plan_end_date	 = "";
		plan_start_date	 = "";
		
	}
	
}
