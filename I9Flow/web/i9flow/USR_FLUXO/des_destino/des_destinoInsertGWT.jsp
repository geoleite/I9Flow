<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="des_destinoJB" class="br.com.i9.flow.jb.Des_destinoInsertJB" scope="request"/>
<jsp:setProperty name="des_destinoJB" property="*"/>
<jsp:setProperty name="des_destinoJB" property="page" value="${pageContext}"/>
${des_destinoJB.execute}
{"resultado":"${des_destinoJB.msg}"}
