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
		// ȡ����Ϊuser��session����
		Admin admin = (Admin) session.get("ADMIN");
		// ���û�е�½���������µ�½
		if (admin != null) {
			return invocation.invoke();
		} else {
			ctx.getSession().put("tip", "���ȵ�¼ϵͳ��");
			return "login";
		}
	}

}
