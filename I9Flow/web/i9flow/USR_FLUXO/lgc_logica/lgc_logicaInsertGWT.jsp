<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="lgc_logicaJB" class="br.com.i9.flow.jb.Lgc_logicaInsertJB" scope="request"/>
<jsp:setProperty name="lgc_logicaJB" property="*"/>
<jsp:setProperty name="lgc_logicaJB" property="page" value="${pageContext}"/>
${lgc_logicaJB.execute}
{"resultado":"${lgc_logicaJB.msg}"}
