<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="opt_opcao_tramiteJB" class="br.com.i9.flow.jb.Opt_opcao_tramiteConsultJB" scope="request"/>                                         
<jsp:setProperty name="opt_opcao_tramiteJB" property="*"/>                                         
<jsp:setProperty name="opt_opcao_tramiteJB" property="page" value="${pageContext}"/>                                         
${opt_opcao_tramiteJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${opt_opcao_tramiteJB.list}" var="item">
     ,{	"tra_nr_idorigem":"${item.tra_nr_idorigem}"
 ,	"tra_nr_iddestino":"${item.tra_nr_iddestino}"
 ,	"opt_nr_ordem":"${item.opt_nr_ordem}"
 ,	"opt_tx_retorno":"${item.opt_tx_retorno}"
 ,	"opt_tx_nome":"${item.opt_tx_nome}"
  }
</c:forEach>
]}                                                                                
   