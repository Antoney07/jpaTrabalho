package org.model;

import org.model.Despesa;
import org.model.DespesaDAO;

import java.util.List;

public class DespesaService {

    private final DespesaDAO dao = new DespesaDAO();

    public void salvar(Despesa despesa) {
        dao.salvar(despesa);
    }

    public List<Despesa> listar() {
        return dao.listar();
    }

    public void atualizar(Despesa despesa) {
        dao.atualizar(despesa);
    }

    public void excluir(int id) {
        dao.excluir(id);
    }

    public double total() {
        return dao.total();
    }
}
