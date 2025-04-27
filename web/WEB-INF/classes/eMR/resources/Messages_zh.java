/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.resources;

import java.util.*;

public class Messages_zh extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
		{"MR_INVALID_DIAG_CODE_FOR_PATIENT","APP-MR0001 输入的诊断�?适用于此病人"},
		{"MRDATE1_GT_DATE2","APP-MR0002 $ �?能大于#"},
		{"MRDATE1_LT_DATE2","APP-MR0003 $ �?能�?于 #"},
		{"MRDATE1_GTR_DATE2","APP-MR0004 $ 应该大于 #"},
		{"MR_VIEW_DTH_REG","APP-MR0005 任何一个病人编�?�标准/死亡时期应输入"},
		{"DIAG_REC0D_AUDIT","APP-MR0006 任何一个病人编�?�标准/冲�?期应输入"},
		{"APPLY_NOT_VALID","APP-MR0007 申请是无效的"},
		{"APPT_NOT_GIVEN","APP-MR0008 此病人的预约明细未准备，�?能准备医疗报告"},
		{"SELECT_TWO_PRACT","APP-MR0009 至少选择两个医生"},
		{"TERM_DESC_SHOULD_NOT_BE_BLANK","APP-MR0010 �??述�?能为空白"},
		{"MR_DIAG_DIFFGRP_CONFIRM","APP-MR0011 你想为目�?的诊断分�?/创建诊断组？"},
		{"MR_CONFIRM_PRINT","APP-MR0012 想打�?�报告 - #?"},
		{"DUPLI_SRL_NO","APP-MR0013 �?�?的�?列�?�命令�?�?许这�?组�?�."},
		{"DUP_SERIAL_NO","APP-MR0014 �?�?的�?列�?�"},
		{"END_DT_GR_START_DT","APP-MR0015 结�?�日期必须大于或等于开始日期"},
		{"CANT_XCEED_250_CHARS","APP-MR0016 输入值�?能超过250个字符"},
		{"CANT_XCEED_2000_CHARS","APP-MR0017 活动详情�?能超过2000字"},
		{"EVENT_START_GREATER_DOB","APP-MR0018 事件开始日期必须大于患者的出生日期"},
		{"EVENT_START_LESS_SYSDATE","APP-MR0019 事件的开始日期应�?于或等于当�?日期"},
		{"FILE_DOESNOT_EXIST","APP-MR0020 病人档案�?存在"},
		{"FILE_ALREADY_CREATED_FCY","APP-MR0021 设备中已建立病人的档案"},
		{"GROUP_NAME_LENGTH","APP-MR0022 组�??称长度�?能超过 # 字符"},
		{"HIGHER_LVL_SEL","APP-MR0023 �?能选择高的级别，�?�能选择低的级别"},
		{"INVALID_SRL_NO","APP-MR0024 无效的医嘱�?列�?�"},
		{"MASTER_SELECT","APP-MR0025 必须选择主�?的"},
		{"ALREADY_EXIST_MBOARD","APP-MR0026 医疗委员会类型已分�?给医疗委员会. 无法�?用"},
		{"NOTE_DOESNOT_EXIST_CANT_PROCEED","APP-MR0027 没有为病人准备医疗报告，无法进行"},
		{"NOTE_DOESNOT_EXIST","APP-MR0028 没有为病人准备医疗报告，�?能查看"},
		{"CONT_MRTHN_ONE_CHIEF","APP-MR0029 �?�?许一个以上的行政"},
		{"MR_EOC_MULT_NOT_ALLOWED","APP-MR0030 �?�?许多项选择"},
		{"ONLY_TEN_SEL_ALLOWED","APP-MR0031 �?��?许10个选项"},
		{"INVALID_SERIAL_NO","APP-MR0032 医嘱�?列�?�值必须大于 0"},
		{"PATIENT_NOT_REGISTERED","APP-MR0033 病人未登记设施。无法处�?�"},
		{"PAYMENT_NOT_COMPLETE","APP-MR0034 付款细节尚未完�?"},
		{"MR_PRY_CONT_MRT_ONE","APP-MR0035 主诊断�?能超过1个"},
		{"MR_INCLUDE_DIG","APP-MR0036 请列入诊断."},
		{"MR_EX_SELECT_ONE_DIAG","APP-MR0037 请至少选择一个诊断."},
		{"MR_DIAG_DIFF_GROUP","APP-MR0038 请选择�?选框"},
		{"RANGE_LENGTH","APP-MR0039 范围长度�?应大于200个字符"},
		{"REF_DATE_GREATER_DOB","APP-MR0040 �?�考日期应该大于患者的出生日期"},
		{"REF_DATE_LESS_SYSDATE","APP-MR0041 �?�考日期应该�?于等于当�?日期"},
		{"REMARKS_XCEED_2000_CHARS","APP-MR0042 备注�?能超过2000年字符"},
		{"REQUEST_ALREADY_MADE","APP-MR0043 请求已�?存在。�?能�?次请求"},
		{"REQ_REAL_IS_MANDATORY","APP-MR0044 申请人或关系应被选中。"},
		{"REQ_DOCS_CANT_XCEED_100_CHARS","APP-MR0045 请求文档�?能超过100个字符"},
		{"SERIAL_NO_NOT_BLANK","APP-MR0046 �?列�?��?能为空"},
		{"STAT_DT_BT_ONSET_AND_CURR","APP-MR0047 状�?日期必须在开始日期和当�?日期之间"},
		{"TERM_CODE_SHOULD_NOT_BE_BLANK","APP-MR0048 长期代�?�?能为空"},
		{"TERM_CODE_LEVEL_1_IS_MANDATORY","APP-MR0049 术语规范第一级是强制的"},
		{"TERM_SET_SHOULD_NOT_BE_BLANK","APP-MR0050 术语集�?能空白"},
		{"MR_REC_DIAG_NO_EXIT_GRP","APP-MR0051 没有任何其他现有的诊断组"},
		{"MR_DIAG_CURR_ACTIVE","APP-MR0052 您无法更新分辨/撤销/出错状�?诊断"},
		{"ENC_CANNOT_BLANK","APP-MR0053 Encounter 已�?被选择为医疗报告请求"},
		{"ONLY_ONE_BLOOD_GRP_WITH_INDETERMINATE_AS_YES","APP-MR0054 应该�?�有一个血型确定为ＹＥＳ"},
		{"CUTOFF_PERIOD_CANNOT_ZERO","APP-MR0055 截止期�?能为零"},
		{"CODE_LENGTH_CANNOT_ZERO","APP-MR0056 代�?长度�?能为"},
		{"MR_PARAM_NOT_DEFINED","APP-MR0057 MR �?�数未设置"},
		{"SAME_GRP_CHKBOX","APP-MR0058 请选择�?�自�?�一组的�?选框"},
		{"ATLEAST_ONE_PRACT","APP-MR0059 至少必须选择一个内部医生"},
		{"CODELENGTH_MAX_30","APP-MR0060 代�?长度�?能超过30个字符"},
		{"INVALID_DIAG_CODE","APP-MR0061 无效的诊断代�?"},
		{"APPT_LESS_THAN_SYSDATE_CANT_PROCEED","APP-MR0062 预约日期�?于当�?的日期。无法进行"},
		{"SUBMIT_CURR_PAGE","APP-MR0063 你想�??交当�?页�?��?�？"},
		{"PREV_ENC_TO_CURR_ENC","APP-MR0064 你想更新以�?诊断为当�?诊断�?�"},
		{"LEVEL_NOT_SELECT","APP-MR0065 这一级�?能被选中"},
		{"SUM_CODELENGTH_MAX_30","APP-MR0066 所有代�?的长度�?能超过去30"},
		{"COMBINATION_NOT_ALLOWED","APP-MR0067记录已�?存在这个病人�?良事件的指标，�?良事件类型和过�?原结�?�"},
		{"MAINTAIN_SEVERITY_LEVEL","APP-MR0068 应该维护安全级别"},
		{"REACTION_ALREADY_RECORDED_DATE","APP-MR0069 �??应已�?记录输入日期"},
		{"DIAG_PROCEDURE","APP-MR0070 你�?能使用超出IP/OP�?�数�?制以外的功能"},
		{"CANNOT_RECODE_AGAIN","APP-MR0071 �?能�?录入相�?�的诊断代�?"},
		{"ONSET_DT_BT_DOB_AND_CURR","APP-MR0072 开始日期应在出生日期和当�?日期之间"},
		{"ASS_DIAG_IN_SUF_DATA","APP-MR0073输入的数�?�是�?够的"},
		{"ASTERIX_CODE_NOT_EXISTS","APP-MR0074 �?�险代�?�?能空白"},
		{"ADM_OR_DEATH_PERIOD","APP-MR0075 必须输入任一个�?院�?出院标准期"},
		{"PATIENT_FILE_NOT_APPL","APP-MR0076 建立病人档案�?适用"}



	};
}			
