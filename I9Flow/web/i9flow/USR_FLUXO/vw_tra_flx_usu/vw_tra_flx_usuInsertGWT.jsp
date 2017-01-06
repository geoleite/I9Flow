<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="vw_tra_flx_usuJB" class="br.com.i9.flow.jb.Vw_tra_flx_usuInsertJB" scope="request"/>
<jsp:setProperty name="vw_tra_flx_usuJB" property="*"/>
<jsp:setProperty name="vw_tra_flx_usuJB" property="page" value="${pageContext}"/>
${vw_tra_flx_usuJB.execute}
{"resultado":"${vw_tra_flx_usuJB.msg}"}
