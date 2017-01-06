<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="tra_tramiteJB" class="br.com.i9.flow.jb.Tra_tramiteInsertJB" scope="request"/>
<jsp:setProperty name="tra_tramiteJB" property="*"/>
<jsp:setProperty name="tra_tramiteJB" property="page" value="${pageContext}"/>
${tra_tramiteJB.execute}
{"resultado":"${tra_tramiteJB.msg}"}
