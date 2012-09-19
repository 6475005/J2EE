package interceptor;

import java.util.Map;

import object.Admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class AdminInterceptor extends AbstractInterceptor {

	@SuppressWarnings("rawtypes")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		// 取出名为user的session属性
		Admin admin = (Admin) session.get("ADMIN");
		// 如果没有登陆，返回重新登陆
		if (admin != null) {
			return invocation.invoke();
		} else {
			ctx.getSession().put("tip", "请先登录系统！");
			return "login";
		}
	}

}
