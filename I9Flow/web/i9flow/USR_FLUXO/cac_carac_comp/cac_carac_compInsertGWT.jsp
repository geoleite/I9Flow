<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cac_carac_compJB" class="br.com.i9.flow.jb.Cac_carac_compInsertJB" scope="request"/>
<jsp:setProperty name="cac_carac_compJB" property="*"/>
<jsp:setProperty name="cac_carac_compJB" property="page" value="${pageContext}"/>
${cac_carac_compJB.execute}
{"resultado":"${cac_carac_compJB.msg}"}
