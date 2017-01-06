<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="aru_usu_areaJB" class="br.com.i9.flow.jb.Aru_usu_areaInsertJB" scope="request"/>
<jsp:setProperty name="aru_usu_areaJB" property="*"/>
<jsp:setProperty name="aru_usu_areaJB" property="page" value="${pageContext}"/>
${aru_usu_areaJB.execute}
{"resultado":"${aru_usu_areaJB.msg}"}
