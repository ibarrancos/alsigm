package ieci.tecdoc.sgm.usuario.admin.struts.action;

import ieci.tecdoc.sgm.usuario.admin.struts.UserAdminHelper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

/**
 * Acci�n encargada de la b�squeda de tipos de liquidaciones. 
 *
 */
public class AltaUsuarioAction extends AdminUsuariosWebAction {

	private static final Logger logger = Logger.getLogger(AltaUsuarioAction.class);
	
	private static final String SUCCESS_FORWARD =		"success";
	private static final String ERROR_FORWARD =			"error";
	private static final String LISTA_USUARIOS_KEY =	"usuarios";
	
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		return mapping.findForward(SUCCESS_FORWARD);
	}
}