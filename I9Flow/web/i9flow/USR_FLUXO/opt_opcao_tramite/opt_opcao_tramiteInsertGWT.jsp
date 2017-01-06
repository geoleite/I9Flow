<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="opt_opcao_tramiteJB" class="br.com.i9.flow.jb.Opt_opcao_tramiteInsertJB" scope="request"/>
<jsp:setProperty name="opt_opcao_tramiteJB" property="*"/>
<jsp:setProperty name="opt_opcao_tramiteJB" property="page" value="${pageContext}"/>
${opt_opcao_tramiteJB.execute}
{"resultado":"${opt_opcao_tramiteJB.msg}"}
