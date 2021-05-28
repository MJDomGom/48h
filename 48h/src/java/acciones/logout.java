/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author mjdom
 */
public class logout extends ActionSupport {
    
    private Map session;
    
    public logout() {
    }
    
    public String execute() throws Exception {
        session = (Map) ActionContext.getContext().getSession();
        session.clear();
        return SUCCESS;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }
    
    
    
}
