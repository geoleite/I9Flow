<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="tid_tipo_documentoJB" class="br.com.i9.flow.jb.Tid_tipo_documentoInsertJB" scope="request"/>
<jsp:setProperty name="tid_tipo_documentoJB" property="*"/>
<jsp:setProperty name="tid_tipo_documentoJB" property="page" value="${pageContext}"/>
${tid_tipo_documentoJB.execute}
{"resultado":"${tid_tipo_documentoJB.msg}"}
