<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@page import="ieci.tecdoc.sgm.admsistema.util.Defs"%>

<%@page import="ieci.tecdoc.sgm.admsistema.bean.UsuarioEntidad"%>
<html>
	<head>
		<LINK href="css/estilos.css" type=text/css rel=stylesheet />

		<SCRIPT language=javascript>
			function realizarOperacion(idUsuario, accion) {
				var formulario = document.getElementById("formulario");
				formulario.action = 'accionesUsuario.do';
				var campo = document.getElementById("<%=Defs.PARAMETRO_USUARIO_SELECCIONADO%>");
				campo.value = idUsuario;
				campo = document.getElementById("<%=Defs.PARAMETRO_ACCION_USUARIO%>");
				campo.value = accion;
				if (accion != '<%=Defs.ACCION_ELIMINAR_USUARIO%>') {
					formulario.submit();
				} else {
					if (confirm("<bean:message key="mensaje.confirmacion.usuario.confirmar_eliminar" />"))
						formulario.submit();
				}
			}

			function realizarOperacionUsuario(accion) {
				var radios = document.usuarios.checkUsuario;
				if (radios != null) {
					if (radios.length) {
						for (var i=0; i < radios.length; i++) {
							if (radios[i].checked) {
								mostrarMensaje (false, '');
								return realizarOperacion(radios[i].value, accion);
							}
						}
					} else if (radios.checked) {
						mostrarMensaje (false, '');
						return realizarOperacion(radios.value, accion);
					}
				}

				ocultarMensajes();
				mostrarMensaje (true, "<bean:message key="mensaje.error.usuario.seleccione" />");
			}

			function ocultarMensajes(){
				if (document.getElementById('mensaje_error') != undefined) {
					document.getElementById('mensaje_error').style.visibility = 'hidden';
					document.getElementById('mensaje_error').style.position = 'absolute';
				}
				if (document.getElementById('mensaje_informativo') != undefined) {
					document.getElementById('mensaje_informativo').style.visibility = 'hidden';
					document.getElementById('mensaje_informativo').style.position = 'absolute';
				}
			}

			function realizarBusqueda() {
				var formulario = document.getElementById("busquedaBean");
				formulario.submit();
			}


			function verEntidades(usuario){
				var i=0;
				var casilla = document.getElementById(i+"_"+usuario);
				var desplegar = true;

				while(casilla != undefined){
					if (i==0){
						if (casilla.style.display=='block')
							desplegar = false;
					}

					if (desplegar){
						casilla.style.display='block';
						document.getElementById('tabla_'+usuario).style.display = 'inline';
					}else{
						casilla.style.display='none';
						document.getElementById('tabla_'+usuario).style.display = 'block';
					}

					i++;
					casilla = document.getElementById(i+"_"+usuario);
				}
				if (desplegar){
					document.getElementById('listado_'+usuario).innerHTML = "<bean:message key="usuarios.entidades.ocultar"/>";
					document.getElementById('imagen_'+usuario).src = 'img/menos.gif';
				}else{
					document.getElementById('listado_'+usuario).innerHTML = "<bean:message key="usuarios.entidades.mostrar"/>";
					document.getElementById('imagen_'+usuario).src = 'img/mas.gif';
				}
			}

			function mostrarMensaje(mostrar, mensaje) {
				var tabla = document.getElementById('tabla_mensajes_usuarios');
				var msj = document.getElementById('mensajes_usuarios');
				msj.innerHTML = mensaje;
				if (mostrar == true) {
					tabla.style.position = 'relative'; tabla.style.visibility = 'visible';
					msj.style.position = 'relative'; msj.style.visibility = 'visible';
				} else {
					tabla.style.position = 'absolute'; tabla.style.visibility = 'hidden';
					msj.style.position = 'absolute'; msj.style.visibility = 'hidden';
				}
			}
		</SCRIPT>
	</head>
	<body>
		<%String locale = (request.getLocale() != null) ? request.getLocale().getLanguage() : ""; if (locale == null || "".equals(locale)) locale = "es";%>
		<jsp:include flush="true" page="../cabecera.jsp">
			<jsp:param name="ayuda" value='<%=request.getContextPath() + "/jsp/ayudas/" + locale + "/usuarios/usuarios.html"%>' />
		</jsp:include>

		<form id=formulario action="" method=post>
			<input id=<%=Defs.PARAMETRO_USUARIO_SELECCIONADO%> type=hidden name=<%=Defs.PARAMETRO_USUARIO_SELECCIONADO%>>
			<input id=<%=Defs.PARAMETRO_ACCION_USUARIO%> type=hidden name=<%=Defs.PARAMETRO_ACCION_USUARIO%>>
		</form>

		<div id=contenedora align=center>
			<div class=cuerpo style="width: 80%">
				<div class=cuerporight>
					<div class=cuerpomid>
						<h1><bean:message key="usuarios.titulo"/></h1>
						<div class=submenu3 style="margin-right: 5px; width: 98%">
							<ul style="margin-right: 5px;">
  								<li class=submen1off>
  									<img src="img/subme3_off.gif">
  									<a href="listadoEntidades.do">
  										<bean:message key="tab.entidades"/>
  									</a>
  									<img src="img/subme3_of_on.gif">
  								</li>
								<li class="submen1on">
									<a href="listadoUsuarios.do" class=submen1on_a>
										<bean:message key="tab.usuarios"/>
									</a>
									<img src="img/subme3_on_0.gif">
		  						</li>
  							</ul>
  						</div>
  						<div class=submenu2>
	      					<ul>
						       	<li class="submen1on">
						       		<img src="img/subme2_on.gif">
						       		<a href="listadoUsuarios.do" class=submen1on_a>
							       		<bean:message key="tab.usuarios.administradores"/>
							       	</a>
						        </li>
						        <li class="submen1off">
							       	<img src="img/subme2_on_of.gif">
							       		<a href="listadoUsuariosInternos.do" class=submen1on_a>
											<bean:message key="tab.usuarios.internos"/>
										</a>
							       	<img src="img/subme2_of_0.gif">
							    </li>
						    </ul>
						</div>
						<div class=cuadro>
							<div>
								<h1><bean:message key="usuarios.configurados"/></h1>
								<div class="col" align="right" style="height: 30px;">
									<table border="0" cellspacing="0" cellpadding="0">
       									<tr align=right>
						       				<td width="100%">&nbsp;</td>
						       				<td width="20%">
						       					<img src="img/ico_user.jpg" style="cursor: pointer" onclick="javascript:realizarOperacion('', '<%=Defs.ACCION_NUEVO_USUARIO%>')" alt="<bean:message key="usuarios.boton.nuevo"/>" title="<bean:message key="usuarios.boton.nuevo"/>"/>
						       				</td>
						       				<td style="font-size: 130%;" valign=top>&nbsp;&nbsp;|&nbsp;&nbsp;</td>
						       				<html:form styleId="busquedaBean" action="/busquedaUsuarios.do" method="post">
							       				<td width="20%">
	       											<input type="text" id="<%=Defs.PARAMETRO_BUSQUEDA%>" name="<%=Defs.PARAMETRO_BUSQUEDA%>"  />
						    					</td>
							       				<td width="20%">
							       					<img src="img/ico_search.jpg" style="cursor: pointer" onclick="javascript:realizarBusqueda()" alt="<bean:message key="usuarios.boton.buscar"/>" title="<bean:message key="usuarios.boton.buscar"/>"/>
							       				</td>
							       			</html:form>
       									</tr>
       								</table>
								</div>
								<div align="right" style="height: 30px; margin-top: 20px;">
									<table border="0" cellspacing="0" cellpadding="0">
       									<tr align=right>
						       				<td width="100%">&nbsp;</td>
						       				<td width="20%">
						       					<img src="img/ico_edit_user.jpg" style="cursor: pointer" onclick="javascript:realizarOperacionUsuario('<%=Defs.ACCION_MODIFICAR_USUARIO%>')" alt="<bean:message key="usuarios.boton.modificar"/>" title="<bean:message key="usuarios.boton.modificar"/>"/>
						       				</td>
						       				<td style="font-size: 130%;" valign=top>&nbsp;&nbsp;|&nbsp;&nbsp;</td>
						       				<td width="20%">
						       					<img src="img/ico_delete_user.jpg" style="cursor: pointer" onclick="javascript:realizarOperacionUsuario('<%=Defs.ACCION_ELIMINAR_USUARIO%>')" alt="<bean:message key="usuarios.boton.eliminar"/>" title="<bean:message key="usuarios.boton.eliminar"/>"/>
						       				</td>
       									</tr>
       								</table>
								</div>
								<br/>
								<logic:present name="<%=Defs.MENSAJE_ERROR%>">
									<table id=mensaje_error border=0 cellpadding=0 cellspacing=0 align=center style="padding-left: 12px; padding-bottom:22px;">
										<tr>
											<td colspan=2>
						                		<label class="gr_error"><bean:message key="<%=(String)request.getAttribute(Defs.MENSAJE_ERROR)%>"/></label>
						                	</td>
										</tr>
										<tr><td colspan=2><br/></td></tr>
									</table>
								</logic:present>
								<logic:present name="<%=Defs.MENSAJE_INFORMATIVO%>">
									<table id=mensaje_informativo border=0 cellpadding=0 cellspacing=0 align=center style="padding-left: 12px; padding-bottom:22px;">
										<tr>
											<td colspan=2>
						                		<label class="gr_informativo"><bean:message key="<%=(String)request.getAttribute(Defs.MENSAJE_INFORMATIVO)%>"/></label>
						                	</td>
										</tr>
										<tr><td colspan=2><br/></td></tr>
									</table>
								</logic:present>
								<table align="center" id="tabla_mensajes_usuarios" border=0 cellpadding=0 cellspacing=0 style="padding-bottom:22px; position: absolute; visibility: hidden;">
									<tr>
										<td>
				    	            		<label id="mensajes_usuarios" class="gr_error" style="visibility: hidden; position:absolute"></label>
					                	</td>
									</tr>
									<tr><td><br/></td></tr>
								</table>
								<form name="usuarios">
								<display:table name="<%=Defs.LISTADO_USUARIOS%>"  uid="usuario"
									pagesize="10"
									requestURI="listadoUsuarios.do"
									export="false"
									class="tablaListado"
									sort="list"
									style="width:96%;">
									<display:column  style="width: 20px; height: 100%" media="html" titleKey="cabeceraTabla.entidades.panelBotones" sortable="false" headerClass="cabeceraTabla" >
										<table width="20px" height="100%">
											<tr height="100%">
												<td width="20px" height="100%">
													<input type="radio" id="checkUsuario" name="checkUsuario" value='<bean:write name="usuario" property="usuario" />' style="border: 0px; width: 20px"/>
												</td>
											</tr>
										</table>
									</display:column>
									<display:column  style="height: 100%" media="html" titleKey="cabeceraTabla.usuarios.usuario" sortable="true" headerClass="cabeceraTabla" >
										<acronym title="<bean:message key="usuarios.modificar" />">
											<table width="100%" height="100%" onclick="javascript:realizarOperacion('<bean:write name="usuario" property="usuario" />', '<%=Defs.ACCION_MODIFICAR_USUARIO%>')" style="cursor: pointer">
												<tr height="100%" valign="top">
													<td width="100%" height="100%">
														<bean:write name="usuario" property="usuario" />
													</td>
												</tr>
											</table>
										</acronym>
									</display:column>
									<display:column  style="height: 100%" media="html" titleKey="cabeceraTabla.usuarios.nombre" sortable="true" headerClass="cabeceraTabla" >
										<acronym title="<bean:message key="usuarios.modificar" />">
											<table width="100%" height="100%" onclick="javascript:realizarOperacion('<bean:write name="usuario" property="usuario" />', '<%=Defs.ACCION_MODIFICAR_USUARIO%>')" style="cursor: pointer">
												<tr height="100%" valign="top">
													<td width="100%" height="100%">
														<bean:write name="usuario" property="nombre" />
													</td>
												</tr>
											</table>
										</acronym>
									</display:column>
									<display:column  style="height: 100%" media="html" titleKey="cabeceraTabla.usuarios.apellidos" sortable="true" headerClass="cabeceraTabla" >
										<acronym title="<bean:message key="usuarios.modificar" />">
											<table width="100%" height="100%" onclick="javascript:realizarOperacion('<bean:write name="usuario" property="usuario" />', '<%=Defs.ACCION_MODIFICAR_USUARIO%>')" style="cursor: pointer">
												<tr height="100%" valign="top">
													<td width="100%" height="100%">
														<bean:write name="usuario" property="apellidos" />
													</td>
												</tr>
											</table>
										</acronym>
									</display:column>
									<display:column  style="height: 100%" media="html" titleKey="cabeceraTabla.usuarios.entidad" headerClass="cabeceraTabla">
											<table width="100%" height="100%" id="tabla_<%=((UsuarioEntidad)usuario).getUsuario()%>">
											<%
												if (((UsuarioEntidad)usuario).getEntidades().size() == 1) {
											%>
												<tr height="100%" valign="top">
													<td width="100%" height="100%">
														<%=(String)((UsuarioEntidad)usuario).getEntidades().get(0)%>
													</td>
												</tr>
											<%
												} else {
											%>
												<tr height="100%" valign="top">
													<td width="100%" height="100%">
															<a style="cursor: pointer" onclick="javascript:verEntidades('<%=((UsuarioEntidad)usuario).getUsuario()%>')">
																<img id="imagen_<%=((UsuarioEntidad)usuario).getUsuario()%>" src="img/mas.gif"/>&nbsp;<label id="listado_<%=((UsuarioEntidad)usuario).getUsuario()%>"><bean:message key="usuarios.entidades.mostrar"/></label>
															</a>
													</td>
												</tr>
														<%
															for(int ind=0; ind<((UsuarioEntidad)usuario).getEntidades().size(); ind++){
														%>
															<tr style="display: none" id='<%=ind+"_"+((UsuarioEntidad)usuario).getUsuario()%>' valign="middle">
																<td>
																	&nbsp;&nbsp;&nbsp;<img id="<%=ind%>_imagen_<%=((UsuarioEntidad)usuario).getUsuario()%>" src="img/book-<%=(ind%2)+1%>.gif"/>&nbsp;
																		<%=((UsuarioEntidad)usuario).getEntidades().get(ind)%>
																</td>
															</tr>
														<%
															}
														}
														%>
											</table>
									</display:column>
								</display:table>
								</form>
							</div>
						</div>
					</div>
					<div class=cuerpobt>
						<div class=cuerporightbt>
							<div class=cuerpomidbt></div>
						</div>
					</div>
				</div>
				<div id=pie></div>
			</div>
		</div>
	</body>
</html>