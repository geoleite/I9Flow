<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tid_tipo_documentoJB" class="br.com.i9.flow.jb.Tid_tipo_documentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="tid_tipo_documentoJB" property="*"/>                                         
<jsp:setProperty name="tid_tipo_documentoJB" property="page" value="${pageContext}"/>                                         
${tid_tipo_documentoJB.execute}                                         
{"resultado":
{"msg":"${tid_tipo_documentoJB.msg}",
     "tid_tipo_documento":{	"tid_nr_id":"${tid_tipo_documentoJB.tid_tipo_documentoT.tid_nr_id}"
 ,	"tid_tx_nome":"${tid_tipo_documentoJB.tid_tipo_documentoT.tid_tx_nome}"
 ,	"tra_nr_id":"${tid_tipo_documentoJB.tid_tipo_documentoT.tra_nr_id}"
  }
    }
     
}                                                                                
   
