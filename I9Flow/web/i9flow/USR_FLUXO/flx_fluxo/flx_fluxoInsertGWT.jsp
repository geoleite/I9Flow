<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="flx_fluxoJB" class="br.com.i9.flow.jb.Flx_fluxoInsertJB" scope="request"/>
<jsp:setProperty name="flx_fluxoJB" property="*"/>
<jsp:setProperty name="flx_fluxoJB" property="page" value="${pageContext}"/>
${flx_fluxoJB.execute}
{"resultado":"${flx_fluxoJB.msg}"}
