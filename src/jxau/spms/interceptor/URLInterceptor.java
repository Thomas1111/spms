package jxau.spms.interceptor;

import javax.servlet.http.HttpSession;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class URLInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation action) throws Exception {
		// TODO Auto-generated method stub\
		
		String result = "success";
		//获取该action中的session
		HttpSession session = (HttpSession)action.getInvocationContext().getSession();
		if (session.getAttribute("account") == null
				||session.getAttribute("name") == null
					||session.getAttribute("role") == null) {
			result = "error";
			return result;
		}else {
			return action.invoke();
		}
	}

}
