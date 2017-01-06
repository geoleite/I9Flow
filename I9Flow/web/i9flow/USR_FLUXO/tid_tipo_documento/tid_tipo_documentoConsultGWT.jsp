<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tid_tipo_documentoJB" class="br.com.i9.flow.jb.Tid_tipo_documentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="tid_tipo_documentoJB" property="*"/>                                         
<jsp:setProperty name="tid_tipo_documentoJB" property="page" value="${pageContext}"/>                                         
${tid_tipo_documentoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${tid_tipo_documentoJB.list}" var="item">
     ,{	"tid_nr_id":"${item.tid_nr_id}"
 ,	"tid_tx_nome":"${item.tid_tx_nome}"
 ,	"tra_nr_id":"${item.tra_nr_id}"
  }
</c:forEach>
]}                                                                                
   
