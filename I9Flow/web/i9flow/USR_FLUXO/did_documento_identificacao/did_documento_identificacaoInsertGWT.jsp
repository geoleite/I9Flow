<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="did_documento_identificacaoJB" class="br.com.i9.flow.jb.Did_documento_identificacaoInsertJB" scope="request"/>
<jsp:setProperty name="did_documento_identificacaoJB" property="*"/>
<jsp:setProperty name="did_documento_identificacaoJB" property="page" value="${pageContext}"/>
${did_documento_identificacaoJB.execute}
{"resultado":"${did_documento_identificacaoJB.msg}"}
