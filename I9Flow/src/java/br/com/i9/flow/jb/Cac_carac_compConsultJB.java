package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cac_carac_compConsultJB extends SystemBase {

    private String className;
    private Cac_carac_compBL cac_carac_compBL = new Cac_carac_compBL();
    // Atributos e propriedades
    private Cac_carac_compT cac_carac_compT = new Cac_carac_compT();

    public void setCac_carac_compT(Cac_carac_compT cac_carac_compT) {
        this.cac_carac_compT = cac_carac_compT;
    }

    public Cac_carac_compT getCac_carac_compT() {
        return cac_carac_compT;
    }
    private List<Cac_carac_compT> list;

    public List<Cac_carac_compT> getList() {
        return list;
    }

    public void setList(List<Cac_carac_compT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        try {
            list = cac_carac_compBL.consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        }
    }

    public void consultByDocTypeNameAndFlowId() {
        try {
            list = cac_carac_compBL.consultByClassNameAndFlowId(className, cac_carac_compT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        }
    }

    public void delete() throws Exception {
        try {
            if (cac_carac_compBL.delete(cac_carac_compT)) {
                setMsg("Exclusao efetuada com sucesso!");
            } else {
                setMsg("Falha: Nao foi possivel excluir este registro.");
            }
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }
}
