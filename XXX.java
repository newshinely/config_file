package com.yinhai.gqkh.company.action;


import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;


import com.yinhai.gqkh.common.action.RSRCBaseAction;
import com.yinhai.gqkh.common.util.ExtUserUtil;
import com.yinhai.gqkh.company.service.ChangeCompanyService;
import com.yinhai.gqkh.domain.B01Domain;
import com.yinhai.gqkh.domain.B01a1Domain;
import com.yinhai.scacomm.InputDomain;
import com.yinhai.scacomm.OutputDomain;
import com.yinhai.sysframework.dto.ParamDTO;
import com.yinhai.sysframework.util.ValidateUtil;
/**
 * 单位信息变更123123
 * @author: 银海人事人才项目组
 * @Copyright: 2012-2013 银海软件所有
 * @date: 2016-9-26 下午09:10:10
 * @vesion: 1.0
 */
@Namespace("/gqkh/company")
@Action(value = "changeCompanyAction", results = {
		@Result(name = "success", location = "/gqkh/page/company/changeCompanyMain.jsp"),
		@Result(name = "toAuditPage", location = "/gqkh/page/company/companyAuditPage.jsp")//审核办理
		})
public class XXXAction extends RSRCBaseAction{

	private XXXService xxxService = (XXXService)getService("xxxService");

	public String execute() throws Exception {
		String page = request.getParameter("page");
		if(page != null){
			return page;
		}
		return SUCCESS;
	}

	/**
	 * 发起申报机构List
	 *
	 * @author
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		ParamDTO dto = getDto();
		InputDomain inputDomain = new InputDomain();
		inputDomain.getParamMap().putAll(dto.getDtoAsMap());
		OutputDomain outputDomain =
			xxxService.getList(getAccessInputDomain(), inputDomain);
		if(null!=outputDomain && OutputDomain.APP_SUCCESS.equals(outputDomain.getAppCode())){
			List<Map> list = (List<Map>)outputDomain.getList();
			setList("grid1", list);
		}
		return JSON;
	}
	/**
	 * 网厅端代码
	 */
	getXtWsClient().exe("", inputDomain, OutputDomain.class);

}
